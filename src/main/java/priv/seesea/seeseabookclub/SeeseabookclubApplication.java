package priv.seesea.seeseabookclub;

import javax.sql.DataSource;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("priv.seesea.seeseabookclub.mapper")
@ServletComponentScan
//缓存注解
@EnableCaching
//使用定时器
@EnableScheduling
public class SeeseabookclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeeseabookclubApplication.class, args);
	}
}
