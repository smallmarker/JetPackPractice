package com.smallmarker.jetpackpractice.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.smallmarker.jetpackpractice.R


/**
 * @author   zl
 * @Date     2023/4/21
 **/
class DeepLinkFragment : Fragment(R.layout.fragment_deep_link) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.apply {
            val id = arguments?.getInt("id")
            findViewById<TextView>(R.id.tv_deep_link).text = "深层链接跳转目的地页面(参数id: ${id})"
        }
    }
}