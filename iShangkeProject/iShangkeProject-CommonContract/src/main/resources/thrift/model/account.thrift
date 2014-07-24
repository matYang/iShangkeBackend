namespace java com.ishangke.edunav.commoncontract.model

struct AccountBo {
    1: i32 id
    2: double balance
    3: string realName
    4: i64 lastModifyTime
    5: i64 createTime
    6: i32 enabled
    7: set<i32> idSet
    8: double balanceStart
    9: double balanceEnd
    10: i64 lastModifyTimeStart
    11: i64 lastModifyTimeEnd
    12: i64 createTimeStart
    13: i64 createTimeEnd
    14: string accountNumber
    }