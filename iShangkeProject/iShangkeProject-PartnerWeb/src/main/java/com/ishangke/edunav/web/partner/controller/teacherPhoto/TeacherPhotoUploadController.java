package com.ishangke.edunav.web.partner.controller.teacherPhoto;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ishangke.edunav.common.Config;
import com.ishangke.edunav.common.utilities.file.AliyunMain;
import com.ishangke.edunav.web.partner.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/teacher/Upload")
public class TeacherPhotoUploadController extends AbstractController {
    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
        if (!file.isEmpty()) {
            try {
                String path = "";
                long partnerId = Long.parseLong(req.getParameter("partnerId"));

                File dir = new File("tmp");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + ".png");
                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
                ImageIO.write(bufferedImage, "png", serverFile);

                path = AliyunMain.uploadImg(partnerId, serverFile, file.getName(), Config.AliyunTeacherImgBucket);
                return path;

            } catch (Exception e) {
                return "You failed to upload " + file.getName() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getName() + " because the file was empty.";
        }
    }
}
