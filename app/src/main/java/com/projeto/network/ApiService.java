package com.projeto.network;
import com.projeto.model.EstagiarioModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("/estagiarios")
    Call<List<EstagiarioModel>> obterEstagiarios();

    @POST("/estagiarios/cadastrar")
    Call<Void> cadastrarEstagiario(@Body EstagiarioModel estagiarioModel);

    @POST("/estagiarios/alterar")
    Call<List<EstagiarioModel>> alterarEstagiario();

    @POST("/estagiarios/excluir")
    Call<Void> excluirEstagiario(@Body EstagiarioModel estagiarioModel);

    @POST("/estagiarios/excluirById")
    Call<Void>  excluirByIdEstagiario(@Body EstagiarioModel estagiarioModel);

}
