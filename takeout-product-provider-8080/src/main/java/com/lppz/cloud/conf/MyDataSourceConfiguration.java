package com.lppz.cloud.conf;

import com.alibaba.druid.DbType;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyDataSourceConfiguration {//@Configuration +@Bean  等同于 xml配置文件
    @Autowired
    WallFilter wallFilter;
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){//注入自定义的数据源
        DruidDataSource dataSource= new DruidDataSource();
        dataSource.getProxyFilters().add(wallFilter);//如果要用Druid的防火墙控制，就要为他的代理ProxyFilters为DataSource的filters赋值
        return dataSource;
    }
    @Bean(name = "wallConfig")
    WallConfig wallFilterConfig() {
        WallConfig wc = new WallConfig();
        wc.setMultiStatementAllow(true);//是否允许一次执行多条语句，缺省关闭
        wc.setTruncateAllow(false);//truncate语句是危险，缺省打开，若需要自行关闭
        wc.setDeleteWhereAlwayTrueCheck(true);//检查DELETE语句的WHERE子句是否是一个永真条件
        wc.setDeleteWhereNoneCheck(true);//检查DELETE语句是否无where条件，这是有风险的，但不是SQL注入类型的风险
        wc.setUpdateWhereAlayTrueCheck(true);//检查UPDATE语句的WHERE子句是否是一个永真条件
        wc.setUpdateWhereNoneCheck(true);//检查UPDATE语句是否无where条件，这是有风险的，但不是SQL注入类型的风险
        return wc;
    }

    @Bean(name = "wallFilter")
    @DependsOn("wallConfig")
    WallFilter wallFilter(WallConfig wallConfig) {
        WallFilter wfilter = new WallFilter();
        wfilter.setConfig(wallConfig);
        wfilter.setDbType(DbType.mysql);
        return wfilter;
    }
    //配置Druid的监控
    //1、配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParms=new HashMap<>();
        initParms.put("loginUsername","ls");
        initParms.put("loginPassword","123456");
//        initParms.put("allow","*");//允许访问的域名，默认是全部允许
        bean.setInitParameters(initParms);
        return bean;
    }
    //2、配置web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean(new WebStatFilter());
        Map<String,String> initParms=new HashMap<>();
        initParms.put("exclusions","/druid/*,*.js,*.css,*.html");//不拦截的请求
        bean.setInitParameters(initParms);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
