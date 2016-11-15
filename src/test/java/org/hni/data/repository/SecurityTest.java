package org.hni.data.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hni.data.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testUnauthenticatedAccess() {
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        response = restTemplate.getForEntity("/h2-console", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        response = restTemplate.getForEntity("/liquibase", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testNoAccessCodeAccess() {
        ResponseEntity<String> response = restTemplate.getForEntity("/users", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void testValidToken() throws IOException {
        ResponseEntity<String> response = restTemplate.withBasicAuth("trusted-app", "secret").postForEntity("/oauth/token?grant_type=password&username=superuser@hni.com&password=password", null, String.class);
        String responseText = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Map jwtMap = new ObjectMapper().readValue(responseText, HashMap.class);
        String accessToken = (String) jwtMap.get("access_token");
        assertNotNull(accessToken);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        ResponseEntity<User> userResponse = restTemplate.exchange("/users/1", HttpMethod.GET, new HttpEntity<>(null, headers), User.class);
        assertEquals(HttpStatus.OK, userResponse.getStatusCode());
        assertEquals("superuser@hni.com", userResponse.getBody().getEmail());
    }


}
