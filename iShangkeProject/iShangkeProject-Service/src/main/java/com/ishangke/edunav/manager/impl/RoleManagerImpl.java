package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.dataaccess.mapper.RoleEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;
import com.ishangke.edunav.manager.RoleManager;
import com.ishangke.edunav.manager.converter.RoleConverter;

@Component
public class RoleManagerImpl implements RoleManager {

    @Autowired
    private RoleEntityExtMapper roleMapper;

    @Override
    public int add(RoleBo roleBo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(RoleBo roleBo) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<RoleBo> list(RoleBo roleBo, PaginationBo page) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getListCount(RoleBo roleBo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<RoleBo> listAll() {
        List<RoleEntityExt> roleList = roleMapper.listAll();
        List<RoleBo> result = new ArrayList<>();
        for (RoleEntityExt roleEntity : roleList) {
            result.add(RoleConverter.toBo(roleEntity));
        }
        return result;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<RoleBo> listRolesByUserId(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getCountByUserId(int userId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<RoleBo> listRolesByGroupId(int groupId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getCountByGroupId(int groupId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public RoleBo getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
