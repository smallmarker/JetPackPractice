package com.smallmarker.jetpackpractice.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smallmarker.jetpackpractice.databinding.ActivityDeepLinkBinding


/**
 * @author   zl
 * @Date     2023/4/21
 **/
class DeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDeepLinkBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}