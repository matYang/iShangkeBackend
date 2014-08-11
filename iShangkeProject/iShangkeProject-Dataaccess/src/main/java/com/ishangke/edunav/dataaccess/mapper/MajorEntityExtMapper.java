package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.MajorEntityExt;

public interface MajorEntityExtMapper {
    public int add(MajorEntityExt majorEntityExt);

    public void deleteById(int id);

    public void update(MajorEntityExt majorEntityExt);

    public List<MajorEntityExt> list(
            @Param("entity") MajorEntityExt MajorEntityExt,
            @Param("page") PaginationEntity page);
 
    public int getListCount(@Param("entity") MajorEntityExt majorEntityExt);

    public List<MajorEntityExt> listAll();

    public int getCount();

    public MajorEntityExt getById(int id);
    
    public List<MajorEntityExt> getBySchoolId(int schoolId);
    
    public int getCountBySchoolId(int schoolId);
}
