package com.example.tpcorn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.tpcorn.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ApiService apiService;
    Disposable disposable;
    List<Result> actionResult;
    List<Result> dramaResult;
    List<Result> thrillerResult;

    //RetrofitApiService retrofitApiService;
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

                        RcAdapter rcAdapter = new RcAdapter(MainActivity.this,actionResult);
                        binding.rcActionFilm.setAdapter(rcAdapter);
                        binding.rcActionFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

                        RcAdapter rcAdapter2 = new RcAdapter(MainActivity.this,dramaResult);
                        binding.rcDramaFilm.setAdapter(rcAdapter2);
                        binding.rcDramaFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
                        RcAdapter rcAdapter3 = new RcAdapter(MainActivity.this,thrillerResult);
                        binding.rcThrillerFilm.setAdapter(rcAdapter3);
                        binding.rcThrillerFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

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

                                RcAdapter rcAdapter = new RcAdapter(MainActivity.this,actionResult);
                                binding.rcActionFilm.setAdapter(rcAdapter);
                                binding.rcActionFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

                                RcAdapter rcAdapter2 = new RcAdapter(MainActivity.this,dramaResult);
                                binding.rcDramaFilm.setAdapter(rcAdapter2);
                                binding.rcDramaFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
                                RcAdapter rcAdapter3 = new RcAdapter(MainActivity.this,thrillerResult);
                                binding.rcThrillerFilm.setAdapter(rcAdapter3);
                                binding.rcThrillerFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

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

                                RcAdapter rcAdapter = new RcAdapter(MainActivity.this,actionResult);
                                binding.rcActionFilm.setAdapter(rcAdapter);
                                binding.rcActionFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

                                RcAdapter rcAdapter2 = new RcAdapter(MainActivity.this,dramaResult);
                                binding.rcDramaFilm.setAdapter(rcAdapter2);
                                binding.rcDramaFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

                                RcAdapter rcAdapter3 = new RcAdapter(MainActivity.this,thrillerResult);
                                binding.rcThrillerFilm.setAdapter(rcAdapter3);
                                binding.rcThrillerFilm.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

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










//        apiService.getActionVideos()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        MainActivity.this.disposable = d;
//
//                    }
//
//                    @Override
//                    public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                        //progressBar1.setVisibility(View.GONE);
//                        RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                        rc_action_film.setAdapter(rcAdapter);
//                        rc_action_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                        Log.i("","");
//                        Toast.makeText(MainActivity.this,"action",Toast.LENGTH_LONG).show();
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//                });
//
//        apiService.getDramaVideos()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        MainActivity.this.disposable = d;
//                    }
//
//                    @Override
//                    public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                        //progressBar1.setVisibility(View.GONE);
//                        RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                        rc_drama_film.setAdapter(rcAdapter);
//                        rc_drama_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                        Log.i("","");
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//                });
//
//        apiService.getThrillerVideos()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        MainActivity.this.disposable = d;
//
//                    }
//
//                    @Override
//                    public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                        //progressBar1.setVisibility(View.GONE);
//                        RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                        rc_Thriller_film.setAdapter(rcAdapter);
//                        rc_Thriller_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                        Log.i("","");
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//                });


//
//        img_rating.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                img_rating.setVisibility(View.GONE);
//                img_calender.setVisibility(View.VISIBLE);
//                apiService.getActionVideosWithRating()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                            @Override
//                            public void onSubscribe(@NonNull Disposable d) {
//                                MainActivity.this.disposable = d;
//
//                            }
//
//                            @Override
//                            public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                                progressBar1.setVisibility(View.GONE);
//                                RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                                rc_action_film.setAdapter(rcAdapter);
//                                rc_action_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                                Log.i("","");
//
//                            }
//
//                            @Override
//                            public void onError(@NonNull Throwable e) {
//
//                            }
//                        });
//
//                apiService.getDramaVideosWithRating()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                            @Override
//                            public void onSubscribe(@NonNull Disposable d) {
//                                MainActivity.this.disposable = d;
//
//                            }
//
//                            @Override
//                            public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                                progressBar1.setVisibility(View.GONE);
//                                RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                                rc_drama_film.setAdapter(rcAdapter);
//                                rc_drama_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                                Log.i("","");
//
//                            }
//
//                            @Override
//                            public void onError(@NonNull Throwable e) {
//
//                            }
//                        });
//
//                apiService.getThrillerVideosWithRating()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                            @Override
//                            public void onSubscribe(@NonNull Disposable d) {
//                                MainActivity.this.disposable = d;
//
//                            }
//
//                            @Override
//                            public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                                progressBar1.setVisibility(View.GONE);
//                                RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                                rc_Thriller_film.setAdapter(rcAdapter);
//                                rc_Thriller_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                                Log.i("","");
//
//                            }
//
//                            @Override
//                            public void onError(@NonNull Throwable e) {
//
//                            }
//                        });
//                Toast.makeText(MainActivity.this,"sorted by Rating",Toast.LENGTH_SHORT).show();
//
//            }
//        });

//        img_calender.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                img_rating.setVisibility(View.VISIBLE);
//                img_calender.setVisibility(View.GONE);
//                apiService.getActionVideosWithYear()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                            @Override
//                            public void onSubscribe(@NonNull Disposable d) {
//                                MainActivity.this.disposable = d;
//
//                            }
//
//                            @Override
//                            public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                                progressBar1.setVisibility(View.GONE);
//                                RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                                rc_action_film.setAdapter(rcAdapter);
//                                rc_action_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                                Log.i("","");
//
//                            }
//
//                            @Override
//                            public void onError(@NonNull Throwable e) {
//
//                            }
//                        });
//                apiService.getDramaVideosWithYear()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                            @Override
//                            public void onSubscribe(@NonNull Disposable d) {
//                                MainActivity.this.disposable = d;
//
//                            }
//
//                            @Override
//                            public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                                progressBar1.setVisibility(View.GONE);
//                                RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                                rc_drama_film.setAdapter(rcAdapter);
//                                rc_drama_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                                Log.i("","");
//
//                            }
//
//                            @Override
//                            public void onError(@NonNull Throwable e) {
//
//                            }
//                        });
//
//                apiService.getThrillerVideosWithYear()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new SingleObserver<BaseModelGetMovies>() {
//                            @Override
//                            public void onSubscribe(@NonNull Disposable d) {
//                                MainActivity.this.disposable = d;
//
//                            }
//
//                            @Override
//                            public void onSuccess(@NonNull BaseModelGetMovies baseModelGetMovies) {
//                                progressBar1.setVisibility(View.GONE);
//                                RcAdapter rcAdapter = new RcAdapter(MainActivity.this,baseModelGetMovies.getResults());
//                                rc_Thriller_film.setAdapter(rcAdapter);
//                                rc_Thriller_film.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
//                                Log.i("","");
//
//                            }
//
//                            @Override
//                            public void onError(@NonNull Throwable e) {
//
//                            }
//                        });
//                Toast.makeText(MainActivity.this,"sorted by Year",Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }

    @Override
    protected void onDestroy() {
        disposable.dispose();

        super.onDestroy();


    }
}