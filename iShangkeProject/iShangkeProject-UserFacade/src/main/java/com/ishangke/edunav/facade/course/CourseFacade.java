package com.ishangke.edunav.facade.course;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.OrderByBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CourseService;
import com.ishangke.edunav.commoncontract.service.CourseService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.PermissionCache;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;

@Component
@Scope(value = "singleton")
public class CourseFacade {
    public CourseBo createCourse(CourseTemplateBo courseTemplateBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, String url) {
        CourseBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createCourse(courseTemplateBo, courseBo, partnerBo, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseCommentBo commentCourse(CourseBo courseBo, CourseCommentBo courseCommnet, UserBo userBo, String url) {
        CourseCommentBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.commentCourse(courseBo, courseCommnet, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<CourseCommentBo> queryCommentBuCourseId(CourseBo courseBo, PaginationBo paginationBo, String url) {
        List<CourseCommentBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCommentBuCourseId(courseBo, paginationBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseCommentBo deleteCommentByCommentId(CourseCommentBo courseCommentBo, UserBo userBo, String url) {
        CourseCommentBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteCommentByCommentId(courseCommentBo, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<CategoryBo> queryCategoryByKeyword(String keyword, String url) {
        List<CategoryBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCategoryByKeyword(keyword, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<CourseBo> queryCourseByPartner(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo, String url) {
        List<CourseBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCourseByPartner(courseBo, partnerBo, userBo, paginationBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<CourseBo> queryCourseByFilter(CourseBo courseBo, PaginationBo paginationBo, String url) {
        List<CourseBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCourseByFilter(courseBo, paginationBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseBo queryCourseById(CourseBo courseBo, UserBo userBo, String url) {
        CourseBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCourseById(courseBo, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseBo transformCourseStatus(CourseBo courseBo, int operation, UserBo userBo, String url) {
        CourseBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.transformCourseStatus(courseBo, operation, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String url) {
        CourseTemplateBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createCourseTemplate(courseTemplateBo, partnerBo, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseTemplateBo transformCourseTmeplateStatus(CourseTemplateBo courseTemplateBo, int operation, UserBo userBo, String url) {
        CourseTemplateBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.transformCourseTmeplateStatus(courseTemplateBo, operation, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<CourseTemplateBo> queryCourseTemplateByPartnerId(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo, String url)
            {
        List<CourseTemplateBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCourseTemplateByPartnerId(courseTemplateBo, partnerBo, userBo, paginationBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseTemplateBo queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo, String url) {
        CourseTemplateBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCourseTemplateById(courseTemplateBo, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args) throws TException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath*:applicationContext-*.xml");
        CourseFacade c = new CourseFacade();
        PaginationBo p = new PaginationBo();
        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
        p.setSize(-1);
        p.setOffset(-1);
        CourseBo ccc= new CourseBo();
        ccc.setCategoryValue("00");
        List<CourseBo> course = c.queryCourseByFilter(ccc, p, "");
        System.out.println(course);
        System.out.println(course.size());
        System.out.println("********************************");
        for (CourseBo cc : course) {
            System.out.println(cc);
        }
    }
}
