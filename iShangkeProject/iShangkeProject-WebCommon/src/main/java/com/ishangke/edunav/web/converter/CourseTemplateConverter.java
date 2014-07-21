package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.model.ClassPhotoVo;
import com.ishangke.edunav.web.model.CourseTemplateVo;
import com.ishangke.edunav.web.model.TeacherVo;
import com.ishangke.edunav.web.common.ActionVo;
import com.ishangke.edunav.web.common.DateUtility;

public class CourseTemplateConverter {
    public static CourseTemplateBo fromModel(CourseTemplateVo vo) {
        CourseTemplateBo courseTemplateBo = new CourseTemplateBo();
        courseTemplateBo.setAddress(vo.getAddress());
        courseTemplateBo.setAddressId(vo.getAddressId());
        courseTemplateBo.setAddressLat(vo.getAddressLat());
        courseTemplateBo.setAddressLat(vo.getAddressLat());
        courseTemplateBo.setAddressLng(vo.getAddressLng());
        courseTemplateBo.setAssignments(vo.getAssignments());
        courseTemplateBo.setBonusService(vo.getBonusService());
        courseTemplateBo.setBookingTotal(vo.getBookingTotal());
        courseTemplateBo.setBookingTotalEnd(vo.getBookingTotalEnd());
        courseTemplateBo.setBookingTotalSet(vo.getBookingTotalSet());
        courseTemplateBo.setBookingTotalStart(vo.getBookingTotalStart());
        courseTemplateBo.setBookingType(vo.getBookingType());
        courseTemplateBo.setCashback(vo.getCashback());
        courseTemplateBo.setCashbackDate(vo.getCashbackDate().getTimeInMillis());
        courseTemplateBo.setCashbackDateEnd(vo.getCashbackDateEnd().getTimeInMillis());
        courseTemplateBo.setCashbackDateStart(vo.getCashbackDateStart().getTimeInMillis());
        courseTemplateBo.setCashbackEnd(vo.getCashbackEnd());
        courseTemplateBo.setCashbackStart(vo.getCashbackStart());
        courseTemplateBo.setCategoryId(vo.getCategoryId());
        courseTemplateBo.setCategoryIdSet(vo.getCategoryIdSet());
        courseTemplateBo.setCategoryName(vo.getCategoryName());
        courseTemplateBo.setCategoryRank(vo.getCategoryRank());
        courseTemplateBo.setCategoryValue(vo.getCategoryValue());
        courseTemplateBo.setCertification(vo.getCertification());
        courseTemplateBo.setCircleId(vo.getCircleId());
        courseTemplateBo.setCircleIdSet(vo.getCircleIdSet());
        courseTemplateBo.setCircleName(vo.getCircleName());
        courseTemplateBo.setCircleValue(vo.getCircleValue());
        if (vo.getClassPhotoList() != null) {
            List<ClassPhotoBo> list = new ArrayList<>();
            for (ClassPhotoVo a : vo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.fromModel(a));
            }
            courseTemplateBo.setClassPhotoList(list);
        }
        courseTemplateBo.setClassSize(vo.getClassSize());
        courseTemplateBo.setClassTeacher(vo.getClassTeacher());
        courseTemplateBo.setClassType(vo.getClassType());
        courseTemplateBo.setClassTypeSet(vo.getClassTypeSet());
        courseTemplateBo.setCommission(vo.getCommission());
        courseTemplateBo.setContact(vo.getContact());
        courseTemplateBo.setCourseHourLength(vo.getCourseHourLength());
        courseTemplateBo.setCourseHourNum(vo.getCourseHourNum());
        courseTemplateBo.setCourseHourNumEnd(vo.getCourseHourNumEnd());
        courseTemplateBo.setCourseHourNumSet(vo.getCourseHourNumSet());
        courseTemplateBo.setCourseHourNumStart(vo.getCourseHourNumStart());
        courseTemplateBo.setCourseIntro(vo.getCourseIntro());
        courseTemplateBo.setCourseName(vo.getCourseName());
        courseTemplateBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        courseTemplateBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        courseTemplateBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        courseTemplateBo.setCutoffDate(vo.getCutoffDate().getTimeInMillis());
        courseTemplateBo.setCutoffDateEnd(vo.getCutoffDateEnd().getTimeInMillis());
        courseTemplateBo.setCutoffDateStart(vo.getCutoffDateStart().getTimeInMillis());
        courseTemplateBo.setDiscount(vo.getDiscount());
        courseTemplateBo.setDiscountEnd(vo.getDiscountEnd());
        courseTemplateBo.setDiscountEnd(vo.getDiscountEnd());
        courseTemplateBo.setDiscountStart(vo.getDiscountStart());
        courseTemplateBo.setDownloadMaterials(vo.getDownloadMaterials());
        courseTemplateBo.setEnabled(vo.getEnabled());
        courseTemplateBo.setExtracurricular(vo.getExtracurricular());
        courseTemplateBo.setFinishDate(vo.getFinishDate().getTimeInMillis());
        courseTemplateBo.setFinishDateEnd(vo.getFinishDateEnd().getTimeInMillis());
        courseTemplateBo.setFinishDateStart(vo.getFinishDateStart().getTimeInMillis());
        courseTemplateBo.setFinishTime1(vo.getFinishTime1());
        courseTemplateBo.setFinishTime2(vo.getFinishTime2());
        courseTemplateBo.setGoal(vo.getGoal());
        courseTemplateBo.setHighScoreReward(vo.getHighScoreReward());
        courseTemplateBo.setId(vo.getId());
        courseTemplateBo.setIdSet(vo.getIdSet());
        courseTemplateBo.setInstName(vo.getInstName());
        courseTemplateBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        courseTemplateBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        courseTemplateBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        courseTemplateBo.setLocationId(vo.getLocationId());
        courseTemplateBo.setLocationIdSet(vo.getLocationIdSet());
        courseTemplateBo.setLocationName(vo.getLocationName());
        courseTemplateBo.setLocationValue(vo.getLocationValue());
        courseTemplateBo.setLogoUrl(vo.getLogoUrl());
        courseTemplateBo.setMarking(vo.getMarking());
        courseTemplateBo.setNoRefundDate(vo.getNoRefundDate().getTimeInMillis());
        courseTemplateBo.setNoRefundDateEnd(vo.getNoRefundDateEnd().getTimeInMillis());
        courseTemplateBo.setNoRefundDateStart(vo.getNoRefundDateStart().getTimeInMillis());
        courseTemplateBo.setOpenCourseRequirement(vo.getOpenCourseRequirement());
        courseTemplateBo.setOriginalPrice(vo.getOriginalPrice());
        courseTemplateBo.setOriginalPriceEnd(vo.getOriginalPriceEnd());
        courseTemplateBo.setOriginalPriceStart(vo.getOriginalPriceStart());
        courseTemplateBo.setOutline(vo.getOutline());
        courseTemplateBo.setPartnerDistinction(vo.getPartnerDistinction());
        courseTemplateBo.setPartnerId(vo.getPartnerId());
        courseTemplateBo.setPartnerIdSet(vo.getPartnerIdSet());
        courseTemplateBo.setPartnerIntro(vo.getPartnerIntro());
        courseTemplateBo.setPartnerQualification(vo.getPartnerQualification());
        courseTemplateBo.setPartnerRating(vo.getPartnerRating());
        courseTemplateBo.setPassAgreement(vo.getPassAgreement());
        courseTemplateBo.setPopularity(vo.getPopularity());
        courseTemplateBo.setPopularityEnd(vo.getPopularityEnd());
        courseTemplateBo.setPopularitySet(vo.getPopularitySet());
        courseTemplateBo.setPopularityStart(vo.getPopularityStart());
        courseTemplateBo.setPrerequest(vo.getPrerequest());
        courseTemplateBo.setPrice(vo.getPrice());
        courseTemplateBo.setPriceEnd(vo.getPriceEnd());
        courseTemplateBo.setPriceStart(vo.getPriceStart());
        courseTemplateBo.setQualityAssurance(vo.getQualityAssurance());
        courseTemplateBo.setQuestionBank(vo.getQuestionBank());
        courseTemplateBo.setQuestionSession(vo.getQuestionSession());
        courseTemplateBo.setQuiz(vo.getQuiz());
        courseTemplateBo.setRating(vo.getRating());
        courseTemplateBo.setRatingEnd(vo.getRatingEnd());
        courseTemplateBo.setRatingStart(vo.getRatingStart());
        courseTemplateBo.setReference(vo.getReference());
        courseTemplateBo.setRegLocation(vo.getRegLocation());
        courseTemplateBo.setRegPhone(vo.getRegPhone());
        courseTemplateBo.setSchooltimeDay(vo.getSchooltimeDay());
        courseTemplateBo.setSchooltimeDaySet(vo.getSchooltimeDaySet());
        courseTemplateBo.setSchooltimeWeek(vo.getSchooltimeWeek());
        courseTemplateBo.setSchooltimeWeekSet(vo.getSchooltimeWeekSet());
        courseTemplateBo.setServiceCharge(vo.getServiceCharge());
        courseTemplateBo.setStartDate(vo.getStartDate().getTimeInMillis());
        courseTemplateBo.setStartDateEnd(vo.getStartDateEnd().getTimeInMillis());
        courseTemplateBo.setStartDateStart(vo.getStartDateStart().getTimeInMillis());
        courseTemplateBo.setStartTime1(vo.getStartTime1());
        courseTemplateBo.setStartTime2(vo.getStartTime2());
        courseTemplateBo.setStartUponArrival(vo.getStartUponArrival());
        courseTemplateBo.setStatus(vo.getStatus());
        courseTemplateBo.setStatusSet(vo.getStatusSet());
        courseTemplateBo.setStudyDayNote(vo.getStudyDayNote());
        courseTemplateBo.setSuitableStudent(vo.getSuitableStudent());
        if (vo.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherVo a : vo.getTeacherList()) {
                list.add(TeacherConverter.fromModel(a));
            }
            courseTemplateBo.setTeacherList(list);
        }
        courseTemplateBo.setTeachingAndExercise(vo.getTeachingAndExercise());
        courseTemplateBo.setTeachingMaterialFee(vo.getTeachingMaterialFee());
        courseTemplateBo.setTeachingMaterialIntro(vo.getTeachingMaterialIntro());
        courseTemplateBo.setTeachingMethod(vo.getTeachingMethod());
        courseTemplateBo.setTrail(vo.getTrail());
        courseTemplateBo.setWholeName(vo.getWholeName());
        if (vo.getActionList() != null) {
            List<ActionBo> list = new ArrayList<>();
            for (ActionVo a : vo.getActionList()) {
                list.add(ActionConverter.fromModel(a));
            }
            courseTemplateBo.setActionList(list);
        }
        return courseTemplateBo;
    }

    public static CourseTemplateVo toModel(CourseTemplateBo bo) {
        CourseTemplateVo courseTemplateVo = new CourseTemplateVo();
        courseTemplateVo.setAddress(bo.getAddress());
        courseTemplateVo.setAddressId(bo.getAddressId());
        courseTemplateVo.setAddressLat(bo.getAddressLat());
        courseTemplateVo.setAddressLat(bo.getAddressLat());
        courseTemplateVo.setAddressLng(bo.getAddressLng());
        courseTemplateVo.setAssignments(bo.getAssignments());
        courseTemplateVo.setBonusService(bo.getBonusService());
        courseTemplateVo.setBookingTotal(bo.getBookingTotal());
        courseTemplateVo.setBookingTotalEnd(bo.getBookingTotalEnd());
        courseTemplateVo.setBookingTotalSet(bo.getBookingTotalSet());
        courseTemplateVo.setBookingTotalStart(bo.getBookingTotalStart());
        courseTemplateVo.setBookingType(bo.getBookingType());
        courseTemplateVo.setCashback(bo.getCashback());
        courseTemplateVo.setCashbackDate(DateUtility.getTimeFromLong(bo.getCashbackDate()));
        courseTemplateVo.setCashbackDateEnd(DateUtility.getTimeFromLong(bo.getCashbackDateEnd()));
        courseTemplateVo.setCashbackDateStart(DateUtility.getTimeFromLong(bo.getCashbackDateStart()));
        courseTemplateVo.setCashbackEnd(bo.getCashbackEnd());
        courseTemplateVo.setCashbackStart(bo.getCashbackStart());
        courseTemplateVo.setCategoryId(bo.getCategoryId());
        courseTemplateVo.setCategoryIdSet(bo.getCategoryIdSet());
        courseTemplateVo.setCategoryName(bo.getCategoryName());
        courseTemplateVo.setCategoryRank(bo.getCategoryRank());
        courseTemplateVo.setCategoryValue(bo.getCategoryValue());
        courseTemplateVo.setCertification(bo.getCertification());
        courseTemplateVo.setCircleId(bo.getCircleId());
        courseTemplateVo.setCircleIdSet(bo.getCircleIdSet());
        courseTemplateVo.setCircleName(bo.getCircleName());
        courseTemplateVo.setCircleValue(bo.getCircleValue());
        if (bo.getClassPhotoList() != null) {
            List<ClassPhotoVo> list = new ArrayList<>();
            for (ClassPhotoBo a : bo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.toModel(a));
            }
            courseTemplateVo.setClassPhotoList(list);
        }
        courseTemplateVo.setClassSize(bo.getClassSize());
        courseTemplateVo.setClassTeacher(bo.getClassTeacher());
        courseTemplateVo.setClassType(bo.getClassType());
        courseTemplateVo.setClassTypeSet(bo.getClassTypeSet());
        courseTemplateVo.setCommission(bo.getCommission());
        courseTemplateVo.setContact(bo.getContact());
        courseTemplateVo.setCourseHourLength(bo.getCourseHourLength());
        courseTemplateVo.setCourseHourNum(bo.getCourseHourNum());
        courseTemplateVo.setCourseHourNumEnd(bo.getCourseHourNumEnd());
        courseTemplateVo.setCourseHourNumSet(bo.getCourseHourNumSet());
        courseTemplateVo.setCourseHourNumStart(bo.getCourseHourNumStart());
        courseTemplateVo.setCourseIntro(bo.getCourseIntro());
        courseTemplateVo.setCourseName(bo.getCourseName());
        courseTemplateVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTemplateVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTemplateVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTemplateVo.setCutoffDate(DateUtility.getTimeFromLong(bo.getCutoffDate()));
        courseTemplateVo.setCutoffDateEnd(DateUtility.getTimeFromLong(bo.getCutoffDateEnd()));
        courseTemplateVo.setCutoffDateStart(DateUtility.getTimeFromLong(bo.getCutoffDateStart()));
        courseTemplateVo.setDiscount(bo.getDiscount());
        courseTemplateVo.setDiscountEnd(bo.getDiscountEnd());
        courseTemplateVo.setDiscountEnd(bo.getDiscountEnd());
        courseTemplateVo.setDiscountStart(bo.getDiscountStart());
        courseTemplateVo.setDownloadMaterials(bo.getDownloadMaterials());
        courseTemplateVo.setEnabled(bo.getEnabled());
        courseTemplateVo.setExtracurricular(bo.getExtracurricular());
        courseTemplateVo.setFinishDate(DateUtility.getTimeFromLong(bo.getFinishDate()));
        courseTemplateVo.setFinishDateEnd(DateUtility.getTimeFromLong(bo.getFinishDateEnd()));
        courseTemplateVo.setFinishDateStart(DateUtility.getTimeFromLong(bo.getFinishDateStart()));
        courseTemplateVo.setFinishTime1(bo.getFinishTime1());
        courseTemplateVo.setFinishTime2(bo.getFinishTime2());
        courseTemplateVo.setGoal(bo.getGoal());
        courseTemplateVo.setHighScoreReward(bo.getHighScoreReward());
        courseTemplateVo.setId(bo.getId());
        courseTemplateVo.setIdSet(bo.getIdSet());
        courseTemplateVo.setInstName(bo.getInstName());
        courseTemplateVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        courseTemplateVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        courseTemplateVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        courseTemplateVo.setLocationId(bo.getLocationId());
        courseTemplateVo.setLocationIdSet(bo.getLocationIdSet());
        courseTemplateVo.setLocationName(bo.getLocationName());
        courseTemplateVo.setLocationValue(bo.getLocationValue());
        courseTemplateVo.setLogoUrl(bo.getLogoUrl());
        courseTemplateVo.setMarking(bo.getMarking());
        courseTemplateVo.setNoRefundDate(DateUtility.getTimeFromLong(bo.getNoRefundDate()));
        courseTemplateVo.setNoRefundDateEnd(DateUtility.getTimeFromLong(bo.getNoRefundDateEnd()));
        courseTemplateVo.setNoRefundDateStart(DateUtility.getTimeFromLong(bo.getNoRefundDateStart()));
        courseTemplateVo.setOpenCourseRequirement(bo.getOpenCourseRequirement());
        courseTemplateVo.setOriginalPrice(bo.getOriginalPrice());
        courseTemplateVo.setOriginalPriceEnd(bo.getOriginalPriceEnd());
        courseTemplateVo.setOriginalPriceStart(bo.getOriginalPriceStart());
        courseTemplateVo.setOutline(bo.getOutline());
        courseTemplateVo.setPartnerDistinction(bo.getPartnerDistinction());
        courseTemplateVo.setPartnerId(bo.getPartnerId());
        courseTemplateVo.setPartnerIdSet(bo.getPartnerIdSet());
        courseTemplateVo.setPartnerIntro(bo.getPartnerIntro());
        courseTemplateVo.setPartnerQualification(bo.getPartnerQualification());
        courseTemplateVo.setPartnerRating(bo.getPartnerRating());
        courseTemplateVo.setPassAgreement(bo.getPassAgreement());
        courseTemplateVo.setPopularity(bo.getPopularity());
        courseTemplateVo.setPopularityEnd(bo.getPopularityEnd());
        courseTemplateVo.setPopularitySet(bo.getPopularitySet());
        courseTemplateVo.setPopularityStart(bo.getPopularityStart());
        courseTemplateVo.setPrerequest(bo.getPrerequest());
        courseTemplateVo.setPrice(bo.getPrice());
        courseTemplateVo.setPriceEnd(bo.getPriceEnd());
        courseTemplateVo.setPriceStart(bo.getPriceStart());
        courseTemplateVo.setQualityAssurance(bo.getQualityAssurance());
        courseTemplateVo.setQuestionBank(bo.getQuestionBank());
        courseTemplateVo.setQuestionSession(bo.getQuestionSession());
        courseTemplateVo.setQuiz(bo.getQuiz());
        courseTemplateVo.setRating(bo.getRating());
        courseTemplateVo.setRatingEnd(bo.getRatingEnd());
        courseTemplateVo.setRatingStart(bo.getRatingStart());
        courseTemplateVo.setReference(bo.getReference());
        courseTemplateVo.setRegLocation(bo.getRegLocation());
        courseTemplateVo.setRegPhone(bo.getRegPhone());
        courseTemplateVo.setSchooltimeDay(bo.getSchooltimeDay());
        courseTemplateVo.setSchooltimeDaySet(bo.getSchooltimeDaySet());
        courseTemplateVo.setSchooltimeWeek(bo.getSchooltimeWeek());
        courseTemplateVo.setSchooltimeWeekSet(bo.getSchooltimeWeekSet());
        courseTemplateVo.setServiceCharge(bo.getServiceCharge());
        courseTemplateVo.setStartDate(DateUtility.getTimeFromLong(bo.getStartDate()));
        courseTemplateVo.setStartDateEnd(DateUtility.getTimeFromLong(bo.getStartDateEnd()));
        courseTemplateVo.setStartDateStart(DateUtility.getTimeFromLong(bo.getStartDateStart()));
        courseTemplateVo.setStartTime1(bo.getStartTime1());
        courseTemplateVo.setStartTime2(bo.getStartTime2());
        courseTemplateVo.setStartUponArrival(bo.getStartUponArrival());
        courseTemplateVo.setStatus(bo.getStatus());
        courseTemplateVo.setStatusSet(bo.getStatusSet());
        courseTemplateVo.setStudyDayNote(bo.getStudyDayNote());
        courseTemplateVo.setSuitableStudent(bo.getSuitableStudent());
        if (bo.getTeacherList() != null) {
            List<TeacherVo> list = new ArrayList<>();
            for (TeacherBo a : bo.getTeacherList()) {
                list.add(TeacherConverter.toModel(a));
            }
            courseTemplateVo.setTeacherList(list);
        }
        courseTemplateVo.setTeachingAndExercise(bo.getTeachingAndExercise());
        courseTemplateVo.setTeachingMaterialFee(bo.getTeachingMaterialFee());
        courseTemplateVo.setTeachingMaterialIntro(bo.getTeachingMaterialIntro());
        courseTemplateVo.setTeachingMethod(bo.getTeachingMethod());
        courseTemplateVo.setTrail(bo.getTrail());
        courseTemplateVo.setWholeName(bo.getWholeName());
        if (bo.getActionList() != null) {
            List<ActionVo> list = new ArrayList<>();
            for (ActionBo a : bo.getActionList()) {
                list.add(ActionConverter.toModel(a));
            }
            courseTemplateVo.setActionList(list);
        }
        return courseTemplateVo;
    }
}
