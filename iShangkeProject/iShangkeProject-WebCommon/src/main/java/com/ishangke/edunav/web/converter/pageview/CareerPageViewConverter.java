package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.commoncontract.model.CareerPageViewBo;
import com.ishangke.edunav.web.converter.CareerConverter;
import com.ishangke.edunav.web.model.CareerVo;
import com.ishangke.edunav.web.model.pageview.CareerPageViewVo;

public class CareerPageViewConverter {
    public static CareerPageViewVo toModel(CareerPageViewBo bo) {
        CareerPageViewVo vo = new CareerPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CareerVo> result = new ArrayList<>();
            for (CareerBo b : bo.getData()) {
                result.add(CareerConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
