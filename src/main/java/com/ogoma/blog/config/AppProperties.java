package com.ogoma.blog.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "ukweli-app")
public class AppProperties {
   private String  symmetricEncryptionSecret;
}
