package com.ogoma.blog.config;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppPropertiesHolder {
    private final AppProperties appProperties;

    private static AppProperties properties;

    @PostConstruct
    private void init() {
        makeAvailable(this.appProperties);
    }

    private static void makeAvailable(AppProperties properties) {
        AppPropertiesHolder.properties = properties;
    }

    public static AppProperties getAppProperties() {
        return AppPropertiesHolder.properties;
    }


}
