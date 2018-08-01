package com.storm.security;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    /**
     * 
     */
    private static final long serialVersionUID = -792062895318875737L;
    
    private String authorityMethod;
    
    private String authorityUrl;

    public String getAuthorityMethod() {
        return authorityMethod;
    }

    public void setAuthorityMethod(String authorityMethod) {
        this.authorityMethod = authorityMethod;
    }

    public String getAuthorityUrl() {
        return authorityUrl;
    }

    public void setAuthorityUrl(String authorityUrl) {
        this.authorityUrl = authorityUrl;
    }
    public CustomGrantedAuthority(){
        
    }
    public CustomGrantedAuthority (String authorityUrl,String authorityMethod) {
        this.authorityMethod = authorityMethod;
        this.authorityUrl = authorityUrl;
    }
    @Override
    public String getAuthority() {
        return authorityUrl+ ";"+authorityMethod;
    }

}
