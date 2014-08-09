package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
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
        if (vo == null) {
            return null;
        }
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
        } else {
            partnerBo.setCutoffDay(Constant.DEFAULTNULL);
        }
        if (vo.getCutoffDayEnd() != null) {
            partnerBo.setCutoffDayEnd(vo.getCutoffDayEnd());
        } else {
            partnerBo.setCutoffDayEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCutoffDaySet() != null) {
            partnerBo.setCutoffDaySet(vo.getCutoffDaySet());
        }
        if (vo.getCutoffDayStart() != null) {
            partnerBo.setCutoffDayStart(vo.getCutoffDayStart());
        } else {
            partnerBo.setCutoffDayStart(Constant.DEFAULTNULL);
        }
        if (vo.getCutoffTime() != null) {
            partnerBo.setCutoffTime(vo.getCutoffTime());
        } else {
            partnerBo.setCutoffTime(Constant.DEFAULTNULL);
        }
        if (vo.getCutoffTimeEnd() != null) {
            partnerBo.setCutoffTimeEnd(vo.getCutoffTimeEnd());
        } else {
            partnerBo.setCutoffTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCutoffTimeSet() != null) {
            partnerBo.setCutoffTimeSet(vo.getCutoffTimeSet());
        }
        if (vo.getCutoffTimeStart() != null) {
            partnerBo.setCutoffTimeStart(vo.getCutoffTimeStart());
        } else {
            partnerBo.setCutoffTimeStart(Constant.DEFAULTNULL);
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
        } else {
            partnerBo.setPartnerQualification(Constant.DEFAULTNULL);
        }
        if (vo.getPartnerQualificationEnd() != null) {
            partnerBo.setPartnerQualificationEnd(vo.getPartnerQualificationEnd());
        } else {
            partnerBo.setPartnerQualificationEnd(Constant.DEFAULTNULL);
        }
        if (vo.getPartnerQualificationStart() != null) {
            partnerBo.setPartnerQualificationStart(vo.getPartnerQualificationStart());
        } else {
            partnerBo.setPartnerQualificationStart(Constant.DEFAULTNULL);
        }

        if (vo.getRating() != null) {
            partnerBo.setRating(vo.getRating());
        } else {
            partnerBo.setRating(Constant.DEFAULTNULL);
        }
        if (vo.getRatingEnd() != null) {
            partnerBo.setRatingEnd(vo.getRatingEnd());
        } else {
            partnerBo.setRatingEnd(Constant.DEFAULTNULL);
        }
        if (vo.getRatingStart() != null) {
            partnerBo.setRatingStart(vo.getRatingStart());
        } else {
            partnerBo.setRatingStart(Constant.DEFAULTNULL);
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
        } else {
            partnerBo.setUniRegLocation(Constant.DEFAULTNULL);
        }
        if (vo.getWholeName() != null) {
            partnerBo.setWholeName(vo.getWholeName());
        }

        if (vo.getLastModifyTime() != null) {
            partnerBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            partnerBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            partnerBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            partnerBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            partnerBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            partnerBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTime() != null) {
            partnerBo.setCreateTime(vo.getCreateTime());
        } else {
            partnerBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            partnerBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            partnerBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            partnerBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            partnerBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
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
        if (bo == null) {
            return null;
        }
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
        partnerVo.setCreateTime(bo.getCreateTime());
        partnerVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        partnerVo.setCreateTimeStart(bo.getCreateTimeStart());
        if (Constant.DEFAULTNULL != bo.getCutoffDay()) {
            partnerVo.setCutoffDay(bo.getCutoffDay());
        }
        if (Constant.DEFAULTNULL != bo.getCutoffDayEnd()) {
            partnerVo.setCutoffDayEnd(bo.getCutoffDayEnd());
        }
        partnerVo.setCutoffDaySet(bo.getCutoffDaySet());
        if (Constant.DEFAULTNULL != bo.getCutoffDayStart()) {
            partnerVo.setCutoffDayStart(bo.getCutoffDayStart());
        }
        if (Constant.DEFAULTNULL != bo.getCutoffTime()) {
            partnerVo.setCutoffTime(bo.getCutoffTime());
        }
        if (Constant.DEFAULTNULL != bo.getCutoffTimeEnd()) {
            partnerVo.setCutoffTimeEnd(bo.getCutoffTimeEnd());
        }
        partnerVo.setCutoffTimeSet(bo.getCutoffTimeSet());
        if (Constant.DEFAULTNULL != bo.getCutoffTimeStart()) {
            partnerVo.setCutoffTimeStart(bo.getCutoffTimeStart());
        }
        partnerVo.setEduQualificationImgUrl(bo.getEduQualificationImgUrl());
        partnerVo.setEnabled(bo.getEnabled());
        partnerVo.setHqContact(bo.getHqContact());
        partnerVo.setHqContactPhone(bo.getHqContactPhone());
        partnerVo.setHqContactSecopt(bo.getHqContactSecopt());
        partnerVo.setHqLocation(bo.getHqLocation());
        partnerVo.setId(bo.getId());
        partnerVo.setIdSet(bo.getIdSet());
        partnerVo.setInstName(bo.getInstName());

        partnerVo.setLastModifyTime(bo.getLastModifyTime());
        partnerVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        partnerVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        partnerVo.setLicence(bo.getLicence());
        partnerVo.setLicenceImgUrl(bo.getLicenceImgUrl());
        partnerVo.setLogoUrl(bo.getLogoUrl());
        partnerVo.setOrganizationNum(bo.getOrganizationNum());
        partnerVo.setPartnerDistinction(bo.getPartnerDistinction());
        partnerVo.setPartnerIntro(bo.getPartnerIntro());
        if (Constant.DEFAULTNULL != bo.getPartnerQualification()) {
            partnerVo.setPartnerQualification(bo.getPartnerQualification());
        }
        if (Constant.DEFAULTNULL != bo.getPartnerQualificationEnd()) {
            partnerVo.setPartnerQualificationEnd(bo.getPartnerQualificationEnd());
        }
        if (Constant.DEFAULTNULL != bo.getPartnerQualificationStart()) {
            partnerVo.setPartnerQualificationStart(bo.getPartnerQualificationStart());
        }

        if (Constant.DEFAULTNULL != bo.getRating()) {
            partnerVo.setRating(bo.getRating());
        }
        if (Constant.DEFAULTNULL != bo.getRatingEnd()) {
            partnerVo.setRatingEnd(bo.getRatingEnd());
        }
        if (Constant.DEFAULTNULL != bo.getRatingStart()) {
            partnerVo.setRatingStart(bo.getRatingStart());
        }
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
        if (Constant.DEFAULTNULL != bo.getUniRegLocation()) {
            partnerVo.setUniRegLocation(bo.getUniRegLocation());
        }
        partnerVo.setWholeName(bo.getWholeName());
        return partnerVo;
    }
}
