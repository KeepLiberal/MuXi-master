package com.muxi.common.config.thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.muxi.common.utils.Threads;

/**
 * 线程池配置
 *
 * @author weny.yang
 **/
@Configuration //@Configuration包含@Component 1.标识当前类为配置类 2.将当前类注入容器
@EnableAsync //项目中使用 @Async的话，必须配合@EnableAsync(通知配置器开启异步)，@EnableAsync加在任何类上都行，只要主启动类能扫描到就行
public class ThreadPoolConfig {
    // 核心线程池大小
    private int corePoolSize = 100;
    // 最大可创建的线程数
    private int maxPoolSize = 200;
    // 队列最大长度
    private int queueCapacity = 100000;
    // 线程池维护线程所允许的空闲时间
    private int keepAliveSeconds = 300;

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize); //核心线程数
        executor.setMaxPoolSize(maxPoolSize);//最大线程数
        executor.setQueueCapacity(queueCapacity);//缓存队列
        executor.setKeepAliveSeconds(keepAliveSeconds);//允许的空闲时间
        executor.setThreadNamePrefix("myThread-");//设置线程名称前缀
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//设置拒绝策略
        executor.setWaitForTasksToCompleteOnShutdown(true);//等待所有任务结束后再关闭线程池
        return executor;
    }

    /**
     * 执行周期性或定时任务
     */
    @Bean(name = "scheduledExecutorService")
    protected ScheduledExecutorService scheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(corePoolSize,
                new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build(),
                new ThreadPoolExecutor.CallerRunsPolicy()) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                Threads.printException(r, t);
            }
        };
    }
}
