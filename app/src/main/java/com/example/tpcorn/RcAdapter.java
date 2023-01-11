package com.example.tpcorn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RcAdapter extends RecyclerView.Adapter<RcAdapter.MyHolder> {

    Context context;
    List<Result> resultList = new ArrayList<>();
    public RcAdapter(Context context,List<Result> resultList){
        this.context = context;
        this.resultList=resultList;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.rc_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Result result = resultList.get(position);
        String id=result.getId();
        holder.txtTitle.setText(result.getTitle());
        Picasso.get().load(result.getImage()).placeholder(R.drawable.download).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("id",id);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

//    public void setDataAdapter(List<Result> resultList){
//        resultList.addAll(resultList);
//
//    }

    public class MyHolder extends RecyclerView.ViewHolder{
        AppCompatImageView img;
        AppCompatTextView txtTitle;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_rc_row);
            txtTitle = itemView.findViewById(R.id.text_rc_row);
        }
    }
}
