namespace java com.ishangke.edunav.commoncontract.model

struct CourseTeacherBo {
    1: i32 id
    2: i32 courseId
    3: i32 teacherId
    4: i64 createTime
    5: set<i32> idSet
    6: set<i32> courseIdSet
    7: set<i32> teacherIdSet
    8: i64 createTimeStart
    9: i64 createTimeEnd
}