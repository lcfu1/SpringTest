package com.java.service.impl;

import com.java.dto.User;
import com.java.dao.impl.UserDaoImpl;
import com.java.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//服务层实现
@Service
public class UserServiceImpl implements IBaseService<User>{
//    持久层对象
//    @Autowired
    UserDaoImpl udi;

//    public void setUdi(UserDaoImpl udi) {
//        this.udi = udi;
//    }

    @Override
    public boolean add(User user) throws SQLException {
        return udi.add(user);
    }

    @Override
    public boolean update(User user) throws SQLException {
        return udi.update(user);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        return udi.delete(user);
    }

    @Override
    public User findById(int id) throws SQLException {
        return udi.findById(id);
    }

    @Override
    public List<User> findByProp(Map map) throws SQLException {
        return udi.findByProp(map);
    }
}
