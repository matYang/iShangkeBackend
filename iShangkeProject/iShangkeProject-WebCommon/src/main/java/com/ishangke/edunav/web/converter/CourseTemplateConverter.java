package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.common.ActionVo;
import com.ishangke.edunav.web.model.ClassPhotoVo;
import com.ishangke.edunav.web.model.CourseTemplateVo;
import com.ishangke.edunav.web.model.TeacherVo;

public class CourseTemplateConverter {
    public static CourseTemplateBo fromModel(CourseTemplateVo vo) {
        if (vo == null) {
            return null;
        }
        CourseTemplateBo courseTemplateBo = new CourseTemplateBo();
        if (vo.getAddress() != null) {
            courseTemplateBo.setAddress(vo.getAddress());
        }
        if (vo.getAddressId() != null) {
            courseTemplateBo.setAddressId(vo.getAddressId());
        }
        if (vo.getAddressLat() != null) {
            courseTemplateBo.setAddressLat(vo.getAddressLat());
        }
        if (vo.getAddressLng() != null) {
            courseTemplateBo.setAddressLng(vo.getAddressLng());
        }
        if (vo.getAddressIdSet() != null) {
            courseTemplateBo.setAddressIdSet(vo.getAddressIdSet());
        }
        if (vo.getRegAddress() != null) {
            courseTemplateBo.setRegAddress(vo.getRegAddress());
        }
        if (vo.getRegAddressId() != null) {
            courseTemplateBo.setRegAddressId(vo.getRegAddressId());
        }
        if (vo.getRegAddressLat() != null) {
            courseTemplateBo.setRegAddressLat(vo.getRegAddressLat());
        }
        if (vo.getRegAddressLng() != null) {
            courseTemplateBo.setRegAddressLng(vo.getRegAddressLng());
        }
        if (vo.getRegAddressIdSet() != null) {
            courseTemplateBo.setRegAddressIdSet(vo.getRegAddressIdSet());
        }
        if (vo.getAssignments() != null) {
            courseTemplateBo.setAssignments(vo.getAssignments());
        }
        if (vo.getBonusService() != null) {
            courseTemplateBo.setBonusService(vo.getBonusService());
        }
        if (vo.getBookingTotal() != null) {
            courseTemplateBo.setBookingTotal(vo.getBookingTotal());
        } else {
            courseTemplateBo.setBookingTotal(Constant.DEFAULTNULL);
        }
        if (vo.getBookingTotalEnd() != null) {
            courseTemplateBo.setBookingTotalEnd(vo.getBookingTotalEnd());
        } else {
            courseTemplateBo.setBookingTotalEnd(Constant.DEFAULTNULL);
        }
        if (vo.getBookingTotalSet() != null) {
            courseTemplateBo.setBookingTotalSet(vo.getBookingTotalSet());
        }
        if (vo.getBookingTotalStart() != null) {
            courseTemplateBo.setBookingTotalStart(vo.getBookingTotalStart());
        } else {
            courseTemplateBo.setBookingTotalStart(Constant.DEFAULTNULL);
        }
        if (vo.getBookingType() != null) {
            courseTemplateBo.setBookingType(vo.getBookingType());
        } else {
            courseTemplateBo.setBookingType(Constant.DEFAULTNULL);
        }
        if (vo.getCashback() != null) {
            courseTemplateBo.setCashback(vo.getCashback());
        } else {
            courseTemplateBo.setCashback(Constant.DEFAULTNULL);
        }

        if (vo.getCashbackEnd() != null) {
            courseTemplateBo.setCashbackEnd(vo.getCashbackEnd());
        } else {
            courseTemplateBo.setCashbackEnd(Constant.DEFAULTNULL);
        }

        if (vo.getCashbackStart() != null) {
            courseTemplateBo.setCashbackStart(vo.getCashbackStart());
        } else {
            courseTemplateBo.setCashbackStart(Constant.DEFAULTNULL);
        }

        if (vo.getCategoryId() != null) {
            courseTemplateBo.setCategoryId(vo.getCategoryId());
        }
        if (vo.getCategoryIdSet() != null) {
            courseTemplateBo.setCategoryIdSet(vo.getCategoryIdSet());
        }
        if (vo.getCategoryName() != null) {
            courseTemplateBo.setCategoryName(vo.getCategoryName());
        }
        if (vo.getCategoryRank() != null) {
            courseTemplateBo.setCategoryRank(vo.getCategoryRank());
        }
        if (vo.getCategoryValue() != null) {
            courseTemplateBo.setCategoryValue(vo.getCategoryValue());
        }
        if (vo.getCertification() != null) {
            courseTemplateBo.setCertification(vo.getCertification());
        }
        if (vo.getCircleId() != null) {
            courseTemplateBo.setCircleId(vo.getCircleId());
        }
        if (vo.getCircleIdSet() != null) {
            courseTemplateBo.setCircleIdSet(vo.getCircleIdSet());
        }
        if (vo.getCircleName() != null) {
            courseTemplateBo.setCircleName(vo.getCircleName());
        }
        if (vo.getCircleValue() != null) {
            courseTemplateBo.setCircleValue(vo.getCircleValue());
        }
        if (vo.getClassSize() != null) {
            courseTemplateBo.setClassSize(vo.getClassSize());
        }
        if (vo.getClassTeacher() != null) {
            courseTemplateBo.setClassTeacher(vo.getClassTeacher());
        }
        if (vo.getClassType() != null) {
            courseTemplateBo.setClassType(vo.getClassType());
        } else {
            courseTemplateBo.setClassType(Constant.DEFAULTNULL);
        }
        if (vo.getClassTypeSet() != null) {
            courseTemplateBo.setClassTypeSet(vo.getClassTypeSet());
        }
        if (vo.getCommission() != null) {
            courseTemplateBo.setCommission(vo.getCommission());
        } else {
            courseTemplateBo.setCommission(Constant.DEFAULTNULL);
        }

        if (vo.getContact() != null) {
            courseTemplateBo.setContact(vo.getContact());
        }
        if (vo.getCourseHourLength() != null) {
            courseTemplateBo.setCourseHourLength(vo.getCourseHourLength());
        } else {
            courseTemplateBo.setCourseHourLength(Constant.DEFAULTNULL);
        }
        if (vo.getCourseHourNum() != null) {
            courseTemplateBo.setCourseHourNum(vo.getCourseHourNum());
        } else {
            courseTemplateBo.setCourseHourNum(Constant.DEFAULTNULL);
        }
        if (vo.getCourseHourNumEnd() != null) {
            courseTemplateBo.setCourseHourNumEnd(vo.getCourseHourNumEnd());
        } else {
            courseTemplateBo.setCourseHourNumEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCourseHourNumSet() != null) {
            courseTemplateBo.setCourseHourNumSet(vo.getCourseHourNumSet());
        }
        if (vo.getCourseHourNumStart() != null) {
            courseTemplateBo.setCourseHourNumStart(vo.getCourseHourNumStart());
        } else {
            courseTemplateBo.setCourseHourNumStart(Constant.DEFAULTNULL);
        }
        if (vo.getCourseIntro() != null) {
            courseTemplateBo.setCourseIntro(vo.getCourseIntro());
        }
        if (vo.getCourseName() != null) {
            courseTemplateBo.setCourseName(vo.getCourseName());
        }
        if (vo.getDiscount() != null) {
            courseTemplateBo.setDiscount(vo.getDiscount());
        } else {
            courseTemplateBo.setDiscount(Constant.DEFAULTNULL);
        }

        if (vo.getDiscountEnd() != null) {
            courseTemplateBo.setDiscountEnd(vo.getDiscountEnd());
        } else {
            courseTemplateBo.setDiscountEnd(Constant.DEFAULTNULL);
        }
        if (vo.getDiscountStart() != null) {
            courseTemplateBo.setDiscountStart(vo.getDiscountStart());
        } else {
            courseTemplateBo.setDiscountStart(Constant.DEFAULTNULL);
        }

        if (vo.getDownloadMaterials() != null) {
            courseTemplateBo.setDownloadMaterials(vo.getDownloadMaterials());
        }
        if (vo.getEnabled() != null) {
            courseTemplateBo.setEnabled(vo.getEnabled());
        }
        if (vo.getExtracurricular() != null) {
            courseTemplateBo.setExtracurricular(vo.getExtracurricular());
        }
        if (vo.getFinishTime1() != null) {
            courseTemplateBo.setFinishTime1(vo.getFinishTime1());
        } else {
            courseTemplateBo.setFinishTime1(Constant.DEFAULTNULL);
        }
        if (vo.getFinishTime2() != null) {
            courseTemplateBo.setFinishTime2(vo.getFinishTime2());
        } else {
            courseTemplateBo.setFinishTime2(Constant.DEFAULTNULL);
        }

        if (vo.getGoal() != null) {
            courseTemplateBo.setGoal(vo.getGoal());
        }
        if (vo.getHighScoreReward() != null) {
            courseTemplateBo.setHighScoreReward(vo.getHighScoreReward());
        }
        if (vo.getId() != null) {
            courseTemplateBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            courseTemplateBo.setIdSet(vo.getIdSet());
        }
        if (vo.getInstName() != null) {
            courseTemplateBo.setInstName(vo.getInstName());
        }
        if (vo.getLocationId() != null) {
            courseTemplateBo.setLocationId(vo.getLocationId());
        }
        if (vo.getLocationIdSet() != null) {
            courseTemplateBo.setLocationIdSet(vo.getLocationIdSet());
        }
        if (vo.getLocationName() != null) {
            courseTemplateBo.setLocationName(vo.getLocationName());
        }
        if (vo.getLocationValue() != null) {
            courseTemplateBo.setLocationValue(vo.getLocationValue());
        }
        if (vo.getLogoUrl() != null) {
            courseTemplateBo.setLogoUrl(vo.getLogoUrl());
        }
        if (vo.getMarking() != null) {
            courseTemplateBo.setMarking(vo.getMarking());
        }
        if (vo.getOpenCourseRequirement() != null) {
            courseTemplateBo.setOpenCourseRequirement(vo.getOpenCourseRequirement());
        }
        if (vo.getOriginalPrice() != null) {
            courseTemplateBo.setOriginalPrice(vo.getOriginalPrice());
        } else {
            courseTemplateBo.setOriginalPrice(Constant.DEFAULTNULL);
        }
        if (vo.getOriginalPriceEnd() != null) {
            courseTemplateBo.setOriginalPriceEnd(vo.getOriginalPriceEnd());
        } else {
            courseTemplateBo.setOriginalPriceEnd(Constant.DEFAULTNULL);
        }
        if (vo.getOriginalPriceStart() != null) {
            courseTemplateBo.setOriginalPriceStart(vo.getOriginalPriceStart());
        } else {
            courseTemplateBo.setOriginalPriceStart(Constant.DEFAULTNULL);
        }
        if (vo.getOutline() != null) {
            courseTemplateBo.setOutline(vo.getOutline());
        }
        if (vo.getPartnerDistinction() != null) {
            courseTemplateBo.setPartnerDistinction(vo.getPartnerDistinction());
        }
        if (vo.getPartnerId() != null) {
            courseTemplateBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            courseTemplateBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        if (vo.getPartnerIntro() != null) {
            courseTemplateBo.setPartnerIntro(vo.getPartnerIntro());
        }
        if (vo.getPartnerQualification() != null) {
            courseTemplateBo.setPartnerQualification(vo.getPartnerQualification());
        }
        if (vo.getPartnerRating() != null) {
            courseTemplateBo.setPartnerRating(vo.getPartnerRating());
        }
        if (vo.getPassAgreement() != null) {
            courseTemplateBo.setPassAgreement(vo.getPassAgreement());
        }
        if (vo.getPopularity() != null) {
            courseTemplateBo.setPopularity(vo.getPopularity());
        } else {
            courseTemplateBo.setPopularity(Constant.DEFAULTNULL);
        }
        if (vo.getPopularityEnd() != null) {
            courseTemplateBo.setPopularityEnd(vo.getPopularityEnd());
        } else {
            courseTemplateBo.setPopularityEnd(Constant.DEFAULTNULL);
        }
        if (vo.getPopularitySet() != null) {
            courseTemplateBo.setPopularitySet(vo.getPopularitySet());
        }
        if (vo.getPopularityStart() != null) {
            courseTemplateBo.setPopularityStart(vo.getPopularityStart());
        } else {
            courseTemplateBo.setPopularityStart(Constant.DEFAULTNULL);
        }
        if (vo.getPrerequest() != null) {
            courseTemplateBo.setPrerequest(vo.getPrerequest());
        }
        if (vo.getPrice() != null) {
            courseTemplateBo.setPrice(vo.getPrice());
        } else {
            courseTemplateBo.setPrice(Constant.DEFAULTNULL);
        }
        if (vo.getPriceEnd() != null) {
            courseTemplateBo.setPriceEnd(vo.getPriceEnd());
        } else {
            courseTemplateBo.setPriceEnd(Constant.DEFAULTNULL);
        }
        if (vo.getPriceStart() != null) {
            courseTemplateBo.setPriceStart(vo.getPriceStart());
        } else {
            courseTemplateBo.setPriceStart(Constant.DEFAULTNULL);
        }
        if (vo.getQualityAssurance() != null) {
            courseTemplateBo.setQualityAssurance(vo.getQualityAssurance());
        }
        if (vo.getQuestionBank() != null) {
            courseTemplateBo.setQuestionBank(vo.getQuestionBank());
        }
        if (vo.getQuestionSession() != null) {
            courseTemplateBo.setQuestionSession(vo.getQuestionSession());
        }
        if (vo.getQuiz() != null) {
            courseTemplateBo.setQuiz(vo.getQuiz());
        }
        if (vo.getRating() != null) {
            courseTemplateBo.setRating(vo.getRating());
        } else {
            courseTemplateBo.setRating(Constant.DEFAULTNULL);
        }

        if (vo.getRatingEnd() != null) {
            courseTemplateBo.setRatingEnd(vo.getRatingEnd());
        } else {
            courseTemplateBo.setRatingEnd(Constant.DEFAULTNULL);
        }

        if (vo.getRatingStart() != null) {
            courseTemplateBo.setRatingStart(vo.getRatingStart());
        } else {
            courseTemplateBo.setRatingStart(Constant.DEFAULTNULL);
        }

        if (vo.getReference() != null) {
            courseTemplateBo.setReference(vo.getReference());
        }
        if (vo.getRegPhone() != null) {
            courseTemplateBo.setRegPhone(vo.getRegPhone());
        }
        if (vo.getSchooltimeDay() != null) {
            courseTemplateBo.setSchooltimeDay(vo.getSchooltimeDay());
        } else {
            courseTemplateBo.setSchooltimeDay(Constant.DEFAULTNULL);
        }
        if (vo.getSchooltimeDaySet() != null) {
            courseTemplateBo.setSchooltimeDaySet(vo.getSchooltimeDaySet());
        }
        if (vo.getSchooltimeWeek() != null) {
            courseTemplateBo.setSchooltimeWeek(vo.getSchooltimeWeek());
        } else {
            courseTemplateBo.setSchooltimeWeek(Constant.DEFAULTNULL);
        }
        if (vo.getSchooltimeWeekSet() != null) {
            courseTemplateBo.setSchooltimeWeekSet(vo.getSchooltimeWeekSet());
        }
        if (vo.getServiceCharge() != null) {
            courseTemplateBo.setServiceCharge(vo.getServiceCharge());
        } else {
            courseTemplateBo.setServiceCharge(Constant.DEFAULTNULL);
        }

        if (vo.getStartTime1() != null) {
            courseTemplateBo.setStartTime1(vo.getStartTime1());
        } else {
            courseTemplateBo.setStartTime1(Constant.DEFAULTNULL);
        }
        if (vo.getStartTime2() != null) {
            courseTemplateBo.setStartTime2(vo.getStartTime2());
        } else {
            courseTemplateBo.setStartTime2(Constant.DEFAULTNULL);
        }
        if (vo.getStartUponArrival() != null) {
            courseTemplateBo.setStartUponArrival(vo.getStartUponArrival());
        } else {
            courseTemplateBo.setStartUponArrival(Constant.DEFAULTNULL);
        }
        if (vo.getStatus() != null) {
            courseTemplateBo.setStatus(vo.getStatus());
        } else {
            courseTemplateBo.setStatus(Constant.DEFAULTNULL);
        }
        if (vo.getStatusSet() != null) {
            courseTemplateBo.setStatusSet(vo.getStatusSet());
        }
        if (vo.getStudyDaysNote() != null) {
            courseTemplateBo.setStudyDaysNote(vo.getStudyDaysNote());
        }
        if (vo.getSuitableStudent() != null) {
            courseTemplateBo.setSuitableStudent(vo.getSuitableStudent());
        }
        if (vo.getTeachingAndExercise() != null) {
            courseTemplateBo.setTeachingAndExercise(vo.getTeachingAndExercise());
        }
        if (vo.getTeachingMaterialFee() != null) {
            courseTemplateBo.setTeachingMaterialFee(vo.getTeachingMaterialFee());
        }
        if (vo.getTeachingMaterialIntro() != null) {
            courseTemplateBo.setTeachingMaterialIntro(vo.getTeachingMaterialIntro());
        }
        if (vo.getTeachingMethod() != null) {
            courseTemplateBo.setTeachingMethod(vo.getTeachingMethod());
        }
        if (vo.getTrail() != null) {
            courseTemplateBo.setTrail(vo.getTrail());
        }
        if (vo.getWholeName() != null) {
            courseTemplateBo.setWholeName(vo.getWholeName());
        }
        courseTemplateBo.setStartDate(vo.getStartDate() == null ? Constant.DEFAULTNULL : vo.getStartDate()
                .getTimeInMillis());
        courseTemplateBo.setStartDateEnd(vo.getStartDateEnd() == null ? Constant.DEFAULTNULL : vo.getStartDateEnd()
                .getTimeInMillis());
        courseTemplateBo.setStartDateStart(vo.getStartDateStart() == null ? Constant.DEFAULTNULL : vo
                .getStartDateStart().getTimeInMillis());
        courseTemplateBo.setNoRefundDate(vo.getNoRefundDate() == null ? Constant.DEFAULTNULL : vo.getNoRefundDate()
                .getTimeInMillis());
        courseTemplateBo.setNoRefundDateEnd(vo.getNoRefundDateEnd() == null ? Constant.DEFAULTNULL : vo
                .getNoRefundDateEnd().getTimeInMillis());
        courseTemplateBo.setNoRefundDateStart(vo.getNoRefundDateStart() == null ? Constant.DEFAULTNULL : vo
                .getNoRefundDateStart().getTimeInMillis());
        courseTemplateBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTime().getTimeInMillis());
        courseTemplateBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        courseTemplateBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        courseTemplateBo.setFinishDate(vo.getFinishDate() == null ? Constant.DEFAULTNULL : vo.getFinishDate()
                .getTimeInMillis());
        courseTemplateBo.setFinishDateEnd(vo.getFinishDateEnd() == null ? Constant.DEFAULTNULL : vo.getFinishDateEnd()
                .getTimeInMillis());
        courseTemplateBo.setFinishDateStart(vo.getFinishDateStart() == null ? Constant.DEFAULTNULL : vo
                .getFinishDateStart().getTimeInMillis());
        courseTemplateBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        courseTemplateBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        courseTemplateBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getCreateTimeStart().getTimeInMillis());
        courseTemplateBo.setCutoffDate(vo.getCutoffDate() == null ? Constant.DEFAULTNULL : vo.getCutoffDate()
                .getTimeInMillis());
        courseTemplateBo.setCutoffDateEnd(vo.getCutoffDateEnd() == null ? Constant.DEFAULTNULL : vo.getCutoffDateEnd()
                .getTimeInMillis());
        courseTemplateBo.setCutoffDateStart(vo.getCutoffDateStart() == null ? Constant.DEFAULTNULL : vo
                .getCutoffDateStart().getTimeInMillis());
        courseTemplateBo.setCashbackDate(vo.getCashbackDate() == null ? Constant.DEFAULTNULL : vo.getCashbackDate()
                .getTimeInMillis());
        courseTemplateBo.setCashbackDateEnd(vo.getCashbackDateEnd() == null ? Constant.DEFAULTNULL : vo
                .getCashbackDateEnd().getTimeInMillis());
        courseTemplateBo.setCashbackDateStart(vo.getCashbackDateStart() == null ? Constant.DEFAULTNULL : vo
                .getCashbackDateStart().getTimeInMillis());
        if (vo.getClassPhotoList() != null) {
            List<ClassPhotoBo> list = new ArrayList<>();
            for (ClassPhotoVo a : vo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.fromModel(a));
            }
            courseTemplateBo.setClassPhotoList(list);
        }
        if (vo.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherVo a : vo.getTeacherList()) {
                list.add(TeacherConverter.fromModel(a));
            }
            courseTemplateBo.setTeacherList(list);
        }
        if (vo.getActionList() != null) {
            List<ActionBo> list = new ArrayList<>();
            for (ActionVo a : vo.getActionList()) {
                list.add(ActionConverter.fromModel(a));
            }
            courseTemplateBo.setActionList(list);
        }
      //存储周一～周日上课时间的信息
        if (vo.getStudyDays() != null && vo.getStudyDays().size() > 0) {
            String studyDays = "";
            for (Integer i : vo.getStudyDays()) {
                studyDays = studyDays + i;
            }
            courseTemplateBo.setStudyDays(studyDays);
        }
        return courseTemplateBo;
    }

    public static CourseTemplateVo toModel(CourseTemplateBo bo) {

        if (bo == null) {
            return null;
        }
        CourseTemplateVo courseTemplateVo = new CourseTemplateVo();
        courseTemplateVo.setAddress(bo.getAddress());
        courseTemplateVo.setAddressId(bo.getAddressId());
        courseTemplateVo.setAddressLat(bo.getAddressLat());
        courseTemplateVo.setAddressLng(bo.getAddressLng());
        courseTemplateVo.setAddressIdSet(bo.getAddressIdSet());
        courseTemplateVo.setRegAddress(bo.getRegAddress());
        courseTemplateVo.setRegAddressId(bo.getRegAddressId());
        courseTemplateVo.setRegAddressLat(bo.getRegAddressLat());
        courseTemplateVo.setRegAddressLng(bo.getRegAddressLng());
        courseTemplateVo.setRegAddressIdSet(bo.getRegAddressIdSet());
        courseTemplateVo.setAssignments(bo.getAssignments());
        courseTemplateVo.setBonusService(bo.getBonusService());
        courseTemplateVo.setAssignments(bo.getAssignments());
        courseTemplateVo.setBonusService(bo.getBonusService());
        if (Constant.DEFAULTNULL != bo.getBookingTotal()) {
            courseTemplateVo.setBookingTotal(bo.getBookingTotal());
        }
        if (Constant.DEFAULTNULL != bo.getBookingTotalEnd()) {
            courseTemplateVo.setBookingTotalEnd(bo.getBookingTotalEnd());
        }
        courseTemplateVo.setBookingTotalSet(bo.getBookingTotalSet());
        if (Constant.DEFAULTNULL != bo.getBookingTotalStart()) {
            courseTemplateVo.setBookingTotalStart(bo.getBookingTotalStart());
        }
        if (Constant.DEFAULTNULL != bo.getBookingType()) {
            courseTemplateVo.setBookingType(bo.getBookingType());
        }
        if (Constant.DEFAULTNULL != bo.getCashback()) {
            courseTemplateVo.setCashback(bo.getCashback());
        }
        courseTemplateVo.setCashbackDate(DateUtility.getTimeFromLong(bo.getCashbackDate()));
        courseTemplateVo.setCashbackDateEnd(DateUtility.getTimeFromLong(bo.getCashbackDateEnd()));
        courseTemplateVo.setCashbackDateStart(DateUtility.getTimeFromLong(bo.getCashbackDateStart()));
        if (Constant.DEFAULTNULL != bo.getCashbackEnd()) {
            courseTemplateVo.setCashbackEnd(bo.getCashbackEnd());
        }
        if (Constant.DEFAULTNULL != bo.getCashbackStart()) {
            courseTemplateVo.setCashbackStart(bo.getCashbackStart());
        }
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
        if (Constant.DEFAULTNULL != bo.getClassType()) {
            courseTemplateVo.setClassType(bo.getClassType());
        }
        courseTemplateVo.setClassTypeSet(bo.getClassTypeSet());
        if (Constant.DEFAULTNULL != bo.getCommission()) {
            courseTemplateVo.setCommission(bo.getCommission());
        }
        courseTemplateVo.setContact(bo.getContact());
        if (Constant.DEFAULTNULL != bo.getCourseHourLength()) {
            courseTemplateVo.setCourseHourLength(bo.getCourseHourLength());
        }
        if (Constant.DEFAULTNULL != bo.getCourseHourNum()) {
            courseTemplateVo.setCourseHourNum(bo.getCourseHourNum());
        }
        if (Constant.DEFAULTNULL != bo.getCourseHourNumEnd()) {
            courseTemplateVo.setCourseHourNumEnd(bo.getCourseHourNumEnd());
        }
        courseTemplateVo.setCourseHourNumSet(bo.getCourseHourNumSet());
        if (Constant.DEFAULTNULL != bo.getCourseHourNumStart()) {
            courseTemplateVo.setCourseHourNumStart(bo.getCourseHourNumStart());
        }
        courseTemplateVo.setCourseIntro(bo.getCourseIntro());
        courseTemplateVo.setCourseName(bo.getCourseName());
        courseTemplateVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTemplateVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTemplateVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTemplateVo.setCutoffDate(DateUtility.getTimeFromLong(bo.getCutoffDate()));
        courseTemplateVo.setCutoffDateEnd(DateUtility.getTimeFromLong(bo.getCutoffDateEnd()));
        courseTemplateVo.setCutoffDateStart(DateUtility.getTimeFromLong(bo.getCutoffDateStart()));
        if (Constant.DEFAULTNULL != bo.getDiscount()) {
            courseTemplateVo.setDiscount(bo.getDiscount());
        }
        if (Constant.DEFAULTNULL != bo.getDiscountEnd()) {
            courseTemplateVo.setDiscountEnd(bo.getDiscountEnd());
        }
        if (Constant.DEFAULTNULL != bo.getDiscountStart()) {
            courseTemplateVo.setDiscountStart(bo.getDiscountStart());
        }
        courseTemplateVo.setDownloadMaterials(bo.getDownloadMaterials());
        courseTemplateVo.setEnabled(bo.getEnabled());
        courseTemplateVo.setExtracurricular(bo.getExtracurricular());
        courseTemplateVo.setFinishDate(DateUtility.getTimeFromLong(bo.getFinishDate()));
        courseTemplateVo.setFinishDateEnd(DateUtility.getTimeFromLong(bo.getFinishDateEnd()));
        courseTemplateVo.setFinishDateStart(DateUtility.getTimeFromLong(bo.getFinishDateStart()));
        if (Constant.DEFAULTNULL != bo.getFinishTime1()) {
            courseTemplateVo.setFinishTime1(bo.getFinishTime1());
        }
        if (Constant.DEFAULTNULL != bo.getFinishTime2()) {
            courseTemplateVo.setFinishTime2(bo.getFinishTime2());
        }
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
        if (Constant.DEFAULTNULL != bo.getOriginalPrice()) {
            courseTemplateVo.setOriginalPrice(bo.getOriginalPrice());
        }
        if (Constant.DEFAULTNULL != bo.getOriginalPriceEnd()) {
            courseTemplateVo.setOriginalPriceEnd(bo.getOriginalPriceEnd());
        }
        if (Constant.DEFAULTNULL != bo.getOriginalPriceStart()) {
            courseTemplateVo.setOriginalPriceStart(bo.getOriginalPriceStart());
        }
        courseTemplateVo.setOutline(bo.getOutline());
        courseTemplateVo.setPartnerDistinction(bo.getPartnerDistinction());
        courseTemplateVo.setPartnerId(bo.getPartnerId());
        courseTemplateVo.setPartnerIdSet(bo.getPartnerIdSet());
        courseTemplateVo.setPartnerIntro(bo.getPartnerIntro());
        courseTemplateVo.setPartnerQualification(bo.getPartnerQualification());
        courseTemplateVo.setPartnerRating(bo.getPartnerRating());
        courseTemplateVo.setPassAgreement(bo.getPassAgreement());
        if (Constant.DEFAULTNULL != bo.getPopularity()) {
            courseTemplateVo.setPopularity(bo.getPopularity());
        }
        if (Constant.DEFAULTNULL != bo.getPopularityEnd()) {
            courseTemplateVo.setPopularityEnd(bo.getPopularityEnd());
        }
        courseTemplateVo.setPopularitySet(bo.getPopularitySet());
        if (Constant.DEFAULTNULL != bo.getPopularityStart()) {
            courseTemplateVo.setPopularityStart(bo.getPopularityStart());
        }
        courseTemplateVo.setPrerequest(bo.getPrerequest());
        if (Constant.DEFAULTNULL != bo.getPrice()) {
            courseTemplateVo.setPrice(bo.getPrice());
        }
        if (Constant.DEFAULTNULL != bo.getPriceEnd()) {
            courseTemplateVo.setPriceEnd(bo.getPriceEnd());
        }
        if (Constant.DEFAULTNULL != bo.getPriceStart()) {
            courseTemplateVo.setPriceStart(bo.getPriceStart());
        }
        courseTemplateVo.setQualityAssurance(bo.getQualityAssurance());
        courseTemplateVo.setQuestionBank(bo.getQuestionBank());
        courseTemplateVo.setQuestionSession(bo.getQuestionSession());
        courseTemplateVo.setQuiz(bo.getQuiz());
        if (Constant.DEFAULTNULL != bo.getRating()) {
            courseTemplateVo.setRating(bo.getRating());
        }
        if (Constant.DEFAULTNULL != bo.getRatingEnd()) {
            courseTemplateVo.setRatingEnd(bo.getRatingEnd());
        }
        if (Constant.DEFAULTNULL != bo.getRatingStart()) {
            courseTemplateVo.setRatingStart(bo.getRatingStart());
        }
        courseTemplateVo.setReference(bo.getReference());
        courseTemplateVo.setRegPhone(bo.getRegPhone());
        if (Constant.DEFAULTNULL != bo.getSchooltimeDay()) {
            courseTemplateVo.setSchooltimeDay(bo.getSchooltimeDay());
        }
        courseTemplateVo.setSchooltimeDaySet(bo.getSchooltimeDaySet());
        if (Constant.DEFAULTNULL != bo.getSchooltimeWeek()) {
            courseTemplateVo.setSchooltimeWeek(bo.getSchooltimeWeek());
        }
        courseTemplateVo.setSchooltimeWeekSet(bo.getSchooltimeWeekSet());
        if (Constant.DEFAULTNULL != bo.getServiceCharge()) {
            courseTemplateVo.setServiceCharge(bo.getServiceCharge());
        }
        courseTemplateVo.setStartDate(DateUtility.getTimeFromLong(bo.getStartDate()));
        courseTemplateVo.setStartDateEnd(DateUtility.getTimeFromLong(bo.getStartDateEnd()));
        courseTemplateVo.setStartDateStart(DateUtility.getTimeFromLong(bo.getStartDateStart()));
        if (Constant.DEFAULTNULL != bo.getStartTime1()) {
            courseTemplateVo.setStartTime1(bo.getStartTime1());
        }
        if (Constant.DEFAULTNULL != bo.getStartTime2()) {
            courseTemplateVo.setStartTime2(bo.getStartTime2());
        }
        if (Constant.DEFAULTNULL != bo.getStartUponArrival()) {
            courseTemplateVo.setStartUponArrival(bo.getStartUponArrival());
        }
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            courseTemplateVo.setStatus(bo.getStatus());
        }
        courseTemplateVo.setStatusSet(bo.getStatusSet());
        courseTemplateVo.setStudyDaysNote(bo.getStudyDaysNote());
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
        if (bo.getStudyDays() != null && !"".equals(bo.getStudyDays())) {
            char[] days = bo.getStudyDays().toCharArray();
            List<Integer> studyDays = new ArrayList<>();
            for (char day : days) {
                studyDays.add(Integer.parseInt("" + day));
            }
            courseTemplateVo.setStudyDays(studyDays);
        }
        return courseTemplateVo;
    }
}
