package com.shiro2.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiro2.entity.Tree;
import com.shiro2.entity.Userinfo;
import com.shiro2.mapper.UserinfoMapper;
import lombok.SneakyThrows;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MyRealm extends AuthorizingRealm {
    private Object Exception;

    @Resource
    private UserinfoMapper userinfoMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String uname = principalCollection.getPrimaryPrincipal().toString();
        Set set = new HashSet<>();
        System.out.println("授权过程中的" + uname);
        List<String> list = new ArrayList<>();
        list.add("Watcher");
        list.add("master");
        List<String> permission = new ArrayList<>();
        permission.add("Watcher:*");
        permission.add("master:a");
        permission.add("sb:control");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(list);
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String uname = authenticationToken.getPrincipal().toString();
        Userinfo userinfo = userinfoMapper.findByUname(uname);
        if (userinfo == null) {
            throw new UnknownAccountException();
        }
        String pwd = userinfo.getUpass();
        Tree tree = new Tree();
        tree.setId(99999);
        tree.setName("注销");
        tree.setFile("/admin/logout");
        List trees = userinfo.getTrees();
        trees.add(tree);

        /*
        获取Request然后得到session对页面传值
         */
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(trees);
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        request.getSession().setAttribute("json",json);


        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(uname,pwd,getName());


        return sai;
    }


}
