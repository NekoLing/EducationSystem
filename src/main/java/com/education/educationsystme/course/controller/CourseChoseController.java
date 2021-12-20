package com.education.educationsystme.course.controller;


import com.education.educationsystme.course.model.Course;
import com.education.educationsystme.course.model.CourseChose;
import com.education.educationsystme.course.model.Student;
import com.education.educationsystme.course.service.ICourseChoseService;
import com.education.educationsystme.util.CookieUtils;
import com.education.educationsystme.util.JsonResponse;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname CourseChoseController
 * @Description
 * @Date 2021/12/14 19:20
 * @Created by gaoqi
 */

@RestController
@RequestMapping(value = "/course")
public class CourseChoseController {
    final
    ICourseChoseService choseSerivce;

    public CourseChoseController(ICourseChoseService choseSerivce) {
        this.choseSerivce = choseSerivce;
    }


    @PostMapping(value = "/chose")
    public JsonResponse chose(@RequestBody CourseChose chose) {
        int state = choseSerivce.chose(chose);
        if (state == 0)
            return new JsonResponse();
        else if (state == 1)
            return new JsonResponse(1, "请勿重复选课");
        else if (state == 3)
            return new JsonResponse(3, "已超过选课期限");
        else
            return new JsonResponse(state, "fail");
    }

    @GetMapping(value = "/unchose")
    public JsonResponse unchose(HttpServletRequest request, @RequestParam Integer courseId) {
        String studentId = CookieUtils.get(request, "accountNumber");

        CourseChose chose = new CourseChose();
        chose.setCourseId(courseId);
        chose.setStudentId(studentId);

        return new JsonResponse(choseSerivce.unchose(chose), "退选0成功1失败");
    }

    @GetMapping(value = "/chose/list")
    public Map<String, Object> queryAll(HttpServletRequest request) {

        String id = CookieUtils.get(request, "accountNumber");

        List<Course> courses = choseSerivce.listByStuId(id);

        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("msg","成了");
        response.put("count", courses.size());
        response.put("data", courses);
        return response;
    }

    @GetMapping(value = "/chose/students")
    public Map<String, Object> queryStudentsById(@RequestParam Integer id) {

        List<Student> students = choseSerivce.listStudentById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("msg","成了");
        response.put("count", students.size());
        response.put("data", students);
        return response;
    }

    @PostMapping(value = "/score")
    public JsonResponse setScore(@RequestBody CourseChose chose) {
        choseSerivce.updateScore(chose);
        return new JsonResponse();
    }
}