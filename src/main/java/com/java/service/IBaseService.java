package com.java.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//服务层通用接口类
public interface IBaseService<T> {
    //增加
    boolean add(T t) throws SQLException;
    //修改
    boolean update(T t) throws SQLException;
    //删除
    boolean delete(T t) throws SQLException;
    //查找
    T findById(int id) throws SQLException;
    //模糊查询
    List<T> findByProp(Map map) throws SQLException;
}
