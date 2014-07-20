package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CareerEntityExt;

public interface CareerEntityExtMapper {

    public int add(CareerEntityExt CareerEntityExt);

    public void deleteById(int id);

    public void update(CareerEntityExt CareerEntityExt);

    public List<CareerEntityExt> list(
            @Param("entity") CareerEntityExt CareerEntityExt,
            @Param("page") PaginationEntity page);
 
    public int getListCount(@Param("entity") CareerEntityExt CareerEntityExt);

    public List<CareerEntityExt> listAll();

    public int getCount();

    public CareerEntityExt getById(int id);
}
