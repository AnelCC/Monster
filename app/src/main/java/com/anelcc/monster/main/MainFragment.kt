package com.anelcc.monster.main


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anelcc.monster.LOG_TAG
import com.anelcc.monster.MainViewModel

import com.anelcc.monster.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /*That will notify the ViewModel when changes happen. And then I need an Observer object.
         Within the Observer object, I'll receive the data as a list of Monster objects. So I'll go back to my ViewModel.*/
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.monsterData.observe(this, Observer {
            val monsterNames = StringBuilder()
            /*I'll reference it as it. That is, this is the value that was passed in when the observer class received changes to the data*/
            for (monster in it) {
                monsterNames.append(monster.name).append("\n")
                //Log.i(LOG_TAG, "parseText: ${monster.name} (\$${monster.price})")
            }
            monster_name.text = monsterNames
        })

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
