package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.RoleBo;

public interface RoleManager {

    public int add(RoleBo roleBo);

    public void deleteById(int id);

    public void update(RoleBo roleBo);

    public List<RoleBo> list(RoleBo roleBo, PaginationBo page);

    public int getListCount(RoleBo roleBo);

    public List<RoleBo> listAll();

    public int getCount();

    public List<RoleBo> listRolesByUserId(int userId);

    public int getCountByUserId(int userId);

    public List<RoleBo> listRolesByGroupId(int groupId);

    public int getCountByGroupId(int groupId);

    public RoleBo getById(int id);

}
