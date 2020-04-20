package com.anelcc.monster.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.anelcc.monster.R



class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        displayMainFragment()
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun displayMainFragment() {
        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host)
        navController.navigate(
            R.id.action_splashFragment_to_mainFragment, null,
            NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()
        )
    }

}
