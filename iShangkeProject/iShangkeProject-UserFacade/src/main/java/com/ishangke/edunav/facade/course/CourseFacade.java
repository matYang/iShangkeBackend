package com.ishangke.edunav.facade.course;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.OrderByBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
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
