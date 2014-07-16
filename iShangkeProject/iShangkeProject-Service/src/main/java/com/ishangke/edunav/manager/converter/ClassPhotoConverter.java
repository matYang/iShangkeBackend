package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;

public class ClassPhotoConverter {
    public static ClassPhotoBo toBo(ClassPhotoEntityExt e) {
        return new ClassPhotoBo();
    }

    public static ClassPhotoEntityExt fromBo(ClassPhotoBo bo) {
        return new ClassPhotoEntityExt();
    }
}
