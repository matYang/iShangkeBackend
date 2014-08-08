package com.ishangke.edunav.web.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.web.common.ActionVo;
import com.ishangke.edunav.web.response.JsonResponse;

public class CourseVo extends JsonResponse {
    private Integer id;

    private String courseName;

    private Integer courseTemplateId;

    private Integer categoryId;

    private Integer locationId;

    private Integer circleId;

    private Integer partnerId;

    private Double price;

    private Double originalPrice;

    private Double cashback;

    private Double commission;

    private Double serviceCharge;

    private Integer status;

    private Calendar lastModifyTime;

    private Calendar createTime;

    private Integer enabled;

    private Integer courseHourLength;

    private String teachingMethod;

    private String teachingMaterialFee;

    private String downloadMaterials;

    private String bonusService;

    private String marking;

    private String assignments;

    private String trail;

    private String questionSession;

    private String teachingAndExercise;

    private String classTeacher;

    private String goal;

    private String outline;

    private String regPhone;

    private String contact;

    private String extracurricular;

    private String passAgreement;

    private String qualityAssurance;

    private String questionBank;

    private String teachingMaterialIntro;

    private String studyDaysNote;
    
    private List<Integer> studyDays;

    private String highScoreReward;

    private String prerequest;

    private String suitableStudent;

    private String openCourseRequirement;

    private String certification;

    private String quiz;

    private String courseIntro;

    private String reference;

    private Integer finishTime2;

    private Integer startTime2;

    private Integer finishTime1;

    private Integer startTime1;

    private Integer startUponArrival;

    private Integer bookingType;

    private Calendar cashbackDate;

    private Calendar noRefundDate;

    private Calendar cutoffDate;

    private Calendar finishDate;

    private Calendar startDate;

    private Integer popularity;

    private Integer courseHourNum;

    private String classSize;

    private Integer classType;

    private Double discount;

    private Integer schooltimeDay;

    private Integer schooltimeWeek;
    private Set<Integer> idSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Set<Integer> categoryIdSet;
    private Set<Integer> locationIdSet;
    private Set<Integer> circleIdSet;
    private Set<Integer> partnerIdSet;
    private Set<Integer> statusSet;
    private Set<Integer> courseTemplateIdSet;
    private Double priceStart;
    private Double priceEnd;
    private Double originalPriceStart;
    private Double originalPriceEnd;
    private Double cashbackStart;
    private Double cashbackEnd;
    private Integer popularityStart;
    private Integer popularityEnd;
    private Set<Integer> popularitySet;
    private Integer courseHourNumStart;
    private Integer courseHourNumEnd;
    private Set<Integer> courseHourNumSet;
    private Calendar startDateStart;
    private Calendar startDateEnd;
    private Calendar finishDateStart;
    private Calendar finishDateEnd;
    private Calendar cutoffDateStart;
    private Calendar cutoffDateEnd;
    private Calendar noRefundDateStart;
    private Calendar noRefundDateEnd;
    private Set<Integer> classTypeSet;
    private Double discountStart;
    private Double discountEnd;
    private Set<Integer> schooltimeDaySet;
    private Set<Integer> schooltimeWeekSet;
    private Calendar cashbackDateStart;
    private Calendar cashbackDateEnd;
    private Double rating;
    private Integer bookingTotal;

    // concrete information
    private List<TeacherVo> teacherList;
    private List<ClassPhotoVo> classPhotoList;

    // placing values identified by FK here, and this is really ugly
    private String logoUrl;
    private String wholeName;
    private String instName;
    private String partnerIntro;
    private Integer partnerQualification;
    private String partnerDistinction;
    private Double partnerRating;

    private Integer addressId;
    private String address;
    private Double addressLat;
    private Double addressLng;
    private Set<Integer> addressIdSet;

    private Integer regAddressId;
    private String regAddress;
    private Double regAddressLat;
    private Double regAddressLng;
    private Set<Integer> regAddressIdSet;

    private String categoryValue;
    private String categoryName;
    private Integer categoryRank;
    private String locationValue;
    private String locationName;
    private String circleValue;
    private String circleName;
    private List<ActionVo> actionList;
    
    //用于idSet的接收
    private String ids;

    public List<ActionVo> getActionList() {
        return actionList;
    }

    public void setActionList(List<ActionVo> actionList) {
        this.actionList = actionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseTemplateId() {
        return courseTemplateId;
    }

    public void setCourseTemplateId(Integer courseTemplateId) {
        this.courseTemplateId = courseTemplateId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getCashback() {
        return cashback;
    }

    public void setCashback(Double cashback) {
        this.cashback = cashback;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Calendar getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Calendar lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getCourseHourLength() {
        return courseHourLength;
    }

    public void setCourseHourLength(Integer courseHourLength) {
        this.courseHourLength = courseHourLength;
    }

    public String getTeachingMethod() {
        return teachingMethod;
    }

    public void setTeachingMethod(String teachingMethod) {
        this.teachingMethod = teachingMethod;
    }

    public String getTeachingMaterialFee() {
        return teachingMaterialFee;
    }

    public void setTeachingMaterialFee(String teachingMaterialFee) {
        this.teachingMaterialFee = teachingMaterialFee;
    }

    public String getDownloadMaterials() {
        return downloadMaterials;
    }

    public void setDownloadMaterials(String downloadMaterials) {
        this.downloadMaterials = downloadMaterials;
    }

    public String getBonusService() {
        return bonusService;
    }

    public void setBonusService(String bonusService) {
        this.bonusService = bonusService;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public String getAssignments() {
        return assignments;
    }

    public void setAssignments(String assignments) {
        this.assignments = assignments;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

    public String getQuestionSession() {
        return questionSession;
    }

    public void setQuestionSession(String questionSession) {
        this.questionSession = questionSession;
    }

    public String getTeachingAndExercise() {
        return teachingAndExercise;
    }

    public void setTeachingAndExercise(String teachingAndExercise) {
        this.teachingAndExercise = teachingAndExercise;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getRegPhone() {
        return regPhone;
    }

    public void setRegPhone(String regPhone) {
        this.regPhone = regPhone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getExtracurricular() {
        return extracurricular;
    }

    public void setExtracurricular(String extracurricular) {
        this.extracurricular = extracurricular;
    }

    public String getPassAgreement() {
        return passAgreement;
    }

    public void setPassAgreement(String passAgreement) {
        this.passAgreement = passAgreement;
    }

    public String getQualityAssurance() {
        return qualityAssurance;
    }

    public void setQualityAssurance(String qualityAssurance) {
        this.qualityAssurance = qualityAssurance;
    }

    public String getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(String questionBank) {
        this.questionBank = questionBank;
    }

    public String getTeachingMaterialIntro() {
        return teachingMaterialIntro;
    }

    public void setTeachingMaterialIntro(String teachingMaterialIntro) {
        this.teachingMaterialIntro = teachingMaterialIntro;
    }

    public String getStudyDaysNote() {
        return studyDaysNote;
    }

    public void setStudyDaysNote(String studyDaysNote) {
        this.studyDaysNote = studyDaysNote;
    }

    public String getHighScoreReward() {
        return highScoreReward;
    }

    public void setHighScoreReward(String highScoreReward) {
        this.highScoreReward = highScoreReward;
    }

    public String getPrerequest() {
        return prerequest;
    }

    public void setPrerequest(String prerequest) {
        this.prerequest = prerequest;
    }

    public String getSuitableStudent() {
        return suitableStudent;
    }

    public void setSuitableStudent(String suitableStudent) {
        this.suitableStudent = suitableStudent;
    }

    public String getOpenCourseRequirement() {
        return openCourseRequirement;
    }

    public void setOpenCourseRequirement(String openCourseRequirement) {
        this.openCourseRequirement = openCourseRequirement;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getFinishTime2() {
        return finishTime2;
    }

    public void setFinishTime2(Integer finishTime2) {
        this.finishTime2 = finishTime2;
    }

    public Integer getStartTime2() {
        return startTime2;
    }

    public void setStartTime2(Integer startTime2) {
        this.startTime2 = startTime2;
    }

    public Integer getFinishTime1() {
        return finishTime1;
    }

    public void setFinishTime1(Integer finishTime1) {
        this.finishTime1 = finishTime1;
    }

    public Integer getStartTime1() {
        return startTime1;
    }

    public void setStartTime1(Integer startTime1) {
        this.startTime1 = startTime1;
    }

    public Integer getStartUponArrival() {
        return startUponArrival;
    }

    public void setStartUponArrival(Integer startUponArrival) {
        this.startUponArrival = startUponArrival;
    }

    public Integer getBookingType() {
        return bookingType;
    }

    public void setBookingType(Integer bookingType) {
        this.bookingType = bookingType;
    }

    public Calendar getCashbackDate() {
        return cashbackDate;
    }

    public void setCashbackDate(Calendar cashbackDate) {
        this.cashbackDate = cashbackDate;
    }

    public Calendar getNoRefundDate() {
        return noRefundDate;
    }

    public void setNoRefundDate(Calendar noRefundDate) {
        this.noRefundDate = noRefundDate;
    }

    public Calendar getCutoffDate() {
        return cutoffDate;
    }

    public void setCutoffDate(Calendar cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    public Calendar getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Calendar finishDate) {
        this.finishDate = finishDate;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getCourseHourNum() {
        return courseHourNum;
    }

    public void setCourseHourNum(Integer courseHourNum) {
        this.courseHourNum = courseHourNum;
    }

    public String getClassSize() {
        return classSize;
    }

    public void setClassSize(String classSize) {
        this.classSize = classSize;
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getSchooltimeDay() {
        return schooltimeDay;
    }

    public void setSchooltimeDay(Integer schooltimeDay) {
        this.schooltimeDay = schooltimeDay;
    }

    public Integer getSchooltimeWeek() {
        return schooltimeWeek;
    }

    public void setSchooltimeWeek(Integer schooltimeWeek) {
        this.schooltimeWeek = schooltimeWeek;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Calendar getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }

    public void setLastModifyTimeStart(Calendar lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }

    public Calendar getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }

    public void setLastModifyTimeEnd(Calendar lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }

    public Calendar getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Calendar createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Calendar getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Calendar createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Set<Integer> getCategoryIdSet() {
        return categoryIdSet;
    }

    public void setCategoryIdSet(Set<Integer> categoryIdSet) {
        this.categoryIdSet = categoryIdSet;
    }

    public Set<Integer> getLocationIdSet() {
        return locationIdSet;
    }

    public void setLocationIdSet(Set<Integer> locationIdSet) {
        this.locationIdSet = locationIdSet;
    }

    public Set<Integer> getCircleIdSet() {
        return circleIdSet;
    }

    public void setCircleIdSet(Set<Integer> circleIdSet) {
        this.circleIdSet = circleIdSet;
    }

    public Set<Integer> getPartnerIdSet() {
        return partnerIdSet;
    }

    public void setPartnerIdSet(Set<Integer> partnerIdSet) {
        this.partnerIdSet = partnerIdSet;
    }

    public Set<Integer> getStatusSet() {
        return statusSet;
    }

    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }

    public Set<Integer> getCourseTemplateIdSet() {
        return courseTemplateIdSet;
    }

    public void setCourseTemplateIdSet(Set<Integer> courseTemplateIdSet) {
        this.courseTemplateIdSet = courseTemplateIdSet;
    }

    public Double getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(Double priceStart) {
        this.priceStart = priceStart;
    }

    public Double getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Double priceEnd) {
        this.priceEnd = priceEnd;
    }

    public Double getOriginalPriceStart() {
        return originalPriceStart;
    }

    public void setOriginalPriceStart(Double originalPriceStart) {
        this.originalPriceStart = originalPriceStart;
    }

    public Double getOriginalPriceEnd() {
        return originalPriceEnd;
    }

    public void setOriginalPriceEnd(Double originalPriceEnd) {
        this.originalPriceEnd = originalPriceEnd;
    }

    public Double getCashbackStart() {
        return cashbackStart;
    }

    public void setCashbackStart(Double cashbackStart) {
        this.cashbackStart = cashbackStart;
    }

    public Double getCashbackEnd() {
        return cashbackEnd;
    }

    public void setCashbackEnd(Double cashbackEnd) {
        this.cashbackEnd = cashbackEnd;
    }

    public Integer getPopularityStart() {
        return popularityStart;
    }

    public void setPopularityStart(Integer popularityStart) {
        this.popularityStart = popularityStart;
    }

    public Integer getPopularityEnd() {
        return popularityEnd;
    }

    public void setPopularityEnd(Integer popularityEnd) {
        this.popularityEnd = popularityEnd;
    }

    public Set<Integer> getPopularitySet() {
        return popularitySet;
    }

    public void setPopularitySet(Set<Integer> popularitySet) {
        this.popularitySet = popularitySet;
    }

    public Integer getCourseHourNumStart() {
        return courseHourNumStart;
    }

    public void setCourseHourNumStart(Integer courseHourNumStart) {
        this.courseHourNumStart = courseHourNumStart;
    }

    public Integer getCourseHourNumEnd() {
        return courseHourNumEnd;
    }

    public void setCourseHourNumEnd(Integer courseHourNumEnd) {
        this.courseHourNumEnd = courseHourNumEnd;
    }

    public Set<Integer> getCourseHourNumSet() {
        return courseHourNumSet;
    }

    public void setCourseHourNumSet(Set<Integer> courseHourNumSet) {
        this.courseHourNumSet = courseHourNumSet;
    }

    public Calendar getStartDateStart() {
        return startDateStart;
    }

    public void setStartDateStart(Calendar startDateStart) {
        this.startDateStart = startDateStart;
    }

    public Calendar getStartDateEnd() {
        return startDateEnd;
    }

    public void setStartDateEnd(Calendar startDateEnd) {
        this.startDateEnd = startDateEnd;
    }

    public Calendar getFinishDateStart() {
        return finishDateStart;
    }

    public void setFinishDateStart(Calendar finishDateStart) {
        this.finishDateStart = finishDateStart;
    }

    public Calendar getFinishDateEnd() {
        return finishDateEnd;
    }

    public void setFinishDateEnd(Calendar finishDateEnd) {
        this.finishDateEnd = finishDateEnd;
    }

    public Calendar getCutoffDateStart() {
        return cutoffDateStart;
    }

    public void setCutoffDateStart(Calendar cutoffDateStart) {
        this.cutoffDateStart = cutoffDateStart;
    }

    public Calendar getCutoffDateEnd() {
        return cutoffDateEnd;
    }

    public void setCutoffDateEnd(Calendar cutoffDateEnd) {
        this.cutoffDateEnd = cutoffDateEnd;
    }

    public Calendar getNoRefundDateStart() {
        return noRefundDateStart;
    }

    public void setNoRefundDateStart(Calendar noRefundDateStart) {
        this.noRefundDateStart = noRefundDateStart;
    }

    public Calendar getNoRefundDateEnd() {
        return noRefundDateEnd;
    }

    public void setNoRefundDateEnd(Calendar noRefundDateEnd) {
        this.noRefundDateEnd = noRefundDateEnd;
    }

    public Set<Integer> getClassTypeSet() {
        return classTypeSet;
    }

    public void setClassTypeSet(Set<Integer> classTypeSet) {
        this.classTypeSet = classTypeSet;
    }

    public Double getDiscountStart() {
        return discountStart;
    }

    public void setDiscountStart(Double discountStart) {
        this.discountStart = discountStart;
    }

    public Double getDiscountEnd() {
        return discountEnd;
    }

    public void setDiscountEnd(Double discountEnd) {
        this.discountEnd = discountEnd;
    }

    public Set<Integer> getSchooltimeDaySet() {
        return schooltimeDaySet;
    }

    public void setSchooltimeDaySet(Set<Integer> schooltimeDaySet) {
        this.schooltimeDaySet = schooltimeDaySet;
    }

    public Set<Integer> getSchooltimeWeekSet() {
        return schooltimeWeekSet;
    }

    public void setSchooltimeWeekSet(Set<Integer> schooltimeWeekSet) {
        this.schooltimeWeekSet = schooltimeWeekSet;
    }

    public Calendar getCashbackDateStart() {
        return cashbackDateStart;
    }

    public void setCashbackDateStart(Calendar cashbackDateStart) {
        this.cashbackDateStart = cashbackDateStart;
    }

    public Calendar getCashbackDateEnd() {
        return cashbackDateEnd;
    }

    public void setCashbackDateEnd(Calendar cashbackDateEnd) {
        this.cashbackDateEnd = cashbackDateEnd;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getBookingTotal() {
        return bookingTotal;
    }

    public void setBookingTotal(Integer bookingTotal) {
        this.bookingTotal = bookingTotal;
    }

    public List<TeacherVo> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherVo> teacherList) {
        this.teacherList = teacherList;
    }

    public List<ClassPhotoVo> getClassPhotoList() {
        return classPhotoList;
    }

    public void setClassPhotoList(List<ClassPhotoVo> classPhotoList) {
        this.classPhotoList = classPhotoList;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getPartnerIntro() {
        return partnerIntro;
    }

    public void setPartnerIntro(String partnerIntro) {
        this.partnerIntro = partnerIntro;
    }

    public Integer getPartnerQualification() {
        return partnerQualification;
    }

    public void setPartnerQualification(Integer partnerQualification) {
        this.partnerQualification = partnerQualification;
    }

    public String getPartnerDistinction() {
        return partnerDistinction;
    }

    public void setPartnerDistinction(String partnerDistinction) {
        this.partnerDistinction = partnerDistinction;
    }

    public Double getPartnerRating() {
        return partnerRating;
    }

    public void setPartnerRating(Double partnerRating) {
        this.partnerRating = partnerRating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAddressLat() {
        return addressLat;
    }

    public void setAddressLat(Double addressLat) {
        this.addressLat = addressLat;
    }

    public Double getAddressLng() {
        return addressLng;
    }

    public void setAddressLng(Double addressLng) {
        this.addressLng = addressLng;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
    }

    public String getLocationValue() {
        return locationValue;
    }

    public void setLocationValue(String locationValue) {
        this.locationValue = locationValue;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCircleValue() {
        return circleValue;
    }

    public void setCircleValue(String circleValue) {
        this.circleValue = circleValue;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public Set<Integer> getAddressIdSet() {
        return addressIdSet;
    }

    public void setAddressIdSet(Set<Integer> addressIdSet) {
        this.addressIdSet = addressIdSet;
    }

    public Integer getRegAddressId() {
        return regAddressId;
    }

    public void setRegAddressId(Integer regAddressId) {
        this.regAddressId = regAddressId;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public Double getRegAddressLat() {
        return regAddressLat;
    }

    public void setRegAddressLat(Double regAddressLat) {
        this.regAddressLat = regAddressLat;
    }

    public Double getRegAddressLng() {
        return regAddressLng;
    }

    public void setRegAddressLng(Double regAddressLng) {
        this.regAddressLng = regAddressLng;
    }

    public Set<Integer> getRegAddressIdSet() {
        return regAddressIdSet;
    }

    public void setRegAddressIdSet(Set<Integer> regAddressIdSet) {
        this.regAddressIdSet = regAddressIdSet;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<Integer> getStudyDays() {
        return studyDays;
    }

    public void setStudyDays(List<Integer> studyDays) {
        this.studyDays = studyDays;
    }

}
