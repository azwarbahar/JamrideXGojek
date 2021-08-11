package com.azwarbahar.jamridexgojek.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.azwarbahar.jamridexgojek.R

class MainPromosFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val rootView = inflater.inflate(R.layout.fragment_main_promos, container, false)

        return rootView

    }

}