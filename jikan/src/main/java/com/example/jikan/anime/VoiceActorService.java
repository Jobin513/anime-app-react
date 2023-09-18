package com.example.jikan.anime;

import com.example.jikan.anime.model.VoiceActor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VoiceActorService {
    private final String JIKAN_API_BASE_URL = "https://api.jikan.moe/v4";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public VoiceActorService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public VoiceActor.Data[] getVoiceActorDetails(int voiceActorId) {
        String apiUrl = JIKAN_API_BASE_URL + "/people/" + voiceActorId + "/voices";
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

        try {
            VoiceActor response = objectMapper.readValue(jsonResponse, VoiceActor.class);
            return response.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
