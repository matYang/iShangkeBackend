include "teacher.thrift"
include "classPhoto.thrift"

namespace java com.ishangke.edunav.commoncontract.model

/**
 * CourseBo
 */
struct CourseBo {
    1: i32 id
    2: string courseName
    3: i32 courseTemplateId
    4: i32 categoryId
    5: i32 locationId
    6: i32 circleId
    7: i32 partnerId
    8: i32 addressId
    9: double price
    10: double originalPrice
    11: double cashback
    12: double commission
    13: double serviceCharge
    14: i32 status
    15: i64 lastModifyTime
    16: i64 createTime
    17: i32 enabled
    18: i32 courseHourLength
    19: string teachingMethod
    20: string teachingMaterialFee
    21: string downloadMaterials
    22: string bonusService
    23: string marking
    24: string assignments
    25: string trail
    26: string questionSession
    27: string teachingAndExercise
    28: string classTeacher
    29: string goal
    30: string outline
    31: string regPhone
    32: string contact
    33: string extracurricular
    34: string passAgreement
    35: string qualityAssurance
    36: string questionBank
    37: string teachingMaterialIntro
    38: string studyDayNote
    39: string highScoreReward
    40: string prerequest
    41: string suitableStudent
    42: string openCourseRequirement
    43: string certification
    44: string quiz
    45: string courseIntro
    46: string reference
    47: string regLocation
    48: i32 finishTime2
    49: i32 startTime2
    50: i32 finishTime1
    51: i32 startTime1
    52: i32 startUponArrival
    53: i32 bookingType
    54: i64 cashbackDate
    55: i64 noRefundDate
    56: i64 cutoffDate
    57: i64 finishDate
    58: i64 startDate
    59: i32 popularity
    60: i32 courseHourNum
    61: string classSize
    62: i32 classType
    63: double discount
    64: i32 schooltimeDay
    65: i32 schooltimeWeek
    66: set<i32> idSet;
    67: i64 lastModifyTimeStart;
    68: i64 lastModifyTimeEnd;
    69: i64 createTimeStart;
    70: i64 createTimeEnd;
    71: set<i32> categoryIdSet;
    72: set<i32> locationIdSet;
    73: set<i32> circleIdSet;
    74: set<i32> partnerIdSet;
    75: set<i32> statusSet;
    76: double priceStart;
    77: double priceEnd;
    78: double originalPriceStart;
    79: double originalPriceEnd;
    80: double cashbackStart;
    81: double cashbackEnd;
    82: i32 popularityStart;
    83: i32 popularityEnd;
    84: set<i32> popularitySet;
    85: i32 courseHourNumStart;
    86: i32 courseHourNumEnd;
    87: set<i32> courseHourNumSet;
    88: i64 startDateStart;
    89: i64 startDateEnd;
    90: i64 finishDateStart;
    91: i64 finishDateEnd;
    92: i64 cutoffDateStart;
    93: i64 cutoffDateEnd;
    94: set<i32> classTypeSet;
    95: double discountStart;
    96: double discountEnd;
    97: double ratingStart;
    98: double ratingEnd;
    99: i32 bookingTotalStart;
    100: i32 bookingTotalEnd;
    101: set<i32> bookingTotalSet;
    102: set<i32> schooltimeDaySet;
    103: set<i32> schooltimeWeekSet;
    104: list<teacher.TeacherBo> teacherList;
    105: list<classPhoto.ClassPhotoBo> classPhotoList;
    106: string logoUrl;
    107: string wholeName;
    108: string instName;
    109: string partnerIntro;
    110: i32 partnerQualification;
    111: string partnerDistinction;
    112: double partnerRating;
    113: string address;
    114: double addressLat;
    115: double addressLng;
    116: string categoryValue;
    117: string categoryName;
    118: i32 categoryRank;
    119: string locationValue;
    120: string locationName;
    121: string circleValue;
    122: string circleName;
}

struct CommentCourseApproveBo {
    1: i32 id
    2: string comment
}

struct CommentCourseRejectBo {
    1: i32 id
    2: string comment
}

struct CommentCourseBo {
    1: i32 id
    2: string commnet 
}