package xyz.spacexplore.ratpack.handlers;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Component;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Context;

import java.util.List;

@Component
public class NacosHandler implements Action<Chain> {
    @NacosInjected
    private NamingService namingService;


    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("nacos/get", this::get);
    }

    private void get(Context context) throws NacosException {
        final String name = context.getRequest().getQueryParams().getOrDefault("serviceName", "");
        final List<Instance> message = namingService.getAllInstances(name);
        //Content-Type: text/html; charset=utf-8
        context.getResponse().getHeaders().add("Content-Type", "text/html; charset=utf-8");
        context.getResponse().status(200);
        //TODO:json convert
        context.render("Hello ");
    }
}
