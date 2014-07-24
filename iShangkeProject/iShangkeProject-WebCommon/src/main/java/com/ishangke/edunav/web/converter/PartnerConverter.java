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
        if (vo.getContract() != null) {
            partnerBo.setContract(vo.getContract());
        }
        if (vo.getCourseContact() != null) {
            partnerBo.setCourseContact(vo.getCourseContact());
        }
        if (vo.getCourseContactPhone() != null) {
            partnerBo.setCourseContactPhone(vo.getCourseContactPhone());
        }
        if (vo.getCutoffDay() != null) {
            partnerBo.setCutoffDay(vo.getCutoffDay());
        }
        if (vo.getCutoffDayEnd() != null) {
            partnerBo.setCutoffDayEnd(vo.getCutoffDayEnd());
        }
        if (vo.getCutoffDaySet() != null) {
            partnerBo.setCutoffDaySet(vo.getCutoffDaySet());
        }
        if (vo.getCutoffDayStart() != null) {
            partnerBo.setCutoffDayStart(vo.getCutoffDayStart());
        }
        if (vo.getCutoffTime() != null) {
            partnerBo.setCutoffTime(vo.getCutoffTime());
        }
        if (vo.getCutoffTimeEnd() != null) {
            partnerBo.setCutoffTimeEnd(vo.getCutoffTimeEnd());
        }
        if (vo.getCutoffTimeSet() != null) {
            partnerBo.setCutoffTimeSet(vo.getCutoffTimeSet());
        }
        if (vo.getCutoffTimeStart() != null) {
            partnerBo.setCutoffTimeStart(vo.getCutoffTimeStart());
        }
        if (vo.getEduQualificationImgUrl() != null) {
            partnerBo.setEduQualificationImgUrl(vo.getEduQualificationImgUrl());
        }
        if (vo.getEnabled() != null) {
            partnerBo.setEnabled(vo.getEnabled());
        }
        if (vo.getHqContact() != null) {
            partnerBo.setHqContact(vo.getHqContact());
        }
        if (vo.getHqContactPhone() != null) {
            partnerBo.setHqContactPhone(vo.getHqContactPhone());
        }
        if (vo.getHqContactSecopt() != null) {
            partnerBo.setHqContactSecopt(vo.getHqContactSecopt());
        }
        if (vo.getHqLocation() != null) {
            partnerBo.setHqLocation(vo.getHqLocation());
        }
        if (vo.getId() != null) {
            partnerBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            partnerBo.setIdSet(vo.getIdSet());
        }
        if (vo.getInstName() != null) {
            partnerBo.setInstName(vo.getInstName());
        }
        if (vo.getLicence() != null) {
            partnerBo.setLicence(vo.getLicence());
        }
        if (vo.getLicenceImgUrl() != null) {
            partnerBo.setLicenceImgUrl(vo.getLicenceImgUrl());
        }
        if (vo.getLogoUrl() != null) {
            partnerBo.setLogoUrl(vo.getLogoUrl());
        }
        if (vo.getOrganizationNum() != null) {
            partnerBo.setOrganizationNum(vo.getOrganizationNum());
        }
        if (vo.getPartnerDistinction() != null) {
            partnerBo.setPartnerDistinction(vo.getPartnerDistinction());
        }
        if (vo.getPartnerIntro() != null) {
            partnerBo.setPartnerIntro(vo.getPartnerIntro());
        }
        if (vo.getPartnerQualification() != null) {
            partnerBo.setPartnerQualification(vo.getPartnerQualification());
        }
        if (vo.getPartnerQualificationEnd() != null) {
            partnerBo.setPartnerQualificationEnd(vo.getPartnerQualificationEnd());
        }
        if (vo.getPartnerQualificationStart() != null) {
            partnerBo.setPartnerQualificationStart(vo.getPartnerQualificationStart());
        }
        if (vo.getPassword() != null) {
            partnerBo.setPassword(vo.getPassword());
        }
        if (vo.getRating() != null) {
            partnerBo.setRating(vo.getRating());
        }
        if (vo.getRatingEnd() != null) {
            partnerBo.setRatingEnd(vo.getRatingEnd());
        }
        if (vo.getRatingStart() != null) {
            partnerBo.setRatingStart(vo.getRatingStart());
        }
        if (vo.getReference() != null) {
            partnerBo.setReference(vo.getReference());
        }
        if (vo.getRegContact() != null) {
            partnerBo.setRegContact(vo.getRegContact());
        }
        if (vo.getRegContactFax() != null) {
            partnerBo.setRegContactFax(vo.getRegContactFax());
        }
        if (vo.getRegContactPhone() != null) {
            partnerBo.setRegContactPhone(vo.getRegContactPhone());
        }
        if (vo.getStudentInqueryPhone() != null) {
            partnerBo.setStudentInqueryPhone(vo.getStudentInqueryPhone());
        }
        if (vo.getTaxRegImgUrl() != null) {
            partnerBo.setTaxRegImgUrl(vo.getTaxRegImgUrl());
        }
        if (vo.getUniRegLocation() != null) {
            partnerBo.setUniRegLocation(vo.getUniRegLocation());
        }
        if (vo.getWholeName() != null) {
            partnerBo.setWholeName(vo.getWholeName());
        }
        partnerBo.setLastLoginTime(vo.getLastLoginTime() == null ? Constant.DEFAULTNULL : vo.getLastLoginTime().getTimeInMillis());
        partnerBo.setLastLoginTimeEnd(vo.getLastLoginTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastLoginTimeEnd().getTimeInMillis());
        partnerBo.setLastLoginTimeStart(vo.getLastLoginTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastLoginTimeStart().getTimeInMillis());
        partnerBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        partnerBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        partnerBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        partnerBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        partnerBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        partnerBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
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
        if (vo.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherVo a : vo.getTeacherList()) {
                list.add(TeacherConverter.fromModel(a));
            }
            partnerBo.setTeacherList(list);
        }
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
