package com.anelcc.monster.ui.detail

import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.anelcc.monster.LOG_TAG
import com.anelcc.monster.R
import com.anelcc.monster.ui.share.ShareViewModel

class DetailFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var viewModel: ShareViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, saveInstances: Bundle?): View? {
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        setHasOptionsMenu(true)
        navController = Navigation.findNavController(
            requireActivity(), R.id.nav_host
        )
        viewModel = ViewModelProviders.of(requireActivity()).get(ShareViewModel::class.java)
        viewModel.selectedMonster.observe(this, Observer {
            Log.i(LOG_TAG, "Selected monster: ${it.name}")
        })

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home) {
            navController.navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }
}
