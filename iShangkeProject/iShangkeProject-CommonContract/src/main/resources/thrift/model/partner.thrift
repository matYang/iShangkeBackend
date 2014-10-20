include "classPhoto.thrift"
include "teacher.thrift"
include "address.thrift"
include "category.thrift"

namespace java com.ishangke.edunav.commoncontract.model

/**
 * PartnerBo
 */
struct PartnerBo {
    1: i32 id
    2: string instName
    3: string logoUrl
    4: string contract
    5: double rating
    6: i64 lastModifyTime
    7: i64 createTime
    8: i32 enabled
    9: string wholeName
    10: string licence
    11: string organizationNum
    12: string reference
    13: string partnerIntro
    14: string partnerDistinction
    15: string licenceImgUrl
    16: string taxRegImgUrl
    17: string eduQualificationImgUrl
    18: string hqLocation
    19: i32 uniRegLocation
    20: string hqContact
    21: string hqContactPhone
    22: string hqContactSecopt
    23: string courseContact
    24: string courseContactPhone
    25: string studentInqueryPhone
    26: string regContact
    27: string regContactPhone
    28: string regContactFax
    29: i32 cutoffDay
    30: i32 cutoffTime
    31: i32 partnerQualification
    32: set<i32> idSet
    33: i64 lastModifyTimeStart
    34: i64 lastModifyTimeEnd
    35: i64 createTimeStart
    36: i64 createTimeEnd
    37: i32 cutoffDayStart
    38: i32 cutoffDayEnd
    39: set<i32> cutoffDaySet
    40: i32 cutoffTimeStart
    41: i32 cutoffTimeEnd
    42: set<i32> cutoffTimeSet
    43: i32 partnerQualificationStart
    44: i32 partnerQualificationEnd
    45: double ratingStart
    46: double ratingEnd 
    47: list<teacher.TeacherBo> teacherList;
    48: list<classPhoto.ClassPhotoBo> classPhotoList;
    49: list<address.AddressBo> addressList;
    50: i32 popularity
    51: i32 courseCount
    52: i32 teacherCount
    53: list<category.CategoryBo> categoryList;
    54: string categoryValue
    55: string circleValue
}
struct PartnerPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<PartnerBo> data
} 