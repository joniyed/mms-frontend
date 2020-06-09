package bd.edu.seu.messmanagementsystemfrontend.service;import bd.edu.seu.messmanagementsystemfrontend.exceptions.ResourceNotFoundException;import bd.edu.seu.messmanagementsystemfrontend.model.LoginInformation;import org.springframework.beans.factory.annotation.Value;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Service;import org.springframework.web.client.HttpClientErrorException;import org.springframework.web.client.RestTemplate;@Servicepublic class LoginService {    @Value("${BASE_URL}")    String baseUrl;    private RestTemplate restTemplate;    public LoginService() {        restTemplate = new RestTemplate();    }    public String getToken(String userName,String passWord) {        try {            ResponseEntity<LoginInformation> entity = restTemplate.getForEntity(baseUrl + "/login/" + userName, LoginInformation.class);            LoginInformation body = entity.getBody();            assert body != null;            if (body.getPassword().equals(passWord)) return body.getRole().toString();            else return "Unknown";        }catch (HttpClientErrorException e){            return e.getStatusCode()+" ----   invalid username or password";        }    }    public LoginInformation getLoginInformation(String userName) throws ResourceNotFoundException {        try {            ResponseEntity<LoginInformation> entity = restTemplate.getForEntity(baseUrl + "/login/" + userName, LoginInformation.class);            LoginInformation body = entity.getBody();            assert body != null;            return body;        }catch (HttpClientErrorException e){           throw new ResourceNotFoundException("not found");        }    }}