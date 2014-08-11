namespace java com.ishangke.edunav.commoncontract.model

struct MajorBo {
    1: i32 id
    2: string value
    3: string name
    4: i64 lastModifyTime
    5: i64 createTime
    6: i32 enabled
    7: i32 schoolId
}
struct MajorPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<MajorBo> data
} 
