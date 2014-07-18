namespace java com.ishangke.edunav.commoncontract.model

struct RoleBo {
    1: i32 id
    2: string name
    3: i64 lastModifyTime
    4: i64 createTime
    5: i32 enabled
    6: set<i32> idSet;
    7: set<i32> bookingIdSet;
    8: i64 createTimeStart;
    9: i64 createTimeEnd;
    10: double priceStart;
    11: double priceEnd;
}