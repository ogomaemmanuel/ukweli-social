package com.ogoma.blog.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "ukweli-app")
public class AppProperties {
   private String  symmetricEncryptionSecret;
}
