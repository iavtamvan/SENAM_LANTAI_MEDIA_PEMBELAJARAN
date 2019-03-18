package com.iav.senamlantai.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.iav.vlvollylearning.R;
import com.iav.senamlantai.adapter.QuizAdapter;
import com.iav.senamlantai.helper.Config;
import com.iav.senamlantai.model.LatihanSoalModel;
import com.iav.senamlantai.rest.ApiService;
import com.iav.senamlantai.rest.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuizActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<LatihanSoalModel> latihanSoalModelArrayList;
    private QuizAdapter quizAdapter;
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        latihanSoalModelArrayList = new ArrayList<>();
        initView();
//        getDtaLatihanSoal();
        wv  = new WebView(this);

        wv.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        wv.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });

        wv .loadUrl("https://www.edmodo.com/?language=id");
        setContentView(wv);

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
        wv = findViewById(R.id.wv);
    }
}
