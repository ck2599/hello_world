package com.czxy.dao;

import com.czxy.domain.Log;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 1519389876@qq.com
 * @version v 1.0
 * @date 2019/7/25  11:42
 * @infos
 */

@org.apache.ibatis.annotations.Mapper
@Repository
public interface LogMapper  extends Mapper<Log> {
}
