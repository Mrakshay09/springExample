package com.netlink.servers.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Data
@ConfigurationProperties(prefix = "my.profile")
public class ProfileConfiguration {

    public String code;

    @Value("${spring.profiles.active}")
    private String profileName;

    @Bean
    @Profile("prod")
    @PostConstruct
    public String dataSourceConfig(){
        System.out.println(code+profileName);
        return "code";

    }

}
