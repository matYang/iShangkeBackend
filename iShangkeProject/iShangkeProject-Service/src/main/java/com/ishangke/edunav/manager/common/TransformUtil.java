package com.ishangke.edunav.manager.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.manager.transform.CurrentStatus;
import com.ishangke.edunav.manager.transform.Operation;
import com.ishangke.edunav.manager.transform.StatusEntity;
import com.ishangke.edunav.manager.transform.Transform;
import com.ishangke.edunav.manager.transform.TransformRole;

public class TransformUtil {
    public static ActionBo toActionBo(Operation o) {
        ActionBo a = new ActionBo();
        a.setName(o.getName());
        return a;
    }
    
    /**
     * 其实没有什么特比的作用这个类
     * 之所已会存在这个类，主要是我希望有这么一个地方，可以让我需要知道json格式的配置文件怎么定义的时候可以通过简单的main就可以复制出来
     * 没办法 我懒嘛～
     * @param args
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        Operation operation = new Operation();
        operation.setName("submit");
        operation.setOperateCode(0);
        
        List<Operation> operations = new ArrayList<Operation>();
        operations.add(operation);
        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setName("new");
        currentStatus.setOperations(operations);
        currentStatus.setStatusCode(0);
        
        List<CurrentStatus> currentStatuses = new ArrayList<>();
        currentStatuses.add(currentStatus);
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setEntityCode(0);
        statusEntity.setName("booking");
        statusEntity.setCurrentStatuses(currentStatuses);
        
        List<StatusEntity> entitys = new ArrayList<>();
        entitys.add(statusEntity);
        TransformRole transformRole = new TransformRole();
        transformRole.setName("admin");
        transformRole.setRoleCode(0);
        transformRole.setEntitys(entitys);
        
        List<TransformRole> listRoles = new ArrayList<>();
        listRoles.add(transformRole);
        Transform transform = new Transform();
        transform.setTransformRoles(listRoles);
        
        ObjectMapper mapper = new ObjectMapper(); 
        String userMapJson = mapper.writeValueAsString(transform);
        System.out.println(userMapJson);
        
        Transform user = mapper.readValue(userMapJson, Transform.class);
        String xxx = mapper.writeValueAsString(user);
        System.out.println(xxx);
    }
}
