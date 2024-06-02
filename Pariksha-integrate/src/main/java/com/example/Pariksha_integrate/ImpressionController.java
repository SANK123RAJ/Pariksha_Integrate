package com.example.Pariksha_integrate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImpressionController {

    @Autowired
    private ParikshaService parikshaService;

    @PostMapping("/save-impression")
    public String saveImpression( @RequestBody Map<String, String> request) {
        String sessionId = request.get("SessionId");
        String userId = request.get("userId");

        Map<String, String> properties = new HashMap<>();
        properties.put("userId", userId);
        properties.put("sessionId", sessionId);

        
       return parikshaService.isenabled(properties);
        
    }
}
