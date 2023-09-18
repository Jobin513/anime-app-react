package com.example.jikan.anime;

import com.example.jikan.anime.model.Character;
import com.example.jikan.anime.model.CharacterVoices;
import com.example.jikan.anime.model.VoiceActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/charactervoices")
public class CharacterVoicesController {

    @Autowired
    private CharacterVoiceService characterVoiceService;

    @GetMapping("/{characterid}")
    public List<CharacterVoices.Data> getCharacterVoiceDetails(@PathVariable int characterid) {
        return characterVoiceService.getCharacterVoiceDetails(characterid);
    }
}