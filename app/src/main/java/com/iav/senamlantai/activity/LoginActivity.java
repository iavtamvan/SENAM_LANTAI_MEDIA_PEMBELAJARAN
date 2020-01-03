package com.iav.senamlantai.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iav.senamlantai.MainActivity;
import com.iav.senamlantai.model.AkunModel;
import com.iav.senamlantai.rest.ApiService;
import com.iav.senamlantai.rest.Client;
import com.iav.vlvollylearning.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvRegister;

    private ArrayList<AkunModel> akunModels;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog loading = ProgressDialog.show(LoginActivity.this, "Loading", "Validasi data...", false, false);
                ApiService apiService = Client.getInstanceRetrofit();
                apiService.getLogin("read", "akun")
                        .enqueue(new Callback<ArrayList<AkunModel>>() {
                            @Override
                            public void onResponse(Call<ArrayList<AkunModel>> call, Response<ArrayList<AkunModel>> response) {
                                if (response.isSuccessful()) {
                                    akunModels = response.body();
                                    for (AkunModel s : akunModels) {
                                        if (s.getUsername() != null && s.getUsername().contains(edtUsername.getText().toString().trim())) {
                                            username = s.getUsername();
                                            Toast.makeText(LoginActivity.this, "Sukses Login sbg " + username, Toast.LENGTH_SHORT).show();
                                            loading.dismiss();
                                            finishAffinity();
                                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        }
                                    }

                                }
                            }

                            @Override
                            public void onFailure(Call<ArrayList<AkunModel>> call, Throwable t) {
                                Toast.makeText(LoginActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                            }
                        });
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }

    private void initView() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
    }
}
