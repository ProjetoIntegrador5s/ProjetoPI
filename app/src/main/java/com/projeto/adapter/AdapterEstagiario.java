package com.projeto.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projeto.app.R;
import com.projeto.model.EstagiarioModel;
import com.projeto.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdapterEstagiario extends RecyclerView.Adapter<AdapterEstagiario.MyViewHolderEstagiario> {


    private List<EstagiarioModel> estagiarios = new ArrayList<>();
    private Button btnExcluir;
    private static final String BASE_URL = "http://192.168.1.68:8080/estagiarios/";

    public AdapterEstagiario(List<EstagiarioModel> estagiarios ) {
        this.estagiarios = estagiarios;
    }

    @NonNull
    @Override
    public MyViewHolderEstagiario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_modal, parent, false);
        return new MyViewHolderEstagiario(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderEstagiario holder, int position) {
        EstagiarioModel estagiario = estagiarios.get(position);
        holder.nome.setText(estagiario.getNome());
        holder.matricula.setText(estagiario.getMatricula());
        holder.nomeCurso.setText(estagiario.getNomeCurso());
        holder.dataIngresso.setText(estagiario.getDataIngresso());
        holder.telefone.setText(estagiario.getTelefone());
        holder.email.setText(estagiario.getEmail());
        holder.relatorio1.setText(estagiario.getRelatorio1());
        holder.relatorio2.setText(estagiario.getRelatorio2());
        holder.statusRelatorio1.setText(estagiario.getStatusRelatorio1());
        holder.statusRelatorio2.setText(estagiario.getStatusRelatorio2());
        holder.comprovanteMatricula.setText(estagiario.getComprovanteMatricula());

        holder.btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiService apiService = retrofit.create(ApiService.class);

                Call<Void> call = apiService.excluirByIdEstagiario(estagiario);
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

    @Override
    public int getItemCount() {
        return estagiarios.size();
    }

    public class MyViewHolderEstagiario extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView nome;
        private TextView matricula;
        private TextView nomeCurso;
        private TextView  dataIngresso;
        private TextView  telefone;
        private TextView  email;
        private TextView  relatorio1;
        private TextView  relatorio2;
        private TextView statusRelatorio1;
        private TextView  statusRelatorio2;
        private TextView  comprovanteMatricula;
        private Button btnExcluir;

        public MyViewHolderEstagiario(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtId);
            nome = itemView.findViewById(R.id.txtNome);
            matricula = itemView.findViewById(R.id.txtMatricula);
            nomeCurso = itemView.findViewById(R.id.txtNomeCurso);
            dataIngresso = itemView.findViewById(R.id.txtDataIngresso);
            telefone = itemView.findViewById(R.id.txtTelefone);
            email = itemView.findViewById(R.id.txtEmail);
            relatorio1 = itemView.findViewById(R.id.txtRelatorio1);
            relatorio2 = itemView.findViewById(R.id.txtRelatorio2);
            statusRelatorio1 = itemView.findViewById(R.id.txtStatusRelatorio1);
            statusRelatorio2 = itemView.findViewById(R.id.txtStatusRelatorio2);
            comprovanteMatricula = itemView.findViewById(R.id.txtComprovanteMatricula);
            btnExcluir = itemView.findViewById(R.id.btnExcluir);
        }
    }
}
