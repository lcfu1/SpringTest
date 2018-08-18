package com.java.dao.impl;

import com.java.dao.Db;
import com.java.dao.IBaseDao;
import com.java.dto.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//持久层的实现
@Repository
public class UserDaoImpl implements IBaseDao<User> {
//    获取连接
    Connection conn= Db.getConn();
//    处理类
    PreparedStatement ps;
//    记录集类
    ResultSet rs;

//    增加
    @Override
    public boolean add(User user) throws SQLException {
//        定义要执行的sql语句
        String sql="INSERT INTO user (username,password) VALUE(?,?)";
//        在连接基础上创建执行
        ps=conn.prepareStatement(sql);
//        植入参数
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
//        执行更新操作，并返回受影响的记录数
        int i=ps.executeUpdate();
//        将返回的整型值处理成要返回的逻辑值
        return i>0?true:false;
    }

//    修改
    @Override
    public boolean update(User user) throws SQLException {
        String sql="UPDATE user SET username=?,password=? WHERE id=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setInt(3,user.getId());
        int i=ps.executeUpdate();
        return i>0?true:false;
    }

//    删除
    @Override
    public boolean delete(User user) throws SQLException {
        String sql="DELETE FROM user WHERE id=?";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,user.getId());
        int i=ps.executeUpdate();
        return i>0?true:false;
    }

//    根据id查找
    @Override
    public User findById(int id) throws SQLException {
        User user=null;
        String sql="SELECT * FROM user WHERE id=?";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,id);
        rs=ps.executeQuery();
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }

//    模糊查询
    @Override
    public List<User> findByProp(Map map) throws SQLException {
        List<User> userList=new ArrayList<User>();
        String sql="SELECT * FROM user WHERE id LIKE '%"+map.get("id")+"%'";
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            userList.add(user);
        }
        return userList;
    }
}
