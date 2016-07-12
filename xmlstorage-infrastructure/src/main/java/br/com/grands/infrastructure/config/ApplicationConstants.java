package br.com.grands.infrastructure.config;

import gumga.framework.core.GumgaValues;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConstants implements GumgaValues {

    @Override
    public String getGumgaSecurityUrl() {
//        return "http://www.gumga.com.br/security-api/publicoperations";
        return "http://192.168.25.250/security-api/publicoperations";
    }

    @Override
    public boolean isLogActive() {
        return true;
    }

}
