package priv.seesea.seeseabookclub.configuer;/**
 * @author http://blog.csdn.net/thewaiting
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import priv.seesea.seeseabookclub.interceptor.AddressInterceptor;
import priv.seesea.seeseabookclub.interceptor.CrossDomain;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 04 -29 -下午 3:55
 */
@Configuration
public class WebAppConfiguer extends WebMvcConfigurationSupport {

    // addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
    // excludePathPatterns 用户排除拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CrossDomain()).addPathPatterns("/**");
//        registry.addInterceptor(new AddressInterceptor()).addPathPatterns("/user/postUser");

        super.addInterceptors(registry);
    }

    @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true);
    }
}
