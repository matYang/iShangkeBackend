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
import com.ishangke.edunav.manager.transform.TransformGroup;

public class TransformUtil {
    public static ActionBo toActionBo(Operation o) {
        ActionBo a = new ActionBo();
        a.setName(o.getName());
        a.setUrl(o.getUrl());
        return a;
    }
    
//    public static List<ActionBo> getActionByGroupName(String groupName, String entityName, int currentStatus) {
//        List<TransformGroup> transformGroupList = new ArrayList<>();
//        List<ActionBo> actionBoList = new ArrayList<>();
//        for (TransformGroup t: transformGroupList) {
//            if(t.getName().equals(groupName)) {
//                List<StatusEntity> statusEntitiesList = t.getEntitys();
//                for(StatusEntity se : statusEntitiesList) {
//                    if(se.getName().equals(entityName)) {
//                        List<CurrentStatus> currentStatusList = se.getCurrentStatuses();
//                        for(CurrentStatus s : currentStatusList) {
//                            if(s.getStatusCode() == currentStatus) {
//                                List<Operation> operationsList = s.getOperations();
//                                for(Operation o : operationsList) {
//                                    actionBoList.add(TransformUtil.toActionBo(o));
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return actionBoList;
//    }
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        Operation operation = new Operation();
        operation.setName("submit");
        operation.setOperateCode(0);
        operation.setUrl("/submit");
        
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
        TransformGroup transformGroup = new TransformGroup();
        transformGroup.setName("admin");
        transformGroup.setGroupCode(0);
        transformGroup.setEntitys(entitys);
        
        List<TransformGroup> listGroups = new ArrayList<>();
        listGroups.add(transformGroup);
        Transform transform = new Transform();
        transform.setTransformGroups(listGroups);
        
        ObjectMapper mapper = new ObjectMapper(); 
        String userMapJson = mapper.writeValueAsString(transform);
        System.out.println(userMapJson);
        
        Transform user = mapper.readValue(userMapJson, Transform.class);
        String xxx = mapper.writeValueAsString(user);
        System.out.println(xxx);
    }
}
