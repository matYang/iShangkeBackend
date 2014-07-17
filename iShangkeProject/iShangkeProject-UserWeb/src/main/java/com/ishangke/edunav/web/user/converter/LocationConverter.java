package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.web.user.model.LocationVo;

public class LocationConverter {
    public static LocationBo fromModel(LocationVo e) {
        LocationBo locationBo = new LocationBo();
        return locationBo;
    }

    public static LocationVo toModel(LocationBo bo) {
        LocationVo locationVo = new LocationVo();
        return locationVo;
    }
}
