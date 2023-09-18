package com.example.jikan.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private int mal_id;
        private String url;
        private Images images;
        private String name;

        // Getter and setter methods for mal_id, url, images, and name

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
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Images {
            private Jpg jpg;
            private Webp webp;

            // Getter and setter methods for jpg and webp

            public Jpg getJpg() {
                return jpg;
            }

            public void setJpg(Jpg jpg) {
                this.jpg = jpg;
            }

            public Webp getWebp() {
                return webp;
            }

            public void setWebp(Webp webp) {
                this.webp = webp;
            }
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Jpg {
                private String image_url;

                // Getter and setter methods for image_url

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }
            }
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Webp {
                private String image_url;
                private String small_image_url;

                // Getter and setter methods for image_url and small_image_url

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
            }
        }
    }
}