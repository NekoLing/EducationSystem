package com.education.educationsystme.course.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.educationsystme.course.model.Course;
import com.education.educationsystme.course.service.ICourseService;
import com.education.educationsystme.util.CookieUtils;
import com.education.educationsystme.util.JsonResponse;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname CourseController
 * @Description 课程的控制层
 * @Date 2021/12/10 15:54
 * @Created by gaoqi
 */
@RestController
@RequestMapping(value = "/course")
public class CourseController {
    final
    ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = "/create")
    public JsonResponse create(HttpServletRequest request, @RequestBody Course course) {

        course.setTid(CookieUtils.get(request, "accountNumber"));

        courseService.save(course);

        return new JsonResponse();
    }

    @PostMapping(value = "/query")
    public JsonResponse query(@RequestParam Integer id) {
        return new JsonResponse(courseService.getById(id));
    }

    @GetMapping(value = "/list")
    public Map<String, Object> queryAll(@RequestParam Integer page, @RequestParam Integer limit) {

        Page<Course> pages = PageHelper.startPage(page, limit).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                courseService.list();
            }
        });

        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("msg","成了");
        response.put("count", pages.getTotal());
        response.put("data", pages);
        return response;
    }

    @GetMapping(value = "/list/condition")
    public Map<String, Object> queryAllWithCon(@RequestParam Map<String, String> map) {
        int page = Integer.parseInt(map.get("page"));
        int limit = Integer.parseInt(map.get("limit"));

        //下面的这些应该放进service里面，暂时先不改了
        QueryWrapper queryWrapper = new QueryWrapper();

        String name = map.get("name");
        String type = map.get("type");
        String location = map.get("location");
        String classtime = map.get("classtime");
        String week = map.get("week");

        if (name != null && !name.isEmpty())
            queryWrapper.like("name", name);
        if (type != null && !type.isEmpty())
            queryWrapper.eq("type", type);
        if (location != null && !location.isEmpty())
            queryWrapper.eq("location", location);
        if (classtime != null && !classtime.isEmpty())
            queryWrapper.eq("classtime", classtime);
        if (week != null && !week.isEmpty())
            queryWrapper.like("week", week);


        Page<Course> pages = PageHelper.startPage(page, limit).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                courseService.list(queryWrapper);
            }
        });

        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("msg","成了");
        response.put("count", pages.getTotal());
        response.put("data", pages);
        return response;
    }

    @GetMapping(value = "/list/teach")
    public JsonResponse queryAllWithTeacher(HttpServletRequest request) {
        String teacherId = CookieUtils.get(request, "accountNumber");
        return new JsonResponse(courseService.queryByTeacher(teacherId),"查询成功");
    }

    @GetMapping(value = "/test")
    public JsonResponse test() {
        return new JsonResponse();
    }
}
