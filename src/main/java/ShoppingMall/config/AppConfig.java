package ShoppingMall.config;

import java.io.File;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
@Configuration
@ComponentScan(basePackages="ShoppingMall")
@EnableWebMvc
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@MapperScan("ShoppingMall.Dao.mapper")
public class AppConfig extends WebMvcConfigurerAdapter {

	//映射jsp
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
           registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
	@Bean
	public DataSource dataSource(Environment env){
		String url = env.getProperty("jdbc.url");
		String username = env.getProperty("jdbc.username");
		String password = env.getProperty("jdbc.password");
		String driverClass = env.getProperty("jdbc.driver");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}

	@Bean
	public JdbcTemplate template(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	//映射public
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
		registry.addResourceHandler("/user-picture/**").addResourceLocations("file:///E:/upload/");
		registry.addResourceHandler("/pro-picture/**").addResourceLocations("file:///E:/sellerUpload/");
	}
	//配置mybatis
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sf.setDataSource(dataSource);
		return sf;
		}
    
	@Bean
	public MultipartResolver multipartResolver() { // 文件名必须要这么写，因为spring mvc会用这个id查找多部解析器
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxUploadSize(10 * 1024 * 1024); // 字节
		return mr;
	}
	
	//事务
     @Bean
     public PlatformTransactionManager transactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
     }
     
     @Bean
     public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
     }
     	
     //支付宝支付
     @Bean
     	public AlipayClient alipayClient() throws IOException {
     		// https://docs.open.alipay.com/270/105899/
     		return new DefaultAlipayClient(
     				"https://openapi.alipay.com/gateway.do",
     				"2018052360246120",
     				FileUtils.readFileToString(new File("D:/alipay/app-prikey.txt"), "UTF-8"),
     				"json", "UTF-8",
     			FileUtils.readFileToString(new File("D:/alipay/alipay-pubkey.txt"), "UTF-8"),
     				"RSA2"
     				);
     	}
}

