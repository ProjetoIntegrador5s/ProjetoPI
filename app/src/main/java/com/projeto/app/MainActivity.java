package com.projeto.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projeto.model.EstagiarioModel;
import com.projeto.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://192.168.1.68:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIrParaDestino = findViewById(R.id.acessarTabelaEstagiarios);

        System.out.println("botão " + btnIrParaDestino);

        btnIrParaDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar um Intent para abrir a ActivityDestino
                Intent intent = new Intent(MainActivity.this, CardsEstagiarios.class);
                startActivity(intent);
            }
        });
        Button cadastrar = findViewById(R.id.CadastroNome);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroEstagiario.class);
                startActivity(intent);
            }
        });


    }
}