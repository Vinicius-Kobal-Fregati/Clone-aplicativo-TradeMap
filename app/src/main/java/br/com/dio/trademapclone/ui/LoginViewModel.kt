package br.com.dio.trademapclone.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dio.trademapclone.domain.ApiService
import br.com.dio.trademapclone.domain.Usuario
import br.com.dio.trademapclone.domain.UsuarioLogado
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val apiService: ApiService) : ViewModel() { //Essa é uma classe que estende de ViewModel, passamos também nossa Api aqui, injetamos ele por parâmetro com o private val.

    private val _usuario = MutableLiveData<Usuario>() //Temos um MutableLiveData.
    val usuario: LiveData<Usuario> = _usuario //Temos o nosso LiveData que recebe o Valor de um MutableLiveData, assim o mutable vai poder se alterar e o LiveData por consequência também vai, mas seu valor sempre será o "mesmo", visto que sempre será o mutable em si e não os valores dele. Com isso nosso fragment não tem acesso ao MutableLiveData, apenas ao LiveData.

    fun login(login: String) { //Esse é nosso método de login. Aqui vamos fazer uma requisição na API, passando o login,
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val usuario = apiService.login(login)
                UsuarioLogado.usuario = usuario
                _usuario.postValue(usuario)
            }.onFailure {
                Log.i("", it.message.orEmpty())
            }
        }
    }
}
