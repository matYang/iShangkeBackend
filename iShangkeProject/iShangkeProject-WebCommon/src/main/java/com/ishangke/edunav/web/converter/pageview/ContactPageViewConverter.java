package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.commoncontract.model.ContactPageViewBo;
import com.ishangke.edunav.web.converter.ContactConverter;
import com.ishangke.edunav.web.model.ContactVo;
import com.ishangke.edunav.web.model.pageview.ContactPageViewVo;

public class ContactPageViewConverter {
    public static ContactPageViewVo toModel(ContactPageViewBo bo) {
        ContactPageViewVo vo = new ContactPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<ContactVo> result = new ArrayList<>();
            for (ContactBo b : bo.getData()) {
                result.add(ContactConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
