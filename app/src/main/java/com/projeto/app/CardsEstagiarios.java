package com.projeto.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projeto.adapter.AdapterEstagiario;
import com.projeto.model.EstagiarioModel;
import com.projeto.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardsEstagiarios extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.1.68:8080/";
    private RecyclerView recyclerView;
    private TextView id;
    private List<EstagiarioModel> estagiariosArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_estagiarios);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        recyclerView = findViewById(R.id.recycleCard);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        Call<List<EstagiarioModel>> call = apiService.obterEstagiarios();

        call.enqueue(new Callback<List<EstagiarioModel>>() {
            public void onResponse(Call<List<EstagiarioModel>> call, Response<List<EstagiarioModel>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    List<EstagiarioModel> estagiarios = response.body();

                    for (EstagiarioModel estagiario : estagiarios) {

                        int id = estagiario.getId();
                        String nome = estagiario.getNome();
                        String matricula = estagiario.getMatricula();
                        String nomeCurso = estagiario.getNomeCurso();
                        String dataIngresso = estagiario.getDataIngresso();
                        String telefone = estagiario.getTelefone();
                        String email = estagiario.getEmail();
                        String relatorio1 = estagiario.getRelatorio1();
                        String relatorio2 = estagiario.getRelatorio2();
                        String statusRelatorio1 = estagiario.getStatusRelatorio1();
                        String statusRelatorio2 = estagiario.getStatusRelatorio2();
                        String comprovanteMatricula = estagiario.getComprovanteMatricula();

                        estagiariosArray.add(new EstagiarioModel(id, nome,matricula,nomeCurso,dataIngresso,telefone,email,relatorio1,relatorio2,statusRelatorio1,statusRelatorio2,comprovanteMatricula));

                    }
                } else {
                    System.out.println("Erro ao buscar Estagiarios " + response.code());
                }

                AdapterEstagiario adapter = new AdapterEstagiario( estagiariosArray );
                recyclerView.setAdapter(adapter);

              }

            public void onFailure(Call<List<EstagiarioModel>> call, Throwable t) {
                System.out.println("Falha ao buscar os dados: " + t.getMessage());
            }

        });

    }


}
