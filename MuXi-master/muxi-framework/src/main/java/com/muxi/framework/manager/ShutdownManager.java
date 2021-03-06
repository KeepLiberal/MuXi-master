package com.muxi.framework.manager;

import com.muxi.framework.shiro.web.session.SpringSessionValidationScheduler;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * 确保应用退出时能关闭后台线程
 *
 * @author wenyong.yang
 */
@Component
@Slf4j
public class ShutdownManager {

    @Autowired(required = false)
    private SpringSessionValidationScheduler springSessionValidationScheduler;

    @Autowired(required = false)
    private EhCacheManager ehCacheManager;

    @PreDestroy
    public void destroy() {
        shutdownSpringSessionValidationScheduler();
        shutdownAsyncManager();
        shutdownEhCacheManager();
    }

    /**
     * 停止Seesion会话检查
     */
    private void shutdownSpringSessionValidationScheduler() {
        if (springSessionValidationScheduler != null && springSessionValidationScheduler.isEnabled()) {
            try {
                log.info("====关闭会话验证任务====");
                springSessionValidationScheduler.disableSessionValidation();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 停止异步执行任务
     */
    private void shutdownAsyncManager() {
        try {
            log.info("====关闭后台任务任务线程池====");
            AsyncManager.me().shutdown();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void shutdownEhCacheManager() {
        try {
            log.info("====关闭缓存====");
            if (ehCacheManager != null) {
                CacheManager cacheManager = ehCacheManager.getCacheManager();
                cacheManager.shutdown();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
