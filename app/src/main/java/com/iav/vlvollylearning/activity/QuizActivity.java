package com.iav.vlvollylearning.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.iav.vlvollylearning.R;
import com.iav.vlvollylearning.adapter.QuizAdapter;
import com.iav.vlvollylearning.helper.Config;
import com.iav.vlvollylearning.model.LatihanSoalModel;
import com.iav.vlvollylearning.rest.ApiService;
import com.iav.vlvollylearning.rest.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuizActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<LatihanSoalModel> latihanSoalModelArrayList;
    private QuizAdapter quizAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        latihanSoalModelArrayList = new ArrayList<>();
        initView();
        getDtaLatihanSoal();
    }

    private void getDtaLatihanSoal() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getLatihanSoal("read","latihan_soal")
                .enqueue(new Callback<ArrayList<LatihanSoalModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<LatihanSoalModel>> call, Response<ArrayList<LatihanSoalModel>> response) {
                        if (response.isSuccessful()){
                            latihanSoalModelArrayList = response.body();
                            quizAdapter = new QuizAdapter(QuizActivity.this, latihanSoalModelArrayList);
                            rv.setLayoutManager(new LinearLayoutManager(QuizActivity.this));
                            rv.setAdapter(quizAdapter);
                            quizAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<LatihanSoalModel>> call, Throwable t) {
                        Toast.makeText(QuizActivity.this, "" + Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }
}
