package com.ishangke.edunav.dataaccess.model.gen;

import java.util.Calendar;

public class CourseTemplateClassPhotoEntity {
    private Integer id;

    private Integer courseTemplateId;

    private Integer classPhotoId;

    private Calendar createTime;

    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseTemplateId() {
        return courseTemplateId;
    }

    public void setCourseTemplateId(Integer courseTemplateId) {
        this.courseTemplateId = courseTemplateId;
    }

    public Integer getClassPhotoId() {
        return classPhotoId;
    }

    public void setClassPhotoId(Integer classPhotoId) {
        this.classPhotoId = classPhotoId;
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}