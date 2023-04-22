package com.smallmarker.jetpackpractice.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.smallmarker.jetpackpractice.R

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.apply {
            findViewById<Button>(R.id.btn_extras).setOnClickListener {
                it.findNavController().navigate(R.id.deepLinkActivity)
            }

            findViewById<ImageView>(R.id.image_view).setOnClickListener {
                val option = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), findViewById(R.id.image_view), "shared_element")
                it.findNavController().navigate(R.id.shareElementDialog, null, null, ActivityNavigatorExtras(option))
            }
        }
    }
}