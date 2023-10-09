package com.javafourthminiassignment.bestpricefinder.webclient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

    @Value("http://localhost:8081/backendserver1/dealItems")
    private String amazonServerApi;

    @Value("http://localhost:8082/backendserver2/dealItems")
    private String ebayServerApi;

    @Value("http://localhost:8083/backendserver3/dealItems")
    private String walmartServerApi;

    @Value("2000")
    private int api1ConnectionTimeout;

    @Value("2000")
    private int api1ReadTimeout;

    @Value("2000")
    private int api1WriteTimeout;

    @Value("1000")
    private int api2ConnectionTimeout;

    @Value("1000")
    private int api2ReadTimeout;

    @Value("1000")
    private int api2WriteTimeout;

    @Value("1000")
    private int api3ConnectionTimeout;

    @Value("1000")
    private int api3ReadTimeout;

    @Value("1000")
    private int api3WriteTimeout;

    @Bean("amazonWebClient")
    public WebClient webClientForApi1() {
        return WebClient.builder()
                .baseUrl(amazonServerApi)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection()
                        .compress(true)
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, api1ConnectionTimeout)
                        .responseTimeout(Duration.ofMillis(api1ReadTimeout))
                        .doOnConnected(conn ->
                                conn.addHandlerLast(new ReadTimeoutHandler(api1ReadTimeout, TimeUnit.MILLISECONDS))
                                        .addHandlerLast(new WriteTimeoutHandler(api1WriteTimeout, TimeUnit.MILLISECONDS)))))
                .build();
    }

    @Bean("ebayWebClient")
    public WebClient webClientForApi2() {
        // Similar configuration for API2 with different timeouts
    	return WebClient.builder()
                .baseUrl(ebayServerApi)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection()
                        .compress(true)
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, api2ConnectionTimeout)
                        .responseTimeout(Duration.ofMillis(api2ReadTimeout))
                        .doOnConnected(conn ->
                                conn.addHandlerLast(new ReadTimeoutHandler(api2ReadTimeout, TimeUnit.MILLISECONDS))
                                        .addHandlerLast(new WriteTimeoutHandler(api2WriteTimeout, TimeUnit.MILLISECONDS)))))
                .build();
    }

    @Bean("walmartWebClient")
    public WebClient webClientForApi3() {
        // Similar configuration for API3 with different timeouts
    	return WebClient.builder()
                .baseUrl(walmartServerApi)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection()
                        .compress(true)
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, api3ConnectionTimeout)
                        .responseTimeout(Duration.ofMillis(api3ReadTimeout))
                        .doOnConnected(conn ->
                                conn.addHandlerLast(new ReadTimeoutHandler(api3ReadTimeout, TimeUnit.MILLISECONDS))
                                        .addHandlerLast(new WriteTimeoutHandler(api3WriteTimeout, TimeUnit.MILLISECONDS)))))
                .build();
    }
}

