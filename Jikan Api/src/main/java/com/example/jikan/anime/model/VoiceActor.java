package com.example.jikan.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VoiceActor {
    private Data[] data;

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String role;
        private Anime anime;
        private Character character;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Anime getAnime() {
            return anime;
        }

        public void setAnime(Anime anime) {
            this.anime = anime;
        }

        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Anime {
        private int mal_id;
        private String url;
        private Images images;
        private String title;

        public int getMal_id() {
            return mal_id;
        }

        public void setMal_id(int mal_id) {
            this.mal_id = mal_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Images getImages() {
            return images;
        }

        public void setImages(Images images) {
            this.images = images;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Character {
        private int mal_id;
        private String url;
        private Images images;
        private String name;

        public int getMal_id() {
            return mal_id;
        }

        public void setMal_id(int mal_id) {
            this.mal_id = mal_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Images getImages() {
            return images;
        }

        public void setImages(Images images) {
            this.images = images;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Images {
        @JsonProperty("jpg")
        private Jpg jpg;

        public Jpg getJpg() {
            return jpg;
        }

        public void setJpg(Jpg jpg) {
            this.jpg = jpg;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Jpg {
        @JsonProperty("image_url")
        private String image_url;

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }
}