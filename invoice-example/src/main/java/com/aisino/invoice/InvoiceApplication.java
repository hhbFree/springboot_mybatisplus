package com.aisino.invoice;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 类描述：
 *
 * @Auther: hbHao
 * @ClassName InvoiceApplication
 * @Date: 2019/5/10 13:55
 * @Version 1.0
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan(basePackages = {"com.aisino.invoice.dao"})
@EnableTransactionManagement//开启事务
public class InvoiceApplication {
    /**
     * 启动方法
     */
    public static void main(String[] args) {
        SpringApplication.run(InvoiceApplication.class,args);
    }
}
