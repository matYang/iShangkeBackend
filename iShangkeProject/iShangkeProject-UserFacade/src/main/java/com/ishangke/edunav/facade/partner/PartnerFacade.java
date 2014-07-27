package com.ishangke.edunav.facade.partner;

import java.util.List;

import org.apache.thrift.TException;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.PartnerService;
import com.ishangke.edunav.commoncontract.service.PartnerService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.PermissionCache;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;

public class PartnerFacade {
    public List<PartnerBo> queryPartner(PartnerBo partnerBo, PaginationBo paginationBo, UserBo userBo, String permissionTag) {
        List<PartnerBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryPartner(partnerBo, paginationBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public PartnerBo queryPartnerById(PartnerBo partnerBo, UserBo userBo, String permissionTag) {
        PartnerBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryPartnerById(partnerBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public PartnerBo updatePartner(PartnerBo partnerBo, UserBo userBo, String permissionTag) {
        PartnerBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.updatePartner(partnerBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public PartnerBo createPartner(PartnerBo partnerBo, UserBo userBo, String permissionTag) {
        PartnerBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createPartner(partnerBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public AddressBo createAddress(AddressBo addressBo, UserBo userBo, String permissionTag) {
        AddressBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createAddress(addressBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public AddressBo updateAddress(AddressBo addressBo, UserBo userBo, String permissionTag) {
        AddressBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.updateAddress(addressBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public AddressBo deleteAddress(AddressBo addressBo, UserBo userBo, String permissionTag) {
        AddressBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteAddress(addressBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<AddressBo> queryAddress(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        List<AddressBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryAddress(addressBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag) {
        ClassPhotoBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createClassPhoto(classPhotoBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag) {
        ClassPhotoBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.updateClassPhoto(classPhotoBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag) {
        ClassPhotoBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteClassPhoto(classPhotoBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<ClassPhotoBo> queryClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        List<ClassPhotoBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryClassPhoto(classPhotoBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public TeacherBo createTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag) {
        TeacherBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createTeacher(teacherBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public TeacherBo updateTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag) {
        TeacherBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.updateTeacher(teacherBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public TeacherBo deleteTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag) {
        TeacherBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteTeacher(teacherBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<TeacherBo> queryTeacher(TeacherBo teacherBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        List<TeacherBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryTeacher(teacherBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) {
        ActivityBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createActivity(activityBo, courseBo, partnerBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo, String permissionTag) {
        ActivityBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.submitActivity(activityBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo, String permissionTag) {
        ActivityBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.approveActivity(activityBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ActivityBo rejectActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) {
        ActivityBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.rejectActivity(activityBo, partnerBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ActivityBo cancelActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) {
        ActivityBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.cancelActivity(activityBo, partnerBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ActivityBo deleteActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) {
        ActivityBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteActivity(activityBo, partnerBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<ActivityBo> queryActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        List<ActivityBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<PartnerService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryActivity(activityBo, partnerBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
