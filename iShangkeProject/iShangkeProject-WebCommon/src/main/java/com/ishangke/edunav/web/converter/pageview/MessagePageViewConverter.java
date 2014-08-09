package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.commoncontract.model.MessagePageViewBo;
import com.ishangke.edunav.web.converter.MessageConverter;
import com.ishangke.edunav.web.model.MessageVo;
import com.ishangke.edunav.web.model.pageview.MessagePageViewVo;

public class MessagePageViewConverter {
    public static MessagePageViewVo toModel(MessagePageViewBo bo) {
        MessagePageViewVo vo = new MessagePageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<MessageVo> result = new ArrayList<>();
            for (MessageBo b : bo.getData()) {
                result.add(MessageConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
