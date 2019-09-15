package com.spring.cloud.service.impl;


import com.spring.cloud.CourseInfo;
import com.spring.cloud.CourseInfosRequest;
import com.spring.cloud.dao.CourseDao;
import com.spring.cloud.entity.Course;
import com.spring.cloud.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author ：vivaciousis
 * @date ：Created in 2019/9/10 22:37
 * @description：课程服务功能实现
 */
@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseDao homepageCourseDao;

    @Autowired
    public CourseServiceImpl(CourseDao homepageCourseDao) {
        this.homepageCourseDao = homepageCourseDao;
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {

        Optional<Course> course = homepageCourseDao.findById(id);
        return buildCourseInfo(course.orElse(Course.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {

        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }

        List<Course> courses = homepageCourseDao.findAllById(
                request.getIds()
        );
        return courses.stream()
                .map(this::buildCourseInfo)
                .collect(Collectors.toList());
    }

    /**
     * <h2>根据数据记录构造对象信息</h2>
     * */
    private CourseInfo buildCourseInfo(Course course) {

        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0
                        ? "免费课程" : "实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
