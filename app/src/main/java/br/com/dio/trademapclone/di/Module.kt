package br.com.dio.trademapclone.di

import br.com.dio.trademapclone.AppDatabase
import br.com.dio.trademapclone.MainViewModel
import br.com.dio.trademapclone.RetrofitService
import br.com.dio.trademapclone.repository.AcaoRepository
import br.com.dio.trademapclone.ui.AcaoViewModel
import br.com.dio.trademapclone.ui.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

//Aqui vamos ensinar a fazer a injeção de dependência.
val viewModelModule = module {
    //Esse é o módulo do nosso Koin.
    viewModel { MainViewModel(get()) }
    viewModel { LoginViewModel(get()) } //Ou seja, sempre que precisarmos do nosso LoginViewModel, basta criar uma instância dele. Essa dsl faz alguns tratamentos no nosso fragment.
    viewModel { AcaoViewModel(get()) }
}

val serviceModule = module {
    //Vamos usar un single, mas também poderíamos utilizar o factory. O single é uma instância única no nosso projeto, enquanto o factory cria uma nova toda vez que é chamado.
    single { RetrofitService.createService() } //Aqui passamos nosso object do retrofit e aplicamos uma criação do Service.
}

val repositoryModule = module {
    single { AcaoRepository(get(), get()) }
}

val daoModule = module {
    single { AppDatabase.getInstance(androidContext()).acaoDAO() }
}