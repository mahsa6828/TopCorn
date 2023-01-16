package com.example.tpcorn.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tpcorn.adapter.RcAdapter;
import com.example.tpcorn.api.ApiService;
import com.example.tpcorn.databinding.ActivityMainBinding;
import com.example.tpcorn.model.BaseModelGetMovies;
import com.example.tpcorn.model.Result;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ApiService apiService;
    Disposable disposable;
    List<Result> actionResult;
    List<Result> dramaResult;
    List<Result> thrillerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService = new ApiService();
        binding.progressCircular.setVisibility(View.VISIBLE);
        actionResult = new ArrayList<>();
        dramaResult = new ArrayList<>();
        thrillerResult = new ArrayList<>();


        apiService.getActionVideos()
                .subscribeOn(Schedulers.io())
                .flatMap(BaseModelGetMovies -> {
                    actionResult.addAll(BaseModelGetMovies.getResults());
                    return apiService.getDramaVideos();
                }
                )
                .flatMap(BaseModelGetMovies -> {
                    dramaResult.addAll(BaseModelGetMovies.getResults());
                    return apiService.getThrillerVideos();
                }
                )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<BaseModelGetMovies>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
                        binding.progressCircular.setVisibility(View.GONE);
                        thrillerResult.addAll(baseModelGetMovies.getResults());

                        showResult(actionResult, binding.rcActionFilm);

                        showResult(dramaResult,binding.rcDramaFilm);

                        showResult(thrillerResult,binding.rcThrillerFilm);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        binding.progressCircular.setVisibility(View.GONE);
                        Snackbar.make(binding.root,e.getMessage(),Snackbar.LENGTH_LONG).show();

                    }
                });

        binding.imgRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressCircular.setVisibility(View.VISIBLE);
                binding.imgRating.setVisibility(View.GONE);
                binding.imgCalender.setVisibility(View.VISIBLE);
                apiService.getActionVideosWithRating()
                        .subscribeOn(Schedulers.io())
                        .flatMap(BaseModelGetMovies -> {
                                    actionResult.clear();
                                    actionResult.addAll(BaseModelGetMovies.getResults());
                                    return apiService.getDramaVideosWithRating();
                                }
                        )
                        .flatMap(BaseModelGetMovies -> {
                                    dramaResult.clear();
                                    dramaResult.addAll(BaseModelGetMovies.getResults());
                                    return apiService.getThrillerVideosWithRating();
                                }
                        )
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<BaseModelGetMovies>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                disposable = d;
                            }

                            @Override
                            public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
                                binding.progressCircular.setVisibility(View.GONE);
                                thrillerResult.clear();
                                thrillerResult.addAll(baseModelGetMovies.getResults());

                                showResult(actionResult, binding.rcActionFilm);

                                showResult(dramaResult,binding.rcDramaFilm);

                                showResult(thrillerResult,binding.rcThrillerFilm);

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                binding.progressCircular.setVisibility(View.GONE);
                                Snackbar.make(binding.root,e.getMessage(),Snackbar.LENGTH_LONG).show();

                            }
                        });
                Toast.makeText(MainActivity.this,"sort by rating",Toast.LENGTH_LONG).show();

            }
        });

        binding.imgCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressCircular.setVisibility(View.VISIBLE);
                binding.imgRating.setVisibility(View.VISIBLE);
                binding.imgCalender.setVisibility(View.GONE);
                apiService.getActionVideosWithYear()
                        .subscribeOn(Schedulers.io())
                        .flatMap(BaseModelGetMovies -> {
                                    actionResult.clear();
                                    actionResult.addAll(BaseModelGetMovies.getResults());
                                    return apiService.getDramaVideosWithYear();
                                }
                        )
                        .flatMap(BaseModelGetMovies -> {
                                    dramaResult.clear();
                                    dramaResult.addAll(BaseModelGetMovies.getResults());
                                    return apiService.getThrillerVideosWithYear();
                                }
                        )
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<BaseModelGetMovies>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                disposable = d;
                            }

                            @Override
                            public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
                                binding.progressCircular.setVisibility(View.GONE);
                                thrillerResult.clear();
                                thrillerResult.addAll(baseModelGetMovies.getResults());

                                showResult(actionResult, binding.rcActionFilm);

                                showResult(dramaResult,binding.rcDramaFilm);

                                showResult(thrillerResult,binding.rcThrillerFilm);

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                binding.progressCircular.setVisibility(View.GONE);
                                Snackbar.make(binding.root,e.getMessage(),Snackbar.LENGTH_LONG).show();

                            }
                        });
                Toast.makeText(MainActivity.this,"sort by clender",Toast.LENGTH_LONG).show();
            }
        });



    }

    private void showResult(List<Result> resultList, RecyclerView p) {
        RcAdapter rcAdapter = new RcAdapter(MainActivity.this, resultList);
        p.setAdapter(rcAdapter);
        p.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false));
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();

        super.onDestroy();


    }
}