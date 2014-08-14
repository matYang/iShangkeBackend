package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.MajorBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.MajorEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.MajorEntityExt;
import com.ishangke.edunav.manager.MajorManager;
import com.ishangke.edunav.manager.converter.MajorConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class MajorManagerImpl implements MajorManager {

    @Autowired
    private MajorEntityExtMapper majorMapper;

    @Override
    public List<MajorBo> query(MajorBo majorBo, PaginationBo paginationBo) {
        MajorEntityExt majorEntity = majorBo == null ? null : MajorConverter.fromBo(majorBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);

        List<MajorEntityExt> results = null;
        try {
            results = majorMapper.list(majorEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，学院信息获取失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<MajorBo>();
        }
        List<MajorBo> convertedResults = new ArrayList<MajorBo>();
        for (MajorEntityExt result : results) {
            convertedResults.add(MajorConverter.toBo(result));
        }
        return convertedResults;
    }

}
