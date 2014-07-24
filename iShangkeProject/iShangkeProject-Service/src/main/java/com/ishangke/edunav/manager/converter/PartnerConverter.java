package com.ishangke.edunav.manager.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public class PartnerConverter {
    public static PartnerBo toBo(PartnerEntityExt e) {
        PartnerBo partnerBo = new PartnerBo();
        if (e.getAddressList() != null) {
            List<AddressBo> list = new ArrayList<>();
            for (AddressEntityExt a : e.getAddressList()) {
                list.add(AddressConverter.toBo(a));
            }
            partnerBo.setAddressList(list);
        }
        if (e.getClassPhotoList() != null) {
            List<ClassPhotoBo> list = new ArrayList<>();
            for (ClassPhotoEntityExt a : e.getClassPhotoList()) {
                list.add(ClassPhotoConverter.toBo(a));
            }
            partnerBo.setClassPhotoList(list);
        }
        partnerBo.setContract(e.getContract());
        partnerBo.setCourseContact(e.getCourseContact());
        partnerBo.setCourseContactPhone(e.getCourseContactPhone());
        partnerBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        partnerBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        partnerBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        partnerBo.setCutoffDay(e.getCutoffDay());
        partnerBo.setCutoffDayEnd(e.getCutoffDayEnd());
        partnerBo.setCutoffDaySet(e.getCutoffDaySet());
        partnerBo.setCutoffDayStart(e.getCutoffDayStart());
        partnerBo.setCutoffTime(e.getCutoffTime());
        partnerBo.setCutoffTimeEnd(e.getCutoffTimeEnd());
        partnerBo.setCutoffTimeSet(e.getCutoffTimeSet());
        partnerBo.setCutoffTimeStart(e.getCutoffTimeStart());
        partnerBo.setEduQualificationImgUrl(e.getEduQualificationImgUrl());
        partnerBo.setEnabled(e.getEnabled());
        partnerBo.setHqContact(e.getHqContact());
        partnerBo.setHqContactPhone(e.getHqContactPhone());
        partnerBo.setHqContactSecopt(e.getHqContactSecopt());
        partnerBo.setHqLocation(e.getHqLocation());
        partnerBo.setId(e.getId());
        partnerBo.setIdSet(e.getIdSet());
        partnerBo.setInstName(e.getInstName());
        partnerBo.setLastLoginTime(e.getLastLoginTime() == null ? Constant.DEFAULTNULL : e.getLastLoginTime().getTimeInMillis());
        partnerBo.setLastLoginTimeEnd(e.getLastLoginTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastLoginTimeEnd().getTimeInMillis());
        partnerBo.setLastLoginTimeStart(e.getLastLoginTimeStart() == null ? Constant.DEFAULTNULL : e.getLastLoginTimeStart().getTimeInMillis());
        partnerBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        partnerBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        partnerBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        partnerBo.setLicence(e.getLicence());
        partnerBo.setLicenceImgUrl(e.getLicenceImgUrl());
        partnerBo.setLogoUrl(e.getLogoUrl());
        partnerBo.setOrganizationNum(e.getOrganizationNum());
        partnerBo.setPartnerDistinction(e.getPartnerDistinction());
        partnerBo.setPartnerIntro(e.getPartnerIntro());
        partnerBo.setPartnerQualification(e.getPartnerQualification());
        partnerBo.setPartnerQualificationEnd(e.getPartnerQualificationEnd());
        partnerBo.setPartnerQualificationStart(e.getPartnerQualificationStart());
        partnerBo.setPassword(e.getPassword());
        partnerBo.setRating(e.getRating());
        partnerBo.setRatingEnd(e.getRatingEnd());
        partnerBo.setRatingStart(e.getRatingStart());
        partnerBo.setReference(e.getReference());
        partnerBo.setRegContact(e.getRegContact());
        partnerBo.setRegContactFax(e.getRegContactFax());
        partnerBo.setRegContactPhone(e.getRegContactPhone());
        partnerBo.setStudentInqueryPhone(e.getStudentInqueryPhone());
        partnerBo.setTaxRegImgUrl(e.getTaxRegImgUrl());
        if (e.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherEntityExt a : e.getTeacherList()) {
                list.add(TeacherConverter.toBo(a));
            }
            partnerBo.setTeacherList(list);
        }
        partnerBo.setUniRegLocation(e.getUniRegLocation());
        partnerBo.setWholeName(e.getWholeName());
        return partnerBo;
    }

    public static PartnerEntityExt fromBo(PartnerBo bo) {
        PartnerEntityExt partnerEntityExt = new PartnerEntityExt();
        if (bo.getAddressList() != null) {
            List<AddressEntityExt> list = new ArrayList<>();
            for (AddressBo a : bo.getAddressList()) {
                list.add(AddressConverter.fromBo(a));
            }
            partnerEntityExt.setAddressList(list);
        }
        if (bo.getClassPhotoList() != null) {
            List<ClassPhotoEntityExt> list = new ArrayList<>();
            for (ClassPhotoBo a : bo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.fromBo(a));
            }
            partnerEntityExt.setClassPhotoList(list);
        }
        partnerEntityExt.setContract(bo.getContract());
        partnerEntityExt.setCourseContact(bo.getCourseContact());
        partnerEntityExt.setCourseContactPhone(bo.getCourseContactPhone());
        partnerEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        partnerEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        partnerEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        partnerEntityExt.setCutoffDay(bo.getCutoffDay());
        partnerEntityExt.setCutoffDayEnd(bo.getCutoffDayEnd());
        partnerEntityExt.setCutoffDaySet(bo.getCutoffDaySet());
        partnerEntityExt.setCutoffDayStart(bo.getCutoffDayStart());
        partnerEntityExt.setCutoffTime(bo.getCutoffTime());
        partnerEntityExt.setCutoffTimeEnd(bo.getCutoffTimeEnd());
        partnerEntityExt.setCutoffTimeSet(bo.getCutoffTimeSet());
        partnerEntityExt.setCutoffTimeStart(bo.getCutoffTimeStart());
        partnerEntityExt.setEduQualificationImgUrl(bo.getEduQualificationImgUrl());
        partnerEntityExt.setEnabled(bo.getEnabled());
        partnerEntityExt.setHqContact(bo.getHqContact());
        partnerEntityExt.setHqContactPhone(bo.getHqContactPhone());
        partnerEntityExt.setHqContactSecopt(bo.getHqContactSecopt());
        partnerEntityExt.setHqLocation(bo.getHqLocation());
        partnerEntityExt.setId(bo.getId());
        partnerEntityExt.setIdSet(bo.getIdSet());
        partnerEntityExt.setInstName(bo.getInstName());
        partnerEntityExt.setLastLoginTime(DateUtility.getTimeFromLong(bo.getLastLoginTime()));
        partnerEntityExt.setLastLoginTimeEnd(DateUtility.getTimeFromLong(bo.getLastLoginTimeEnd()));
        partnerEntityExt.setLastLoginTimeStart(DateUtility.getTimeFromLong(bo.getLastLoginTimeStart()));
        partnerEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        partnerEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        partnerEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        partnerEntityExt.setLicence(bo.getLicence());
        partnerEntityExt.setLicenceImgUrl(bo.getLicenceImgUrl());
        partnerEntityExt.setLogoUrl(bo.getLogoUrl());
        partnerEntityExt.setOrganizationNum(bo.getOrganizationNum());
        partnerEntityExt.setPartnerDistinction(bo.getPartnerDistinction());
        partnerEntityExt.setPartnerIntro(bo.getPartnerIntro());
        partnerEntityExt.setPartnerQualification(bo.getPartnerQualification());
        partnerEntityExt.setPartnerQualificationEnd(bo.getPartnerQualificationEnd());
        partnerEntityExt.setPartnerQualificationStart(bo.getPartnerQualificationStart());
        partnerEntityExt.setPassword(bo.getPassword());
        partnerEntityExt.setRating(bo.getRating());
        partnerEntityExt.setRatingEnd(bo.getRatingEnd());
        partnerEntityExt.setRatingStart(bo.getRatingStart());
        partnerEntityExt.setReference(bo.getReference());
        partnerEntityExt.setRegContact(bo.getRegContact());
        partnerEntityExt.setRegContactFax(bo.getRegContactFax());
        partnerEntityExt.setRegContactPhone(bo.getRegContactPhone());
        partnerEntityExt.setStudentInqueryPhone(bo.getStudentInqueryPhone());
        partnerEntityExt.setTaxRegImgUrl(bo.getTaxRegImgUrl());
        if (bo.getTeacherList() != null) {
            List<TeacherEntityExt> list = new ArrayList<>();
            for (TeacherBo a : bo.getTeacherList()) {
                list.add(TeacherConverter.fromBo(a));
            }
            partnerEntityExt.setTeacherList(list);
        }
        partnerEntityExt.setUniRegLocation(bo.getUniRegLocation());
        partnerEntityExt.setWholeName(bo.getWholeName());
        return partnerEntityExt;
    }
}
