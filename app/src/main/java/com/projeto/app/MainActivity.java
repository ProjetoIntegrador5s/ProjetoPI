package com.projeto.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.projeto.model.EstagiarioModel;
import com.projeto.network.ApiModule;
import com.projeto.network.ApiResponseModel;
import com.projeto.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://192.168.56.1:8080/estagiarios/";
    private static final String TAG = ApiModule.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIrParaDestino = findViewById(R.id.acessarTabelaEstagiarios);
        btnIrParaDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar um Intent para abrir a ActivityDestino
                Intent intent = new Intent(MainActivity.this, TabelaEstagiarios.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<EstagiarioModel>> call = apiService.obterEstagiarios();

        call.enqueue(new Callback<List<EstagiarioModel>>() {
            public void onResponse(Call<List<EstagiarioModel>> call, Response<List<EstagiarioModel>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    List<EstagiarioModel> estagiarios = response.body();
                    for (EstagiarioModel estagiario : estagiarios) {
                        // Aqui você pode acessar outras propriedades do objeto EstagiarioModel conforme necessário
                    }
                } else {
                    Log.e(TAG, "Resposta sem sucesso. Código: " + response.code());
                }
            }
            public void onFailure(Call<List<EstagiarioModel>> call, Throwable t) {
                Log.e(TAG, "Falha ao buscar os dados: " + t.getMessage());
            }
        });
    }
}