package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public class TeacherConverter {
    public static TeacherBo toBo(TeacherEntityExt e) {
        TeacherBo teacherBo = new TeacherBo();
        return teacherBo;
    }

    public static TeacherEntityExt fromBo(TeacherBo bo) {
        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
        return teacherEntityExt;
    }
}
