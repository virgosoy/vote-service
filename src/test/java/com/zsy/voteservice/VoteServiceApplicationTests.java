package com.zsy.voteservice;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VoteServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    void test1(){
        System.out.println("参数化测试b");
    }

    @Test
    @Order(2)
    void test2(){
        System.out.println("参数化测试a");
    }

}
