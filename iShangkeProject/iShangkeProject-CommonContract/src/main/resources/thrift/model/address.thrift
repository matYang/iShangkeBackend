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
    9: set<i32> idSet
    10: set<i32> partnerIdSet
    11: double latStart
    12: double latEnd
    13: double lngStart
    14: double lngEnd
    15: i64 lastModifyTimeStart
    16: i64 lastModifyTimeEnd
    17: i64 createTimeStart
    18: i64 createTimeEnd
}
struct AddressBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<AddressBo> data
}