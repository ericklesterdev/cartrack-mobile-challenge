package com.mvvm.sample.presentation.util

import android.content.Intent
import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun Fragment.isInFragmentStack(fragmentManager: FragmentManager, tag: String): Boolean {
    val fragment = fragmentManager.findFragmentByTag(tag)
    return fragment != null
}

fun Fragment.addFragment(fragmentManager: FragmentManager, frameId: Int, tag: String = "") {
    val transaction = fragmentManager.beginTransaction()
    transaction.add(frameId, this, tag)
    transaction.commit()
}

fun Fragment.replaceFragment(fragmentManager: FragmentManager, frameId: Int, tag: String = "", animate: Boolean = true) {
    val transaction = fragmentManager.beginTransaction()
    if (animate) {
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
    }
    transaction.replace(frameId, this, tag)
    transaction.commit()
}

fun Fragment.goToActivity(activity: Activity, dest: Class<*>) {
    val intent = Intent(activity, dest)
    activity.startActivity(intent)
}

fun Fragment.showFragment(fragmentManager: FragmentManager, animate: Boolean = true) {
    val transaction = fragmentManager.beginTransaction()
    if (animate) {
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
    }
    transaction.show(this)
            .commit()
}

fun Fragment.hideFragment(fragmentManager: FragmentManager, animate: Boolean = true) {
    val transaction = fragmentManager.beginTransaction()
    if (animate) {
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
    }
    transaction.hide(this)
            .commit()
}

fun Fragment.setHeight(newHeight: Int) {
    val view = this.view
    val params = view?.layoutParams!!
    params.apply {
        width = view.width
        height = newHeight
    }
    view.layoutParams = params
}