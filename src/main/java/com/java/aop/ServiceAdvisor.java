package com.java.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

@Aspect
@Repository
public class ServiceAdvisor {
    /**
     * pointcut
     * 声明一个切入点
     * 切入点是一个特殊方法，没有返回值，没有入参，没有实现
     * 在execution中说明，切入的方法有什么特点，*指方法返回类型。
     */

    //* 在add前面表示任意返回类型，add(..)中的..指参数也任意
    @Pointcut("execution(* add(..))")
    private void addPointcut() {}

    //advice通知
    @Before(value = "addPointcut()")
    public void doSthBefore(){
        System.out.println("Before。。。");
    }

    //find*查找find开头的方法
    @Pointcut("execution(* find*(..))")
    private void findPointcut() {}

    //事后要做的事情
    @After(value = "findPointcut()")
    public void doSthAfter(){
        System.out.println("After。。。");
    }
}
