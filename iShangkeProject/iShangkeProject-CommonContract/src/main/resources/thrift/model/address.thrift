namespace java com.ishangke.edunav.commoncontract.model

struct AddressBo {
    1: i32 id
    2: i32 partnerId
    3: string detail
    4: double lat
    5: double lng
    6: i64 lastModifyTime
    7: i64 createTime
    8: i32 enabled
    9: i32 deleted
    10: i32 idStart
    11: i32 idEnd
    12: set<i32> idSet
    13: i32 partnerIdStart
    14: i32 partnerIdEnd
    15: set<i32> partnerIdSet
    16: double latStart
    17: double latEnd
    18: double lngStart
    19: double lngEnd
    20: i64 lastModifyTimeStart
    21: i64 lastModifyTimeEnd
    22: i64 createTimeStart
    23: i64 createTimeEnd
}