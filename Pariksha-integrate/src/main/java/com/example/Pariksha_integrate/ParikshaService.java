package com.example.Pariksha_integrate;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import io.getunleash.util.UnleashConfig;

@Service
public class ParikshaService {

    @Autowired
    private ImpressionRepository impressionRepository;
    private  Unleash unleash;

    public String isenabled(Map<String, String> properties){

         UnleashConfig config = UnleashConfig.builder()
                .appName("tryyy")
                .instanceId("your-instance-1")
                .unleashAPI("http://host.docker.internal:4242/api")
                .apiKey("*:production.ab60b27a26df04d174ef8dbc75f2a1d093536e21627a1c5dd1be4cc2")
                .synchronousFetchOnInitialisation(true)
                .build();

        unleash = new DefaultUnleash(config);

        // Map<String, String> properties = new HashMap<>();
        // properties.put("userId", "46");
        // properties.put("sessionId", "EMI");


        UnleashContext.Builder contextBuilder = UnleashContext.builder();
        String userId = properties.get("userId");
        properties.forEach(contextBuilder::addProperty);
        contextBuilder.userId(userId);
        contextBuilder.sessionId(properties.get("sessionId"));

        UnleashContext context = contextBuilder.build();
        boolean isEnabled = unleash.isEnabled("toggle1", context, true);
        saveImpression("toggle1", isEnabled, context, userId);
        if(isEnabled)
        return "This feature is enabled for user"+userId; 
        else
        return "This feature is NOT enabled for user"+userId;


        
    }

    public void saveImpression(String toggleName, boolean toggleState,UnleashContext context, String userId) {
        Impression impression = new Impression();
        impression.setEventtype("feature-toggle-check");
        impression.setTogglename(toggleName);
        impression.setTogglestate(toggleState);
        impression.setIdentifier(userId);
        impression.setContext(context.getProperties().toString());
        impression.setCreatedat(LocalDateTime.now());
        System.out.println(impression);
        impressionRepository.save(impression);
    }
}
