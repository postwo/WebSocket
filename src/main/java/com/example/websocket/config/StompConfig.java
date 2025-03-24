package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");                   // @MessageMapping 를 이용해서 메시지 수신할 destination prefix
        config.enableSimpleBroker("/topic", "/queue");      // 위 목적 외 destination prefix
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/helloworld");                    // websocket
        registry.addEndpoint("/helloworld").withSockJS();       // sockjs

        //const stompClient = new StompJs.Client({
        //    brokerURL: 'ws://localhost:8080/helloworld'
        //});
        //app.js 에 있는 이부분에 helloworld이거하고 .addEndpoint("/helloworld"). 이게 똑같아야 한다 
    }

}
