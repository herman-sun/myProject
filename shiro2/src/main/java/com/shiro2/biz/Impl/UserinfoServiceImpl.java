package com.shiro2.biz.Impl;

import com.shiro2.biz.UserinfoService;
import com.shiro2.entity.Userinfo;
import com.shiro2.mapper.UserinfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Resource
    private UserinfoMapper userinfoMapper;
    @Override
    public Userinfo findByUname(String uname) {
        return userinfoMapper.findByUname(uname);
    }
}
