package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;

public class ClassPhotoConverter {
    public static ClassPhotoBo toBo(ClassPhotoEntityExt e) {
        ClassPhotoBo classPhotoBo = new ClassPhotoBo();
        return classPhotoBo;
    }

    public static ClassPhotoEntityExt fromBo(ClassPhotoBo bo) {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        return classPhotoEntityExt;
    }
}
