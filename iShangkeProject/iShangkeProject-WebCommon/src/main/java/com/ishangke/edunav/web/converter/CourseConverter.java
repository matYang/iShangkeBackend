package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.common.ActionVo;
import com.ishangke.edunav.web.common.DateUtility;
import com.ishangke.edunav.web.model.ClassPhotoVo;
import com.ishangke.edunav.web.model.CourseVo;
import com.ishangke.edunav.web.model.TeacherVo;

public class CourseConverter {
    public static CourseBo fromModel(CourseVo vo) {
        CourseBo courseBo = new CourseBo();
        courseBo.setAddress(vo.getAddress());
        courseBo.setAddressId(vo.getAddressId());
        courseBo.setAddressLat(vo.getAddressLat());
        courseBo.setAddressLng(vo.getAddressLng());
        courseBo.setAssignments(vo.getAssignments());
        courseBo.setBonusService(vo.getBonusService());
        courseBo.setBookingTotal(vo.getBookingTotal());
        courseBo.setBookingType(vo.getBookingType());
        courseBo.setCashback(vo.getCashback());
        courseBo.setCashbackDate(vo.getCashbackDate().getTimeInMillis());
        courseBo.setCashbackDateStart(vo.getCashbackDateStart().getTimeInMillis());
        courseBo.setCashbackDateEnd(vo.getCashbackDateEnd().getTimeInMillis());
        courseBo.setCashbackEnd(vo.getCashbackEnd());
        courseBo.setCashbackStart(vo.getCashbackStart());
        courseBo.setCategoryId(vo.getCategoryId());
        courseBo.setCategoryIdSet(vo.getCategoryIdSet());
        courseBo.setCategoryName(vo.getCategoryName());
        courseBo.setCategoryRank(vo.getCategoryRank());
        courseBo.setCategoryValue(vo.getCategoryValue());
        courseBo.setCertification(vo.getCertification());
        courseBo.setCircleId(vo.getCircleId());
        courseBo.setCircleIdSet(vo.getCircleIdSet());
        courseBo.setCircleName(vo.getCircleName());
        courseBo.setCircleValue(vo.getCircleValue());
        if (vo.getClassPhotoList() != null) {
            List<ClassPhotoBo> list = new ArrayList<>();
            for (ClassPhotoVo a : vo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.fromModel(a));
            }
            courseBo.setClassPhotoList(list);
        }
        courseBo.setClassSize(vo.getClassSize());
        courseBo.setClassTeacher(vo.getClassTeacher());
        courseBo.setClassType(vo.getClassType());
        courseBo.setClassTypeSet(vo.getClassTypeSet());
        courseBo.setCommission(vo.getCommission());
        courseBo.setContact(vo.getContact());
        courseBo.setCourseHourLength(vo.getCourseHourLength());
        courseBo.setCourseHourNum(vo.getCourseHourNum());
        courseBo.setCourseHourNumEnd(vo.getCourseHourNumEnd());
        courseBo.setCourseHourNumSet(vo.getCourseHourNumSet());
        courseBo.setCourseHourNumStart(vo.getCourseHourNumStart());
        courseBo.setCourseIntro(vo.getCourseIntro());
        courseBo.setCourseName(vo.getCourseName());
        courseBo.setCourseTemplateId(vo.getCourseTemplateId());
        courseBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        courseBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        courseBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        courseBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        courseBo.setCutoffDate(vo.getCutoffDate().getTimeInMillis());
        courseBo.setCutoffDateEnd(vo.getCutoffDateEnd().getTimeInMillis());
        courseBo.setCutoffDateStart(vo.getCutoffDateStart().getTimeInMillis());
        courseBo.setDiscount(vo.getDiscount());
        courseBo.setDiscountEnd(vo.getDiscountEnd());
        courseBo.setDiscountStart(vo.getDiscountStart());
        courseBo.setDownloadMaterials(vo.getDownloadMaterials());
        courseBo.setEnabled(vo.getEnabled());
        courseBo.setExtracurricular(vo.getExtracurricular());
        courseBo.setFinishDate(vo.getFinishDate().getTimeInMillis());
        courseBo.setFinishDateEnd(vo.getFinishDateEnd().getTimeInMillis());
        courseBo.setFinishDateStart(vo.getFinishDateStart().getTimeInMillis());
        courseBo.setFinishTime1(vo.getFinishTime1());
        courseBo.setFinishTime2(vo.getFinishTime2());
        courseBo.setGoal(vo.getGoal());
        courseBo.setHighScoreReward(vo.getHighScoreReward());
        courseBo.setId(vo.getId());
        courseBo.setIdSet(vo.getIdSet());
        courseBo.setInstName(vo.getInstName());
        courseBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        courseBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        courseBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        courseBo.setLocationId(vo.getLocationId());
        courseBo.setLocationIdSet(vo.getLocationIdSet());
        courseBo.setLocationName(vo.getLocationName());
        courseBo.setLocationValue(vo.getLocationValue());
        courseBo.setLogoUrl(vo.getLogoUrl());
        courseBo.setMarking(vo.getMarking());
        courseBo.setNoRefundDate(vo.getNoRefundDate().getTimeInMillis());
        courseBo.setNoRefundDateStart(vo.getNoRefundDateStart().getTimeInMillis());
        courseBo.setNoRefundDateEnd(vo.getNoRefundDateEnd().getTimeInMillis());
        courseBo.setOpenCourseRequirement(vo.getOpenCourseRequirement());
        courseBo.setOriginalPrice(vo.getOriginalPrice());
        courseBo.setOriginalPriceEnd(vo.getOriginalPriceEnd());
        courseBo.setOriginalPriceStart(vo.getOriginalPriceStart());
        courseBo.setOutline(vo.getOutline());
        courseBo.setPartnerDistinction(vo.getPartnerDistinction());
        courseBo.setPartnerId(vo.getPartnerId());
        courseBo.setPartnerIdSet(vo.getPartnerIdSet());
        courseBo.setPartnerIntro(vo.getPartnerIntro());
        courseBo.setPartnerQualification(vo.getPartnerQualification());
        courseBo.setPartnerRating(vo.getPartnerRating());
        courseBo.setPassAgreement(vo.getPassAgreement());
        courseBo.setPopularity(vo.getPopularity());
        courseBo.setPopularityEnd(vo.getPopularityEnd());
        courseBo.setPopularitySet(vo.getPopularitySet());
        courseBo.setPopularityStart(vo.getPopularityStart());
        courseBo.setQualityAssurance(vo.getQualityAssurance());
        courseBo.setQuestionBank(vo.getQuestionBank());
        courseBo.setQuestionSession(vo.getQuestionSession());
        courseBo.setQuiz(vo.getQuiz());
        courseBo.setRating(vo.getRating());
        courseBo.setReference(vo.getReference());
        courseBo.setRegLocation(vo.getRegLocation());
        courseBo.setRegPhone(vo.getRegPhone());
        courseBo.setSchooltimeDay(vo.getSchooltimeDay());
        courseBo.setSchooltimeDaySet(vo.getSchooltimeDaySet());
        courseBo.setSchooltimeWeek(vo.getSchooltimeWeek());
        courseBo.setSchooltimeWeekSet(vo.getSchooltimeWeekSet());
        courseBo.setServiceCharge(vo.getServiceCharge());
        courseBo.setStartDate(vo.getStartDate().getTimeInMillis());
        courseBo.setStartDateEnd(vo.getStartDateEnd().getTimeInMillis());
        courseBo.setStartDateStart(vo.getStartDateStart().getTimeInMillis());
        courseBo.setStartTime1(vo.getStartTime1());
        courseBo.setStartTime2(vo.getStartTime2());
        courseBo.setStartUponArrival(vo.getStartUponArrival());
        courseBo.setStatus(vo.getStatus());
        courseBo.setStatusSet(vo.getStatusSet());
        courseBo.setStudyDayNote(vo.getStudyDayNote());
        courseBo.setSuitableStudent(vo.getSuitableStudent());
        if (vo.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherVo a : vo.getTeacherList()) {
                list.add(TeacherConverter.fromModel(a));
            }
            courseBo.setTeacherList(list);
        }
        courseBo.setTeachingAndExercise(vo.getTeachingAndExercise());
        courseBo.setTeachingMaterialFee(vo.getTeachingMaterialFee());
        courseBo.setTeachingMaterialIntro(vo.getTeachingMaterialIntro());
        courseBo.setTeachingMethod(vo.getTeachingMethod());
        courseBo.setTrail(vo.getTrail());
        courseBo.setWholeName(vo.getWholeName());
        if (vo.getActionList() != null) {
            List<ActionBo> list = new ArrayList<>();
            for (ActionVo a : vo.getActionList()) {
                list.add(ActionConverter.fromModel(a));
            }
            courseBo.setActionList(list);
        }
        return courseBo;
    }

    public static CourseVo toModel(CourseBo bo) {
        CourseVo courseVo = new CourseVo();
        courseVo.setAddress(bo.getAddress());
        courseVo.setAddressId(bo.getAddressId());
        courseVo.setAddressLat(bo.getAddressLat());
        courseVo.setAddressLng(bo.getAddressLng());
        courseVo.setAssignments(bo.getAssignments());
        courseVo.setBonusService(bo.getBonusService());
        courseVo.setBookingTotal(bo.getBookingTotal());
        courseVo.setBookingType(bo.getBookingType());
        courseVo.setCashback(bo.getCashback());
        courseVo.setCashbackDate(DateUtility.getTimeFromLong(bo.getCashbackDate()));
        courseVo.setCashbackDateStart(DateUtility.getTimeFromLong(bo.getCashbackDateStart()));
        courseVo.setCashbackDateEnd(DateUtility.getTimeFromLong(bo.getCashbackDateEnd()));
        courseVo.setCashbackEnd(bo.getCashbackEnd());
        courseVo.setCashbackStart(bo.getCashbackStart());
        courseVo.setCategoryId(bo.getCategoryId());
        courseVo.setCategoryIdSet(bo.getCategoryIdSet());
        courseVo.setCategoryName(bo.getCategoryName());
        courseVo.setCategoryRank(bo.getCategoryRank());
        courseVo.setCategoryValue(bo.getCategoryValue());
        courseVo.setCertification(bo.getCertification());
        courseVo.setCircleId(bo.getCircleId());
        courseVo.setCircleIdSet(bo.getCircleIdSet());
        courseVo.setCircleName(bo.getCircleName());
        courseVo.setCircleValue(bo.getCircleValue());
        if (bo.getClassPhotoList() != null) {
            List<ClassPhotoVo> list = new ArrayList<>();
            for (ClassPhotoBo a : bo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.toModel(a));
            }
            courseVo.setClassPhotoList(list);
        }
        courseVo.setClassSize(bo.getClassSize());
        courseVo.setClassTeacher(bo.getClassTeacher());
        courseVo.setClassType(bo.getClassType());
        courseVo.setClassTypeSet(bo.getClassTypeSet());
        courseVo.setCommission(bo.getCommission());
        courseVo.setContact(bo.getContact());
        courseVo.setCourseHourLength(bo.getCourseHourLength());
        courseVo.setCourseHourNum(bo.getCourseHourNum());
        courseVo.setCourseHourNumEnd(bo.getCourseHourNumEnd());
        courseVo.setCourseHourNumSet(bo.getCourseHourNumSet());
        courseVo.setCourseHourNumStart(bo.getCourseHourNumStart());
        courseVo.setCourseIntro(bo.getCourseIntro());
        courseVo.setCourseName(bo.getCourseName());
        courseVo.setCourseTemplateId(bo.getCourseTemplateId());
        courseVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseVo.setCutoffDate(DateUtility.getTimeFromLong(bo.getCutoffDate()));
        courseVo.setCutoffDateEnd(DateUtility.getTimeFromLong(bo.getCutoffDateEnd()));
        courseVo.setCutoffDateStart(DateUtility.getTimeFromLong(bo.getCutoffDateStart()));
        courseVo.setDiscount(bo.getDiscount());
        courseVo.setDiscountEnd(bo.getDiscountEnd());
        courseVo.setDiscountStart(bo.getDiscountStart());
        courseVo.setDownloadMaterials(bo.getDownloadMaterials());
        courseVo.setEnabled(bo.getEnabled());
        courseVo.setExtracurricular(bo.getExtracurricular());
        courseVo.setFinishDate(DateUtility.getTimeFromLong(bo.getFinishDate()));
        courseVo.setFinishDateEnd(DateUtility.getTimeFromLong(bo.getFinishDateEnd()));
        courseVo.setFinishDateStart(DateUtility.getTimeFromLong(bo.getFinishDateStart()));
        courseVo.setFinishTime1(bo.getFinishTime1());
        courseVo.setFinishTime2(bo.getFinishTime2());
        courseVo.setGoal(bo.getGoal());
        courseVo.setHighScoreReward(bo.getHighScoreReward());
        courseVo.setId(bo.getId());
        courseVo.setIdSet(bo.getIdSet());
        courseVo.setInstName(bo.getInstName());
        courseVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        courseVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        courseVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        courseVo.setLocationId(bo.getLocationId());
        courseVo.setLocationIdSet(bo.getLocationIdSet());
        courseVo.setLocationName(bo.getLocationName());
        courseVo.setLocationValue(bo.getLocationValue());
        courseVo.setLogoUrl(bo.getLogoUrl());
        courseVo.setMarking(bo.getMarking());
        courseVo.setNoRefundDate(DateUtility.getTimeFromLong(bo.getNoRefundDate()));
        courseVo.setNoRefundDateStart(DateUtility.getTimeFromLong(bo.getNoRefundDateStart()));
        courseVo.setNoRefundDateEnd(DateUtility.getTimeFromLong(bo.getNoRefundDateEnd()));
        courseVo.setOpenCourseRequirement(bo.getOpenCourseRequirement());
        courseVo.setOriginalPrice(bo.getOriginalPrice());
        courseVo.setOriginalPriceEnd(bo.getOriginalPriceEnd());
        courseVo.setOriginalPriceStart(bo.getOriginalPriceStart());
        courseVo.setOutline(bo.getOutline());
        courseVo.setPartnerDistinction(bo.getPartnerDistinction());
        courseVo.setPartnerId(bo.getPartnerId());
        courseVo.setPartnerIdSet(bo.getPartnerIdSet());
        courseVo.setPartnerIntro(bo.getPartnerIntro());
        courseVo.setPartnerQualification(bo.getPartnerQualification());
        courseVo.setPartnerRating(bo.getPartnerRating());
        courseVo.setPassAgreement(bo.getPassAgreement());
        courseVo.setPopularity(bo.getPopularity());
        courseVo.setPopularityEnd(bo.getPopularityEnd());
        courseVo.setPopularitySet(bo.getPopularitySet());
        courseVo.setPopularityStart(bo.getPopularityStart());
        courseVo.setQualityAssurance(bo.getQualityAssurance());
        courseVo.setQuestionBank(bo.getQuestionBank());
        courseVo.setQuestionSession(bo.getQuestionSession());
        courseVo.setQuiz(bo.getQuiz());
        courseVo.setRating(bo.getRating());
        courseVo.setReference(bo.getReference());
        courseVo.setRegLocation(bo.getRegLocation());
        courseVo.setRegPhone(bo.getRegPhone());
        courseVo.setSchooltimeDay(bo.getSchooltimeDay());
        courseVo.setSchooltimeDaySet(bo.getSchooltimeDaySet());
        courseVo.setSchooltimeWeek(bo.getSchooltimeWeek());
        courseVo.setSchooltimeWeekSet(bo.getSchooltimeWeekSet());
        courseVo.setServiceCharge(bo.getServiceCharge());
        courseVo.setStartDate(DateUtility.getTimeFromLong(bo.getStartDate()));
        courseVo.setStartDateEnd(DateUtility.getTimeFromLong(bo.getStartDateEnd()));
        courseVo.setStartDateStart(DateUtility.getTimeFromLong(bo.getStartDateStart()));
        courseVo.setStartTime1(bo.getStartTime1());
        courseVo.setStartTime2(bo.getStartTime2());
        courseVo.setStartUponArrival(bo.getStartUponArrival());
        courseVo.setStatus(bo.getStatus());
        courseVo.setStatusSet(bo.getStatusSet());
        courseVo.setStudyDayNote(bo.getStudyDayNote());
        courseVo.setSuitableStudent(bo.getSuitableStudent());
        if (bo.getTeacherList() != null) {
            List<TeacherVo> list = new ArrayList<>();
            for (TeacherBo a : bo.getTeacherList()) {
                list.add(TeacherConverter.toModel(a));
            }
            courseVo.setTeacherList(list);
        }
        courseVo.setTeachingAndExercise(bo.getTeachingAndExercise());
        courseVo.setTeachingMaterialFee(bo.getTeachingMaterialFee());
        courseVo.setTeachingMaterialIntro(bo.getTeachingMaterialIntro());
        courseVo.setTeachingMethod(bo.getTeachingMethod());
        courseVo.setTrail(bo.getTrail());
        courseVo.setWholeName(bo.getWholeName());
        if (bo.getActionList() != null) {
            List<ActionVo> list = new ArrayList<>();
            for (ActionBo a : bo.getActionList()) {
                list.add(ActionConverter.toModel(a));
            }
            courseVo.setActionList(list);
        }
        return courseVo;
    }
}
