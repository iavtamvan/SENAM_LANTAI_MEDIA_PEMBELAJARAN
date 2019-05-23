package com.iav.senamlantai.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.iav.senamlantai.adapter.QuizAdapter;
import com.iav.senamlantai.helper.Config;
import com.iav.senamlantai.model.DataMenuModel;
import com.iav.senamlantai.rest.ApiService;
import com.iav.senamlantai.rest.Client;
import com.iav.vlvollylearning.R;
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataMenuActivity extends AppCompatActivity {

    private TextView tvMenuType;
    private RecyclerView rv;

    private ArrayList<DataMenuModel> dataMenuModels;
    private QuizAdapter quizAdapter;
    private String nameMenu;

    private LinearLayout div;
    private RequestManager requestManager = null;
    private ProgressBar progressCircularMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_menu);
        initView();
        nameMenu = getIntent().getStringExtra(Config.BUNDLE_NAME_MENU);
        tvMenuType.setText(nameMenu);
        dataMenuModels = new ArrayList<>();
        progressCircularMenu.setVisibility(View.VISIBLE);
        getDataMenu();

    }

    private void getDataMenu() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getDataMenu("read", "data_menu")
                .enqueue(new Callback<ArrayList<DataMenuModel>>() {

                    @Override
                    public void onResponse(Call<ArrayList<DataMenuModel>> call, Response<ArrayList<DataMenuModel>> response) {
                        if (response.isSuccessful()) {
                            dataMenuModels = response.body();
                            progressCircularMenu.setVisibility(View.GONE);
                            div.setVisibility(View.VISIBLE);
//                            quizAdapter = new QuizAdapter(DataMenuActivity.this, dataMenuModels);
//                            rv.setLayoutManager(new LinearLayoutManager(DataMenuActivity.this));
//                            rv.setAdapter(quizAdapter);
//                            quizAdapter.notifyDataSetChanged();
                            for (DataMenuModel s : dataMenuModels) {
                                if (s.getType() != null && s.getType().contains(nameMenu)) {

                                    final String nama_teknik_judul;
                                    final String image_url;
                                    final String video_youtube_id;
                                    final String deskripsi;
                                    final String type;
                                    final String judul;

                                    nama_teknik_judul = s.getNamaTeknik();
                                    image_url = s.getImageUrl();
                                    video_youtube_id = s.getVideoYoutubeId();
                                    deskripsi = s.getDeskripsi();
                                    type = s.getType();
                                    judul = s.getJudul();
                                    LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                    View view = layoutInflater.inflate(R.layout.list_data, null);

                                    TextView tvMenuNamaTeknik;
                                    TextView tvMenuJudul;
                                    ImageView ivMenu;
                                    CardView cvklik;
                                    Button btnLihatVideo;

                                    cvklik = view.findViewById(R.id.cvklik);
                                    ivMenu = view.findViewById(R.id.iv_Menu);
                                    tvMenuJudul = view.findViewById(R.id.tv_menu_judul);
                                    tvMenuNamaTeknik = view.findViewById(R.id.tv_menu_nama_teknik);
                                    btnLihatVideo = view.findViewById(R.id.btn_lihat_video);

                                    requestManager = Glide.with(DataMenuActivity.this);
                                    RequestBuilder requestBuilder = requestManager.load(image_url);

                                    // Create glide request option.
                                    RequestOptions requestOptions = new RequestOptions();

                                    // Apply glide request options.
                                    requestBuilder.apply(requestOptions);

                                    // Load image to image view to display.
                                    requestBuilder.into(ivMenu);

                                    tvMenuJudul.setText(judul);
                                    tvMenuNamaTeknik.setText(nama_teknik_judul);

                                    cvklik.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
//                                            Toast.makeText(DataMenuActivity.this, "" + deskripsi + judul + video_youtube_id, Toast.LENGTH_SHORT).show();

                                            Intent intent = new Intent(new Intent(DataMenuActivity.this, DetailActivity.class));
                                            intent.putExtra(Config.NAMA_TEKNIK_JUDUL, nama_teknik_judul);
                                            intent.putExtra(Config.IMAGE_URL, image_url);
                                            intent.putExtra(Config.VIDEO_YOUTUBE_ID, video_youtube_id);
                                            intent.putExtra(Config.DESKRIPSI, deskripsi);
                                            intent.putExtra(Config.TYPE, type);
                                            intent.putExtra(Config.JUDUL, judul);
                                            startActivity(intent);
                                        }
                                    });
                                    btnLihatVideo.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            YouTubePlayerView youtubePlayerView;
                                            final Dialog dialog = new Dialog(DataMenuActivity.this);// add here your class name
                                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                            dialog.setContentView(R.layout.pop_up_video);//add your own xml with defied with and height of videoview
                                            youtubePlayerView = dialog.findViewById(R.id.youtube_player_view);
                                            youtubePlayerView.isFullScreen();
                                            youtubePlayerView.initialize(new YouTubePlayerInitListener() {
                                                @Override
                                                public void onInitSuccess(final YouTubePlayer youTubePlayer) {
                                                    youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                                                        @Override
                                                        public void onReady() {
                                                            youTubePlayer.loadVideo(video_youtube_id, 0);
                                                        }
                                                    });
                                                }
                                            }, true);
                                            dialog.show();
                                        }
                                    });

                                    div.addView(view);
                                }
                            }


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<DataMenuModel>> call, Throwable t) {
                        Toast.makeText(DataMenuActivity.this, Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        tvMenuType = findViewById(R.id.tv_menu_type);
        rv = findViewById(R.id.rv);
        div = findViewById(R.id.div);
        progressCircularMenu = findViewById(R.id.progress_circular_menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
