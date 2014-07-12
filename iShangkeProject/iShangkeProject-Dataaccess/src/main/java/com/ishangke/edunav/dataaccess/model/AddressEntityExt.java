package com.ishangke.edunav.dataaccess.model;

import com.ishangke.edunav.dataaccess.model.gen.AddressEntity;
import java.util.Date;

public class AddressEntityExt extends AddressEntity {
	private int idStart;
    private int idEnd;

    private int partnerIdStart;
    private int partnerIdEnd;
    private int locationIdStart;
    private int locationIdEnd;
    private int circleIdStart;
    private int circleIdEnd;

    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
}
