namespace java com.ishangke.edunav.commoncontract.model

struct AccountBo {
    1: i32 id
    2: double balance
    3: string realName
    4: i64 lastModifyTime
    5: i64 createTime
    6: i32 enabled
    7: i32 deleted
    8: i32 idStart;
    9: i32 idEnd;
    10: set<i32> idSet;
    11: double balanceStart;
    12: double balanceEnd;
    13: i64 lastModifyTimeBefore;
    14: i64 lastModifyTimeAfter;
    15: i64 createTimeBefore;
    16: i64 createTimeAfter;
}