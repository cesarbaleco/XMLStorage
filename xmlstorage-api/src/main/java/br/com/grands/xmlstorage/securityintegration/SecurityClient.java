package br.com.grands.xmlstorage.securityintegration;

import br.com.grands.infrastructure.config.ApplicationConstants;
import gumga.framework.core.GumgaThreadScope;
import gumga.framework.core.GumgaValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@Component
public class SecurityClient {

    @Autowired
    private  GumgaValues gumgaValues;

    private  Properties properties;

    private  Properties getProperties() {
        if(gumgaValues == null)
            gumgaValues = new ApplicationConstants();

        if(properties == null)
            properties = gumgaValues.getCustomFileProperties();

        return properties;
    }

    public ResponseEntity<Object> getOrganization(String id, String name) {
        String nameVar = name;
        if (nameVar == null) {
            nameVar = new String();
        }
        String url = getProperties().getProperty("security.url").concat("/security-api/api/organization?aq={aq}");

        String aq = "obj.name like '%" + nameVar + "%' and obj.hierarchyCode like '" + id + "%'";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("gumgaToken", GumgaThreadScope.gumgaToken.get());
        headers.set("Accept", "application/json, text/plain, */*");
        headers.set("Accept-Encoding", "gzip, deflate");
        headers.set("Content-Type", "application/json;charset=utf-8");

        HttpEntity requestEntity = new HttpEntity(headers);
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, Object.class, aq);
    }
}
