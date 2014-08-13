package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.SchoolEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.SchoolEntityExt;
import com.ishangke.edunav.manager.SchoolManager;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.SchoolConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class SchoolManagerImpl implements SchoolManager {
    
    @Autowired
    private SchoolEntityExtMapper schoolMapper;

    @Override
    public List<SchoolBo> query(SchoolBo schoolBo, PaginationBo paginationBo) {
        SchoolEntityExt schoolEntity = schoolBo == null ? null : SchoolConverter.fromBo(schoolBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);

        List<SchoolEntityExt> results = null;
        try {
            results = schoolMapper.list(schoolEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，院校信息获取失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<SchoolBo>();
        }
        List<SchoolBo> convertedResults = new ArrayList<SchoolBo>();
        for (SchoolEntityExt result : results) {
            convertedResults.add(SchoolConverter.toBo(result));
        }
        return convertedResults;
    }

}
