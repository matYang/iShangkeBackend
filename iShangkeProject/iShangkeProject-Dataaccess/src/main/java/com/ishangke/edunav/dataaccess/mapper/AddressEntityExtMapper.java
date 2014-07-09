package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

public interface AddressEntityExtMapper {

    public int add(AddressEntityExt addressEntityExt);
    public void deleteById(int id);
    public void update(AddressEntityExt addressEntityExt);
}
