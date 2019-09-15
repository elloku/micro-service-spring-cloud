package com.spring.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.CourseInfo;
import com.spring.cloud.CourseInfosRequest;
import com.spring.cloud.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：vivaciousis
 * @date ：Created in 2019/9/11 22:16
 * @description：课程对外服务接口
 */
@Slf4j
@RestController
public class CourseController {
    /** 课程服务接口 */
    private final ICourseService courseService;

    @Autowired
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * 127.0.0.1:7001/course/get/course?id=
     * 127.0.0.1:9000/course/get/course?id=
     * */
    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(Long id) {
        log.info("<course>: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(
            @RequestBody CourseInfosRequest request) {
        log.info("<course>: get courses -> {}",
                JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
