package com.example.jikan.anime;

import com.example.jikan.anime.model.CharacterVoices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class CharacterVoiceService {
    private final String JIKAN_API_BASE_URL = "https://api.jikan.moe/v4";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CharacterVoiceService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<CharacterVoices.Data> getCharacterVoiceDetails(int characterId) {
        String apiUrl = JIKAN_API_BASE_URL + "/characters/" + characterId + "/voices";

        try {
            String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
            CharacterVoices response = objectMapper.readValue(jsonResponse, CharacterVoices.class);
            return response.getData();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
