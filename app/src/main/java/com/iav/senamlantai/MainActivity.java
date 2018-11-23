package com.iav.senamlantai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.iav.senamlantai.adapter.MenuAdapter;
import com.iav.senamlantai.helper.Config;
import com.iav.senamlantai.model.ImageSliderModel;
import com.iav.senamlantai.model.MenuModel;
import com.iav.vlvollylearning.R;
import com.iav.senamlantai.rest.ApiService;
import com.iav.senamlantai.rest.Client;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView ivMenu;
    private RecyclerView rv;
    private ArrayList<MenuModel> menuModels;
    private MenuAdapter menuAdapter;
    private SliderLayout mSliderSlider;
    private PagerIndicator customIndicator;
    private PagerIndicator customIndicator2;
    private ArrayList<ImageSliderModel> imageSliderModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        menuModels = new ArrayList<>();
        imageSliderModels = new ArrayList<>();
        getDataMenu();
        getSlider();
    }

    private void getSlider() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getImageSlider("read", "image_slider")
                .enqueue(new Callback<ArrayList<ImageSliderModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ImageSliderModel>> call, Response<ArrayList<ImageSliderModel>> response) {
                        if (response.isSuccessful()) {
                            imageSliderModels = response.body();
                            for (int i = 0; i < imageSliderModels.size(); i++) {
                                mSliderSlider.setVisibility(View.VISIBLE);
                                customIndicator.setVisibility(View.VISIBLE);
                                customIndicator2.setVisibility(View.VISIBLE);
                                HashMap<String, String> url_maps = new HashMap<String, String>();
                                // * Get internet
                                url_maps.put(imageSliderModels.get(i).getText(), imageSliderModels.get(i).getImageUrl());


                                for (String name : url_maps.keySet()) {
                                    TextSliderView textSliderView = new TextSliderView(MainActivity.this);
                                    // initialize a SliderLayout
                                    textSliderView
                                            .description(name)
                                            .image(url_maps.get(name))
                                            .setScaleType(BaseSliderView.ScaleType.Fit);
                                    //add your extra information
                                    textSliderView.bundle(new Bundle());
                                    textSliderView.getBundle()
                                            .putString("extra", name);

                                    mSliderSlider.addSlider(textSliderView);
                                }
                                mSliderSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
                                mSliderSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                                mSliderSlider.setCustomAnimation(new DescriptionAnimation());
                                mSliderSlider.setDuration(4000);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ImageSliderModel>> call, Throwable t) {

                    }
                });
    }

    private void getDataMenu() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getMenu("read", "menu")
                .enqueue(new Callback<ArrayList<MenuModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<MenuModel>> call, Response<ArrayList<MenuModel>> response) {
                        if (response.isSuccessful()) {
                            menuModels = response.body();
                            menuAdapter = new MenuAdapter(MainActivity.this, menuModels);
                            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            rv.setAdapter(menuAdapter);
                            rv.setHasFixedSize(true);
                            menuAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<MenuModel>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        ivMenu = findViewById(R.id.iv_menu);
        rv = findViewById(R.id.rv);
        mSliderSlider = findViewById(R.id.mSliderSlider);
        customIndicator = findViewById(R.id.custom_indicator);
        customIndicator2 = findViewById(R.id.custom_indicator2);
    }
}
