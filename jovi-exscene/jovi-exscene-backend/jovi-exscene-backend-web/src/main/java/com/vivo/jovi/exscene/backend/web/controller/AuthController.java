package com.vivo.jovi.exscene.backend.web.controller;

import com.vivo.internet.privilege.client.service.MobileSSOService;
import com.vivo.internet.privilege.client.service.OAServiceExt;
import com.vivo.internet.privilege.client.util.SSOUtil;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.util.Map;

@Controller
public class AuthController implements InitializingBean{

    @Override
    public void afterPropertiesSet() throws Exception {
        System.setProperty("aes.key", VivoConfigManager.get("aes.key","mg2mdeQAuNLRTeg8"));
        System.setProperty("aes.iv", VivoConfigManager.get("aes.iv","3256580422935278"));
    }

    @Autowired
    private ApplicationContext applicationContext;


    @RequestMapping(value = "/index")
    public String index(Map<String,Object> model){
        return "auth/index";
    }


    /**
     * 无权限跳转页面
     * @return
     */
    @RequestMapping("/forbidden")
    public String forbidden() {
        return "auth/forbidden";
    }

//    //旧方法
//    @RequestMapping(value = "/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response){
//
//        String token = SSOUtil.getCookieValue(request, SSOUtil.COOKIE_KEY_TOKEN);
//        if (token != null) {
//            request.getSession(false).invalidate();
//            SSOUtil.clearCookie(response, SSOUtil.COOKIE_KEY_TOKEN);
//            String logoutUrl = applicationContext.getBean(OAServiceExt.class).getLoginOutUrl(request, "/index");
//            return "redirect:" + logoutUrl;
//        }
//
//        String mtoken = SSOUtil.getCookieValue(request, SSOUtil.COOKIE_KEY_MTOKEN);
//        if (mtoken != null) {
//            request.getSession(false).invalidate();
//
//            String logoutUrl = applicationContext.getBean(MobileSSOService.class).getLoginOutUrl(request, "/index");
//            return "redirect:" + logoutUrl;
//        }
//        if (request.getSession(false) != null)
//        {
//            request.getSession(false).invalidate();
//        }
//
//        return "redirect:/index";
//    }

//    //新方法
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws MalformedURLException {
        ServletContext servletContext = request.getSession().getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");

        String token = SSOUtil.getCookieValue(request, SSOUtil.COOKIE_KEY_TOKEN);
        if (token != null) {
            request.getSession(false).invalidate();
            SSOUtil.clearCookie(response, SSOUtil.COOKIE_KEY_TOKEN, SSOUtil.getSecondDomain(request));

            String logoutUrl = applicationContext.getBean(OAServiceExt.class).getLoginOutUrl(request, "/index");
            return "redirect:" + logoutUrl;
        }

        String mtoken = SSOUtil.getCookieValue(request, SSOUtil.COOKIE_KEY_MTOKEN);
        if (mtoken != null) {
            request.getSession(false).invalidate();

            String logoutUrl = applicationContext.getBean(MobileSSOService.class).getLoginOutUrl(request, "/index");
            return "redirect:" + logoutUrl;
        }

        return "redirect:/index";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "auth/welcome";
    }


}
