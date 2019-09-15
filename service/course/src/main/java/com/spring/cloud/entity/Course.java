package com.spring.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：vivaciousis
 * @date ：Created in 2019/9/11 22:18
 * @description：映射实体表定义
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "homepage_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** 课程名称 */
    @Basic
    @Column(name = "course_name", nullable = false)
    private String courseName;

    /** 课程类型 */
    @Basic
    @Column(name = "course_type", nullable = false)
    private Integer courseType;

    /** 课程图标 */
    @Basic
    @Column(name = "course_icon", nullable = false)
    private String courseIcon;

    /** 课程介绍 */
    @Basic
    @Column(name = "course_intro", nullable = false)
    private String courseIntro;

    /** 创建时间 */
    @Basic
    @Column(name = "create_time", nullable = false)
    @CreatedDate
    private Date createTime;

    /** 更新时间 */
    @Basic
    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public Course(String courseName, Integer courseType,
                          String courseIcon, String courseIntro) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    /**
     * <h2>返回一个无效的课程</h2>
     * */
    public static Course invalid() {

        Course invalid = new Course(
                "", 0, "", ""
        );
        invalid.setId(-1L);
        return invalid;
    }



}
