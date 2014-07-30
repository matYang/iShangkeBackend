package com.ishangke.edunav.facade.user;

import org.apache.thrift.TException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CategoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentPageViewBo;
import com.ishangke.edunav.commoncontract.model.CoursePageViewBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplatePageViewBo;
import com.ishangke.edunav.commoncontract.model.OrderByBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
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
    public CourseBo createCourse(CourseBo courseBo, UserBo userBo, String url) {
        CourseBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createCourse(courseBo, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseCommentBo commentCourse(CourseCommentBo courseCommnet, UserBo userBo, String url) {
        CourseCommentBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.commentCourse(courseCommnet, userBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CourseCommentPageViewBo queryCommentByCourseId(CourseBo courseBo, PaginationBo paginationBo, String url) {
        CourseCommentPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCommentByCourseId(courseBo, paginationBo, PermissionCache.getTag(url));
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

    public CategoryPageViewBo queryCategoryByKeyword(String keyword, String url) {
        CategoryPageViewBo result = null;
        
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

    public CoursePageViewBo queryCourse(CourseBo courseBo, UserBo userBo, PaginationBo paginationBo, String url) {
        CoursePageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCourse(courseBo, userBo, paginationBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public CoursePageViewBo queryCourseByFilter(CourseBo courseBo, PaginationBo paginationBo, String url) {
        CoursePageViewBo result = null;
        
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

    public CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, String url) {
        CourseTemplateBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createCourseTemplate(courseTemplateBo, userBo, PermissionCache.getTag(url));
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

    public CourseTemplatePageViewBo queryCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, PaginationBo paginationBo, String url)
            {
        CourseTemplatePageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<CourseService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCourseTemplate(courseTemplateBo, userBo, paginationBo, PermissionCache.getTag(url));
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
        CoursePageViewBo course = c.queryCourseByFilter(null, null, "");
        System.out.println(course);
        System.out.println(course.getData().size());
        System.out.println("********************************");
        for (CourseBo cc : course.getData()) {
            System.out.println(cc);
        }
    }
}
