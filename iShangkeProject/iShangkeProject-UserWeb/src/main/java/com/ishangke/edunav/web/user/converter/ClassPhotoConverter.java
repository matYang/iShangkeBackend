package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.web.user.model.ClassPhotoVo;

public class ClassPhotoConverter {
    public static ClassPhotoBo fromModel(ClassPhotoVo e) {
        ClassPhotoBo classPhotoBo = new ClassPhotoBo();
        return classPhotoBo;
    }

    public static ClassPhotoVo toModel(ClassPhotoBo bo) {
        ClassPhotoVo classPhotoVo = new ClassPhotoVo();
        return classPhotoVo;
    }
}
