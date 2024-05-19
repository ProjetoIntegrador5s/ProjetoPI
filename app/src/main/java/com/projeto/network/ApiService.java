package com.projeto.network;
import com.projeto.model.EstagiarioModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("/estagiarios")
    Call<List<EstagiarioModel>> obterEstagiarios();

    @POST("/estagiarios")
    Call<List<EstagiarioModel>> cadastrarEstagiario();
}
