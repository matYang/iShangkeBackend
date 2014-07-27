package com.ishangke.edunav.manager.common;

import com.ishangke.edunav.commoncontract.service.AccountService;
import com.ishangke.edunav.commoncontract.service.BookingService;
import com.ishangke.edunav.commoncontract.service.CourseService;
import com.ishangke.edunav.commoncontract.service.CourseTemplateService;
import com.ishangke.edunav.commoncontract.service.GeneralService;
import com.ishangke.edunav.commoncontract.service.PartnerService;
import com.ishangke.edunav.commoncontract.service.UserService;
import com.ishangke.edunav.service.impl.AccountServiceImpl;
import com.ishangke.edunav.service.impl.BookingServiceImpl;
import com.ishangke.edunav.service.impl.CourseServiceImpl;
import com.ishangke.edunav.service.impl.CourseTemplateServiceImpl;
import com.ishangke.edunav.service.impl.GeneralServiceImpl;
import com.ishangke.edunav.service.impl.PartnerServiceImpl;
import com.ishangke.edunav.service.impl.UserServiceImpl;

public enum ServiceEnum {
    Account("Account", 9001, AccountService.Processor.class, AccountServiceImpl.class),
    Booking("Booking", 9002, BookingService.Processor.class, BookingServiceImpl.class),
    Course("Course", 9003, CourseService.Processor.class, CourseServiceImpl.class),
    CourseTemplate("CourseTemplate", 9004, CourseTemplateService.Processor.class, CourseTemplateServiceImpl.class),
    General("General", 9005, GeneralService.Processor.class, GeneralServiceImpl.class), 
    Partner("Partner", 9006, PartnerService.Processor.class, PartnerServiceImpl.class), 
    User("User", 9007, UserService.Processor.class, UserServiceImpl.class);

    private ServiceEnum(String name, int port, Class<?> processorClass, Class<?> handlerClass) {
        this.name = name;
        this.port = port;
        this.processorClass = processorClass;
        this.handlerClass = handlerClass;
    }

    private Class<?> processorClass;
    private Class<?> handlerClass;
    private String name;
    private int port;

    public Class<?> getProcessorClass() {
        return processorClass;
    }

    public void setProcessorClass(Class<?> processorClass) {
        this.processorClass = processorClass;
    }

    public Class<?> getHandlerClass() {
        return handlerClass;
    }

    public void setHandlerClass(Class<?> handlerClass) {
        this.handlerClass = handlerClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
