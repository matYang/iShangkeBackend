package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.dataaccess.model.LocationEntityExt;

public class LocationConverter {
    public static LocationBo toBo(LocationEntityExt e) {
        LocationBo locationBo = new LocationBo();
        return locationBo;
    }

    public static LocationEntityExt fromBo(LocationBo bo) {
        LocationEntityExt locationEntityExt = new LocationEntityExt();
        return locationEntityExt;
    }
}
