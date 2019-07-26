package com.czxy.service;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Table;
import java.util.List;

/**
 * @author 1519389876@qq.com
 * @version v 1.0
 * @date 2019/7/25  10:49
 * @infos
 */

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User login(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        criteria.andEqualTo("password",user.getPassword());
        List<User> users = userMapper.selectByExample(example);
        if (users.size()==0){
            return null;
        }
       return users.get(0);
    }
}
