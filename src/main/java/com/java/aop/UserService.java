package com.java.aop;

import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    public void add(){
        System.out.println(this.getClass().getSimpleName()+":add");
    }
    public void add(int i){
        System.out.println(this.getClass().getSimpleName()+":"+i);
    }
    public void findById(){
        System.out.println(this.getClass().getSimpleName()+"findById");
    }
    public void findByProp(){
        System.out.println(this.getClass().getSimpleName()+":findByProp");
    }
    public void findByName(){
        System.out.println(this.getClass().getSimpleName()+":findByName");
    }
}
