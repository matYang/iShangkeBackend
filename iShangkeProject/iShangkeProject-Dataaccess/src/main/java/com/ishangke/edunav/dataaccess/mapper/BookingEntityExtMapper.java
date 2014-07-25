package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

public interface BookingEntityExtMapper {

    public int add(BookingEntityExt bookingEntityExt);

    public void deleteById(int id);

    public void update(BookingEntityExt bookingEntityExt);

    public List<BookingEntityExt> list(
            @Param("entity") BookingEntityExt bookingEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") BookingEntityExt bookingEntityExt);

    public List<BookingEntityExt> listAll();

    public int getCount();

    public BookingEntityExt getById(int id);
    
    public List<BookingEntityExt> listByUserId(@Param("entity") BookingEntityExt bookingEntityExt, @Param("user") UserEntityExt user,
            @Param("page") PaginationEntity page);
    
    public int getCountByUserId(@Param("entity") BookingEntityExt bookingEntityExt, @Param("user") UserEntityExt user);
    
    public List<BookingEntityExt> listByPartnerId(@Param("entity") BookingEntityExt bookingEntityExt, @Param("partner") PartnerEntityExt partner,
            @Param("page") PaginationEntity page);
    
    public int getCountBypartnerId(@Param("entity") BookingEntityExt bookingEntityExt, @Param("partner") PartnerEntityExt partner);
}
