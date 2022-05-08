package com.muxi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author wenyong.yang
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class MuXiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MuXiApplication.class, args);
        log.info("(♥◠‿◠)  慕溪快速开发系统启动成功  (◠‿◠♥)");
    }
}