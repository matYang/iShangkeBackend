package com.ishangke.edunav.web.partner.controller.partner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ishangke.edunav.common.Config;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.file.AliyunMain;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PartnerPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.PartnerFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.PartnerConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.converter.pageview.PartnerPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.PartnerVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.model.pageview.PartnerPageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.partner.reflection.ReflectionService;

@Controller
@RequestMapping("/p-api/v2/partner")
public class PartnerController extends AbstractController {

    @Autowired
    UserFacade userFacade;

    @Autowired
    PartnerFacade partnerFacade;

    @RequestMapping(value = "/import", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<String> importPartners(@RequestParam("file") MultipartFile file) throws ControllerException {
        JsonResponse<String> result = new JsonResponse<>();
        if (file.isEmpty()) {
            throw new ControllerException("上传文件为空");
        }

        File dir = new File("tmp");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + ".xls");

        try {
            byte[] contentInBytes = file.getBytes();
            FileOutputStream fos = new FileOutputStream(serverFile);
            fos.write(contentInBytes);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            throw new ControllerException("读取或写入本地文件出错");
        }

        Workbook book;
        Sheet sheet;
        FileInputStream fis;
        try {
            fis = new FileInputStream(new File(serverFile.getAbsolutePath()));
            book = Workbook.getWorkbook(fis);
            sheet = book.getSheet(0);
        } catch (BiffException | IOException e) {
            throw new ControllerException("读取xml的时候挂掉了,make sure 你的file 是 .xls 不是 .xlsx");
        }

        int row = 0;
        int col = 0;
        int totalRow = sheet.getRows();
        int totalCol = sheet.getColumns();
        int count = 0;
        Map<Integer, String> fmap = new HashMap<Integer, String>();
        Map<String, String> kvmap = new HashMap<String, String>();
        ReflectionService rs = null;
        // NOTE: The information should be stored as following order
        Cell c = sheet.getCell(col, row);
        if (c != null && !c.equals("")) {
            PartnerBo partner = new PartnerBo();
            for (row = 0; row < totalRow; row++) {
                for (col = 0; col < totalCol; col++) {
                    c = sheet.getCell(col, row);
                    if (row == 0) {
                        String field = c.getContents();
                        kvmap.put(field, null);
                        fmap.put(col, field);
                    } else {
                        String value = c.getContents();
                        kvmap.put(fmap.get(col), value);
                    }
                }
                if (row == 0) {
                    rs = new ReflectionService(partner);
                } else {
                    try {
                        partner = (PartnerBo) rs.getBoFromMap(kvmap);
                        partner.setLastModifyTime(DateUtility.getCurTime());
                        partner.setCreateTime(DateUtility.getCurTime());
                        // TODO Add partner to DB
                        count++;
                    } catch (IllegalArgumentException | IllegalAccessException | ParseException e) {
                        throw new ControllerException("导入出错");
                    }
                }
            }
        }

        serverFile.delete();
        result.setResponse("successfully imported " + count + " partners");
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    PartnerPageViewVo queryPartner(PartnerVo partnerVo, PaginationVo paginationVo, HttpServletRequest req,
            HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return (PartnerPageViewVo) this.handleWebException(c, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }

        PartnerPageViewBo pageViewBo = null;
        PartnerPageViewVo pageViewVo = null;

        pageViewBo = partnerFacade.queryPartner(PartnerConverter.fromModel(partnerVo),
                PaginationConverter.toBo(paginationVo), curUser, permissionTag);
        pageViewVo = PartnerPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    // get partner by id is open data, no authentication
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    PartnerVo queryPartnerById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);

        PartnerVo partnerVo = new PartnerVo();
        partnerVo.setId(id);
        PartnerBo responseBo = null;
        PartnerVo responseVo = null;

        responseBo = null;
        try {
            partnerFacade.queryPartnerById(PartnerConverter.fromModel(partnerVo),
                    UserConverter.fromModel(new UserVo()), permissionTag);
        } catch (ControllerException c) {
            return (PartnerVo) this.handleWebException(c, resp);
        }
        responseVo = PartnerConverter.toModel(responseBo);

        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    PartnerVo update(@PathVariable("id") int partnerId, @RequestBody PartnerVo partnerVo, HttpServletRequest req,
            HttpServletResponse resp) {
        PartnerVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return (PartnerVo) this.handleWebException(c, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }

        PartnerBo targetPartner = PartnerConverter.fromModel(partnerVo);
        targetPartner.setId(partnerId);

        PartnerBo responsePartner = null;
        try {
            partnerFacade.updatePartner(targetPartner, curUser, permissionTag);
        } catch (ControllerException c) {
            return (PartnerVo) this.handleWebException(c, resp);
        }
        responseVo = PartnerConverter.toModel(responsePartner);
        return responseVo;
    }

    @RequestMapping(value = "/{id}/logo", method = RequestMethod.POST)
    public @ResponseBody
    PartnerVo uploadLogo(@RequestParam("file") MultipartFile file, @PathVariable("id") int partnerId,
            HttpServletRequest req, HttpServletResponse resp) {
        PartnerVo partnerVo = new PartnerVo();

        if (!file.isEmpty()) {
            try {
                String imgUrl = "";

                File dir = new File("tmp");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + ".png");
                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
                ImageIO.write(bufferedImage, "png", serverFile);

                imgUrl = AliyunMain.uploadImg(partnerId, serverFile, file.getName(), Config.AliyunLogoBucket);
                partnerVo.setLogoUrl(imgUrl);

            } catch (Exception e) {
                throw new ControllerException("PartnerLogo 上传失败");
            }
        } else {
            throw new ControllerException("PartnerLogo file 为空");
        }
        return partnerVo;
    }

}