package com.anelcc.monster.ui.splash

import android.Manifest
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.anelcc.monster.R

const val PERMISSION_REQUEST_CODE = 1001

class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (ContextCompat.checkSelfPermission(requireContext(), WRITE_EXTERNAL_STORAGE) == PERMISSION_GRANTED) {
            displayMainFragment()
        } else {
            requestPermissions(arrayOf(WRITE_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
        }
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun displayMainFragment() {
        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host)
        navController.navigate(
            R.id.action_splashFragment_to_mainFragment, null,
            NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PERMISSION_GRANTED) {
                displayMainFragment()
            } else {
                Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }

}
