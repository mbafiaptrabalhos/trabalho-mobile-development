package br.com.fiap.trabalho_mobile_development

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.trabalho_mobile_development.di.networkModule
import br.com.fiap.trabalho_mobile_development.di.repositoryModule
import br.com.fiap.trabalho_mobile_development.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        // Start stetho
        Stetho.initializeWithDefaults(this)

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    repositoryModule
                )
            )
        }
    }
}