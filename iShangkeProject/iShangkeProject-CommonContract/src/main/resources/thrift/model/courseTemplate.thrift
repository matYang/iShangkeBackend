include "teacher.thrift"
include "classPhoto.thrift"

namespace java com.ishangke.edunav.commoncontract.model

struct CourseTemplateBo {
    1: i32 id
    2: string courseName
    3: i32 categoryId
    4: i32 locationId
    5: i32 circleId
    6: i32 partnerId
    7: i32 addressId
    8: double price
    9: double originalPrice
    10: double cashback
    11: double commission
    12: double serviceCharge
    13: i32 status
    14: i64 lastModifyTime
    15: i64 createTime
    16: i32 enabled
    17: i32 courseHourNum
    18: i32 courseHourLength
    19: i32 popularity
    20: i64 startDate
    21: i64 finishDate
    22: i64 cutoffDate
    23: i64 noRefundDate
    24: i64 cashbackDate
    25: i32 bookingType
    26: i32 startUponArrival
    27: i32 startTime1
    28: i32 finishTime1
    29: i32 startTime2
    30: i32 finishTime2
    31: string regLocation
    32: string reference
    33: string courseIntro
    34: string quiz
    35: string certification
    36: string openCourseRequirement
    37: string suitableStudent
    38: string prerequest
    39: string highScoreReward
    40: string studyDayNote
    41: string teachingMaterialIntro
    42: string questionBank
    43: string qualityAssurance
    44: string passAgreement
    45: string extracurricular
    46: string contact
    47: string regPhone
    48: string outline
    49: string goal
    50: string classTeacher
    51: string teachingAndExercise
    52: string questionSession
    53: string trail
    54: string assignments
    55: string marking
    56: string bonusService
    57: string downloadMaterials
    58: string teachingMaterialFee
    59: string teachingMethod
    60: string classSize
    61: i32 classType
    62: double discount
    63: double rating
    64: i32 bookingTotal
    65: i32 schooltimeDay
    66: i32 schooltimeWeek
    67: set<i32> idSet
    68: i64 lastModifyTimeStart
    69: i64 lastModifyTimeEnd
    70: i64 createTimeStart
    71: i64 createTimeEnd
    72: set<i32> categoryIdSet
    73: set<i32> locationIdSet
    74: set<i32> circleIdSet
    75: set<i32> partnerIdSet
    76: set<i32> statusSet
    77: double priceStart
    78: double priceEnd
    79: double originalPriceStart
    80: double originalPriceEnd
    81: double cashbackStart
    82: double cashbackEnd
    83: i32 popularityStart
    84: i32 popularityEnd
    85: set<i32> popularitySet
    86: i32 courseHourNumStart
    87: i32 courseHourNumEnd
    88: set<i32> courseHourNumSet
    89: i64 startDateStart
    90: i64 startDateEnd
    91: i64 finishDateStart
    92: i64 finishDateEnd
    93: i64 cutoffDateStart
    94: i64 cutoffDateEnd
    95: set<i32> classTypeSet
    96: double discountStart
    97: double discountEnd
    98: double ratingStart
    99: double ratingEnd
    100: i32 bookingTotalStart
    101: i32 bookingTotalEnd
    102: set<i32> bookingTotalSet
    103: set<i32> schooltimeDaySet
    104: set<i32> schooltimeWeekSet
    105: list<teacher.TeacherBo> teacherList
    106: list<classPhoto.ClassPhotoBo> classPhotoList
    107: string logoUrl
    108: string wholeName
    109: string instName
    110: string partnerIntro
    111: i32 partnerQualification
    112: string partnerDistinction
    113: double partnerRating
    114: string address
    115: double addressLat
    116: double addressLng
    117: string categoryValue
    118: string categoryName
    119: i32 categoryRank
    120: string locationValue
    121: string locationName
    122: string circleValue
    123: string circleName
}

struct CommentCourseTemplateApproveBo {
    1: i32 id
    2: string comment
}

struct CommentCourseTemplateRejectBo {
    1: i32 id
    2: string comment
}

