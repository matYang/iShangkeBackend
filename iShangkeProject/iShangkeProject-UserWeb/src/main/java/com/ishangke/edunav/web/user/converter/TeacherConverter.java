package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.user.model.TeacherVo;

public class TeacherConverter {
    public static TeacherBo fromModel(TeacherVo e) {
        TeacherBo teacherBo = new TeacherBo();
        return teacherBo;
    }

    public static TeacherVo toModel(TeacherBo bo) {
        TeacherVo teacherVo = new TeacherVo();
        return teacherVo;
    }
}
