package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.common.ActionVo;
import com.ishangke.edunav.web.model.ClassPhotoVo;
import com.ishangke.edunav.web.model.CourseVo;
import com.ishangke.edunav.web.model.TeacherVo;

public class CourseConverter {
    public static CourseBo fromModel(CourseVo vo) {
        if (vo == null) {
            return null;
        }
        CourseBo courseBo = new CourseBo();
        if (vo.getAddress() != null) {
            courseBo.setAddress(vo.getAddress());
        }
        if (vo.getAddressId() != null) {
            courseBo.setAddressId(vo.getAddressId());
        }
        if (vo.getAddressLat() != null) {
            courseBo.setAddressLat(vo.getAddressLat());
        }
        if (vo.getAddressLng() != null) {
            courseBo.setAddressLng(vo.getAddressLng());
        }
        if (vo.getAddressIdSet() != null) {
            courseBo.setAddressIdSet(vo.getAddressIdSet());
        }
        if (vo.getRegAddress() != null) {
            courseBo.setRegAddress(vo.getRegAddress());
        }
        if (vo.getRegAddressId() != null) {
            courseBo.setRegAddressId(vo.getRegAddressId());
        }
        if (vo.getRegAddressLat() != null) {
            courseBo.setRegAddressLat(vo.getRegAddressLat());
        }
        if (vo.getRegAddressLng() != null) {
            courseBo.setRegAddressLng(vo.getRegAddressLng());
        }
        if (vo.getRegAddressIdSet() != null) {
            courseBo.setRegAddressIdSet(vo.getRegAddressIdSet());
        }
        if (vo.getAssignments() != null) {
            courseBo.setAssignments(vo.getAssignments());
        }
        if (vo.getBonusService() != null) {
            courseBo.setBonusService(vo.getBonusService());
        }
        if (vo.getBookingTotal() != null) {
            courseBo.setBookingTotal(vo.getBookingTotal());
        }
        if (vo.getBookingType() != null) {
            courseBo.setBookingType(vo.getBookingType());
        } else {
            courseBo.setBookingType(Constant.DEFAULTNULL);
        }
        if (vo.getCashback() != null) {
            courseBo.setCashback(vo.getCashback());
        } else {
            courseBo.setCashback(Constant.DEFAULTNULL);
        }
        if (vo.getCashbackEnd() != null) {
            courseBo.setCashbackEnd(vo.getCashbackEnd());
        } else {
            courseBo.setCashbackEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCashbackStart() != null) {
            courseBo.setCashbackStart(vo.getCashbackStart());
        } else {
            courseBo.setCashbackStart(Constant.DEFAULTNULL);
        }
        if (vo.getCategoryId() != null) {
            courseBo.setCategoryId(vo.getCategoryId());
        }
        if (vo.getCategoryIdSet() != null) {
            courseBo.setCategoryIdSet(vo.getCategoryIdSet());
        }
        if (vo.getCategoryName() != null) {
            courseBo.setCategoryName(vo.getCategoryName());
        }
        if (vo.getCategoryRank() != null) {
            courseBo.setCategoryRank(vo.getCategoryRank());
        }
        if (vo.getCategoryValue() != null) {
            courseBo.setCategoryValue(vo.getCategoryValue());
        }
        if (vo.getCertification() != null) {
            courseBo.setCertification(vo.getCertification());
        }
        if (vo.getCircleId() != null) {
            courseBo.setCircleId(vo.getCircleId());
        }
        if (vo.getCircleIdSet() != null) {
            courseBo.setCircleIdSet(vo.getCircleIdSet());
        }
        if (vo.getCircleName() != null) {
            courseBo.setCircleName(vo.getCircleName());
        }
        if (vo.getCircleValue() != null) {
            courseBo.setCircleValue(vo.getCircleValue());
        }
        if (vo.getClassSize() != null) {
            courseBo.setClassSize(vo.getClassSize());
        }
        if (vo.getClassTeacher() != null) {
            courseBo.setClassTeacher(vo.getClassTeacher());
        }
        if (vo.getClassType() != null) {
            courseBo.setClassType(vo.getClassType());
        } else {
            courseBo.setClassType(Constant.DEFAULTNULL);
        }

        if (vo.getClassTypeSet() != null) {
            courseBo.setClassTypeSet(vo.getClassTypeSet());
        }
        if (vo.getCommission() != null) {
            courseBo.setCommission(vo.getCommission());
        } else {
            courseBo.setCommission(Constant.DEFAULTNULL);
        }

        if (vo.getContact() != null) {
            courseBo.setContact(vo.getContact());
        }
        if (vo.getCourseHourLength() != null) {
            courseBo.setCourseHourLength(vo.getCourseHourLength());
        } else {
            courseBo.setCourseHourLength(Constant.DEFAULTNULL);
        }
        if (vo.getCourseHourNum() != null) {
            courseBo.setCourseHourNum(vo.getCourseHourNum());
        } else {
            courseBo.setCourseHourNum(Constant.DEFAULTNULL);
        }

        if (vo.getCourseHourNumEnd() != null) {
            courseBo.setCourseHourNumEnd(vo.getCourseHourNumEnd());
        } else {
            courseBo.setCourseHourNumEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCourseHourNumSet() != null) {
            courseBo.setCourseHourNumSet(vo.getCourseHourNumSet());
        }
        if (vo.getCourseHourNumStart() != null) {
            courseBo.setCourseHourNumStart(vo.getCourseHourNumStart());
        } else {
            courseBo.setCourseHourNumStart(Constant.DEFAULTNULL);
        }
        if (vo.getCourseIntro() != null) {
            courseBo.setCourseIntro(vo.getCourseIntro());
        }
        if (vo.getCourseName() != null) {
            courseBo.setCourseName(vo.getCourseName());
        }
        if (vo.getCourseTemplateId() != null) {
            courseBo.setCourseTemplateId(vo.getCourseTemplateId());
        }
        if (vo.getCourseTemplateIdSet() != null) {
            courseBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        }
        if (vo.getDiscount() != null) {
            courseBo.setDiscount(vo.getDiscount());
        } else {
            courseBo.setDiscount(Constant.DEFAULTNULL);
        }

        if (vo.getDiscountEnd() != null) {
            courseBo.setDiscountEnd(vo.getDiscountEnd());
        } else {
            courseBo.setDiscountEnd(Constant.DEFAULTNULL);
        }

        if (vo.getDiscountStart() != null) {
            courseBo.setDiscountStart(vo.getDiscountStart());
        } else {
            courseBo.setDiscountStart(Constant.DEFAULTNULL);
        }

        if (vo.getDownloadMaterials() != null) {
            courseBo.setDownloadMaterials(vo.getDownloadMaterials());
        }
        if (vo.getEnabled() != null) {
            courseBo.setEnabled(vo.getEnabled());
        }
        if (vo.getExtracurricular() != null) {
            courseBo.setExtracurricular(vo.getExtracurricular());
        }
        if (vo.getFinishTime1() != null) {
            courseBo.setFinishTime1(vo.getFinishTime1());
        } else {
            courseBo.setFinishTime1(Constant.DEFAULTNULL);
        }

        if (vo.getFinishTime2() != null) {
            courseBo.setFinishTime2(vo.getFinishTime2());
        } else {
            courseBo.setFinishTime2(Constant.DEFAULTNULL);
        }

        if (vo.getGoal() != null) {
            courseBo.setGoal(vo.getGoal());
        }
        if (vo.getHighScoreReward() != null) {
            courseBo.setHighScoreReward(vo.getHighScoreReward());
        }
        if (vo.getId() != null) {
            courseBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            courseBo.setIdSet(vo.getIdSet());
        }
        if (vo.getInstName() != null) {
            courseBo.setInstName(vo.getInstName());
        }
        if (vo.getLocationId() != null) {
            courseBo.setLocationId(vo.getLocationId());
        }
        if (vo.getLocationIdSet() != null) {
            courseBo.setLocationIdSet(vo.getLocationIdSet());
        }
        if (vo.getLocationName() != null) {
            courseBo.setLocationName(vo.getLocationName());
        }
        if (vo.getLocationValue() != null) {
            courseBo.setLocationValue(vo.getLocationValue());
        }
        if (vo.getLogoUrl() != null) {
            courseBo.setLogoUrl(vo.getLogoUrl());
        }
        if (vo.getMarking() != null) {
            courseBo.setMarking(vo.getMarking());
        }
        if (vo.getOpenCourseRequirement() != null) {
            courseBo.setOpenCourseRequirement(vo.getOpenCourseRequirement());
        }
        if (vo.getPrice() != null) {
            courseBo.setPrice(vo.getPrice());
        } else {
            courseBo.setPrice(Constant.DEFAULTNULL);
        }
        if (vo.getPriceEnd() != null) {
            courseBo.setPriceEnd(vo.getPriceEnd());
        } else {
            courseBo.setPriceEnd(Constant.DEFAULTNULL);
        }
        if (vo.getPriceStart() != null) {
            courseBo.setPriceStart(vo.getPriceStart());
        } else {
            courseBo.setPriceStart(Constant.DEFAULTNULL);
        }
        if (vo.getOriginalPrice() != null) {
            courseBo.setOriginalPrice(vo.getOriginalPrice());
        } else {
            courseBo.setOriginalPrice(Constant.DEFAULTNULL);
        }
        if (vo.getOriginalPriceEnd() != null) {
            courseBo.setOriginalPriceEnd(vo.getOriginalPriceEnd());
        } else {
            courseBo.setOriginalPriceEnd(Constant.DEFAULTNULL);
        }
        if (vo.getOriginalPriceStart() != null) {
            courseBo.setOriginalPriceStart(vo.getOriginalPriceStart());
        } else {
            courseBo.setOriginalPriceStart(Constant.DEFAULTNULL);
        }
        if (vo.getOutline() != null) {
            courseBo.setOutline(vo.getOutline());
        }
        if (vo.getPartnerDistinction() != null) {
            courseBo.setPartnerDistinction(vo.getPartnerDistinction());
        }
        if (vo.getPartnerId() != null) {
            courseBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            courseBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        if (vo.getPartnerIntro() != null) {
            courseBo.setPartnerIntro(vo.getPartnerIntro());
        }
        if (vo.getPartnerQualification() != null) {
            courseBo.setPartnerQualification(vo.getPartnerQualification());
        }
        if (vo.getPartnerRating() != null) {
            courseBo.setPartnerRating(vo.getPartnerRating());
        }
        if (vo.getPassAgreement() != null) {
            courseBo.setPassAgreement(vo.getPassAgreement());
        }
        if (vo.getPopularity() != null) {
            courseBo.setPopularity(vo.getPopularity());
        } else {
            courseBo.setPopularity(Constant.DEFAULTNULL);
        }

        if (vo.getPopularityEnd() != null) {
            courseBo.setPopularityEnd(vo.getPopularityEnd());
        } else {
            courseBo.setPopularityEnd(Constant.DEFAULTNULL);
        }
        if (vo.getPopularitySet() != null) {
            courseBo.setPopularitySet(vo.getPopularitySet());
        }
        if (vo.getPopularityStart() != null) {
            courseBo.setPopularityStart(vo.getPopularityStart());
        } else {
            courseBo.setPopularityStart(Constant.DEFAULTNULL);
        }
        if (vo.getQualityAssurance() != null) {
            courseBo.setQualityAssurance(vo.getQualityAssurance());
        }
        if (vo.getQuestionBank() != null) {
            courseBo.setQuestionBank(vo.getQuestionBank());
        }
        if (vo.getQuestionSession() != null) {
            courseBo.setQuestionSession(vo.getQuestionSession());
        }
        if (vo.getQuiz() != null) {
            courseBo.setQuiz(vo.getQuiz());
        }
        if (vo.getRating() != null) {
            courseBo.setRating(vo.getRating());
        }
        if (vo.getReference() != null) {
            courseBo.setReference(vo.getReference());
        }
        if (vo.getRegPhone() != null) {
            courseBo.setRegPhone(vo.getRegPhone());
        }
        if (vo.getPrerequest() != null) {
            courseBo.setPrerequest(vo.getPrerequest());
        }
        if (vo.getSchooltimeDay() != null) {
            courseBo.setSchooltimeDay(vo.getSchooltimeDay());
        } else {
            courseBo.setSchooltimeDay(Constant.DEFAULTNULL);
        }

        if (vo.getSchooltimeDaySet() != null) {
            courseBo.setSchooltimeDaySet(vo.getSchooltimeDaySet());
        }
        if (vo.getSchooltimeWeek() != null) {
            courseBo.setSchooltimeWeek(vo.getSchooltimeWeek());
        } else {
            courseBo.setSchooltimeWeek(Constant.DEFAULTNULL);
        }

        if (vo.getSchooltimeWeekSet() != null) {
            courseBo.setSchooltimeWeekSet(vo.getSchooltimeWeekSet());
        }
        if (vo.getServiceCharge() != null) {
            courseBo.setServiceCharge(vo.getServiceCharge());
        } else {
            courseBo.setServiceCharge(Constant.DEFAULTNULL);
        }
        if (vo.getStartTime1() != null) {
            courseBo.setStartTime1(vo.getStartTime1());
        } else {
            courseBo.setStartTime1(Constant.DEFAULTNULL);
        }

        if (vo.getStartTime2() != null) {
            courseBo.setStartTime2(vo.getStartTime2());
        } else {
            courseBo.setStartTime2(Constant.DEFAULTNULL);
        }

        if (vo.getStartUponArrival() != null) {
            courseBo.setStartUponArrival(vo.getStartUponArrival());
        } else {
            courseBo.setStartUponArrival(Constant.DEFAULTNULL);
        }

        if (vo.getStatus() != null) {
            courseBo.setStatus(vo.getStatus());
        } else {
            courseBo.setStatus(Constant.DEFAULTNULL);
        }
        if (vo.getStatusSet() != null) {
            courseBo.setStatusSet(vo.getStatusSet());
        }
        if (vo.getStudyDaysNote() != null) {
            courseBo.setStudyDaysNote(vo.getStudyDaysNote());
        }
        if (vo.getSuitableStudent() != null) {
            courseBo.setSuitableStudent(vo.getSuitableStudent());
        }
        if (vo.getTeachingAndExercise() != null) {
            courseBo.setTeachingAndExercise(vo.getTeachingAndExercise());
        }
        if (vo.getTeachingMaterialFee() != null) {
            courseBo.setTeachingMaterialFee(vo.getTeachingMaterialFee());
        }
        if (vo.getTeachingMaterialIntro() != null) {
            courseBo.setTeachingMaterialIntro(vo.getTeachingMaterialIntro());
        }
        if (vo.getTeachingMethod() != null) {
            courseBo.setTeachingMethod(vo.getTeachingMethod());
        }
        if (vo.getTrail() != null) {
            courseBo.setTrail(vo.getTrail());
        }
        if (vo.getWholeName() != null) {
            courseBo.setWholeName(vo.getWholeName());
        }
        if (vo.getStartDate() != null) {
            courseBo.setStartDate(vo.getStartDate());
        } else {
            courseBo.setStartDate(Constant.DEFAULTNULL);
        }
        if (vo.getStartDateEnd() != null) {
            courseBo.setStartDateEnd(vo.getStartDateEnd());
        } else {
            courseBo.setStartDateEnd(Constant.DEFAULTNULL);
        }
        if (vo.getStartDateStart() != null) {
            courseBo.setStartDateStart(vo.getStartDateStart());
        } else {
            courseBo.setStartDateStart(Constant.DEFAULTNULL);
        }
        if (vo.getNoRefundDate() != null) {
            courseBo.setNoRefundDate(vo.getNoRefundDate());
        } else {
            courseBo.setNoRefundDate(Constant.DEFAULTNULL);
        }
        if (vo.getNoRefundDateStart() != null) {
            courseBo.setNoRefundDateStart(vo.getNoRefundDateStart());
        } else {
            courseBo.setNoRefundDateStart(Constant.DEFAULTNULL);
        }
        if (vo.getNoRefundDateEnd() != null) {
            courseBo.setNoRefundDateEnd(vo.getNoRefundDateEnd());
        } else {
            courseBo.setNoRefundDateEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            courseBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            courseBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            courseBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            courseBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            courseBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            courseBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getFinishDate() != null) {
            courseBo.setFinishDate(vo.getFinishDate());
        } else {
            courseBo.setFinishDate(Constant.DEFAULTNULL);
        }
        if (vo.getFinishDateEnd() != null) {
            courseBo.setFinishDateEnd(vo.getFinishDateEnd());
        } else {
            courseBo.setFinishDateEnd(Constant.DEFAULTNULL);
        }
        if (vo.getFinishDateStart() != null) {
            courseBo.setFinishDateStart(vo.getFinishDateStart());
        } else {
            courseBo.setFinishDateStart(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTime() != null) {
            courseBo.setCreateTime(vo.getCreateTime());
        } else {
            courseBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            courseBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            courseBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            courseBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            courseBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getCutoffDate() != null) {
            courseBo.setCutoffDate(vo.getCutoffDate());
        } else {
            courseBo.setCutoffDate(Constant.DEFAULTNULL);
        }
        if (vo.getCutoffDateEnd() != null) {
            courseBo.setCutoffDateEnd(vo.getCutoffDateEnd());
        } else {
            courseBo.setCutoffDateEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCutoffDateStart() != null) {
            courseBo.setCutoffDateStart(vo.getCutoffDateStart());
        } else {
            courseBo.setCutoffDateStart(Constant.DEFAULTNULL);
        }
        if (vo.getCashbackDate() != null) {
            courseBo.setCashbackDate(vo.getCashbackDate());
        } else {
            courseBo.setCashbackDate(Constant.DEFAULTNULL);
        }
        if (vo.getCashbackDateStart() != null) {
            courseBo.setCashbackDateStart(vo.getCashbackDateStart());
        } else {
            courseBo.setCashbackDateStart(Constant.DEFAULTNULL);
        }
        if (vo.getCashbackDateEnd() != null) {
            courseBo.setCashbackDateEnd(vo.getCashbackDateEnd());
        } else {
            courseBo.setCashbackDateEnd(Constant.DEFAULTNULL);
        }
        if (vo.getClassPhotoList() != null) {
            List<ClassPhotoBo> list = new ArrayList<>();
            for (ClassPhotoVo a : vo.getClassPhotoList()) {
                list.add(ClassPhotoConverter.fromModel(a));
            }
            courseBo.setClassPhotoList(list);
        }
        if (vo.getTeacherList() != null) {
            List<TeacherBo> list = new ArrayList<>();
            for (TeacherVo a : vo.getTeacherList()) {
                list.add(TeacherConverter.fromModel(a));
            }
            courseBo.setTeacherList(list);
        }
        if (vo.getActionList() != null) {
            List<ActionBo> list = new ArrayList<>();
            for (ActionVo a : vo.getActionList()) {
                list.add(ActionConverter.fromModel(a));
            }
            courseBo.setActionList(list);
        }
        // 存储周一～周日上课时间的信息
        if (vo.getStudyDays() != null && vo.getStudyDays().size() > 0) {
            String studyDays = "";
            for (Integer i : vo.getStudyDays()) {
                studyDays = studyDays + i;
            }
            courseBo.setStudyDays(studyDays);
        }
        return courseBo;
    }

    public static CourseVo toModel(CourseBo bo) {
        if (bo == null) {
            return null;
        }
        CourseVo courseVo = new CourseVo();
        courseVo.setAddress(bo.getAddress());
        courseVo.setAddressId(bo.getAddressId());
        courseVo.setAddressLat(bo.getAddressLat());
        courseVo.setAddressLng(bo.getAddressLng());
//        courseVo.setAddressIdSet(bo.getAddressIdSet());
        courseVo.setRegAddress(bo.getRegAddress());
        courseVo.setRegAddressId(bo.getRegAddressId());
        courseVo.setRegAddressLat(bo.getRegAddressLat());
        courseVo.setRegAddressLng(bo.getRegAddressLng());
//        courseVo.setRegAddressIdSet(bo.getRegAddressIdSet());
        courseVo.setAssignments(bo.getAssignments());
        courseVo.setBonusService(bo.getBonusService());
        courseVo.setBookingTotal(bo.getBookingTotal());
        if (Constant.DEFAULTNULL != bo.getBookingType()) {
            courseVo.setBookingType(bo.getBookingType());
        }
        if (Constant.DEFAULTNULL != bo.getCashback()) {
            courseVo.setCashback(bo.getCashback());
        }
        courseVo.setCashbackDate(bo.getCashbackDate());
//        courseVo.setCashbackDateStart(bo.getCashbackDateStart());
//        courseVo.setCashbackDateEnd(bo.getCashbackDateEnd());
        if (Constant.DEFAULTNULL != bo.getCashbackEnd()) {
            courseVo.setCashbackEnd(bo.getCashbackEnd());
        }
        if (Constant.DEFAULTNULL != bo.getCashbackStart()) {
            courseVo.setCashbackStart(bo.getCashbackStart());
        }
        courseVo.setCategoryId(bo.getCategoryId());
//        courseVo.setCategoryIdSet(bo.getCategoryIdSet());
        courseVo.setCategoryName(bo.getCategoryName());
        courseVo.setCategoryRank(bo.getCategoryRank());
        courseVo.setCategoryValue(bo.getCategoryValue());
        courseVo.setCertification(bo.getCertification());
        courseVo.setCircleId(bo.getCircleId());
//        courseVo.setCircleIdSet(bo.getCircleIdSet());
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
        if (Constant.DEFAULTNULL != bo.getClassType()) {
            courseVo.setClassType(bo.getClassType());
        }
//        courseVo.setClassTypeSet(bo.getClassTypeSet());
        if (Constant.DEFAULTNULL != bo.getCommission()) {
            courseVo.setCommission(bo.getCommission());
        }
        courseVo.setContact(bo.getContact());
        if (Constant.DEFAULTNULL != bo.getCourseHourLength()) {
            courseVo.setCourseHourLength(bo.getCourseHourLength());
        }
        if (Constant.DEFAULTNULL != bo.getCourseHourNum()) {
            courseVo.setCourseHourNum(bo.getCourseHourNum());
        }
        if (Constant.DEFAULTNULL != bo.getCourseHourNumEnd()) {
            courseVo.setCourseHourNumEnd(bo.getCourseHourNumEnd());
        }
        courseVo.setCourseHourNumSet(bo.getCourseHourNumSet());
        if (Constant.DEFAULTNULL != bo.getCourseHourNumStart()) {
            courseVo.setCourseHourNumStart(bo.getCourseHourNumStart());
        }
        courseVo.setCourseIntro(bo.getCourseIntro());
        courseVo.setCourseName(bo.getCourseName());
        courseVo.setCourseTemplateId(bo.getCourseTemplateId());
//        courseVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseVo.setCreateTime(bo.getCreateTime());
//        courseVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        courseVo.setCreateTimeStart(bo.getCreateTimeStart());
        if (bo.getCutoffDate() != Constant.DEFAULTNULL) {
            courseVo.setCutoffDate(bo.getCutoffDate());            
        }
//        courseVo.setCutoffDateEnd(bo.getCutoffDateEnd());
//        courseVo.setCutoffDateStart(bo.getCutoffDateStart());
        if (Constant.DEFAULTNULL != bo.getDiscount()) {
            courseVo.setDiscount(bo.getDiscount());
        }
        if (Constant.DEFAULTNULL != bo.getDiscountEnd()) {
            courseVo.setDiscountEnd(bo.getDiscountEnd());
        }
        if (Constant.DEFAULTNULL != bo.getDiscountStart()) {
            courseVo.setDiscountStart(bo.getDiscountStart());
        }
        courseVo.setDownloadMaterials(bo.getDownloadMaterials());
        courseVo.setEnabled(bo.getEnabled());
        courseVo.setExtracurricular(bo.getExtracurricular());
        if (bo.getFinishDate() != Constant.DEFAULTNULL) {
            courseVo.setFinishDate(bo.getFinishDate());            
        }
//        courseVo.setFinishDateEnd(bo.getFinishDateEnd());
//        courseVo.setFinishDateStart(bo.getFinishDateStart());
        if (Constant.DEFAULTNULL != bo.getFinishTime1()) {
            courseVo.setFinishTime1(bo.getFinishTime1());
        }
        if (Constant.DEFAULTNULL != bo.getFinishTime2()) {
            courseVo.setFinishTime2(bo.getFinishTime2());
        }
        courseVo.setGoal(bo.getGoal());
        courseVo.setHighScoreReward(bo.getHighScoreReward());
        courseVo.setId(bo.getId());
//        courseVo.setIdSet(bo.getIdSet());
        courseVo.setInstName(bo.getInstName());
        courseVo.setLastModifyTime(bo.getLastModifyTime());
//        courseVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        courseVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        courseVo.setLocationId(bo.getLocationId());
        courseVo.setLocationIdSet(bo.getLocationIdSet());
        courseVo.setLocationName(bo.getLocationName());
        courseVo.setLocationValue(bo.getLocationValue());
        courseVo.setLogoUrl(bo.getLogoUrl());
        courseVo.setMarking(bo.getMarking());
        courseVo.setNoRefundDate(bo.getNoRefundDate());
//        courseVo.setNoRefundDateStart(bo.getNoRefundDateStart());
//        courseVo.setNoRefundDateEnd(bo.getNoRefundDateEnd());
        courseVo.setOpenCourseRequirement(bo.getOpenCourseRequirement());
        courseVo.setPrerequest(bo.getPrerequest());
        //隐藏价格
//        if (Constant.DEFAULTNULL != bo.getPrice()) {
//            courseVo.setPrice(bo.getPrice());
//        }
        if (Constant.DEFAULTNULL != bo.getPriceEnd()) {
            courseVo.setPriceEnd(bo.getPriceEnd());
        }
        if (Constant.DEFAULTNULL != bo.getPriceStart()) {
            courseVo.setPriceStart(bo.getPriceStart());
        }
        //隐藏价格
//        if (Constant.DEFAULTNULL != bo.getOriginalPrice()) {
//            courseVo.setOriginalPrice(bo.getOriginalPrice());
//        }
        if (Constant.DEFAULTNULL != bo.getOriginalPriceEnd()) {
            courseVo.setOriginalPriceEnd(bo.getOriginalPriceEnd());
        }
        if (Constant.DEFAULTNULL != bo.getOriginalPriceStart()) {
            courseVo.setOriginalPriceStart(bo.getOriginalPriceStart());
        }
        courseVo.setOutline(bo.getOutline());
        courseVo.setPartnerDistinction(bo.getPartnerDistinction());
        courseVo.setPartnerId(bo.getPartnerId());
//        courseVo.setPartnerIdSet(bo.getPartnerIdSet());
        courseVo.setPartnerIntro(bo.getPartnerIntro());
        courseVo.setPartnerQualification(bo.getPartnerQualification());
        courseVo.setPartnerRating(bo.getPartnerRating());
        courseVo.setPassAgreement(bo.getPassAgreement());
        if (Constant.DEFAULTNULL != bo.getPopularity()) {
            courseVo.setPopularity(bo.getPopularity());
        }
        if (Constant.DEFAULTNULL != bo.getPopularityEnd()) {
            courseVo.setPopularityEnd(bo.getPopularityEnd());
        }
        courseVo.setPopularitySet(bo.getPopularitySet());
        if (Constant.DEFAULTNULL != bo.getPopularityStart()) {
            courseVo.setPopularityStart(bo.getPopularityStart());
        }
        courseVo.setQualityAssurance(bo.getQualityAssurance());
        courseVo.setQuestionBank(bo.getQuestionBank());
        courseVo.setQuestionSession(bo.getQuestionSession());
        courseVo.setQuiz(bo.getQuiz());
        courseVo.setRating(bo.getRating());
        courseVo.setReference(bo.getReference());
        courseVo.setRegPhone(bo.getRegPhone());
        if (Constant.DEFAULTNULL != bo.getSchooltimeDay()) {
            courseVo.setSchooltimeDay(bo.getSchooltimeDay());
        }
//        courseVo.setSchooltimeDaySet(bo.getSchooltimeDaySet());
        if (Constant.DEFAULTNULL != bo.getSchooltimeWeek()) {
            courseVo.setSchooltimeWeek(bo.getSchooltimeWeek());
        }
//        courseVo.setSchooltimeWeekSet(bo.getSchooltimeWeekSet());
        if (Constant.DEFAULTNULL != bo.getServiceCharge()) {
            courseVo.setServiceCharge(bo.getServiceCharge());
        }
        if (bo.getStartDate() != Constant.DEFAULTNULL) {
            courseVo.setStartDate(bo.getStartDate());    
        } 
//        courseVo.setStartDateEnd(bo.getStartDateEnd());
//        courseVo.setStartDateStart(bo.getStartDateStart());
        if (Constant.DEFAULTNULL != bo.getStartTime1()) {
            courseVo.setStartTime1(bo.getStartTime1());
        }
        if (Constant.DEFAULTNULL != bo.getStartTime2()) {
            courseVo.setStartTime2(bo.getStartTime2());
        }
        if (Constant.DEFAULTNULL != bo.getStartUponArrival()) {
            courseVo.setStartUponArrival(bo.getStartUponArrival());
        }
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            courseVo.setStatus(bo.getStatus());
        }
//        courseVo.setStatusSet(bo.getStatusSet());
        courseVo.setStudyDaysNote(bo.getStudyDaysNote());
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
        if (bo.getStudyDays() != null && !"".equals(bo.getStudyDays())) {
            char[] days = bo.getStudyDays().toCharArray();
            List<Integer> studyDays = new ArrayList<>();
            for (char day : days) {
                studyDays.add(Integer.parseInt("" + day));
            }
            courseVo.setStudyDays(studyDays);
        }
        return courseVo;
    }
}
