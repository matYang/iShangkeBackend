package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;

public interface ContactEntityExtMapper {

    public int add(ContactEntityExt contactEntityExt);

    public void deleteById(int id);

    public void update(ContactEntityExt contactEntityExt);

    public int getCount();

    public List<ContactEntityExt> list(
            @Param("entity") ContactEntityExt contactEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") ContactEntityExt contactEntityExt);
}
