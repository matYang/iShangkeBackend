package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoPageViewBo;
import com.ishangke.edunav.web.converter.ClassPhotoConverter;
import com.ishangke.edunav.web.model.ClassPhotoVo;
import com.ishangke.edunav.web.model.pageview.ClassPhotoPageViewVo;

public class ClassPhotoPageViewConverter {
    public static ClassPhotoPageViewVo toModel(ClassPhotoPageViewBo bo) {
        ClassPhotoPageViewVo vo = new ClassPhotoPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<ClassPhotoVo> result = new ArrayList<>();
            for (ClassPhotoBo b : bo.getData()) {
                result.add(ClassPhotoConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
