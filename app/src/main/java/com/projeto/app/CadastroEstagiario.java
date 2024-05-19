package com.projeto.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.projeto.helper.HttpHelper;
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

        btnBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostEstagiarioTask().execute(nomeTxt.getText().toString());
            }
        });
    }

    private class PostEstagiarioTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            EstagiarioModel estagiarioModel = new EstagiarioModel();
            Gson gson = new Gson();
            String estagiarioJson = gson.toJson(estagiarioModel);
            System.out.println("NOME:" + estagiarioJson);
            HttpHelper http = new HttpHelper();
            try {
                http.post(estagiarioJson);
            } catch (IOException e) {
                e.printStackTrace();
                // Trate o erro conforme necessário
            }
            return null;
        }
    }
}