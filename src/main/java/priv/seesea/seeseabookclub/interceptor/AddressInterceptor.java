package priv.seesea.seeseabookclub.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.model.pojo.Address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -06 -下午 7:04
 */


public class AddressInterceptor extends BizLogger implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        logger.debug("拦截开始");
        logger.debug("addressvalue:"+request.getParameter("address").toString());
        Address address = new Address();
        String ad[] = request.getParameter("address").toString().split("-");
        address.setAddressUserId(ad[0].toString());
        address.setAddressProvince(ad[1]);
        address.setAddressCity(ad[2]);
        address.setAddressArea(ad[3]);



        return true;
    }

}
