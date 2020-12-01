package com.mvvm.sample.presentation.onboarding.login

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mvvm.sample.BR
import com.mvvm.sample.R
import com.mvvm.sample.databinding.FragmentLoginBinding
import com.mvvm.sample.di.Injector.inject
import com.mvvm.sample.presentation.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private var fragmentLoginBinding: FragmentLoginBinding? = null

    @Inject
    lateinit var viewModel: LoginViewModel


    override fun getLayoutResource(): Int = R.layout.fragment_login

    override fun onActivityFinishing() {
    }

    override fun onCreateView(savedInstanceState: Bundle?) {
        inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        performDataBinding()
        setup()
    }

    private fun setup(){
        tv_register.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(getString(R.string.label_dont_have_account), Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(getString(R.string.label_dont_have_account))
        }

        viewModel.emailError.observe(this,  {
            fragmentLoginBinding?.tilEmail?.error = if (it != null) getString(it) else null
        })

        viewModel.passwordError.observe(this,  {
            fragmentLoginBinding?.tilPassword?.error = if (it != null) getString(it) else null
        })

    }

    private fun performDataBinding() {
        fragmentLoginBinding = DataBindingUtil.setContentView(activity!!, getLayoutResource())
        fragmentLoginBinding?.setVariable(BR.viewModel, viewModel)
        fragmentLoginBinding?.executePendingBindings()
    }

}