package com.zpf.xiaomoushu.onboarding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zpf.xiaomoushu.R
import com.zpf.xiaomoushu.onboarding.ui.fragment.SignInFragment

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SignInFragment.newInstance())
                .commitNow()
        }
    }
}