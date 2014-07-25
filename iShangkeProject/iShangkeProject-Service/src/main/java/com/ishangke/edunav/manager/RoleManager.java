package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.RoleBo;

public interface RoleManager {

    int add(RoleBo roleBo);

    void deleteById(int id);

    void update(RoleBo roleBo);

    List<RoleBo> list(RoleBo roleBo, PaginationBo page);

    int getListCount(RoleBo roleBo);

    List<RoleBo> listAll();

    int getCount();

    List<RoleBo> listRolesByUserId(int userId);

    int getCountByUserId(int userId);

    List<RoleBo> listRolesByGroupId(int groupId);

    int getCountByGroupId(int groupId);

    RoleBo getById(int id);

}
