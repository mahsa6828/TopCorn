package com.example.tpcorn.api;

import com.example.tpcorn.model.BaseModeInfo;
import com.example.tpcorn.model.BaseModelGetMovies;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApiService {

//    @GET("Top250Movies/k_5obh36hz?genres=action")
    @GET("AdvancedSearch/k_5obh36hz?genres=action")
    Single<BaseModelGetMovies> getActionVideos();

    @GET("AdvancedSearch/k_5obh36hz?genres=drama")
    Single<BaseModelGetMovies> getDramaVideos();

    @GET("AdvancedSearch/k_5obh36hz?genres=thriller")
    Single<BaseModelGetMovies> getThrillerVideos();

    @GET("AdvancedSearch/k_5obh36hz?genres=action&sort=user_rating,desc")
    Single<BaseModelGetMovies> getActionVideosWithRating();

    @GET("AdvancedSearch/k_5obh36hz?genres=drama&sort=user_rating,desc")
    Single<BaseModelGetMovies> getDramaVideosWithRating();

    @GET("AdvancedSearch/k_5obh36hz?genres=thriller&sort=user_rating,desc")
    Single<BaseModelGetMovies> getThrillerVideosWithRating();

    @GET("AdvancedSearch/k_5obh36hz?genres=action&sort=year,desc")
    Single<BaseModelGetMovies> getActionVideosWithYear();

    @GET("AdvancedSearch/k_5obh36hz?genres=drama&sort=year,desc")
    Single<BaseModelGetMovies> getDramaVideosWithYear();

    @GET("AdvancedSearch/k_5obh36hz?genres=thriller&sort=year,desc")
    Single<BaseModelGetMovies> getThrillerVideosWithYear();




    @GET("Title/k_5obh36hz/{id}")
    Single<BaseModeInfo> getMovieFromId(@Path("id") String id);
}
