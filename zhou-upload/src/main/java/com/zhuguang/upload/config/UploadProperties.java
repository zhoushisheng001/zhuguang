package com.zhuguang.upload.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "zhou.upload")
public class UploadProperties {

    private String baseUrl;

    private List<String> suffixes;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<String> getSuffixes() {
        return suffixes;
    }

    public void setSuffixes(List<String> suffixes) {
        this.suffixes = suffixes;
    }
}
