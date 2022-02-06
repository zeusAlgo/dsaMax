package com.alg.dsaMax.ui.main
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.alg.dsaMax.R

class settingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}