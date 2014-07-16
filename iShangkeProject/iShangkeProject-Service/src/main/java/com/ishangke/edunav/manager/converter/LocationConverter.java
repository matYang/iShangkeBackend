package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.dataaccess.model.LocationEntityExt;

public class LocationConverter {
    public static LocationBo toBo(LocationEntityExt e) {
        return new LocationBo();
    }

    public static LocationEntityExt fromBo(LocationBo bo) {
        return new LocationEntityExt();
    }
}
