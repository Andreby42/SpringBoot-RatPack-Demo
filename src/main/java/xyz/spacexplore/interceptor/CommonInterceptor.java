package xyz.spacexplore.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;



@Component
@Slf4j
public class CommonInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        log.debug("pre get {} request", webRequest.getSessionId());
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        log.debug("postHandle {} request", webRequest.getSessionId());
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
        log.debug("afterCompletion   {} request", webRequest.getSessionId());
    }
}
