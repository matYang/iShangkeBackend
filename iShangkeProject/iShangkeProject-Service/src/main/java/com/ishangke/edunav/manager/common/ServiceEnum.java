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
    Account("127.0.0.1", 9001, AccountService.Processor.class, AccountServiceImpl.class),
    Booking("127.0.0.1", 9002, BookingService.Processor.class, BookingServiceImpl.class),
    Course("127.0.0.1", 9003, CourseService.Processor.class, CourseServiceImpl.class),
    CourseTemplate("127.0.0.1", 9004, CourseTemplateService.Processor.class, CourseTemplateServiceImpl.class),
    General("127.0.0.1", 9005, GeneralService.Processor.class, GeneralServiceImpl.class), 
    Partner("127.0.0.1", 9006, PartnerService.Processor.class, PartnerServiceImpl.class), 
    User("127.0.0.1", 9007, UserService.Processor.class, UserServiceImpl.class);

    private ServiceEnum(String host, int port, Class<?> processorClass, Class<?> handlerClass) {
        this.host = host;
        this.port = port;
        this.processorClass = processorClass;
        this.handlerClass = handlerClass;
    }

    private Class<?> processorClass;
    private Class<?> handlerClass;
    private String host;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
