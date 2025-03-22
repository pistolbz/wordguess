package com.nhom8.wordguess.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Cấu hình WebSocket cho game
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${app.cors.allowed-origins:http://localhost:*,http://127.0.0.1:*}")
    private String[] allowedOrigins;

    @SuppressWarnings("null")
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Cấu hình prefix cho các điểm đầu cuối gửi tin nhắn
        config.enableSimpleBroker("/topic");
        // Cấu hình prefix cho các điểm đầu cuối nhận tin nhắn
        config.setApplicationDestinationPrefixes("/app");
    }

@SuppressWarnings("null")
@Override
public void registerStompEndpoints(StompEndpointRegistry registry) {
    // Đăng ký endpoint WebSocket với STOMP
    registry.addEndpoint("/ws-wordguess")
            .setAllowedOriginPatterns(allowedOrigins)
            .withSockJS();
}
}