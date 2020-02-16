package com.mydataway.api.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sneaker on 2017/4/20.
 */
@ConfigurationProperties(prefix = GatewayProperties.PREFIX)
public class GatewayProperties {

    public static final String PREFIX = "gateway";
    /**
     * 需要检查token的url地址集合
     */
    private Set<String> checkTokenIncludeUrls = new HashSet<>();
    /**
     * 不需要检查token的url地址集合
     */
    private Set<String> checkTokenExcludeUrls = new HashSet<>();
    /**
     * check token服务地址
     */
    private String checkTokenService;

    /**
     *
     */
    private Set<String> checkAppKeyIncludeUrls = new HashSet<>();

    /**
     *
     */
    private Set<String> checkAppKeyExcludeUrls = new HashSet<>();

    /**
     * check appKey服务地址
     */
    private String checkAppKeyService;

    public String getCheckTokenService() {
        return checkTokenService;
    }

    public void setCheckTokenService(String checkTokenService) {
        this.checkTokenService = checkTokenService;
    }

    public Set<String> getCheckTokenIncludeUrls() {
        return checkTokenIncludeUrls;
    }

    public void setCheckTokenIncludeUrls(Set<String> checkTokenIncludeUrls) {
        this.checkTokenIncludeUrls = checkTokenIncludeUrls;
    }

    public Set<String> getCheckTokenExcludeUrls() {
        return checkTokenExcludeUrls;
    }

    public void setCheckTokenExcludeUrls(Set<String> checkTokenExcludeUrls) {
        this.checkTokenExcludeUrls = checkTokenExcludeUrls;
    }

    public Set<String> getCheckAppKeyIncludeUrls() {
        return checkAppKeyIncludeUrls;
    }

    public void setCheckAppKeyIncludeUrls(Set<String> checkAppKeyIncludeUrls) {
        this.checkAppKeyIncludeUrls = checkAppKeyIncludeUrls;
    }

    public Set<String> getCheckAppKeyExcludeUrls() {
        return checkAppKeyExcludeUrls;
    }

    public void setCheckAppKeyExcludeUrls(Set<String> checkAppKeyExcludeUrls) {
        this.checkAppKeyExcludeUrls = checkAppKeyExcludeUrls;
    }

    public String getCheckAppKeyService() {
        return checkAppKeyService;
    }

    public void setCheckAppKeyService(String checkAppKeyService) {
        this.checkAppKeyService = checkAppKeyService;
    }
}
