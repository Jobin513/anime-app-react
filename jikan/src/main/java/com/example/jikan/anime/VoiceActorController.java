package com.example.jikan.anime;

import com.example.jikan.anime.model.VoiceActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voiceactors")
public class VoiceActorController {
    private final VoiceActorService voiceActorService;

    @Autowired
    public VoiceActorController(VoiceActorService voiceActorService) {
        this.voiceActorService = voiceActorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoiceActor.Data[]> getVoiceActor(@PathVariable("id") int voiceActorId) {
        // Call the service to retrieve voice actor details
        VoiceActor.Data[] voiceActorData = voiceActorService.getVoiceActorDetails(voiceActorId);

        if (voiceActorData != null && voiceActorData.length > 0) {
            return new ResponseEntity<>(voiceActorData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}