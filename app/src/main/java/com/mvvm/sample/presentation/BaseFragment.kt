package com.mvvm.sample.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseFragment : Fragment() {


    protected abstract fun getLayoutResource(): Int

    /**
     * Rely on this instead of onDestroy() or onDestroyView() because the mentioned methods are not guaranteed to be called.
     *
     * https://developer.android.com/reference/android/app/Activity.html#onDestroy()
     */
    protected abstract fun onActivityFinishing()

    protected abstract fun onCreateView(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(getLayoutResource(), container, false)
        onCreateView(savedInstanceState)
        return rootView
    }

    override fun onPause() {
        super.onPause()

        activity?.let {
            if (it.isFinishing) {
                onActivityFinishing()
            }
        }
    }

}
