package com.czxy.service;

import com.czxy.dao.LogMapper;
import com.czxy.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 1519389876@qq.com
 * @version v 1.0
 * @date 2019/7/25  11:43
 * @infos
 */

@Service
@Transactional
public class LogService {
    @Autowired
    private LogMapper logMapper;
    public void add(Log log){
        logMapper.insert(log);
    }
}
