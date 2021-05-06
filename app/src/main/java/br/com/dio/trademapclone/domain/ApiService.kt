package br.com.dio.trademapclone.domain

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService { //Essa é nossa interface, ela possui dois métodos, um de login e outro de favoritos.

    @GET("/usuarios/{login}") //Operação do tipo GET, ele possui o login passado por parâmetro (pois é uma variável), com isso, precisamos do path.
    suspend fun login(@Path("login") login: String): Usuario //Aqui conseguimos acessar a variável login e passar ela de forma correta para nosso GET. Essa requisição, nos devolve um usuário (arquivo Usuario.kt).

    @POST("/acoes/favorita")
    suspend fun adicionarFavorito(@Body acaoFavorita: AcaoFavorita): Acao //Vamos usar o suspend para fazermos de forma assíncrona

}