package com.example.tpcorn;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class BaseModeInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("originalTitle")
    @Expose
    private String originalTitle;
    @SerializedName("fullTitle")
    @Expose
    private String fullTitle;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("runtimeMins")
    @Expose
    private String runtimeMins;
    @SerializedName("runtimeStr")
    @Expose
    private String runtimeStr;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("plotLocal")
    @Expose
    private String plotLocal;
    @SerializedName("plotLocalIsRtl")
    @Expose
    private Boolean plotLocalIsRtl;
    @SerializedName("awards")
    @Expose
    private String awards;
    @SerializedName("directors")
    @Expose
    private String directors;
    @SerializedName("directorList")
    @Expose
    private List<Director> directorList = null;

    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("starList")
    @Expose
    private List<Star> starList = null;

    @SerializedName("fullCast")
    @Expose
    private Object fullCast;
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
    @SerializedName("ratings")
    @Expose
    private Object ratings;
    @SerializedName("wikipedia")
    @Expose
    private Object wikipedia;
    @SerializedName("posters")
    @Expose
    private Object posters;
    @SerializedName("images")
    @Expose
    private Object images;
    @SerializedName("trailer")
    @Expose
    private Object trailer;

    @SerializedName("tagline")
    @Expose
    private Object tagline;
    @SerializedName("keywords")
    @Expose
    private String keywords;
    @SerializedName("keywordList")
    @Expose
    private List<String> keywordList = null;

    @SerializedName("tvSeriesInfo")
    @Expose
    private Object tvSeriesInfo;
    @SerializedName("tvEpisodeInfo")
    @Expose
    private Object tvEpisodeInfo;
    @SerializedName("errorMessage")
    @Expose
    private Object errorMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntimeMins() {
        return runtimeMins;
    }

    public void setRuntimeMins(String runtimeMins) {
        this.runtimeMins = runtimeMins;
    }

    public String getRuntimeStr() {
        return runtimeStr;
    }

    public void setRuntimeStr(String runtimeStr) {
        this.runtimeStr = runtimeStr;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPlotLocal() {
        return plotLocal;
    }

    public void setPlotLocal(String plotLocal) {
        this.plotLocal = plotLocal;
    }

    public Boolean getPlotLocalIsRtl() {
        return plotLocalIsRtl;
    }

    public void setPlotLocalIsRtl(Boolean plotLocalIsRtl) {
        this.plotLocalIsRtl = plotLocalIsRtl;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
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


    public Object getFullCast() {
        return fullCast;
    }

    public void setFullCast(Object fullCast) {
        this.fullCast = fullCast;
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

    public Object getRatings() {
        return ratings;
    }

    public void setRatings(Object ratings) {
        this.ratings = ratings;
    }

    public Object getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(Object wikipedia) {
        this.wikipedia = wikipedia;
    }

    public Object getPosters() {
        return posters;
    }

    public void setPosters(Object posters) {
        this.posters = posters;
    }

    public Object getImages() {
        return images;
    }

    public void setImages(Object images) {
        this.images = images;
    }

    public Object getTrailer() {
        return trailer;
    }

    public void setTrailer(Object trailer) {
        this.trailer = trailer;
    }


    public Object getTagline() {
        return tagline;
    }

    public void setTagline(Object tagline) {
        this.tagline = tagline;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }


    public Object getTvSeriesInfo() {
        return tvSeriesInfo;
    }

    public void setTvSeriesInfo(Object tvSeriesInfo) {
        this.tvSeriesInfo = tvSeriesInfo;
    }

    public Object getTvEpisodeInfo() {
        return tvEpisodeInfo;
    }

    public void setTvEpisodeInfo(Object tvEpisodeInfo) {
        this.tvEpisodeInfo = tvEpisodeInfo;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

}




