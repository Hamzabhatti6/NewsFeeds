package com.hamza.bhatti.wrappers

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.hamza.bhatti.R
import com.hamza.bhatti.models.News

class HomeNavigationWrapper: AppWrapper() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private const val viewId: Int = R.id.nav_home_fragment
        @SuppressLint("StaticFieldLeak")
        private var navController: NavController? = null

        fun init(mainActivity: Activity?) {
            if (mainActivity != null) {
                navController = Navigation.findNavController(mainActivity, viewId)
            }
        }

        private fun getPopUpHomeNavOption(): NavOptions {
            val navBuilder = NavOptions.Builder()
            navBuilder.setEnterAnim(R.anim.slide_in).setExitAnim(R.anim.fade_out)
                .setPopEnterAnim(R.anim.slide_in).setPopExitAnim(R.anim.fade_out)

            return navBuilder.build()
        }

        fun showNewsDetail(news: News) {
            if (navController != null) {
                val bundle = Bundle()
                bundle.putSerializable("newsModel", news)
                navController!!.navigate(R.id.newsDetailFragment, bundle, getPopUpHomeNavOption())
            }
        }

    }
}