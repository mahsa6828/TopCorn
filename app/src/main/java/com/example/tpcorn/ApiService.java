package com.example.tpcorn;

import io.reactivex.Single;

public class ApiService {
    RetrofitApiService retrofitApiService;
    public ApiService(){
        retrofitApiService = ApiClient.getRetrofit().create(RetrofitApiService.class);

    }

    public Single<BaseModelGetMovies> getActionVideos(){
        return retrofitApiService.getActionVideos();
    }

    public Single<BaseModelGetMovies> getDramaVideos(){
        return retrofitApiService.getDramaVideos();
    }

    public Single<BaseModelGetMovies> getThrillerVideos(){
        return retrofitApiService.getThrillerVideos();
    }
    public Single<BaseModelGetMovies> getActionVideosWithRating(){
        return retrofitApiService.getActionVideosWithRating();
    }
    public Single<BaseModelGetMovies> getDramaVideosWithRating(){
        return retrofitApiService.getDramaVideosWithRating();
    }
    public Single<BaseModelGetMovies> getThrillerVideosWithRating(){
        return retrofitApiService.getThrillerVideosWithRating();
    }
    public Single<BaseModelGetMovies> getActionVideosWithYear(){
        return retrofitApiService.getActionVideosWithYear();
    }
    public Single<BaseModelGetMovies> getDramaVideosWithYear(){
        return retrofitApiService.getDramaVideosWithYear();
    }
    public Single<BaseModelGetMovies> getThrillerVideosWithYear(){
        return retrofitApiService.getThrillerVideosWithYear();
    }

    public Single<BaseModeInfo> getMovieFromId(String id){
        return retrofitApiService.getMovieFromId(id);
    }
}


