namespace java com.ishangke.edunav.commoncontract.model

struct ActivityBo {
    1: i32 id
    2: string name
    3: i32 partnerId
    4: i32 courseId
    5: string remark
    6: i64 startTime
    7: i64 endTime
    8: i32 status
    9: i64 lastModifyTime
    10: i64 createTime
    11: i32 enabled
    12: set<i32> idSet
    13: set<i32> partnerIdSet
    14: set<i32> courseIdSet
    15: i64 startTimeStart
    16: i64 startTimeEnd
    17: i64 endTimeStart 
    18: i64 endTimeEnd
    19: set<i32> statusSet
    20: i64 lastModifyTimeStart
    21: i64 lastModifyTimeEnd
    22: i64 createTimeStart
    23: i64 createTimeEnd
   }
   struct ActivityPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<ActivityBo> data
}

