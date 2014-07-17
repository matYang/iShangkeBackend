namespace java com.ishangke.edunav.commoncontract.model

struct ApproveHistoryBo {
    1: i32 id
    2: i32 type
    3: i32 attachedId
    4: i32 submitUserId
    5: i32 approveUserId
    6: i32 preStatus
    7: i32 postStatus
    8: string comment
    9: i64 createTime
    10: set<i32> idSet
    11: set<i32> typeSet
    12: set<i32> attachedIdSet
    13: set<i32> submitUserIdSet
    14: set<i32> approveUserIdSet
    15: set<i32> preStatusSet
    16: set<i32> postStatusSet
    17: i64 createTimeStart
    18: i64 createTimeEnd
    }