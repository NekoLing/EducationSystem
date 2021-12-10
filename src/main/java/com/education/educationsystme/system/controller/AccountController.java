package com.education.educationsystme.system.controller;

import com.education.config.MyConstant;
import com.education.educationsystme.course.model.Student;
import com.education.educationsystme.course.model.Teacher;
import com.education.educationsystme.course.service.IStudentService;
import com.education.educationsystme.course.service.ITeacherService;
import com.education.educationsystme.system.model.Account;
import com.education.educationsystme.system.model.User;
import com.education.educationsystme.system.service.IAccountService;
import com.education.educationsystme.util.CookieUtils;
import com.education.educationsystme.util.JsonResponse;
import com.education.educationsystme.util.JwtUitls;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname AccountController
 * @Description 系统账户的控制层
 * @Date 2021/11/5 22:19
 * @Created by gaoqi
 */

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private final IAccountService accountService;
    private final JwtUitls jwtUitls;
    private final IStudentService studentService;
    private final ITeacherService teacherService;

    public AccountController(IAccountService accountService, JwtUitls jwtUitls, IStudentService studentService, ITeacherService teacherService) {
        this.accountService = accountService;
        this.jwtUitls = jwtUitls;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    /**
     * 创建账户
     * @param account 只包括账号和密码
     * @return 成功提示
     */
    @PostMapping(value = "/create")
    public JsonResponse create(@RequestBody Account account) {
        accountService.save(account);
        return new JsonResponse();
    }

    @PostMapping(value = "/query")
    public JsonResponse queryByID(@RequestParam String id) {
        return new JsonResponse(accountService.getById(id));
    }

    /**
     * 更新账户信息，一般只有密码会更新
     * @param account 包括账号和密码
     * @return 成功提示
     */
    @PostMapping(value = "update")
    public JsonResponse updateByID(@RequestBody Account account) {
        //更新账户信息
        accountService.updateById(account);
        return new JsonResponse();
    }

    /**
     * 登录，验证账号和密码的正确性
     * @param inputAccount 只包括账号和密码
     * @return 账户全部信息，外加token
     */
    @PostMapping(value = "/login")
    public JsonResponse login(@RequestBody Account inputAccount) {
        Account saveAccount = accountService.getByNumber(inputAccount.getAccountNumber());

        //生成token
        if (saveAccount != null)
            saveAccount.setToken(jwtUitls.createToken(saveAccount.getId().toString(),saveAccount.getAccountNumber()));

        if (saveAccount == null)
            return new JsonResponse(1, "用户不存在");
        else if (!saveAccount.getPassword().equals(inputAccount.getPassword()))
            return new JsonResponse(1, "密码错误");
        else
            return new JsonResponse(saveAccount, "登录成功");
    }

    /**
     * 获取一个User对象，内含有用户的账户信息和个人信息,信息基于token查询获得
     * @param request 请求体
     * @return User对象，包括一个账户对象和一个用户对象
     */
    @GetMapping(value = "/user")
    public JsonResponse getCurrentUser(HttpServletRequest request) {

        User user = new User();

        String token = CookieUtils.getToken(request);
        Account account = jwtUitls.getAccount(token);
        user.setAccount(account);

        Integer accountType = account.getAccountType();
        String accountNumber = account.getAccountNumber();
        if (accountType == MyConstant.ACCOUNT_TYPE_MANAGER || accountType == MyConstant.ACCOUNT_TYPE_TEACHER) {
            Teacher teacher = teacherService.getById(accountNumber);
            user.setRole(teacher);
            return new JsonResponse(user);
        }
        else if (accountType == MyConstant.ACCOUNT_TYPE_STUDENT) {
            Student student = studentService.getById(accountNumber);
            user.setRole(student);
            return new JsonResponse(user);
        }
        else
            return new JsonResponse(1, "用户类型不存在");
    }

    /**
     * 单纯测试请求是否正常的接口
     * @return 成功提示
     */
    @GetMapping(value = "/test")
    public JsonResponse test() {
        return new JsonResponse();
    }
}
