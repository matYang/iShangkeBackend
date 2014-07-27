package com.ishangke.edunav.manager.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public class CourseTemplateConverter {
    public static CourseTemplateBo toBo(CourseTemplateEntityExt e) {
        if (e == null) {
            return null;
        }
        CourseTemplateBo courseTemplateBo = new CourseTemplateBo();
        if (e.getAddress() != null) {
            courseTemplateBo.setAddress(e.getAddress());
        }
        if (e.getAddressId() != null) {
            courseTemplateBo.setAddressId(e.getAddressId());
        }
        if (e.getAddressLat() != null) {
            courseTemplateBo.setAddressLat(e.getAddressLat());
        }
        if (e.getAddressLat() != null) {
            courseTemplateBo.setAddressLat(e.getAddressLat());
        }
        if (e.getAddressLng() != null) {
            courseTemplateBo.setAddressLng(e.getAddressLng());
        }
        if (e.getAssignments() != null) {
            courseTemplateBo.setAssignments(e.getAssignments());
        }
        if (e.getBonusService() != null) {
            courseTemplateBo.setBonusService(e.getBonusService());
        }
        if (e.getBookingTotal() != null) {
            courseTemplateBo.setBookingTotal(e.getBookingTotal());
        } else {
            courseTemplateBo.setBookingTotal(Constant.DEFAULTNULL);
        }
        if (e.getBookingTotalEnd() != null) {
            courseTemplateBo.setBookingTotalEnd(e.getBookingTotalEnd());
        } else {
            courseTemplateBo.setBookingTotalEnd(Constant.DEFAULTNULL);
        }
        if (e.getBookingTotalSet() != null) {
            courseTemplateBo.setBookingTotalSet(e.getBookingTotalSet());
        }
        if (e.getBookingTotalStart() != null) {
            courseTemplateBo.setBookingTotalStart(e.getBookingTotalStart());
        } else {
            courseTemplateBo.setBookingTotalStart(Constant.DEFAULTNULL);
        }
        if (e.getBookingType() != null) {
            courseTemplateBo.setBookingType(e.getBookingType());
        } else {
            courseTemplateBo.setBookingType(Constant.DEFAULTNULL);
        }
        if (e.getCashback() != null) {
            courseTemplateBo.setCashback(e.getCashback());
        } else {
            courseTemplateBo.setCashback(Constant.DEFAULTNULL);
        }
        if (e.getCashbackEnd() != null) {
            courseTemplateBo.setCashbackEnd(e.getCashbackEnd());
        } else {
            courseTemplateBo.setCashbackEnd(Constant.DEFAULTNULL);
        }
        if (e.getCashbackStart() != null) {
            courseTemplateBo.setCashbackStart(e.getCashbackStart());
        } else {
            courseTemplateBo.setCashbackStart(Constant.DEFAULTNULL);
        }
        if (e.getCategoryId() != null) {
            courseTemplateBo.setCategoryId(e.getCategoryId());
        }
        if (e.getCategoryIdSet() != null) {
            courseTemplateBo.setCategoryIdSet(e.getCategoryIdSet());
        }
        if (e.getCategoryName() != null) {
            courseTemplateBo.setCategoryName(e.getCategoryName());
        }
        if (e.getCategoryRank() != null) {
            courseTemplateBo.setCategoryRank(e.getCategoryRank());
        }
        if (e.getCategoryValue() != null) {
            courseTemplateBo.setCategoryValue(e.getCategoryValue());
        }
        if (e.getCertification() != null) {
            courseTemplateBo.setCertification(e.getCertification());
        }
        if (e.getCircleId() != null) {
            courseTemplateBo.setCircleId(e.getCircleId());
        }
        if (e.getCircleIdSet() != null) {
            courseTemplateBo.setCircleIdSet(e.getCircleIdSet());
        }
        if (e.getCircleName() != null) {
            courseTemplateBo.setCircleName(e.getCircleName());
        }
        if (e.getCircleValue() != null) {
            courseTemplateBo.setCircleValue(e.getCircleValue());
        }
        if (e.getClassSize() != null) {
            courseTemplateBo.setClassSize(e.getClassSize());
        }
        if (e.getClassTeacher() != null) {
            courseTemplateBo.setClassTeacher(e.getClassTeacher());
        }
        if (e.getClassType() != null) {
            courseTemplateBo.setClassType(e.getClassType());
        } else {
            courseTemplateBo.setClassType(Constant.DEFAULTNULL);
        }
        if (e.getClassTypeSet() != null) {
            courseTemplateBo.setClassTypeSet(e.getClassTypeSet());
        }
        if (e.getCommission() != null) {
            courseTemplateBo.setCommission(e.getCommission());
        } else {
            courseTemplateBo.setCommission(Constant.DEFAULTNULL);
        }
        if (e.getContact() != null) {
            courseTemplateBo.setContact(e.getContact());
        }
        if (e.getCourseHourLength() != null) {
            courseTemplateBo.setCourseHourLength(e.getCourseHourLength());
        } else {
            courseTemplateBo.setCourseHourLength(Constant.DEFAULTNULL);
        }
        if (e.getCourseHourNum() != null) {
            courseTemplateBo.setCourseHourNum(e.getCourseHourNum());
        } else {
            courseTemplateBo.setCourseHourNum(Constant.DEFAULTNULL);
        }
        if (e.getCourseHourNumEnd() != null) {
            courseTemplateBo.setCourseHourNumEnd(e.getCourseHourNumEnd());
        } else {
            courseTemplateBo.setCourseHourNumEnd(Constant.DEFAULTNULL);
        }
        if (e.getCourseHourNumSet() != null) {
            courseTemplateBo.setCourseHourNumSet(e.getCourseHourNumSet());
        }
        if (e.getCourseHourNumStart() != null) {
            courseTemplateBo.setCourseHourNumStart(e.getCourseHourNumStart());
        } else {
            courseTemplateBo.setCourseHourNumStart(Constant.DEFAULTNULL);
        }
        if (e.getCourseIntro() != null) {
            courseTemplateBo.setCourseIntro(e.getCourseIntro());
        }
        if (e.getCourseName() != null) {
            courseTemplateBo.setCourseName(e.getCourseName());
        }
        if (e.getDiscount() != null) {
            courseTemplateBo.setDiscount(e.getDiscount());
        } else {
            courseTemplateBo.setDiscount(Constant.DEFAULTNULL);
        }
        if (e.getDiscountEnd() != null) {
            courseTemplateBo.setDiscountEnd(e.getDiscountEnd());
        } else {
            courseTemplateBo.setDiscountEnd(Constant.DEFAULTNULL);
        }
        if (e.getDiscountStart() != null) {
            courseTemplateBo.setDiscountStart(e.getDiscountStart());
        } else {
            courseTemplateBo.setDiscountStart(Constant.DEFAULTNULL);
        }
        if (e.getDownloadMaterials() != null) {
            courseTemplateBo.setDownloadMaterials(e.getDownloadMaterials());
        }
        if (e.getEnabled() != null) {
            courseTemplateBo.setEnabled(e.getEnabled());
        }
        if (e.getExtracurricular() != null) {
            courseTemplateBo.setExtracurricular(e.getExtracurricular());
        }
        if (e.getFinishTime1() != null) {
            courseTemplateBo.setFinishTime1(e.getFinishTime1());
        } else {
            courseTemplateBo.setFinishTime1(Constant.DEFAULTNULL);
        }
        if (e.getFinishTime2() != null) {
            courseTemplateBo.setFinishTime2(e.getFinishTime2());
        } else {
            courseTemplateBo.setFinishTime2(Constant.DEFAULTNULL);
        }
        if (e.getGoal() != null) {
            courseTemplateBo.setGoal(e.getGoal());
        }
        if (e.getHighScoreReward() != null) {
            courseTemplateBo.setHighScoreReward(e.getHighScoreReward());
        }
        if (e.getId() != null) {
            courseTemplateBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            courseTemplateBo.setIdSet(e.getIdSet());
        }
        if (e.getInstName() != null) {
            courseTemplateBo.setInstName(e.getInstName());
        }
        if (e.getLocationId() != null) {
            courseTemplateBo.setLocationId(e.getLocationId());
        }
        if (e.getLocationIdSet() != null) {
            courseTemplateBo.setLocationIdSet(e.getLocationIdSet());
        }
        if (e.getLocationName() != null) {
            courseTemplateBo.setLocationName(e.getLocationName());
        }
        if (e.getLocationValue() != null) {
            courseTemplateBo.setLocationValue(e.getLocationValue());
        }
        if (e.getLogoUrl() != null) {
            courseTemplateBo.setLogoUrl(e.getLogoUrl());
        }
        if (e.getMarking() != null) {
            courseTemplateBo.setMarking(e.getMarking());
        }
        if (e.getOpenCourseRequirement() != null) {
            courseTemplateBo.setOpenCourseRequirement(e.getOpenCourseRequirement());
        }
        if (e.getOriginalPrice() != null) {
            courseTemplateBo.setOriginalPrice(e.getOriginalPrice());
        } else {
            courseTemplateBo.setOriginalPrice(Constant.DEFAULTNULL);
        }
        if (e.getOriginalPriceEnd() != null) {
            courseTemplateBo.setOriginalPriceEnd(e.getOriginalPriceEnd());
        } else {
            courseTemplateBo.setOriginalPriceEnd(Constant.DEFAULTNULL);
        }
        if (e.getOriginalPriceStart() != null) {
            courseTemplateBo.setOriginalPriceStart(e.getOriginalPriceStart());
        } else {
            courseTemplateBo.setOriginalPriceStart(Constant.DEFAULTNULL);
        }
        if (e.getOutline() != null) {
            courseTemplateBo.setOutline(e.getOutline());
        }
        if (e.getPartnerDistinction() != null) {
            courseTemplateBo.setPartnerDistinction(e.getPartnerDistinction());
        }
        if (e.getPartnerId() != null) {
            courseTemplateBo.setPartnerId(e.getPartnerId());
        }
        if (e.getPartnerIdSet() != null) {
            courseTemplateBo.setPartnerIdSet(e.getPartnerIdSet());
        }
        if (e.getPartnerIntro() != null) {
            courseTemplateBo.setPartnerIntro(e.getPartnerIntro());
        }
        if (e.getPartnerQualification() != null) {
            courseTemplateBo.setPartnerQualification(e.getPartnerQualification());
        }
        if (e.getPartnerRating() != null) {
            courseTemplateBo.setPartnerRating(e.getPartnerRating());
        }
        if (e.getPassAgreement() != null) {
            courseTemplateBo.setPassAgreement(e.getPassAgreement());
        }
        if (e.getPopularity() != null) {
            courseTemplateBo.setPopularity(e.getPopularity());
        } else {
            courseTemplateBo.setPopularity(Constant.DEFAULTNULL);
        }
        if (e.getPopularityEnd() != null) {
            courseTemplateBo.setPopularityEnd(e.getPopularityEnd());
        } else {
            courseTemplateBo.setPopularityEnd(Constant.DEFAULTNULL);
        }
        if (e.getPopularitySet() != null) {
            courseTemplateBo.setPopularitySet(e.getPopularitySet());
        }
        if (e.getPopularityStart() != null) {
            courseTemplateBo.setPopularityStart(e.getPopularityStart());
        } else {
            courseTemplateBo.setPopularityStart(Constant.DEFAULTNULL);
        }
        if (e.getPrerequest() != null) {
            courseTemplateBo.setPrerequest(e.getPrerequest());
        }
        if (e.getPrice() != null) {
            courseTemplateBo.setPrice(e.getPrice());
        } else {
            courseTemplateBo.setPrice(Constant.DEFAULTNULL);
        }
        if (e.getPriceEnd() != null) {
            courseTemplateBo.setPriceEnd(e.getPriceEnd());
        } else {
            courseTemplateBo.setPriceEnd(Constant.DEFAULTNULL);
        }
        if (e.getPriceStart() != null) {
            courseTemplateBo.setPriceStart(e.getPriceStart());
        } else {
            courseTemplateBo.setPriceStart(Constant.DEFAULTNULL);
        }
        if (e.getQualityAssurance() != null) {
            courseTemplateBo.setQualityAssurance(e.getQualityAssurance());
        }
        if (e.getQuestionBank() != null) {
            courseTemplateBo.setQuestionBank(e.getQuestionBank());
        }
        if (e.getQuestionSession() != null) {
            courseTemplateBo.setQuestionSession(e.getQuestionSession());
        }
        if (e.getQuiz() != null) {
            courseTemplateBo.setQuiz(e.getQuiz());
        }
        if (e.getRating() != null) {
            courseTemplateBo.setRating(e.getRating());
        } else {
            courseTemplateBo.setRating(Constant.DEFAULTNULL);
        }
        if (e.getRatingEnd() != null) {
            courseTemplateBo.setRatingEnd(e.getRatingEnd());
        } else {
            courseTemplateBo.setRatingEnd(Constant.DEFAULTNULL);
        }
        if (e.getRatingStart() != null) {
            courseTemplateBo.setRatingStart(e.getRatingStart());
        } else {
            courseTemplateBo.setRatingStart(Constant.DEFAULTNULL);
        }
        if (e.getReference() != null) {
            courseTemplateBo.setReference(e.getReference());
        }
        if (e.getRegLocation() != null) {
            courseTemplateBo.setRegLocation(e.getRegLocation());
        }
        if (e.getRegPhone() != null) {
            courseTemplateBo.setRegPhone(e.getRegPhone());
        }
        if (e.getSchooltimeDay() != null) {
            courseTemplateBo.setSchooltimeDay(e.getSchooltimeDay());
        } else {
            courseTemplateBo.setSchooltimeDay(Constant.DEFAULTNULL);
        }
        if (e.getSchooltimeDaySet() != null) {
            courseTemplateBo.setSchooltimeDaySet(e.getSchooltimeDaySet());
        }
        if (e.getSchooltimeWeek() != null) {
            courseTemplateBo.setSchooltimeWeek(e.getSchooltimeWeek());
        } else {
            courseTemplateBo.setSchooltimeWeek(Constant.DEFAULTNULL);
        }
        if (e.getSchooltimeWeekSet() != null) {
            courseTemplateBo.setSchooltimeWeekSet(e.getSchooltimeWeekSet());
        }
        if (e.getServiceCharge() != null) {
            courseTemplateBo.setServiceCharge(e.getServiceCharge());
        } else {
            courseTemplateBo.setServiceCharge(Constant.DEFAULTNULL);
        }
        if (e.getStartTime1() != null) {
            courseTemplateBo.setStartTime1(e.getStartTime1());
        } else {
            courseTemplateBo.setStartTime1(Constant.DEFAULTNULL);
        }
        if (e.getStartTime2() != null) {
            courseTemplateBo.setStartTime2(e.getStartTime2());
        } else {
            courseTemplateBo.setStartTime2(Constant.DEFAULTNULL);
        }
        if (e.getStartUponArrival() != null) {
            courseTemplateBo.setStartUponArrival(e.getStartUponArrival());
        } else {
            courseTemplateBo.setStartUponArrival(Constant.DEFAULTNULL);
        }
        if (e.getStatus() != null) {
            courseTemplateBo.setStatus(e.getStatus());
        } else {
            courseTemplateBo.setStatus(Constant.DEFAULTNULL);
        }
        if (e.getStatusSet() != null) {
            courseTemplateBo.setStatusSet(e.getStatusSet());
        }
        if (e.getStudyDayNote() != null) {
            courseTemplateBo.setStudyDayNote(e.getStudyDayNote());
        }
        if (e.getSuitableStudent() != null) {
            courseTemplateBo.setSuitableStudent(e.getSuitableStudent());
        }
        if (e.getTeachingAndExercise() != null) {
            courseTemplateBo.setTeachingAndExercise(e.getTeachingAndExercise());
        }
        if (e.getTeachingMaterialFee() != null) {
            courseTemplateBo.setTeachingMaterialFee(e.getTeachingMaterialFee());
        }
        if (e.getTeachingMaterialIntro() != null) {
            courseTemplateBo.setTeachingMaterialIntro(e.getTeachingMaterialIntro());
        }
        if (e.getTeachingMethod() != null) {
            courseTemplateBo.setTeachingMethod(e.getTeachingMethod());
        }
        if (e.getTrail() != null) {
            courseTemplateBo.setTrail(e.getTrail());
        }
        if (e.getWholeName() != null) {
            courseTemplateBo.setWholeName(e.getWholeName());
        }
        courseTemplateBo.setStartDate(e.getStartDate() == null ? Constant.DEFAULTNULL : e.getStartDate()
                .getTimeInMillis());
        courseTemplateBo.setStartDateEnd(e.getStartDateEnd() == null ? Constant.DEFAULTNULL : e.getStartDateEnd()
                .getTimeInMillis());
        courseTemplateBo.setStartDateStart(e.getStartDateStart() == null ? Constant.DEFAULTNULL : e.getStartDateStart()
                .getTimeInMillis());
        courseTemplateBo.setNoRefundDate(e.getNoRefundDate() == null ? Constant.DEFAULTNULL : e.getNoRefundDate()
                .getTimeInMillis());
        courseTemplateBo.setNoRefundDateEnd(e.getNoRefundDateEnd() == null ? Constant.DEFAULTNULL : e
                .getNoRefundDateEnd().getTimeInMillis());
        courseTemplateBo.setNoRefundDateStart(e.getNoRefundDateStart() == null ? Constant.DEFAULTNULL : e
                .getNoRefundDateStart().getTimeInMillis());
        courseTemplateBo.setCashbackDate(e.getCashbackDate() == null ? Constant.DEFAULTNULL : e.getCashbackDate()
                .getTimeInMillis());
        courseTemplateBo.setCashbackDateEnd(e.getCashbackDateEnd() == null ? Constant.DEFAULTNULL : e
                .getCashbackDateEnd().getTimeInMillis());
        courseTemplateBo.setCashbackDateStart(e.getCashbackDateStart() == null ? Constant.DEFAULTNULL : e
                .getCashbackDateStart().getTimeInMillis());
        courseTemplateBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime()
                .getTimeInMillis());
        courseTemplateBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        courseTemplateBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e
                .getCreateTimeStart().getTimeInMillis());
        courseTemplateBo.setCutoffDate(e.getCutoffDate() == null ? Constant.DEFAULTNULL : e.getCutoffDate()
                .getTimeInMillis());
        courseTemplateBo.setCutoffDateEnd(e.getCutoffDateEnd() == null ? Constant.DEFAULTNULL : e.getCutoffDateEnd()
                .getTimeInMillis());
        courseTemplateBo.setCutoffDateStart(e.getCutoffDateStart() == null ? Constant.DEFAULTNULL : e
                .getCutoffDateStart().getTimeInMillis());
        courseTemplateBo.setFinishDate(e.getFinishDate() == null ? Constant.DEFAULTNULL : e.getFinishDate()
                .getTimeInMillis());
        courseTemplateBo.setFinishDateEnd(e.getFinishDateEnd() == null ? Constant.DEFAULTNULL : e.getFinishDateEnd()
                .getTimeInMillis());
        courseTemplateBo.setFinishDateStart(e.getFinishDateStart() == null ? Constant.DEFAULTNULL : e
                .getFinishDateStart().getTimeInMillis());
        courseTemplateBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        courseTemplateBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        courseTemplateBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        if (e.getClassPhotoList() != null) {
            List<ClassPhotoBo> list = new ArrayList<>();
            for (ClassPhotoEntityExt a : e.getClassPhotoList()) {
                list.add(ClassPhotoConverter.toBo(a));
            }
            courseTemplateBo.setClassPhotoList(list);
        }
        if (e.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherEntityExt a : e.getTeacherList()) {
                list.add(TeacherConverter.toBo(a));
            }
            courseTemplateBo.setTeacherList(list);
        }
        return courseTemplateBo;
    }

    public static CourseTemplateEntityExt fromBo(CourseTemplateBo bo) {
        if (bo == null) {
            return null;
        }
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
        courseTemplateEntityExt.setAddress(bo.getAddress());
        courseTemplateEntityExt.setAddressId(bo.getAddressId());
        courseTemplateEntityExt.setAddressLat(bo.getAddressLat());
        courseTemplateEntityExt.setAddressLat(bo.getAddressLat());
        courseTemplateEntityExt.setAddressLng(bo.getAddressLng());
        courseTemplateEntityExt.setAssignments(bo.getAssignments());
        courseTemplateEntityExt.setBonusService(bo.getBonusService());
        if (bo.getBookingTotal() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setBookingTotal(bo.getBookingTotal());
        }
        if (bo.getBookingTotalEnd() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setBookingTotalEnd(bo.getBookingTotalEnd());
        }
        courseTemplateEntityExt.setBookingTotalSet(bo.getBookingTotalSet());
        if (bo.getBookingTotalStart() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setBookingTotalStart(bo.getBookingTotalStart());
        }
        if (bo.getBookingType() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setBookingType(bo.getBookingType());
        }
        if (bo.getCashback() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setCashback(bo.getCashback());
        }
        courseTemplateEntityExt.setCashbackDate(DateUtility.getTimeFromLong(bo.getCashbackDate()));
        courseTemplateEntityExt.setCashbackDateEnd(DateUtility.getTimeFromLong(bo.getCashbackDateEnd()));
        courseTemplateEntityExt.setCashbackDateStart(DateUtility.getTimeFromLong(bo.getCashbackDateStart()));
        if (bo.getCashbackEnd() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setCashbackEnd(bo.getCashbackEnd());
        }
        if (bo.getCashbackStart() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setCashbackStart(bo.getCashbackStart());
        }
        courseTemplateEntityExt.setCategoryId(bo.getCategoryId());
        courseTemplateEntityExt.setCategoryIdSet(bo.getCategoryIdSet());
        courseTemplateEntityExt.setCategoryName(bo.getCategoryName());
        courseTemplateEntityExt.setCategoryRank(bo.getCategoryRank());
        courseTemplateEntityExt.setCategoryValue(bo.getCategoryValue());
        courseTemplateEntityExt.setCertification(bo.getCertification());
        courseTemplateEntityExt.setCircleId(bo.getCircleId());
        courseTemplateEntityExt.setCircleIdSet(bo.getCircleIdSet());
        courseTemplateEntityExt.setCircleName(bo.getCircleName());
        courseTemplateEntityExt.setCircleValue(bo.getCircleValue());
        if (bo.getClassPhotoList() != null) {
            List<ClassPhotoEntityExt> list = new ArrayList<>();
            for (ClassPhotoBo a : bo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.fromBo(a));
            }
            courseTemplateEntityExt.setClassPhotoList(list);
        }
        courseTemplateEntityExt.setClassSize(bo.getClassSize());
        courseTemplateEntityExt.setClassTeacher(bo.getClassTeacher());
        if (bo.getClassType() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setClassType(bo.getClassType());
        }
        courseTemplateEntityExt.setClassTypeSet(bo.getClassTypeSet());
        if (bo.getCommission() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setCommission(bo.getCommission());
        }
        courseTemplateEntityExt.setContact(bo.getContact());
        if (bo.getCourseHourLength() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setCourseHourLength(bo.getCourseHourLength());
        }
        if (bo.getCourseHourNum() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setCourseHourNum(bo.getCourseHourNum());
        }
        if (bo.getCourseHourNumEnd() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setCourseHourNumEnd(bo.getCourseHourNumEnd());
        }
        courseTemplateEntityExt.setCourseHourNumSet(bo.getCourseHourNumSet());
        if (bo.getCourseHourNumStart() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setCourseHourNumStart(bo.getCourseHourNumStart());
        }
        courseTemplateEntityExt.setCourseIntro(bo.getCourseIntro());
        courseTemplateEntityExt.setCourseName(bo.getCourseName());
        courseTemplateEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTemplateEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTemplateEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTemplateEntityExt.setCutoffDate(DateUtility.getTimeFromLong(bo.getCutoffDate()));
        courseTemplateEntityExt.setCutoffDateEnd(DateUtility.getTimeFromLong(bo.getCutoffDateEnd()));
        courseTemplateEntityExt.setCutoffDateStart(DateUtility.getTimeFromLong(bo.getCutoffDateStart()));
        if (bo.getDiscount() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setDiscount(bo.getDiscount());
        }
        if (bo.getDiscountEnd() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setDiscountEnd(bo.getDiscountEnd());
        }
        if (bo.getDiscountStart() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setDiscountStart(bo.getDiscountStart());
        }
        courseTemplateEntityExt.setDownloadMaterials(bo.getDownloadMaterials());
        courseTemplateEntityExt.setEnabled(bo.getEnabled());
        courseTemplateEntityExt.setExtracurricular(bo.getExtracurricular());
        courseTemplateEntityExt.setFinishDate(DateUtility.getTimeFromLong(bo.getFinishDate()));
        courseTemplateEntityExt.setFinishDateEnd(DateUtility.getTimeFromLong(bo.getFinishDateEnd()));
        courseTemplateEntityExt.setFinishDateStart(DateUtility.getTimeFromLong(bo.getFinishDateStart()));
        if (bo.getFinishTime1() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setFinishTime1(bo.getFinishTime1());
        }
        if (bo.getFinishTime2() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setFinishTime2(bo.getFinishTime2());
        }
        courseTemplateEntityExt.setGoal(bo.getGoal());
        courseTemplateEntityExt.setHighScoreReward(bo.getHighScoreReward());
        courseTemplateEntityExt.setId(bo.getId());
        courseTemplateEntityExt.setIdSet(bo.getIdSet());
        courseTemplateEntityExt.setInstName(bo.getInstName());
        courseTemplateEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        courseTemplateEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        courseTemplateEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        courseTemplateEntityExt.setLocationId(bo.getLocationId());
        courseTemplateEntityExt.setLocationIdSet(bo.getLocationIdSet());
        courseTemplateEntityExt.setLocationName(bo.getLocationName());
        courseTemplateEntityExt.setLocationValue(bo.getLocationValue());
        courseTemplateEntityExt.setLogoUrl(bo.getLogoUrl());
        courseTemplateEntityExt.setMarking(bo.getMarking());
        courseTemplateEntityExt.setNoRefundDate(DateUtility.getTimeFromLong(bo.getNoRefundDate()));
        courseTemplateEntityExt.setNoRefundDateEnd(DateUtility.getTimeFromLong(bo.getNoRefundDateEnd()));
        courseTemplateEntityExt.setNoRefundDateStart(DateUtility.getTimeFromLong(bo.getNoRefundDateStart()));
        courseTemplateEntityExt.setOpenCourseRequirement(bo.getOpenCourseRequirement());
        if (bo.getOriginalPrice() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setOriginalPrice(bo.getOriginalPrice());
        }
        if (bo.getOriginalPriceEnd() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setOriginalPriceEnd(bo.getOriginalPriceEnd());
        }
        if (bo.getOriginalPriceStart() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setOriginalPriceStart(bo.getOriginalPriceStart());
        }
        courseTemplateEntityExt.setOutline(bo.getOutline());
        courseTemplateEntityExt.setPartnerDistinction(bo.getPartnerDistinction());
        courseTemplateEntityExt.setPartnerId(bo.getPartnerId());
        courseTemplateEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
        courseTemplateEntityExt.setPartnerIntro(bo.getPartnerIntro());
        courseTemplateEntityExt.setPartnerQualification(bo.getPartnerQualification());
        courseTemplateEntityExt.setPartnerRating(bo.getPartnerRating());
        courseTemplateEntityExt.setPassAgreement(bo.getPassAgreement());
        if (bo.getPopularity() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setPopularity(bo.getPopularity());
        }
        if (bo.getPopularityEnd() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setPopularityEnd(bo.getPopularityEnd());
        }
        courseTemplateEntityExt.setPopularitySet(bo.getPopularitySet());
        if (bo.getPopularityStart() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setPopularityStart(bo.getPopularityStart());
        }
        courseTemplateEntityExt.setPrerequest(bo.getPrerequest());
        if (bo.getPrice() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setPrice(bo.getPrice());
        }
        if (bo.getPriceEnd() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setPriceEnd(bo.getPriceEnd());
        }
        if (bo.getPriceStart() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setPriceStart(bo.getPriceStart());
        }
        courseTemplateEntityExt.setQualityAssurance(bo.getQualityAssurance());
        courseTemplateEntityExt.setQuestionBank(bo.getQuestionBank());
        courseTemplateEntityExt.setQuestionSession(bo.getQuestionSession());
        courseTemplateEntityExt.setQuiz(bo.getQuiz());
        if (bo.getRating() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setRating(bo.getRating());
        }
        if (bo.getRatingEnd() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setRatingEnd(bo.getRatingEnd());
        }
        if (bo.getRatingStart() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setRatingStart(bo.getRatingStart());
        }
        courseTemplateEntityExt.setReference(bo.getReference());
        courseTemplateEntityExt.setRegLocation(bo.getRegLocation());
        courseTemplateEntityExt.setRegPhone(bo.getRegPhone());
        if (bo.getSchooltimeDay() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setSchooltimeDay(bo.getSchooltimeDay());
        }
        courseTemplateEntityExt.setSchooltimeDaySet(bo.getSchooltimeDaySet());
        if (bo.getSchooltimeWeek() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setSchooltimeWeek(bo.getSchooltimeWeek());
        }
        courseTemplateEntityExt.setSchooltimeWeekSet(bo.getSchooltimeWeekSet());
        if (bo.getServiceCharge() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setServiceCharge(bo.getServiceCharge());
        }
        courseTemplateEntityExt.setStartDate(DateUtility.getTimeFromLong(bo.getStartDate()));
        courseTemplateEntityExt.setStartDateEnd(DateUtility.getTimeFromLong(bo.getStartDateEnd()));
        courseTemplateEntityExt.setStartDateStart(DateUtility.getTimeFromLong(bo.getStartDateStart()));
        if (bo.getStartTime1() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setStartTime1(bo.getStartTime1());
        }
        if (bo.getStartTime2() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setStartTime2(bo.getStartTime2());
        }
        if (bo.getStartUponArrival() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setStartUponArrival(bo.getStartUponArrival());
        }
        if (bo.getStatus() != Constant.DEFAULTNULL) {
            courseTemplateEntityExt.setStatus(bo.getStatus());
        }
        courseTemplateEntityExt.setStatusSet(bo.getStatusSet());
        courseTemplateEntityExt.setStudyDayNote(bo.getStudyDayNote());
        courseTemplateEntityExt.setSuitableStudent(bo.getSuitableStudent());
        if (bo.getTeacherList() != null) {
            List<TeacherEntityExt> list = new ArrayList<>();
            for (TeacherBo a : bo.getTeacherList()) {
                list.add(TeacherConverter.fromBo(a));
            }
            courseTemplateEntityExt.setTeacherList(list);
        }
        courseTemplateEntityExt.setTeachingAndExercise(bo.getTeachingAndExercise());
        courseTemplateEntityExt.setTeachingMaterialFee(bo.getTeachingMaterialFee());
        courseTemplateEntityExt.setTeachingMaterialIntro(bo.getTeachingMaterialIntro());
        courseTemplateEntityExt.setTeachingMethod(bo.getTeachingMethod());
        courseTemplateEntityExt.setTrail(bo.getTrail());
        courseTemplateEntityExt.setWholeName(bo.getWholeName());
        return courseTemplateEntityExt;
    }
}
