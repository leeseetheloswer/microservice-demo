package com.leesee.gatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取token
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        System.out.println(token);
        if(!token.equals("1")){
            //响应http状态码
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return  exchange.getResponse().setComplete();

        }
        return chain.filter(exchange);
    }
}
