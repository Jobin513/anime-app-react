package com.example.jikan.anime;
import com.example.jikan.anime.model.Character;
import com.example.jikan.anime.model.Anime;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JikanService {
    private final String JIKAN_API_BASE_URL = "https://api.jikan.moe/v4/characters?&q=";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public JikanService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public Character getCharacterDetails(String characterName) {
        String apiUrl = JIKAN_API_BASE_URL + characterName + "&sort=asc";
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

        try {
            // Deserialize the JSON into the Character object
            Character character = objectMapper.readValue(jsonResponse, Character.class);

            // Check if the character is not null
            if (character != null) {
                return character; // Return the Character object
            } else {
                return null; // Character not found or invalid response
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
