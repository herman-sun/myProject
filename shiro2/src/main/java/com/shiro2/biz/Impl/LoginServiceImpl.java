package com.shiro2.biz.Impl;

import com.shiro2.biz.LoginService;
import com.shiro2.entity.Tree;
import com.shiro2.mapper.TreeMapper;
import com.shiro2.mapper.UserinfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    TreeMapper treeMapper;

    @Override
    public List getAllTrees() {
        List<Tree> trees = treeMapper.selectByExample(null);
        return trees;
    }
}
