package com.example.jikan.anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jikan.anime.model.Character;

@RestController
@RequestMapping("/character") // Define a base URL for character-related endpoints
public class CharacterController {

    @Autowired
    private JikanService jikanService;

    @GetMapping("/{characterName}")
    public Character getCharacterDetails(@PathVariable String characterName) {
        // Call the JikanService to fetch character details
        return jikanService.getCharacterDetails(characterName);
    }
}
