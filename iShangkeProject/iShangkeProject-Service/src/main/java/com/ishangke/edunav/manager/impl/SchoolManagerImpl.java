package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.SchoolEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.SchoolEntityExt;
import com.ishangke.edunav.manager.SchoolManager;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.SchoolConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class SchoolManagerImpl implements SchoolManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolManagerImpl.class);

    @Autowired
    private SchoolEntityExtMapper schoolEntityExtMapper;

    @Override
    public List<SchoolBo> query(SchoolBo schoolBo, PaginationBo paginationBo) {
        // Check Null
        if (schoolBo == null) {
            throw new ManagerException("SchoolBo is null");
        }

        // Convert
        SchoolEntityExt schoolEntity = SchoolConverter.fromBo(schoolBo);
        PaginationEntity pageEntity = PaginationConverter.fromBo(paginationBo);
        List<SchoolEntityExt> schoolList = null;
        List<SchoolBo> resultList = null;

        try {
            schoolList = schoolEntityExtMapper.list(schoolEntity, pageEntity);
            for (SchoolEntityExt schoolPo : schoolList) {
                resultList.add(SchoolConverter.toBo(schoolPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("School Query Failed");
        }
    }

}
