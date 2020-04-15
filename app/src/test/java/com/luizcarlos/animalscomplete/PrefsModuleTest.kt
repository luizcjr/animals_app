package com.luizcarlos.animalscomplete

import android.app.Application
import com.luizcarlos.animalscomplete.di.PrefsModule
import com.luizcarlos.animalscomplete.util.SharedPreferencesHelper

class PrefsModuleTest(val mockPrefs : SharedPreferencesHelper) : PrefsModule() {

    override fun providesSharedPreference(app: Application): SharedPreferencesHelper {
        return mockPrefs
    }
}