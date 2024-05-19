package com.projeto.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projeto.model.EstagiarioModel;
import com.projeto.network.ApiModule;
import com.projeto.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TabelaEstagiarios extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.56.1:8080/estagiarios/";
    private static final String TAG = ApiModule.class.getSimpleName();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela_estagiarios);

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
                    TableLayout tableLayout = findViewById(R.id.tabelaEstagiarios); // ID da sua TableLayout no arquivo XML

                    for (EstagiarioModel estagiario : estagiarios) {
                        TableRow row = new TableRow(TabelaEstagiarios.this);

                        System.out.println("MATRICULA" + estagiario.getMatricula());

                        // Adicionando o nome do estagiário
                        TextView nomeTextView = new TextView(TabelaEstagiarios.this);
                        nomeTextView.setText(estagiario.getNome());
                        nomeTextView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 4f));
                        row.addView(nomeTextView);

                        TextView teste = new TextView(TabelaEstagiarios.this);
                        teste.setText(estagiario.getNome());
                        teste.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 2f));
                        row.addView(teste);

                        tableLayout.addView(row);
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
