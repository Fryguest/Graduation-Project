package com.wlmiao.realm;

import com.wlmiao.model.User;
import com.wlmiao.service.IUserService;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoAuthorizingRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService userService;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 根据用户ID查询角色（role），放入到Authorization里。
        Set<String> roles = userService.findRoleByUserId(shiroUser.getId());
        logger.debug("roles : {} ", roles);
        info.setRoles(roles);
        // 根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissions = userService.findPermissionByUserId(shiroUser.getId());
        logger.debug("permissions : {} ", permissions);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 认证回调函数,登录时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
        throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByUsername(token.getUsername());
        logger.debug("user login : {} , password : {} ", token.getUsername(), token.getPassword());
        if (null != user) {
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                new ShiroUser(user.getId(), user.getEmail()), user.getPswd(), null, getName());
            return authenticationInfo;
        } else {
            return null;
        }
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("SHA1");
        this.setCredentialsMatcher(credentialsMatcher);
    }

    /**
     * 清空当前用户权限信息
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
     */
    public static class ShiroUser implements Serializable {

        private static final long serialVersionUID = 776323789180895561L;

        private Long id;
        private String username;

        public ShiroUser(Long id, String username) {
            super();
            this.id = id;
            this.username = username;
        }

        public Long getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        /**
         * 本函数输出将作为默认的<shiro:principal/>输出.
         */
        @Override
        public String toString() {
            return username;
        }

        /**
         * 重载hashCode,只计算username;
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(username);
        }

        /**
         * 重载equals,只计算username;
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ShiroUser other = (ShiroUser) obj;
            if (username == null) {
                if (other.username != null) {
                    return false;
                }
            } else if (!username.equals(other.username)) {
                return false;
            }
            return true;
        }

    }

}
