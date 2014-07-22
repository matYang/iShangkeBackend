package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolManagerImpl.class);

    @Autowired
    private SchoolEntityExtMapper schoolMapper;

    @Override
    public List<SchoolBo> query(SchoolBo schoolBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (schoolBo == null) {
            throw new ManagerException("School Query Failed: SchoolBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        SchoolEntityExt schoolEntity = SchoolConverter.fromBo(schoolBo);
        List<SchoolEntityExt> schoolList = null;
        List<SchoolBo> resultList = null;

        try {
            schoolList = schoolMapper.list(schoolEntity, pageEntity);
            for (SchoolEntityExt schoolPo : schoolList) {
                resultList.add(SchoolConverter.toBo(schoolPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("School Query Failed", t);
        }
    }

}
