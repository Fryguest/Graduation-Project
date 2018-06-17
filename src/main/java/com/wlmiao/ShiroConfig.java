package com.wlmiao;

import com.wlmiao.realm.DemoAuthorizingRealm;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    /**
     * shiroFilter
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setSuccessUrl("/index");
        shiroFilter.setUnauthorizedUrl("/forbiddenFront");

        Map<String, String> filterChainDefinitionMapping = new HashMap<String, String>();
        filterChainDefinitionMapping.put("/static/**", "anon");
        filterChainDefinitionMapping.put("/student*", "roles[\"student\"]");
        filterChainDefinitionMapping.put("/manager*", "roles[\"manager\"]");
        filterChainDefinitionMapping.put("/teacher*", "roles[\"teacher\"]");
        filterChainDefinitionMapping.put("/*", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);

        shiroFilter.setSecurityManager(securityManager);

        Map<String, Filter> filters = new HashMap<String, Filter>();
        filters.put("anon", new AnonymousFilter());
        filters.put("authc", new FormAuthenticationFilter());
        filters.put("logout", new LogoutFilter());
        filters.put("roles", new RolesAuthorizationFilter());
        filters.put("user", new UserFilter());
        shiroFilter.setFilters(filters);
        return shiroFilter;
    }

    /**
     * 注册自定义的Realm
     */
    @Bean(name = "realm")
    public DemoAuthorizingRealm realm() {
        DemoAuthorizingRealm realm = new DemoAuthorizingRealm();
        return realm;
    }

    /**
     * 注册权限的缓存
     */
    @Bean(name = "shiroEhCacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:shiro/ehcache-shiro.xml");
        return em;
    }

    /**
     * 声明SecurityManager
     *
     * @param realm cacheManager
     */
    @Bean(name = "securityManager")
    public SecurityManager securityManager(@Qualifier("realm") AuthorizingRealm realm,
        @Qualifier("shiroEhCacheManager") CacheManager cacheManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        manager.setCacheManager(cacheManager);
        return manager;
    }

    /**
     * 保证实现了shiro内部lifecycle函数的bean执行
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启shiro,首先创建代理
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    /**
     * 再加载securityManager
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
        @Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
}
