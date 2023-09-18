package com.example.jikan.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Anime {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private int mal_id;
        private String title;
        private String synopsis;
        private String url;

        @JsonProperty("images")
        private Images images; // Include 'images' property

        // Getter for 'image_url' of the 'jpg' part of 'images'
        public String getJpgImageUrl() {
            return images.getJpg().getImage_url();
        }

        public int getMal_id() {
            return mal_id;
        }

        public void setMal_id(int mal_id) {
            this.mal_id = mal_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSynopsis() {
            return synopsis;
        }

        public void setSynopsis(String synopsis) {
            this.synopsis = synopsis;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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
    }

    public static class Jpg {
        private String image_url;
        private String small_image_url;
        private String large_image_url;
        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getSmall_image_url() {
            return small_image_url;
        }

        public void setSmall_image_url(String small_image_url) {
            this.small_image_url = small_image_url;
        }

        public String getLarge_image_url() {
            return large_image_url;
        }

        public void setLarge_image_url(String large_image_url) {
            this.large_image_url = large_image_url;
        }
    }
}
