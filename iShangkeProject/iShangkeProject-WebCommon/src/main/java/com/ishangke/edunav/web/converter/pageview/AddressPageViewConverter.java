package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.AddressPageViewBo;
import com.ishangke.edunav.web.converter.AddressConverter;
import com.ishangke.edunav.web.model.AddressVo;
import com.ishangke.edunav.web.model.pageview.AddressPageViewVo;

public class AddressPageViewConverter {
    public static AddressPageViewVo toModel(AddressPageViewBo bo) {
        AddressPageViewVo vo = new AddressPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<AddressVo> result = new ArrayList<>();
            for (AddressBo b : bo.getData()) {
                result.add(AddressConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
