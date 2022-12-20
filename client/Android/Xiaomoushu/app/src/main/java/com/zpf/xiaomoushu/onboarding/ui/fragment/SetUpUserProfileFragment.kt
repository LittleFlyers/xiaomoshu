package com.zpf.xiaomoushu.onboarding.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zpf.xiaomoushu.R
import com.zpf.xiaomoushu.onboarding.viewmodel.SetUpUserProfileViewModel

class SetUpUserProfileFragment : Fragment() {

    companion object {
        fun newInstance() = SetUpUserProfileFragment()
    }

    private lateinit var viewModel: SetUpUserProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_up_user_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SetUpUserProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}