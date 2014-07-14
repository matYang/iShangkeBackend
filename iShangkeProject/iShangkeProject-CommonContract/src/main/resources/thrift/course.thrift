namespace java com.ishangke.edunav.commoncontract.model

/**
 * CourseBo
 */
struct CourseBo {
  1: i32 id
  2: string name
}

struct CourseTemplateBo {
    1: i32 id
    2: string name
}

struct CommentCourseApproveBo {
    1: i32 id
    2: string comment
}

struct CommentCourseTemplateApproveBo {
    1: i32 id
    2: string comment
}

struct CommentCourseRejectBo {
    1: i32 id
    2: string comment
}

struct CommentCourseTemplateRejectBo {
    1: i32 id
    2: string comment
}

struct CommentCourseBo {
    1: i32 id
    2: string commnet 
}