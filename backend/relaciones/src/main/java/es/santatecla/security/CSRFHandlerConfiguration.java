package es.santatecla.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class CSRFHandlerConfiguration implements WebMvcConfigurer {
    private static class CSRFHandlerInterceptor extends HandlerInterceptorAdapter {

        @Override
        public void postHandle(final HttpServletRequest request,
                               final HttpServletResponse response, final Object handler,
                               final ModelAndView modelAndView) {

            CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
            if (token != null) {
                modelAndView.addObject("token", token.getToken());
            }
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CSRFHandlerInterceptor());
    }
}