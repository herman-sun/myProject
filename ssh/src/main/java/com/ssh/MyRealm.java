package com.ssh;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {
    private Object Exception;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String uname = principalCollection.getPrimaryPrincipal().toString();
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

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String uname = authenticationToken.getPrincipal().toString();
        String pwd = getUser(uname);
        if (pwd==null) {
            throw new UnknownAccountException();
        }



        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(uname,pwd,getName());
        return sai;
    }

    public String getUser(String uname) {
        if (uname.equals("aaa")) {
            return "bbb";
        } else {
            return null;
        }
    }
}
