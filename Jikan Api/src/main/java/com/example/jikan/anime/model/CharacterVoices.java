package com.example.jikan.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

public class CharacterVoices {

    private List<CharacterVoices.Data> data;

    public List<CharacterVoices.Data> getData() {
        return data;
    }

    public void setData(List<CharacterVoices.Data> data) {
        this.data = data;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String language;
        private Person person;

        public String getLanguage() { return language; }

        public void setLanguage(String language){ this.language = language; }

        public Person getPerson() { return person; }

        public void setPerson(Person person){ this.person = person; }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Person {
            private int mal_id;
            private String url;
            private Images image;
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
                return image;
            }

            public void setImages(Images image) {
                this.image = image;
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
            private Jpg jpg;

            public Jpg getJpg() {
                return jpg;
            }

            public void setJpg(Jpg jpg) {
                this.jpg = jpg;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Jpg {
                private String image_url;


                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }
            }
    }
}
}
