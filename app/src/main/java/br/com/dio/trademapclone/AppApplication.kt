package br.com.dio.trademapclone

import android.app.Application
import br.com.dio.trademapclone.di.daoModule
import br.com.dio.trademapclone.di.repositoryModule
import br.com.dio.trademapclone.di.serviceModule
import br.com.dio.trademapclone.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() { //Essa classe estende de Application, ela vai ensinar para nosso Koin como injetar uma independência, como o ViewModel. Essa classe vai ser instanciada antes de todas as outras, precisamos startar ela passando nosso koin.

    override fun onCreate() { //Vamos usar o ciclo de vida onCreate.
        super.onCreate()
        startKoin { //Chamamos uma dsl do Koin que starta ele. Precisamos passar dois parâmetros, o contexto e os nossos módulos (onde vamos ensinar o koin a criar os objetos, para isso, vamos usar a pasta di (dependece injection).
            androidContext(this@AppApplication)
            modules(viewModelModule, serviceModule, repositoryModule, daoModule) //Vamos passar nossos módulos que vão ser iniciados.
        }
    }
}