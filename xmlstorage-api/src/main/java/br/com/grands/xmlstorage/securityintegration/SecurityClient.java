package br.com.grands.xmlstorage.securityintegration;

import gumga.framework.core.GumgaThreadScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SecurityClient {

    public ResponseEntity<Object> getOrganization(String id, String name) {
        String nameVar = name;
        if (nameVar == null) {
            nameVar = new String();
        }
        String url = "http://192.168.25.250/security-api/api/organization?aq={aq}";

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
