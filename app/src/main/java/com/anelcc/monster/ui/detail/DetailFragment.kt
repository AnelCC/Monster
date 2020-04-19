package com.anelcc.monster.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.anelcc.monster.LOG_TAG
import com.anelcc.monster.R
import com.anelcc.monster.databinding.FragmentDetailBinding
import com.anelcc.monster.ui.share.SharedViewModel

class DetailFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, saveInstances: Bundle?): View? {
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        setHasOptionsMenu(true)
        navController = Navigation.findNavController(
            requireActivity(), R.id.nav_host
        )
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        Log.i(LOG_TAG, "DetailFragment viewModel ${viewModel.selectedMonster.value}")

        val binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            navController.navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }
}
