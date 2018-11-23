package com.iav.senamlantai.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.iav.senamlantai.helper.Config;
import com.iav.vlvollylearning.R;
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

public class DetailActivity extends AppCompatActivity {
    private String nameMenu;
    private String nama_teknik_judul;
    private String image_url;
    private String video_youtube_id;
    private String deskripsi;
    private String type;
    private String judul;
    private ImageView ivDetail;
    private YouTubePlayerView youtubePlayerView;
    private TextView tvDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();

        nama_teknik_judul = getIntent().getStringExtra(Config.NAMA_TEKNIK_JUDUL);
        image_url = getIntent().getStringExtra(Config.IMAGE_URL);
        video_youtube_id = getIntent().getStringExtra(Config.VIDEO_YOUTUBE_ID);
        deskripsi = getIntent().getStringExtra(Config.DESKRIPSI);
        type = getIntent().getStringExtra(Config.TYPE);
        judul = getIntent().getStringExtra(Config.JUDUL);

        Toast.makeText(this, "" + image_url, Toast.LENGTH_SHORT).show();
        getSupportActionBar().setTitle(judul);
        Glide.with(DetailActivity.this).load(image_url).into(ivDetail);
        RequestManager requestManager = null;
        requestManager = Glide.with(DetailActivity.this);
        RequestBuilder requestBuilder = requestManager.load(image_url);

        // Create glide request option.
        RequestOptions requestOptions = new RequestOptions();

        // Apply glide request options.
        requestBuilder.apply(requestOptions);

        // Load image to image view to display.
        requestBuilder.into(ivDetail);


        tvDeskripsi.setText(deskripsi);

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
    }

    private void initView() {
        ivDetail = findViewById(R.id.iv_detail);
        youtubePlayerView = findViewById(R.id.youtube_player_view);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);
    }
}
