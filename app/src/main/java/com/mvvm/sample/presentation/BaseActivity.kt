package com.mvvm.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mvvm.sample.presentation.util.addFragment
import com.mvvm.sample.presentation.util.replaceFragment


abstract class BaseActivity : AppCompatActivity(){

    private lateinit var fragmentManager: FragmentManager

    protected abstract fun getLayoutResource(): Int

    /**
     * Rely on this instead of onDestroy() or onDestroyView() because the mentioned methods are not guaranteed to be called.
     *
     * https://developer.android.com/reference/android/app/Activity.html#onDestroy()
     */
    protected abstract fun onActivityFinishing()

    protected abstract fun setupInjection()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInjection()

        if (getLayoutResource() != 0) {
            setContentView(getLayoutResource())
        }

        fragmentManager = supportFragmentManager
    }


    protected fun setCustomToolbar(toolbar: Toolbar, backButton: Boolean = false) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(backButton)
        supportActionBar?.setDisplayShowHomeEnabled(backButton)
        supportActionBar?.setHomeButtonEnabled(backButton)
    }
    
    protected fun setDisplayHomeAsUpEnabled(show: Boolean){
        supportActionBar?.setDisplayHomeAsUpEnabled(show)
    }
    
    protected fun getBackStackEntryCount(): Int = fragmentManager.backStackEntryCount


    protected fun removeAllFragmentsInBackStack() {
        val count = fragmentManager.backStackEntryCount
        for (i in 0 until count) {
            fragmentManager.popBackStackImmediate()
        }
    }

    protected fun removeCurrentFragmentInBackStack() {
        fragmentManager.popBackStackImmediate()
    }



    fun addBaseFragment(fragment: BaseFragment, container: Int, tag: String = "") {
        fragment.addFragment(supportFragmentManager, container, tag)
    }

    fun replaceBaseFragment(fragment: BaseFragment, container: Int, tag: String = "", animate: Boolean = false) {
        fragment.replaceFragment(supportFragmentManager, container, tag, animate = animate)
    }

    /**
     * Show provided fragment in containerId. This the same as replacing the fragment in containerId
     * using [androidx.fragment.app.FragmentTransaction.replace].
     * @param containerId containerId which will contain the fragment
     * @param fragment the fragment that will be displayed in the containerId
     * @param addToBackStack if true, create a backstack entry
     */
    protected fun showFragment(containerId: Int, fragment: Fragment, addToBackStack: Boolean) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(containerId, fragment)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    override fun onPause() {
        super.onPause()
        if (isFinishing){
            onActivityFinishing()
        }
    }
}