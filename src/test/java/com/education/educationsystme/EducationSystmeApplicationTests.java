package com.education.educationsystme;

import com.education.educationsystme.system.model.Account;
import com.education.educationsystme.system.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class EducationSystmeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    AccountService service;

    @Test
    void CreateData() {
        Account account = new Account();
        account.setId("tch123412341234");
        account.setName("教师0");
        account.setPassword("123456");
//        account.setEmail("testMng0@email.com");
//        account.setPhone(12345678901L);
//        account.setGrade(2017);
//        account.setClassNumber(1);
//        account.setMajor("自然地理");
        account.setAccountType(1);
        service.save(account);
    }
}
