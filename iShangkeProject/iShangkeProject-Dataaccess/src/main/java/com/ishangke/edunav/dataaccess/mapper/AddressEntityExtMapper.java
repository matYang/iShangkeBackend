package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

public interface AddressEntityExtMapper {

    public int add(AddressEntityExt addressEntityExt);
    
    public void deleteById(int id);
    
    public void update(AddressEntityExt addressEntityExt);
    
    public int getCount();

    public List<AddressEntityExt> list(AddressEntityExt addressEntityExt);
}
