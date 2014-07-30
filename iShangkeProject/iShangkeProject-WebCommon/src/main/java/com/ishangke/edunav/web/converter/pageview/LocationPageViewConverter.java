package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.LocationPageViewBo;
import com.ishangke.edunav.web.converter.LocationConverter;
import com.ishangke.edunav.web.model.LocationVo;
import com.ishangke.edunav.web.model.pageview.LocationPageViewVo;

public class LocationPageViewConverter {
    public static LocationPageViewVo toModel(LocationPageViewBo bo) {
        LocationPageViewVo vo = new LocationPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<LocationVo> result = new ArrayList<>();
            for (LocationBo b : bo.getData()) {
                result.add(LocationConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
