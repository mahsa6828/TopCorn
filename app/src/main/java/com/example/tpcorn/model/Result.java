package com.example.tpcorn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("runtimeStr")
    @Expose
    private String runtimeStr;
    @SerializedName("genres")
    @Expose
    private String genres;
    @SerializedName("genreList")
    @Expose
    private List<Genre> genreList = null;
    @SerializedName("contentRating")
    @Expose
    private String contentRating;
    @SerializedName("imDbRating")
    @Expose
    private String imDbRating;
    @SerializedName("imDbRatingVotes")
    @Expose
    private String imDbRatingVotes;
    @SerializedName("metacriticRating")
    @Expose
    private String metacriticRating;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("starList")
    @Expose
    private List<Star> starList = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuntimeStr() {
        return runtimeStr;
    }

    public void setRuntimeStr(String runtimeStr) {
        this.runtimeStr = runtimeStr;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getImDbRatingVotes() {
        return imDbRatingVotes;
    }

    public void setImDbRatingVotes(String imDbRatingVotes) {
        this.imDbRatingVotes = imDbRatingVotes;
    }

    public String getMetacriticRating() {
        return metacriticRating;
    }

    public void setMetacriticRating(String metacriticRating) {
        this.metacriticRating = metacriticRating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public List<Star> getStarList() {
        return starList;
    }

    public void setStarList(List<Star> starList) {
        this.starList = starList;
    }
}
