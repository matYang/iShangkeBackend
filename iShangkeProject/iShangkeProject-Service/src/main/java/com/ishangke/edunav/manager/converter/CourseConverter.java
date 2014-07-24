package com.ishangke.edunav.manager.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public class CourseConverter {
    public static CourseBo toBo(CourseEntityExt e) {
        CourseBo courseBo = new CourseBo();
        if (e.getAddress() != null) {
            courseBo.setAddress(e.getAddress());
        }
        if (e.getAddressId() != null) {
            courseBo.setAddressId(e.getAddressId());
        }
        if (e.getAddressLat() != null) {
            courseBo.setAddressLat(e.getAddressLat());
        }
        if (e.getAddressLng() != null) {
            courseBo.setAddressLng(e.getAddressLng());
        }
        if (e.getAssignments() != null) {
            courseBo.setAssignments(e.getAssignments());
        }
        if (e.getBonusService() != null) {
            courseBo.setBonusService(e.getBonusService());
        }
        if (e.getBookingTotal() != null) {
            courseBo.setBookingTotal(e.getBookingTotal());
        }
        if (e.getBookingType() != null) {
            courseBo.setBookingType(e.getBookingType());
        }
        if (e.getCashback() != null) {
            courseBo.setCashback(e.getCashback());
        }
        if (e.getCashbackEnd() != null) {
            courseBo.setCashbackEnd(e.getCashbackEnd());
        }
        if (e.getCashbackStart() != null) {
            courseBo.setCashbackStart(e.getCashbackStart());
        }
        if (e.getCategoryId() != null) {
            courseBo.setCategoryId(e.getCategoryId());
        }
        if (e.getCategoryIdSet() != null) {
            courseBo.setCategoryIdSet(e.getCategoryIdSet());
        }
        if (e.getCategoryName() != null) {
            courseBo.setCategoryName(e.getCategoryName());
        }
        if (e.getCategoryRank() != null) {
            courseBo.setCategoryRank(e.getCategoryRank());
        }
        if (e.getCategoryValue() != null) {
            courseBo.setCategoryValue(e.getCategoryValue());
        }
        if (e.getCertification() != null) {
            courseBo.setCertification(e.getCertification());
        }
        if (e.getCircleId() != null) {
            courseBo.setCircleId(e.getCircleId());
        }
        if (e.getCircleIdSet() != null) {
            courseBo.setCircleIdSet(e.getCircleIdSet());
        }
        if (e.getCircleName() != null) {
            courseBo.setCircleName(e.getCircleName());
        }
        if (e.getCircleValue() != null) {
            courseBo.setCircleValue(e.getCircleValue());
        }
        if (e.getClassSize() != null) {
            courseBo.setClassSize(e.getClassSize());
        }
        if (e.getClassTeacher() != null) {
            courseBo.setClassTeacher(e.getClassTeacher());
        }
        if (e.getClassType() != null) {
            courseBo.setClassType(e.getClassType());
        }
        if (e.getClassTypeSet() != null) {
            courseBo.setClassTypeSet(e.getClassTypeSet());
        }
        if (e.getCommission() != null) {
            courseBo.setCommission(e.getCommission());
        }
        if (e.getContact() != null) {
            courseBo.setContact(e.getContact());
        }
        if (e.getCourseHourLength() != null) {
            courseBo.setCourseHourLength(e.getCourseHourLength());
        }
        if (e.getCourseHourNum() != null) {
            courseBo.setCourseHourNum(e.getCourseHourNum());
        }
        if (e.getCourseHourNumEnd() != null) {
            courseBo.setCourseHourNumEnd(e.getCourseHourNumEnd());
        }
        if (e.getCourseHourNumSet() != null) {
            courseBo.setCourseHourNumSet(e.getCourseHourNumSet());
        }
        if (e.getCourseHourNumStart() != null) {
            courseBo.setCourseHourNumStart(e.getCourseHourNumStart());
        }
        if (e.getCourseIntro() != null) {
            courseBo.setCourseIntro(e.getCourseIntro());
        }
        if (e.getCourseName() != null) {
            courseBo.setCourseName(e.getCourseName());
        }
        if (e.getCourseTemplateId() != null) {
            courseBo.setCourseTemplateId(e.getCourseTemplateId());
        }
        if (e.getCourseTemplateIdSet() != null) {
            courseBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        }
        if (e.getDiscount() != null) {
            courseBo.setDiscount(e.getDiscount());
        }
        if (e.getDiscountEnd() != null) {
            courseBo.setDiscountEnd(e.getDiscountEnd());
        }
        if (e.getDiscountStart() != null) {
            courseBo.setDiscountStart(e.getDiscountStart());
        }
        if (e.getDownloadMaterials() != null) {
            courseBo.setDownloadMaterials(e.getDownloadMaterials());
        }
        if (e.getEnabled() != null) {
            courseBo.setEnabled(e.getEnabled());
        }
        if (e.getExtracurricular() != null) {
            courseBo.setExtracurricular(e.getExtracurricular());
        }
        if (e.getFinishTime1() != null) {
            courseBo.setFinishTime1(e.getFinishTime1());
        }
        if (e.getFinishTime2() != null) {
            courseBo.setFinishTime2(e.getFinishTime2());
        }
        if (e.getGoal() != null) {
            courseBo.setGoal(e.getGoal());
        }
        if (e.getHighScoreReward() != null) {
            courseBo.setHighScoreReward(e.getHighScoreReward());
        }
        if (e.getId() != null) {
            courseBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            courseBo.setIdSet(e.getIdSet());
        }
        if (e.getInstName() != null) {
            courseBo.setInstName(e.getInstName());
        }
        if (e.getLocationId() != null) {
            courseBo.setLocationId(e.getLocationId());
        }
        if (e.getLocationIdSet() != null) {
            courseBo.setLocationIdSet(e.getLocationIdSet());
        }
        if (e.getLocationName() != null) {
            courseBo.setLocationName(e.getLocationName());
        }
        if (e.getLocationValue() != null) {
            courseBo.setLocationValue(e.getLocationValue());
        }
        if (e.getLogoUrl() != null) {
            courseBo.setLogoUrl(e.getLogoUrl());
        }
        if (e.getMarking() != null) {
            courseBo.setMarking(e.getMarking());
        }
        if (e.getOpenCourseRequirement() != null) {
            courseBo.setOpenCourseRequirement(e.getOpenCourseRequirement());
        }
        if (e.getOriginalPrice() != null) {
            courseBo.setOriginalPrice(e.getOriginalPrice());
        }
        if (e.getOriginalPriceEnd() != null) {
            courseBo.setOriginalPriceEnd(e.getOriginalPriceEnd());
        }
        if (e.getOriginalPriceStart() != null) {
            courseBo.setOriginalPriceStart(e.getOriginalPriceStart());
        }
        if (e.getOutline() != null) {
            courseBo.setOutline(e.getOutline());
        }
        if (e.getPartnerDistinction() != null) {
            courseBo.setPartnerDistinction(e.getPartnerDistinction());
        }
        if (e.getPartnerId() != null) {
            courseBo.setPartnerId(e.getPartnerId());
        }
        if (e.getPartnerIdSet() != null) {
            courseBo.setPartnerIdSet(e.getPartnerIdSet());
        }
        if (e.getPartnerIntro() != null) {
            courseBo.setPartnerIntro(e.getPartnerIntro());
        }
        if (e.getPartnerQualification() != null) {
            courseBo.setPartnerQualification(e.getPartnerQualification());
        }
        if (e.getPartnerRating() != null) {
            courseBo.setPartnerRating(e.getPartnerRating());
        }
        if (e.getPassAgreement() != null) {
            courseBo.setPassAgreement(e.getPassAgreement());
        }
        if (e.getPopularity() != null) {
            courseBo.setPopularity(e.getPopularity());
        }
        if (e.getPopularityEnd() != null) {
            courseBo.setPopularityEnd(e.getPopularityEnd());
        }
        if (e.getPopularitySet() != null) {
            courseBo.setPopularitySet(e.getPopularitySet());
        }
        if (e.getPopularityStart() != null) {
            courseBo.setPopularityStart(e.getPopularityStart());
        }
        if (e.getQualityAssurance() != null) {
            courseBo.setQualityAssurance(e.getQualityAssurance());
        }
        if (e.getQuestionBank() != null) {
            courseBo.setQuestionBank(e.getQuestionBank());
        }
        if (e.getQuestionSession() != null) {
            courseBo.setQuestionSession(e.getQuestionSession());
        }
        if (e.getQuiz() != null) {
            courseBo.setQuiz(e.getQuiz());
        }
        if (e.getRating() != null) {
            courseBo.setRating(e.getRating());
        }
        if (e.getReference() != null) {
            courseBo.setReference(e.getReference());
        }
        if (e.getRegLocation() != null) {
            courseBo.setRegLocation(e.getRegLocation());
        }
        if (e.getRegPhone() != null) {
            courseBo.setRegPhone(e.getRegPhone());
        }
        if (e.getSchooltimeDay() != null) {
            courseBo.setSchooltimeDay(e.getSchooltimeDay());
        }
        if (e.getSchooltimeDaySet() != null) {
            courseBo.setSchooltimeDaySet(e.getSchooltimeDaySet());
        }
        if (e.getSchooltimeWeek() != null) {
            courseBo.setSchooltimeWeek(e.getSchooltimeWeek());
        }
        if (e.getSchooltimeWeekSet() != null) {
            courseBo.setSchooltimeWeekSet(e.getSchooltimeWeekSet());
        }
        if (e.getServiceCharge() != null) {
            courseBo.setServiceCharge(e.getServiceCharge());
        }
        if (e.getStartTime1() != null) {
            courseBo.setStartTime1(e.getStartTime1());
        }
        if (e.getStartTime2() != null) {
            courseBo.setStartTime2(e.getStartTime2());
        }
        if (e.getStartUponArrival() != null) {
            courseBo.setStartUponArrival(e.getStartUponArrival());
        }
        if (e.getStatus() != null) {
            courseBo.setStatus(e.getStatus());
        }
        if (e.getStatusSet() != null) {
            courseBo.setStatusSet(e.getStatusSet());
        }
        if (e.getStudyDayNote() != null) {
            courseBo.setStudyDayNote(e.getStudyDayNote());
        }
        if (e.getSuitableStudent() != null) {
            courseBo.setSuitableStudent(e.getSuitableStudent());
        }
        if (e.getTeachingAndExercise() != null) {
            courseBo.setTeachingAndExercise(e.getTeachingAndExercise());
        }
        if (e.getTeachingMaterialFee() != null) {
            courseBo.setTeachingMaterialFee(e.getTeachingMaterialFee());
        }
        if (e.getTeachingMaterialIntro() != null) {
            courseBo.setTeachingMaterialIntro(e.getTeachingMaterialIntro());
        }
        if (e.getTeachingMethod() != null) {
            courseBo.setTeachingMethod(e.getTeachingMethod());
        }
        if (e.getTrail() != null) {
            courseBo.setTrail(e.getTrail());
        }
        if (e.getWholeName() != null) {
            courseBo.setWholeName(e.getWholeName());
        }
        courseBo.setStartDate(e.getStartDate() == null ? Constant.DEFAULTNULL : e.getStartDate().getTimeInMillis());
        courseBo.setStartDateEnd(e.getStartDateEnd() == null ? Constant.DEFAULTNULL : e.getStartDateEnd().getTimeInMillis());
        courseBo.setStartDateStart(e.getStartDateStart() == null ? Constant.DEFAULTNULL : e.getStartDateStart().getTimeInMillis());
        courseBo.setNoRefundDate(e.getNoRefundDate() == null ? Constant.DEFAULTNULL : e.getNoRefundDate().getTimeInMillis());
        courseBo.setNoRefundDateStart(e.getNoRefundDateStart() == null ? Constant.DEFAULTNULL : e.getNoRefundDateStart().getTimeInMillis());
        courseBo.setNoRefundDateEnd(e.getNoRefundDateEnd() == null ? Constant.DEFAULTNULL : e.getNoRefundDateEnd().getTimeInMillis());
        courseBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        courseBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        courseBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        courseBo.setFinishDate(e.getFinishDate() == null ? Constant.DEFAULTNULL : e.getFinishDate().getTimeInMillis());
        courseBo.setFinishDateEnd(e.getFinishDateEnd() == null ? Constant.DEFAULTNULL : e.getFinishDateEnd().getTimeInMillis());
        courseBo.setFinishDateStart(e.getFinishDateStart() == null ? Constant.DEFAULTNULL : e.getFinishDateStart().getTimeInMillis());
        courseBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        courseBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        courseBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        courseBo.setCutoffDate(e.getCutoffDate() == null ? Constant.DEFAULTNULL : e.getCutoffDate().getTimeInMillis());
        courseBo.setCutoffDateEnd(e.getCutoffDateEnd() == null ? Constant.DEFAULTNULL : e.getCutoffDateEnd().getTimeInMillis());
        courseBo.setCutoffDateStart(e.getCutoffDateStart() == null ? Constant.DEFAULTNULL : e.getCutoffDateStart().getTimeInMillis());
        courseBo.setCashbackDate(e.getCashbackDate() == null ? Constant.DEFAULTNULL : e.getCashbackDate().getTimeInMillis());
        courseBo.setCashbackDateStart(e.getCashbackDateStart() == null ? Constant.DEFAULTNULL : e.getCashbackDateStart().getTimeInMillis());
        courseBo.setCashbackDateEnd(e.getCashbackDateEnd() == null ? Constant.DEFAULTNULL : e.getCashbackDateEnd().getTimeInMillis());
        if (e.getClassPhotoList() != null) {
            List<ClassPhotoBo> list = new ArrayList<>();
            for (ClassPhotoEntityExt a : e.getClassPhotoList()) {
                list.add(ClassPhotoConverter.toBo(a));
            }
            courseBo.setClassPhotoList(list);
        }
        if (e.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherEntityExt a : e.getTeacherList()) {
                list.add(TeacherConverter.toBo(a));
            }
            courseBo.setTeacherList(list);
        }
        return courseBo;
    }

    public static CourseEntityExt fromBo(CourseBo bo) {
        CourseEntityExt courseEntityExt = new CourseEntityExt();
        courseEntityExt.setAddress(bo.getAddress());
        courseEntityExt.setAddressId(bo.getAddressId());
        courseEntityExt.setAddressLat(bo.getAddressLat());
        courseEntityExt.setAddressLng(bo.getAddressLng());
        courseEntityExt.setAssignments(bo.getAssignments());
        courseEntityExt.setBonusService(bo.getBonusService());
        courseEntityExt.setBookingTotal(bo.getBookingTotal());
        courseEntityExt.setBookingType(bo.getBookingType());
        courseEntityExt.setCashback(bo.getCashback());
        courseEntityExt.setCashbackDate(DateUtility.getTimeFromLong(bo.getCashbackDate()));
        courseEntityExt.setCashbackDateStart(DateUtility.getTimeFromLong(bo.getCashbackDateStart()));
        courseEntityExt.setCashbackDateEnd(DateUtility.getTimeFromLong(bo.getCashbackDateEnd()));
        courseEntityExt.setCashbackEnd(bo.getCashbackEnd());
        courseEntityExt.setCashbackStart(bo.getCashbackStart());
        courseEntityExt.setCategoryId(bo.getCategoryId());
        courseEntityExt.setCategoryIdSet(bo.getCategoryIdSet());
        courseEntityExt.setCategoryName(bo.getCategoryName());
        courseEntityExt.setCategoryRank(bo.getCategoryRank());
        courseEntityExt.setCategoryValue(bo.getCategoryValue());
        courseEntityExt.setCertification(bo.getCertification());
        courseEntityExt.setCircleId(bo.getCircleId());
        courseEntityExt.setCircleIdSet(bo.getCircleIdSet());
        courseEntityExt.setCircleName(bo.getCircleName());
        courseEntityExt.setCircleValue(bo.getCircleValue());
        if (bo.getClassPhotoList() != null) {
            List<ClassPhotoEntityExt> list = new ArrayList<>();
            for (ClassPhotoBo a : bo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.fromBo(a));
            }
            courseEntityExt.setClassPhotoList(list);
        }
        courseEntityExt.setClassSize(bo.getClassSize());
        courseEntityExt.setClassTeacher(bo.getClassTeacher());
        courseEntityExt.setClassType(bo.getClassType());
        courseEntityExt.setClassTypeSet(bo.getClassTypeSet());
        courseEntityExt.setCommission(bo.getCommission());
        courseEntityExt.setContact(bo.getContact());
        courseEntityExt.setCourseHourLength(bo.getCourseHourLength());
        courseEntityExt.setCourseHourNum(bo.getCourseHourNum());
        courseEntityExt.setCourseHourNumEnd(bo.getCourseHourNumEnd());
        courseEntityExt.setCourseHourNumSet(bo.getCourseHourNumSet());
        courseEntityExt.setCourseHourNumStart(bo.getCourseHourNumStart());
        courseEntityExt.setCourseIntro(bo.getCourseIntro());
        courseEntityExt.setCourseName(bo.getCourseName());
        courseEntityExt.setCourseTemplateId(bo.getCourseTemplateId());
        courseEntityExt.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseEntityExt.setCutoffDate(DateUtility.getTimeFromLong(bo.getCutoffDate()));
        courseEntityExt.setCutoffDateEnd(DateUtility.getTimeFromLong(bo.getCutoffDateEnd()));
        courseEntityExt.setCutoffDateStart(DateUtility.getTimeFromLong(bo.getCutoffDateStart()));
        courseEntityExt.setDiscount(bo.getDiscount());
        courseEntityExt.setDiscountEnd(bo.getDiscountEnd());
        courseEntityExt.setDiscountStart(bo.getDiscountStart());
        courseEntityExt.setDownloadMaterials(bo.getDownloadMaterials());
        courseEntityExt.setEnabled(bo.getEnabled());
        courseEntityExt.setExtracurricular(bo.getExtracurricular());
        courseEntityExt.setFinishDate(DateUtility.getTimeFromLong(bo.getFinishDate()));
        courseEntityExt.setFinishDateEnd(DateUtility.getTimeFromLong(bo.getFinishDateEnd()));
        courseEntityExt.setFinishDateStart(DateUtility.getTimeFromLong(bo.getFinishDateStart()));
        courseEntityExt.setFinishTime1(bo.getFinishTime1());
        courseEntityExt.setFinishTime2(bo.getFinishTime2());
        courseEntityExt.setGoal(bo.getGoal());
        courseEntityExt.setHighScoreReward(bo.getHighScoreReward());
        courseEntityExt.setId(bo.getId());
        courseEntityExt.setIdSet(bo.getIdSet());
        courseEntityExt.setInstName(bo.getInstName());
        courseEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        courseEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        courseEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        courseEntityExt.setLocationId(bo.getLocationId());
        courseEntityExt.setLocationIdSet(bo.getLocationIdSet());
        courseEntityExt.setLocationName(bo.getLocationName());
        courseEntityExt.setLocationValue(bo.getLocationValue());
        courseEntityExt.setLogoUrl(bo.getLogoUrl());
        courseEntityExt.setMarking(bo.getMarking());
        courseEntityExt.setNoRefundDate(DateUtility.getTimeFromLong(bo.getNoRefundDate()));
        courseEntityExt.setNoRefundDateStart(DateUtility.getTimeFromLong(bo.getNoRefundDateStart()));
        courseEntityExt.setNoRefundDateEnd(DateUtility.getTimeFromLong(bo.getNoRefundDateEnd()));
        courseEntityExt.setOpenCourseRequirement(bo.getOpenCourseRequirement());
        courseEntityExt.setOriginalPrice(bo.getOriginalPrice());
        courseEntityExt.setOriginalPriceEnd(bo.getOriginalPriceEnd());
        courseEntityExt.setOriginalPriceStart(bo.getOriginalPriceStart());
        courseEntityExt.setOutline(bo.getOutline());
        courseEntityExt.setPartnerDistinction(bo.getPartnerDistinction());
        courseEntityExt.setPartnerId(bo.getPartnerId());
        courseEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
        courseEntityExt.setPartnerIntro(bo.getPartnerIntro());
        courseEntityExt.setPartnerQualification(bo.getPartnerQualification());
        courseEntityExt.setPartnerRating(bo.getPartnerRating());
        courseEntityExt.setPassAgreement(bo.getPassAgreement());
        courseEntityExt.setPopularity(bo.getPopularity());
        courseEntityExt.setPopularityEnd(bo.getPopularityEnd());
        courseEntityExt.setPopularitySet(bo.getPopularitySet());
        courseEntityExt.setPopularityStart(bo.getPopularityStart());
        courseEntityExt.setQualityAssurance(bo.getQualityAssurance());
        courseEntityExt.setQuestionBank(bo.getQuestionBank());
        courseEntityExt.setQuestionSession(bo.getQuestionSession());
        courseEntityExt.setQuiz(bo.getQuiz());
        courseEntityExt.setRating(bo.getRating());
        courseEntityExt.setReference(bo.getReference());
        courseEntityExt.setRegLocation(bo.getRegLocation());
        courseEntityExt.setRegPhone(bo.getRegPhone());
        courseEntityExt.setSchooltimeDay(bo.getSchooltimeDay());
        courseEntityExt.setSchooltimeDaySet(bo.getSchooltimeDaySet());
        courseEntityExt.setSchooltimeWeek(bo.getSchooltimeWeek());
        courseEntityExt.setSchooltimeWeekSet(bo.getSchooltimeWeekSet());
        courseEntityExt.setServiceCharge(bo.getServiceCharge());
        courseEntityExt.setStartDate(DateUtility.getTimeFromLong(bo.getStartDate()));
        courseEntityExt.setStartDateEnd(DateUtility.getTimeFromLong(bo.getStartDateEnd()));
        courseEntityExt.setStartDateStart(DateUtility.getTimeFromLong(bo.getStartDateStart()));
        courseEntityExt.setStartTime1(bo.getStartTime1());
        courseEntityExt.setStartTime2(bo.getStartTime2());
        courseEntityExt.setStartUponArrival(bo.getStartUponArrival());
        courseEntityExt.setStatus(bo.getStatus());
        courseEntityExt.setStatusSet(bo.getStatusSet());
        courseEntityExt.setStudyDayNote(bo.getStudyDayNote());
        courseEntityExt.setSuitableStudent(bo.getSuitableStudent());
        if (bo.getTeacherList() != null) {
            List<TeacherEntityExt> list = new ArrayList<>();
            for (TeacherBo a : bo.getTeacherList()) {
                list.add(TeacherConverter.fromBo(a));
            }
            courseEntityExt.setTeacherList(list);
        }
        courseEntityExt.setTeachingAndExercise(bo.getTeachingAndExercise());
        courseEntityExt.setTeachingMaterialFee(bo.getTeachingMaterialFee());
        courseEntityExt.setTeachingMaterialIntro(bo.getTeachingMaterialIntro());
        courseEntityExt.setTeachingMethod(bo.getTeachingMethod());
        courseEntityExt.setTrail(bo.getTrail());
        courseEntityExt.setWholeName(bo.getWholeName());
        return courseEntityExt;
    }
}
