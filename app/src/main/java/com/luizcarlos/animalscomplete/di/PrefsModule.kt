package com.luizcarlos.animalscomplete.di

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.luizcarlos.animalscomplete.util.SharedPreferencesHelper
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
open class PrefsModule {

    /*
    * A annotation singleton, garante que é criado apenas umas instância da classe em questão
    * A annotatico TypeOfContext define o tipo do contexto em que pode ser chamado
    *  */
    @Provides
    @Singleton
    @TypeOfContext(CONTEXT_APP)
    open fun providesSharedPreference(app: Application): SharedPreferencesHelper {
        return SharedPreferencesHelper(app)
    }

    @Provides
    @Singleton
    @TypeOfContext(CONTEXT_ACTIVITY)
    fun providesActivitySharedPreference(activity: AppCompatActivity): SharedPreferencesHelper {
        return SharedPreferencesHelper(activity)
    }
}

const val CONTEXT_APP = "Application context"
const val CONTEXT_ACTIVITY = "Activity context"

/*
* O qualifier é utilizado quando é necessário ter mais de uma aplicação da injeção
 */
@Qualifier
annotation class TypeOfContext(val type: String)