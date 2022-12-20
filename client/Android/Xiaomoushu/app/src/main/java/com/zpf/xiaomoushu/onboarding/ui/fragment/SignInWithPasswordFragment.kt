package com.zpf.xiaomoushu.onboarding.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zpf.xiaomoushu.R
import com.zpf.xiaomoushu.onboarding.viewmodel.SignInWithPasswordViewModel

class SignInWithPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = SignInWithPasswordFragment()
    }

    private lateinit var viewModel: SignInWithPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in_with_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignInWithPasswordViewModel::class.java)
        // TODO: Use the ViewModel
    }

}