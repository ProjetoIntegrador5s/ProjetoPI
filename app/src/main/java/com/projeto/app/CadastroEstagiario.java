package com.projeto.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.projeto.model.EstagiarioModel;

import java.io.IOException;

public class CadastroEstagiario extends AppCompatActivity {

    private EditText nomeTxt;
    private Button btnBusca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_estagiario);

        btnBusca = findViewById(R.id.CadastroNome);
        nomeTxt = findViewById(R.id.nomeEditText);

    }

}