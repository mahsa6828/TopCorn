package com.example.tpcorn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tpcorn.databinding.ActivityMain2Binding;
import com.example.tpcorn.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;
    ApiService apiService;
    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService = new ApiService();

        String id=getIntent().getStringExtra("id");

        binding.toolbarIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.btnOpenImdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String url = "https://m.imdb.com/title/"+id+"/";
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        apiService.getMovieFromId(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<BaseModeInfo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                           MainActivity2.this.disposable=d;
                    }

                    @Override
                    public void onSuccess(@NonNull BaseModeInfo baseModeInfo) {
                        Log.i("","");
                        binding.txtRating.setText(baseModeInfo.getImDbRating());
                        binding.textDirector.setText(baseModeInfo.getDirectors());
                        binding.txtStarring.setText(baseModeInfo.getStars());
                        binding.txtGenre.setText(baseModeInfo.getGenres());
                        binding.tvTitle.setText(baseModeInfo.getTitle());
                        binding.tvDescription.setText(baseModeInfo.getPlot());
                        Picasso.get().load(baseModeInfo.getImage()).into(binding.imgPoster);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (disposable != null){
            disposable.dispose();
        }
        super.onDestroy();

    }
}