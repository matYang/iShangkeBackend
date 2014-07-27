package com.ishangke.edunav.web.common;

import com.ishangke.edunav.commoncontract.service.AccountService;
import com.ishangke.edunav.commoncontract.service.BookingService;
import com.ishangke.edunav.commoncontract.service.CourseService;
import com.ishangke.edunav.commoncontract.service.GeneralService;
import com.ishangke.edunav.commoncontract.service.PartnerService;
import com.ishangke.edunav.commoncontract.service.UserService;

public enum ClientEnum {
    Account("Account", "127.0.0.1", 9001, AccountService.Client.class),
    Booking("Booking", "127.0.0.1", 9002, BookingService.Client.class),
    Course("Course", "127.0.0.1", 9003, CourseService.Client.class),
//    CourseTemplate("CourseTemplate", "127.0.0.1", 9004, CourseTemplateService.Client.class),
    General("General", "127.0.0.1", 9005, GeneralService.Client.class),
    Partner("Partner", "127.0.0.1", 9006, PartnerService.Client.class),
    User("User", "127.0.0.1", 9007, UserService.Client.class);

    private ClientEnum(String name, String host, int port, Class<?> clientClass) {
        this.name = name;
        this.clientClass = clientClass;
        this.host = host;
        this.port = port;
    }

    private String name;
    private String host;
    private int port;
    private Class<?> clientClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getClientClass() {
        return clientClass;
    }

    public void setClientClass(Class<?> clientClass) {
        this.clientClass = clientClass;
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
