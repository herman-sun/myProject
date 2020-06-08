package com.shiro2.biz;

import com.shiro2.entity.Userinfo;

public interface UserinfoService {
    Userinfo findByUname(String uname);
}
