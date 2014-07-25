include "classPhoto.thrift"
include "teacher.thrift"
include "address.thrift"

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
    6: i64 lastLoginTime
    7: i64 lastModifyTime
    8: i64 createTime
    9: i32 enabled
    10: string wholeName
    11: string licence
    12: string organizationNum
    13: string reference
    14: string password
    15: string partnerIntro
    16: string partnerDistinction
    17: string licenceImgUrl
    18: string taxRegImgUrl
    19: string eduQualificationImgUrl
    20: string hqLocation
    21: i32 uniRegLocation
    22: string hqContact
    23: string hqContactPhone
    24: string hqContactSecopt
    25: string courseContact
    26: string courseContactPhone
    27: string studentInqueryPhone
    28: string regContact
    29: string regContactPhone
    30: string regContactFax
    31: i32 cutoffDay
    32: i32 cutoffTime
    33: i32 partnerQualification
    34: set<i32> idSet
    35: i64 lastModifyTimeStart
    36: i64 lastModifyTimeEnd
    37: i64 createTimeStart
    38: i64 createTimeEnd
    39: i64 lastLoginTimeStart
    40: i64 lastLoginTimeEnd
    41: i32 cutoffDayStart
    42: i32 cutoffDayEnd
    43: set<i32> cutoffDaySet
    44: i32 cutoffTimeStart
    45: i32 cutoffTimeEnd
    46: set<i32> cutoffTimeSet
    47: i32 partnerQualificationStart
    48: i32 partnerQualificationEnd
    49: double ratingStart
    50: double ratingEnd 
    51: list<teacher.TeacherBo> teacherList;
    52: list<classPhoto.ClassPhotoBo> classPhotoList;
    53: list<address.AddressBo> addressList;
}
struct PartnerBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<PartnerBo> data
} 