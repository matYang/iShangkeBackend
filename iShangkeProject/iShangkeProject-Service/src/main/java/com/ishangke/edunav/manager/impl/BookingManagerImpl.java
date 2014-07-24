package com.ishangke.edunav.manager.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingCreateBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.BookingHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.ContactManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.converter.BookingConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.transform.Operation;

@Component
public class BookingManagerImpl implements BookingManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingManagerImpl.class);

    @Autowired
    private AuthManager authManager;

    @Autowired
    private TransformManager transformManager;

    @Autowired
    private BookingEntityExtMapper bookingMapper;

    @Autowired
    private ContactManager contactManager;

    @Autowired
    private CouponManager couponManager;

    @Autowired
    private BookingHistoryEntityExtMapper bookingHistoryMapper;

    @Autowired
    private CourseEntityExtMapper courseMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Override
    public BookingBo createBookingByUser(CourseBo courseBo, BookingBo bookingBo, CommentBookingCreateBo commentBookingCreateBo, UserBo userBo) {
        // TODO coupon的使用
        return null;
    }

    @Override
    public List<BookingBo> queryBooking(BookingBo bookingBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookingHistoryBo> queryHistory(BookingHistoryBo bookingHistoryBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 所有的关于booking的状态的转移都是通过此入口实现的 不再提供除创建、删除之外的特定方法
     */
    @Override
    public BookingBo transformBookingStatus(BookingBo bookingBo, int operation, UserBo userBo) {
        BookingEntityExt bookingEntityExt = bookingMapper.getById(bookingBo.getId());
        if (bookingEntityExt == null) {
            throw new ManagerException("booking is nolonger exits");
        }
        String roleName = authManager.getRole(userBo.getId());
        List<Operation> operationList = transformManager.getOperationByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, bookingEntityExt.getStatus());
        Operation op = null;
        for (Operation o : operationList) {
            if (o.getOperateCode() == operation) {
                op = o;
            }
        }
        if (Constant.ROLEUSER.equals(roleName)) {
            // 如果是普通用户
            // 用户修改自己的booking
            if (bookingEntityExt.getUserId() != userBo.getId()) {
                throw new ManagerException("cannot modift other's booking");
            }
            // 按照业务流程修改订单
            if (op == null) {
                throw new ManagerException("cannot modift current booking status");
            }
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setOptName(operation);
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistoryMapper.add(bookingHistory);
            return (BookingConverter.toBo(bookingMapper.getById(bookingBo.getId())));
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            // 如果是合作商管理员
            // 合作商只能修改自己本机构的booking
            CourseEntityExt course = courseMapper.getInfoById(bookingBo.getCourseId());
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("unlogin user");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (g.getPartnerId().equals(course.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (!isSameGroup) {
                throw new ManagerException("cannot modift other's booking");
            }
            // 按照业务流程修改booking
            if (op == null) {
                throw new ManagerException("cannot modift current booking status");
            }
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setOptName(operation);
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistoryMapper.add(bookingHistory);
            return (BookingConverter.toBo(bookingMapper.getById(bookingBo.getId())));
        } else if (Constant.ROLEADMIN.equals(roleName)) {
            // 如果是管理员
            // 按照业务流程修改booking
            if (op == null) {
                throw new ManagerException("cannot modift current booking status");
            }
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setOptName(operation);
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistoryMapper.add(bookingHistory);
            return (BookingConverter.toBo(bookingMapper.getById(bookingBo.getId())));
        } else if (Constant.ROLESYSTEMADMIN.equals(roleName)) {
            //超级管理员可以进行任何操作
            //系统会将本次操作标记为异常
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            List<Operation> allOperation = transformManager.listAll(Constant.STATUSTRANSFORMBOOKING);
            for (Operation o : allOperation) {
                if (o.getOperateCode() == operation) {
                    op = o;
                    break;
                }
            }
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setNormal(Constant.BOOKINGUNNORMAL);
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            //just for test
            bookingHistory.setEnabled(0);
            bookingHistoryMapper.add(bookingHistory);
            LOGGER.warn(String.format("[Booking]system admin system [%d] [%s] booking status from [%d] to [%d] at" + new Date(), userBo.getId(), op.getName(), preStatus, op.getNextStatus()));
            return (BookingConverter.toBo(bookingMapper.getById(bookingBo.getId())));
        }
        return null;
    }

}
