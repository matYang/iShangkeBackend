package com.ishangke.edunav.manager.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public class PartnerConverter {
    public static PartnerBo toBo(PartnerEntityExt e) {
        if (e == null) {
            return null;
        }
        PartnerBo partnerBo = new PartnerBo();
        if (e.getContract() != null) {
            partnerBo.setContract(e.getContract());
        }
        if (e.getCourseContact() != null) {
            partnerBo.setCourseContact(e.getCourseContact());
        }
        if (e.getCourseContactPhone() != null) {
            partnerBo.setCourseContactPhone(e.getCourseContactPhone());
        }
        if (e.getCutoffDay() != null) {
            partnerBo.setCutoffDay(e.getCutoffDay());
        } else {
            partnerBo.setCutoffDay(Constant.DEFAULTNULL);
        }
        if (e.getCutoffDayEnd() != null) {
            partnerBo.setCutoffDayEnd(e.getCutoffDayEnd());
        } else {
            partnerBo.setCutoffDayEnd(Constant.DEFAULTNULL);
        }
        if (e.getCutoffDaySet() != null) {
            partnerBo.setCutoffDaySet(e.getCutoffDaySet());
        }
        if (e.getCutoffDayStart() != null) {
            partnerBo.setCutoffDayStart(e.getCutoffDayStart());
        } else {
            partnerBo.setCutoffDayStart(Constant.DEFAULTNULL);
        }
        if (e.getCutoffTime() != null) {
            partnerBo.setCutoffTime(e.getCutoffTime());
        } else {
            partnerBo.setCutoffTime(Constant.DEFAULTNULL);
        }
        if (e.getCutoffTimeEnd() != null) {
            partnerBo.setCutoffTimeEnd(e.getCutoffTimeEnd());
        } else {
            partnerBo.setCutoffTimeEnd(Constant.DEFAULTNULL);
        }
        if (e.getCutoffTimeSet() != null) {
            partnerBo.setCutoffTimeSet(e.getCutoffTimeSet());
        }
        if (e.getCutoffTimeStart() != null) {
            partnerBo.setCutoffTimeStart(e.getCutoffTimeStart());
        } else {
            partnerBo.setCutoffTimeStart(Constant.DEFAULTNULL);
        }
        if (e.getEduQualificationImgUrl() != null) {
            partnerBo.setEduQualificationImgUrl(e.getEduQualificationImgUrl());
        }
        if (e.getEnabled() != null) {
            partnerBo.setEnabled(e.getEnabled());
        }
        if (e.getHqContact() != null) {
            partnerBo.setHqContact(e.getHqContact());
        }
        if (e.getHqContactPhone() != null) {
            partnerBo.setHqContactPhone(e.getHqContactPhone());
        }
        if (e.getHqContactSecopt() != null) {
            partnerBo.setHqContactSecopt(e.getHqContactSecopt());
        }
        if (e.getHqLocation() != null) {
            partnerBo.setHqLocation(e.getHqLocation());
        }
        if (e.getId() != null) {
            partnerBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            partnerBo.setIdSet(e.getIdSet());
        }
        if (e.getInstName() != null) {
            partnerBo.setInstName(e.getInstName());
        }
        if (e.getLicence() != null) {
            partnerBo.setLicence(e.getLicence());
        }
        if (e.getLicenceImgUrl() != null) {
            partnerBo.setLicenceImgUrl(e.getLicenceImgUrl());
        }
        if (e.getLogoUrl() != null) {
            partnerBo.setLogoUrl(e.getLogoUrl());
        }
        if (e.getOrganizationNum() != null) {
            partnerBo.setOrganizationNum(e.getOrganizationNum());
        }
        if (e.getPartnerDistinction() != null) {
            partnerBo.setPartnerDistinction(e.getPartnerDistinction());
        }
        if (e.getPartnerIntro() != null) {
            partnerBo.setPartnerIntro(e.getPartnerIntro());
        }
        if (e.getPartnerQualification() != null) {
            partnerBo.setPartnerQualification(e.getPartnerQualification());
        } else {
            partnerBo.setPartnerQualification(Constant.DEFAULTNULL);
        }
        if (e.getPartnerQualificationEnd() != null) {
            partnerBo.setPartnerQualificationEnd(e.getPartnerQualificationEnd());
        } else {
            partnerBo.setPartnerQualificationEnd(Constant.DEFAULTNULL);
        }
        if (e.getPartnerQualificationStart() != null) {
            partnerBo.setPartnerQualificationStart(e.getPartnerQualificationStart());
        } else {
            partnerBo.setPartnerQualificationStart(Constant.DEFAULTNULL);
        }
       
        if (e.getRating() != null) {
            partnerBo.setRating(e.getRating());
        } else {
            partnerBo.setRating(Constant.DEFAULTNULL);
        }
        if (e.getRatingEnd() != null) {
            partnerBo.setRatingEnd(e.getRatingEnd());
        } else {
            partnerBo.setRatingEnd(Constant.DEFAULTNULL);
        }
        if (e.getRatingStart() != null) {
            partnerBo.setRatingStart(e.getRatingStart());
        } else {
            partnerBo.setRatingStart(Constant.DEFAULTNULL);
        }
        if (e.getReference() != null) {
            partnerBo.setReference(e.getReference());
        }
        if (e.getRegContact() != null) {
            partnerBo.setRegContact(e.getRegContact());
        }
        if (e.getRegContactFax() != null) {
            partnerBo.setRegContactFax(e.getRegContactFax());
        }
        if (e.getRegContactPhone() != null) {
            partnerBo.setRegContactPhone(e.getRegContactPhone());
        }
        if (e.getStudentInqueryPhone() != null) {
            partnerBo.setStudentInqueryPhone(e.getStudentInqueryPhone());
        }
        if (e.getTaxRegImgUrl() != null) {
            partnerBo.setTaxRegImgUrl(e.getTaxRegImgUrl());
        }
        if (e.getUniRegLocation() != null) {
            partnerBo.setUniRegLocation(e.getUniRegLocation());
        } else {
            partnerBo.setUniRegLocation(Constant.DEFAULTNULL);
        }
        if (e.getWholeName() != null) {
            partnerBo.setWholeName(e.getWholeName());
        }
        partnerBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        partnerBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        partnerBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
       
        partnerBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        partnerBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        partnerBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        if (e.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherEntityExt a : e.getTeacherList()) {
                list.add(TeacherConverter.toBo(a));
            }
            partnerBo.setTeacherList(list);
        }
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
        if (e.getPopularity() != null) {
            partnerBo.setPopularity(e.getPopularity());
        } else {
            partnerBo.setPopularity(Constant.DEFAULTNULL);
        }
        if (e.getCourseCount() != null) {
            partnerBo.setCourseCount(e.getCourseCount());
        } else {
            partnerBo.setCourseCount(Constant.DEFAULTNULL);
        }
        if (e.getTeacherCount() != null) {
            partnerBo.setTeacherCount(e.getTeacherCount());
        } else {
            partnerBo.setTeacherCount(Constant.DEFAULTNULL);
        }
        if (e.getCategoryList() != null) {
            List<CategoryBo> list = new ArrayList<>();
            for (CategoryEntityExt a : e.getCategoryList()) {
                list.add(CategoryConverter.toBo(a));
            }
            partnerBo.setCategoryList(list);
        }
        if (e.getCategoryValue() != null) {
            partnerBo.setCategoryValue(e.getCategoryValue());
        }
        if (e.getCircleValue() != null) {
            partnerBo.setCircleValue(e.getCircleValue());
        }
        if (e.getLocationValue() != null) {
            partnerBo.setLocationValue(e.getLocationValue());
        }
        return partnerBo;
    }

    public static PartnerEntityExt fromBo(PartnerBo bo) {
        if (bo == null) {
            return null;
        }
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
        if (bo.getCutoffDay() != Constant.DEFAULTNULL) {
            partnerEntityExt.setCutoffDay(bo.getCutoffDay());
        }
        if (bo.getCutoffDayEnd() != Constant.DEFAULTNULL) {
            partnerEntityExt.setCutoffDayEnd(bo.getCutoffDayEnd());
        }
        partnerEntityExt.setCutoffDaySet(bo.getCutoffDaySet());
        if (bo.getCutoffDayStart() != Constant.DEFAULTNULL) {
            partnerEntityExt.setCutoffDayStart(bo.getCutoffDayStart());
        }
        if (bo.getCutoffTime() != Constant.DEFAULTNULL) {
            partnerEntityExt.setCutoffTime(bo.getCutoffTime());
        }
        if (bo.getCutoffTimeEnd() != Constant.DEFAULTNULL) {
            partnerEntityExt.setCutoffTimeEnd(bo.getCutoffTimeEnd());
        }
        partnerEntityExt.setCutoffTimeSet(bo.getCutoffTimeSet());
        if (bo.getCutoffTimeStart() != Constant.DEFAULTNULL) {
            partnerEntityExt.setCutoffTimeStart(bo.getCutoffTimeStart());
        }
        partnerEntityExt.setEduQualificationImgUrl(bo.getEduQualificationImgUrl());
        partnerEntityExt.setEnabled(bo.getEnabled());
        partnerEntityExt.setHqContact(bo.getHqContact());
        partnerEntityExt.setHqContactPhone(bo.getHqContactPhone());
        partnerEntityExt.setHqContactSecopt(bo.getHqContactSecopt());
        partnerEntityExt.setHqLocation(bo.getHqLocation());
        partnerEntityExt.setId(bo.getId());
        partnerEntityExt.setIdSet(bo.getIdSet());
        partnerEntityExt.setInstName(bo.getInstName());
       
        partnerEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        partnerEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        partnerEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        partnerEntityExt.setLicence(bo.getLicence());
        partnerEntityExt.setLicenceImgUrl(bo.getLicenceImgUrl());
        partnerEntityExt.setLogoUrl(bo.getLogoUrl());
        partnerEntityExt.setOrganizationNum(bo.getOrganizationNum());
        partnerEntityExt.setPartnerDistinction(bo.getPartnerDistinction());
        partnerEntityExt.setPartnerIntro(bo.getPartnerIntro());
        if (bo.getPartnerQualification() != Constant.DEFAULTNULL) {
            partnerEntityExt.setPartnerQualification(bo.getPartnerQualification());
        }
        if (bo.getPartnerQualificationEnd() != Constant.DEFAULTNULL) {
            partnerEntityExt.setPartnerQualificationEnd(bo.getPartnerQualificationEnd());
        }
        if (bo.getPartnerQualificationStart() != Constant.DEFAULTNULL) {
            partnerEntityExt.setPartnerQualificationStart(bo.getPartnerQualificationStart());
        }
     
        if (bo.getRating() != Constant.DEFAULTNULL) {
            partnerEntityExt.setRating(bo.getRating());
        }
        if (bo.getRatingEnd() != Constant.DEFAULTNULL) {
            partnerEntityExt.setRatingEnd(bo.getRatingEnd());
        }
        if (bo.getRatingStart() != Constant.DEFAULTNULL) {
            partnerEntityExt.setRatingStart(bo.getRatingStart());
        }
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
        if (bo.getUniRegLocation() != Constant.DEFAULTNULL) {
            partnerEntityExt.setUniRegLocation(bo.getUniRegLocation());
        }
        partnerEntityExt.setWholeName(bo.getWholeName());
        if (Constant.DEFAULTNULL != bo.getPopularity()) {
            partnerEntityExt.setPopularity(bo.getPopularity());
        }
        partnerEntityExt.setCategoryValue(bo.getCategoryValue());
        partnerEntityExt.setCircleValue(bo.getCircleValue());
        partnerEntityExt.setLocationValue(bo.getLocationValue());
        return partnerEntityExt;
    }
}
