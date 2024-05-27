package com.projeto.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;
import com.projeto.model.EstagiarioModel;
import com.projeto.network.ApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastroEstagiario extends AppCompatActivity {

    private EstagiarioModel estagiario;
    private static final String BASE_URL = "http://192.168.1.68:8080/";
    ApiService a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_estagiario);

        Button cadastrarEstagiario = findViewById(R.id.CadastroNome);

        cadastrarEstagiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cliquei!");
                String relatorio1Est;
                String relatorio2Est;
                String compMatriculaEst;
                EditText nomeEst = findViewById(R.id.nomeEst);
                EditText matriculaEst = findViewById(R.id.matriculaEst);
                EditText nomeCursoEst = findViewById(R.id.nomeCursoEst);
                EditText dataIngressoEst = findViewById(R.id.dataIngressoEst);
                EditText telefoneEst = findViewById(R.id.telefoneEst);
                EditText emailEst = findViewById(R.id.emailEst);
                CheckBox relatorio1 = findViewById(R.id.relatorio1);
                if(relatorio1.isChecked()){
                    relatorio1Est = "Enviado";
                } else {
                    relatorio1Est = "Não enviado";
                }
                CheckBox relatorio2 = findViewById(R.id.relatorio2);
                if(relatorio2.isChecked()){
                    relatorio2Est = "Enviado";
                } else {
                    relatorio2Est = "Não enviado";
                }
                CheckBox compMatricula = findViewById(R.id.compMatricula);
                if(compMatricula.isChecked()){
                    compMatriculaEst = "Enviado";
                }else{
                    compMatriculaEst = "Não enviado";
                }
                String nomeEstI = nomeEst.getText().toString();
                String matriculaEstI = matriculaEst.getText().toString();
                String nomeCursoEstI = nomeCursoEst.getText().toString();
                String dataIngressoEstI = dataIngressoEst.getText().toString();
                String telefoneEstI = telefoneEst.getText().toString();
                String emailEstI = emailEst.getText().toString();
                System.out.println(" Nome:"+nomeEstI+" Matricula: "+matriculaEstI+" Nome Curso: "+nomeCursoEstI+" Data: "+dataIngressoEstI+" telefone: "+telefoneEstI+" Email: "+emailEstI);

                EstagiarioModel e = new EstagiarioModel(nomeEstI,matriculaEstI,nomeCursoEstI,dataIngressoEstI,telefoneEstI,emailEstI,relatorio1Est,relatorio2Est,relatorio1Est,relatorio2Est,compMatriculaEst);
                System.out.println(e.toString());
                System.out.println("Cheguei aqui");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiService apiService = retrofit.create(ApiService.class);
                Call<Void> call = apiService.cadastrarEstagiario(e);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            System.out.println("sucesso");
                        } else {
                            System.out.println("falha");
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Tratar falha na requisição
                    }
                });



            }
        });

    }

}