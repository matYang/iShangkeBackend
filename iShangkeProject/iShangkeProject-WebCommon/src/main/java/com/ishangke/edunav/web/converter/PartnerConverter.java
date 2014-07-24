package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.model.AddressVo;
import com.ishangke.edunav.web.model.ClassPhotoVo;
import com.ishangke.edunav.web.model.PartnerVo;
import com.ishangke.edunav.web.model.TeacherVo;

public class PartnerConverter {
    public static PartnerBo fromModel(PartnerVo vo) {
        PartnerBo partnerBo = new PartnerBo();
        if (vo.getAddressList() != null) {
            List<AddressBo> list = new ArrayList<>();
            for (AddressVo a : vo.getAddressList()) {
                list.add(AddressConverter.fromModel(a));
            }
            partnerBo.setAddressList(list);
        }
        if (vo.getClassPhotoList() != null) {
            List<ClassPhotoBo> list = new ArrayList<>();
            for (ClassPhotoVo a : vo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.fromModel(a));
            }
            partnerBo.setClassPhotoList(list);
        }
        partnerBo.setContract(vo.getContract());
        partnerBo.setCourseContact(vo.getCourseContact());
        partnerBo.setCourseContactPhone(vo.getCourseContactPhone());
        partnerBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        partnerBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        partnerBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        partnerBo.setCutoffDay(vo.getCutoffDay());
        partnerBo.setCutoffDayEnd(vo.getCutoffDayEnd());
        partnerBo.setCutoffDaySet(vo.getCutoffDaySet());
        partnerBo.setCutoffDayStart(vo.getCutoffDayStart());
        partnerBo.setCutoffTime(vo.getCutoffTime());
        partnerBo.setCutoffTimeEnd(vo.getCutoffTimeEnd());
        partnerBo.setCutoffTimeSet(vo.getCutoffTimeSet());
        partnerBo.setCutoffTimeStart(vo.getCutoffTimeStart());
        partnerBo.setEduQualificationImgUrl(vo.getEduQualificationImgUrl());
        partnerBo.setEnabled(vo.getEnabled());
        partnerBo.setHqContact(vo.getHqContact());
        partnerBo.setHqContactPhone(vo.getHqContactPhone());
        partnerBo.setHqContactSecopt(vo.getHqContactSecopt());
        partnerBo.setHqLocation(vo.getHqLocation());
        partnerBo.setId(vo.getId());
        partnerBo.setIdSet(vo.getIdSet());
        partnerBo.setInstName(vo.getInstName());
        partnerBo.setLastLoginTime(vo.getLastLoginTime() == null ? Constant.DEFAULTNULL : vo.getLastLoginTime().getTimeInMillis());
        partnerBo.setLastLoginTimeEnd(vo.getLastLoginTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastLoginTimeEnd().getTimeInMillis());
        partnerBo.setLastLoginTimeStart(vo.getLastLoginTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastLoginTimeStart().getTimeInMillis());
        partnerBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        partnerBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        partnerBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        partnerBo.setLicence(vo.getLicence());
        partnerBo.setLicenceImgUrl(vo.getLicenceImgUrl());
        partnerBo.setLogoUrl(vo.getLogoUrl());
        partnerBo.setOrganizationNum(vo.getOrganizationNum());
        partnerBo.setPartnerDistinction(vo.getPartnerDistinction());
        partnerBo.setPartnerIntro(vo.getPartnerIntro());
        partnerBo.setPartnerQualification(vo.getPartnerQualification());
        partnerBo.setPartnerQualificationEnd(vo.getPartnerQualificationEnd());
        partnerBo.setPartnerQualificationStart(vo.getPartnerQualificationStart());
        partnerBo.setPassword(vo.getPassword());
        partnerBo.setRating(vo.getRating());
        partnerBo.setRatingEnd(vo.getRatingEnd());
        partnerBo.setRatingStart(vo.getRatingStart());
        partnerBo.setReference(vo.getReference());
        partnerBo.setRegContact(vo.getRegContact());
        partnerBo.setRegContactFax(vo.getRegContactFax());
        partnerBo.setRegContactPhone(vo.getRegContactPhone());
        partnerBo.setStudentInqueryPhone(vo.getStudentInqueryPhone());
        partnerBo.setTaxRegImgUrl(vo.getTaxRegImgUrl());
        if (vo.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherVo a : vo.getTeacherList()) {
                list.add(TeacherConverter.fromModel(a));
            }
            partnerBo.setTeacherList(list);
        }
        partnerBo.setUniRegLocation(vo.getUniRegLocation());
        partnerBo.setWholeName(vo.getWholeName());
        return partnerBo;
    }

    public static PartnerVo toModel(PartnerBo bo) {
        PartnerVo partnerVo = new PartnerVo();
        if (bo.getAddressList() != null) {
            List<AddressVo> list = new ArrayList<>();
            for (AddressBo a : bo.getAddressList()) {
                list.add(AddressConverter.toModel(a));
            }
            partnerVo.setAddressList(list);
        }
        if (bo.getClassPhotoList() != null) {
            List<ClassPhotoVo> list = new ArrayList<>();
            for (ClassPhotoBo a : bo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.toModel(a));
            }
            partnerVo.setClassPhotoList(list);
        }
        partnerVo.setContract(bo.getContract());
        partnerVo.setCourseContact(bo.getCourseContact());
        partnerVo.setCourseContactPhone(bo.getCourseContactPhone());
        partnerVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        partnerVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        partnerVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        partnerVo.setCutoffDay(bo.getCutoffDay());
        partnerVo.setCutoffDayEnd(bo.getCutoffDayEnd());
        partnerVo.setCutoffDaySet(bo.getCutoffDaySet());
        partnerVo.setCutoffDayStart(bo.getCutoffDayStart());
        partnerVo.setCutoffTime(bo.getCutoffTime());
        partnerVo.setCutoffTimeEnd(bo.getCutoffTimeEnd());
        partnerVo.setCutoffTimeSet(bo.getCutoffTimeSet());
        partnerVo.setCutoffTimeStart(bo.getCutoffTimeStart());
        partnerVo.setEduQualificationImgUrl(bo.getEduQualificationImgUrl());
        partnerVo.setEnabled(bo.getEnabled());
        partnerVo.setHqContact(bo.getHqContact());
        partnerVo.setHqContactPhone(bo.getHqContactPhone());
        partnerVo.setHqContactSecopt(bo.getHqContactSecopt());
        partnerVo.setHqLocation(bo.getHqLocation());
        partnerVo.setId(bo.getId());
        partnerVo.setIdSet(bo.getIdSet());
        partnerVo.setInstName(bo.getInstName());
        partnerVo.setLastLoginTime(DateUtility.getTimeFromLong(bo.getLastLoginTime()));
        partnerVo.setLastLoginTimeEnd(DateUtility.getTimeFromLong(bo.getLastLoginTimeEnd()));
        partnerVo.setLastLoginTimeStart(DateUtility.getTimeFromLong(bo.getLastLoginTimeStart()));
        partnerVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        partnerVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        partnerVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        partnerVo.setLicence(bo.getLicence());
        partnerVo.setLicenceImgUrl(bo.getLicenceImgUrl());
        partnerVo.setLogoUrl(bo.getLogoUrl());
        partnerVo.setOrganizationNum(bo.getOrganizationNum());
        partnerVo.setPartnerDistinction(bo.getPartnerDistinction());
        partnerVo.setPartnerIntro(bo.getPartnerIntro());
        partnerVo.setPartnerQualification(bo.getPartnerQualification());
        partnerVo.setPartnerQualificationEnd(bo.getPartnerQualificationEnd());
        partnerVo.setPartnerQualificationStart(bo.getPartnerQualificationStart());
        partnerVo.setPassword(bo.getPassword());
        partnerVo.setRating(bo.getRating());
        partnerVo.setRatingEnd(bo.getRatingEnd());
        partnerVo.setRatingStart(bo.getRatingStart());
        partnerVo.setReference(bo.getReference());
        partnerVo.setRegContact(bo.getRegContact());
        partnerVo.setRegContactFax(bo.getRegContactFax());
        partnerVo.setRegContactPhone(bo.getRegContactPhone());
        partnerVo.setStudentInqueryPhone(bo.getStudentInqueryPhone());
        partnerVo.setTaxRegImgUrl(bo.getTaxRegImgUrl());
        if (bo.getTeacherList() != null) {
            List<TeacherVo> list = new ArrayList<>();
            for (TeacherBo a : bo.getTeacherList()) {
                list.add(TeacherConverter.toModel(a));
            }
            partnerVo.setTeacherList(list);
        }
        partnerVo.setUniRegLocation(bo.getUniRegLocation());
        partnerVo.setWholeName(bo.getWholeName());
        return partnerVo;
    }
}
