package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public class TeacherConverter {
    public static TeacherBo toBo(TeacherEntityExt e) {
        return new TeacherBo();
    }

    public static TeacherEntityExt fromBo(TeacherBo bo) {
        return new TeacherEntityExt();
    }
}
