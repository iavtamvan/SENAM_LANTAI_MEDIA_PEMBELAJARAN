package com.iav.senamlantai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.iav.vlvollylearning.R;
import com.iav.senamlantai.model.LatihanSoalModel;

import java.util.ArrayList;


public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LatihanSoalModel> latihanSoalModels;


    public QuizAdapter(Context context, ArrayList<LatihanSoalModel> latihanSoalModels) {
        this.context = context;
        this.latihanSoalModels = latihanSoalModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_latihan, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvNoSoal.setText("Soal - " + position);
        Glide.with(context).load(latihanSoalModels.get(position).getImageUrl()).into(holder.ivSoal);

        RequestManager requestManager = null;
        requestManager = Glide.with(context);
        RequestBuilder requestBuilder = requestManager.load(latihanSoalModels.get(position).getImageUrl());

        // Create glide request option.
        RequestOptions requestOptions = new RequestOptions();

        // Apply glide request options.
        requestBuilder.apply(requestOptions);

        // Load image to image view to display.
        requestBuilder.into(holder.ivSoal);

        holder.tvSoal.setText(latihanSoalModels.get(position).getPertanyaan());
        holder.tvJawaban1.setText(latihanSoalModels.get(position).getJawabanA());
        holder.tvJawaban2.setText(latihanSoalModels.get(position).getJawabanB());
        holder.tvJawaban3.setText(latihanSoalModels.get(position).getJawabanC());
        holder.tvJawaban4.setText(latihanSoalModels.get(position).getJawabanD());
        holder.tvJawaban5.setText(latihanSoalModels.get(position).getJawabanE());

        holder.cvKlikJawaban1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tvJawaban1.getText().toString().trim().contains(latihanSoalModels.get(position).getJawabanBenar())) {
                    Toast.makeText(context, "Jawaban benar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Jawaban salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.cvKlikJawaban2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tvJawaban2.getText().toString().trim().contains(latihanSoalModels.get(position).getJawabanBenar())) {
                    Toast.makeText(context, "Jawaban benar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Jawaban salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.cvKlikJawaban3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tvJawaban3.getText().toString().trim().contains(latihanSoalModels.get(position).getJawabanBenar())) {
                    Toast.makeText(context, "Jawaban benar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Jawaban salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.cvKlikJawaban4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tvJawaban4.getText().toString().trim().contains(latihanSoalModels.get(position).getJawabanBenar())) {
                    Toast.makeText(context, "Jawaban benar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Jawaban salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.cvKlikJawaban5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tvJawaban5.getText().toString().trim().contains(latihanSoalModels.get(position).getJawabanBenar())) {
                    Toast.makeText(context, "Jawaban benar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Jawaban salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return latihanSoalModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvklik;
        private TextView tvNoSoal;
        private ImageView ivSoal;
        private TextView tvSoal;
        private CardView cvKlikJawaban1;
        private TextView tvJawaban1;
        private CardView cvKlikJawaban2;
        private TextView tvJawaban2;
        private CardView cvKlikJawaban3;
        private TextView tvJawaban3;
        private CardView cvKlikJawaban4;
        private TextView tvJawaban4;
        private CardView cvKlikJawaban5;
        private TextView tvJawaban5;

        public ViewHolder(View itemView) {
            super(itemView);

            cvklik = itemView.findViewById(R.id.cvklik);
            tvNoSoal = itemView.findViewById(R.id.tv_no_soal);
            ivSoal = itemView.findViewById(R.id.iv_soal);
            tvSoal = itemView.findViewById(R.id.tv_soal);
            cvKlikJawaban1 = itemView.findViewById(R.id.cv_klik_jawaban1);
            tvJawaban1 = itemView.findViewById(R.id.tv_jawaban1);
            cvKlikJawaban2 = itemView.findViewById(R.id.cv_klik_jawaban2);
            tvJawaban2 = itemView.findViewById(R.id.tv_jawaban2);
            cvKlikJawaban3 = itemView.findViewById(R.id.cv_klik_jawaban3);
            tvJawaban3 = itemView.findViewById(R.id.tv_jawaban3);
            cvKlikJawaban4 = itemView.findViewById(R.id.cv_klik_jawaban4);
            tvJawaban4 = itemView.findViewById(R.id.tv_jawaban4);
            cvKlikJawaban5 = itemView.findViewById(R.id.cv_klik_jawaban5);
            tvJawaban5 = itemView.findViewById(R.id.tv_jawaban5);
        }
    }
}
