package com.streamtoolbox.klask.controller;

import com.streamtoolbox.klask.game.GameState;
import com.streamtoolbox.klask.stamp.StampClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = KlaskAppConfiguration.class)
@PropertySource("classpath:application.properties")
public class KlaskAppConfiguration {

    @Bean
    public GameState gameSettings(@Autowired SimpMessagingTemplate simpMessagingTemplate) {
        return new GameState(stampClient(), simpMessagingTemplate);
    }

    @Bean
    public StampClient stampClient() {
        return new StampClient();
    }
}
