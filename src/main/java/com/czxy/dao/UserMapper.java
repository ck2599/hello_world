package com.czxy.dao;

import com.czxy.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 1519389876@qq.com
 * @version v 1.0
 * @date 2019/7/25  10:49
 * @infos
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User> {
}
