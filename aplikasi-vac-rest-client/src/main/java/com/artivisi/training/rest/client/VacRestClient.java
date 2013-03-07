/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.rest.client;

import com.artivisi.training.rest.domain.Role;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author endy
 */
public class VacRestClient {
    private String serverUrl = "http://localhost:8080/aplikasi-vac-rest-server/rest/role";
    private RestTemplate restTemplate = new RestTemplate();
    
    public List<Role> semuaRole(){
        ParameterizedTypeReference<List<Role>> roleType
                = new ParameterizedTypeReference<List<Role>>() {};
        List<Role> hasil = restTemplate
                .exchange(serverUrl, HttpMethod.GET, HttpEntity.EMPTY, roleType)
                .getBody();
        return hasil;
    }
    
    public Role cariRoleById(Integer id){
        return restTemplate.getForObject(serverUrl+"/"+id, Role.class);
    }
}
