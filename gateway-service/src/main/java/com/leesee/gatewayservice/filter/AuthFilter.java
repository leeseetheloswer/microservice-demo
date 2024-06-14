package com.leesee.gatewayservice.filter;

import com.leesee.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AuthFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        获取token
        String token = exchange.getRequest().getHeaders().getFirst("token");
        log.info("接收到的token为：{}",token);

//        if(token==null||!JWTUtils.verify(token)){
//            //响应http状态码
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return  exchange.getResponse().setComplete();
//
//        }
        return chain.filter(exchange);
    }
}
