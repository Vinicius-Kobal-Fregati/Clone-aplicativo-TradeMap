package br.com.dio.trademapclone.domain

data class Usuario( //Nossa classe de usuários com todas as informações sobre ele. POr ser um data class, ele já tem os getters e setters implementados pelo Kotlin (é útil só para armaxenar dados).
    val login: String,
    val senha: String,
    val email: String,
    val nome: String,
    val acoesFavoritas: List<Acao>, //Aqui temos outra data class, ação, no arquivo Acao.kt.
    val ativo: Boolean
)
