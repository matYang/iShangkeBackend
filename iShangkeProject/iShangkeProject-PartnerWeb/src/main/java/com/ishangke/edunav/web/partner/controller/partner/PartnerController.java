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
    JsonResponse importPartners(@RequestParam("file") MultipartFile file, HttpServletResponse resp) throws ControllerException {
        // Need a User
        int userId = 1;
        UserVo user = new UserVo();
        user.setId(userId);
        UserBo userBo = UserConverter.fromModel(user);
        String permissionTag = "GET/api/v2/course";

        JsonResponse result = new JsonResponse();
        if (file.isEmpty()) {
            return this.handleWebException(new ControllerException("上传文件为空"), resp);
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
            return this.handleWebException(new ControllerException("读取或写入本地文件出错"), resp);
        } finally {
            serverFile.delete();
        }

        Workbook book;
        Sheet sheet;
        FileInputStream fis;
        try {
            fis = new FileInputStream(new File(serverFile.getAbsolutePath()));
            book = Workbook.getWorkbook(fis);
            sheet = book.getSheet(0);
        } catch (BiffException | IOException e) {
            return this.handleWebException(new ControllerException("读取xml的时候挂掉了,make sure 你的file 是 .xls 不是 .xlsx"), resp);
        } finally {
            serverFile.delete();
        }

        int row = 0;
        int col = 0;
        int totalRow = sheet.getRows();
        int totalCol = sheet.getColumns();
        int count = 0;
        Map<Integer, String> fmap = new HashMap<Integer, String>();
        Map<String, String> kvmap = new HashMap<String, String>();
        ReflectionService rs = null;
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
                        partnerFacade.createPartner(partner, userBo, permissionTag);
                        count++;
                    } catch (IllegalArgumentException | IllegalAccessException | ParseException e) {
                        return this.handleWebException(new ControllerException("导入出错"), resp);
                    } finally {
                        serverFile.delete();
                    }
                }
            }
        }

        if (serverFile.exists()) {
            serverFile.delete();
        }
        result.setMessage("successfully imported " + count + " partners");
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryPartner(PartnerVo partnerVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        PartnerPageViewBo pageViewBo = null;
        PartnerPageViewVo pageViewVo = null;

        try {
            pageViewBo = partnerFacade.queryPartner(PartnerConverter.fromModel(partnerVo), PaginationConverter.toBo(paginationVo), curUser,
                    permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = PartnerPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    // get partner by id is open data, no authentication
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryPartnerById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);

        PartnerVo partnerVo = new PartnerVo();
        partnerVo.setId(id);
        PartnerBo responseBo = null;
        PartnerVo responseVo = null;
        try {
            responseBo = partnerFacade.queryPartnerById(PartnerConverter.fromModel(partnerVo), UserConverter.fromModel(new UserVo()), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = PartnerConverter.toModel(responseBo);

        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse update(@PathVariable("id") int partnerId, @RequestBody PartnerVo partnerVo, HttpServletRequest req, HttpServletResponse resp) {
        PartnerVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        PartnerBo targetPartner = PartnerConverter.fromModel(partnerVo);
        targetPartner.setId(partnerId);

        PartnerBo responsePartner = null;
        try {
            responsePartner = partnerFacade.updatePartner(targetPartner, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = PartnerConverter.toModel(responsePartner);
        return responseVo;
    }

    @RequestMapping(value = "/{id}/logo", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse uploadLogo(@RequestParam("file") MultipartFile file, @PathVariable("id") int partnerId, HttpServletRequest req,
            HttpServletResponse resp) {

        // String permissionTag = this.getUrl(req);
        // SessionBo authSessionBo = this.getSession(req);
        //
        // UserBo curUser = userFacade.authenticate(authSessionBo,
        // permissionTag);
        // int curId = curUser.getId();
        // boolean loggedIn = curId > 0;
        // if (!loggedIn) {
        // throw new ControllerException("对不起，您尚未登录");
        // }

        // This can be deleted later
        // Need a User
        int userId = 1;
        UserVo user = new UserVo();
        user.setId(userId);
        UserBo userBo = UserConverter.fromModel(user);
        String permissionTag = "GET/api/v2/course";
        // This can be deleted later

        PartnerVo partnerVo = new PartnerVo();

        if (!file.isEmpty()) {
            File serverFile = null;
            try {
                String imgUrl = "";

                File dir = new File("tmp");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + ".png");
                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
                ImageIO.write(bufferedImage, "png", serverFile);

                imgUrl = AliyunMain.uploadImg(partnerId, serverFile, file.getName(), Config.AliyunLogoBucket);
                partnerVo.setLogoUrl(imgUrl);
                PartnerBo partnerBo = PartnerConverter.fromModel(partnerVo);
                partnerFacade.updatePartner(partnerBo, userBo, permissionTag);

            } catch (Exception e) {

                return this.handleWebException(new ControllerException("PartnerLogo 上传失败"), resp);
            } finally {
                if (serverFile != null) {
                    serverFile.delete();
                }
            }
        } else {
            return this.handleWebException(new ControllerException("PartnerLogo file 为空"), resp);
        }
        return partnerVo;
    }
}
