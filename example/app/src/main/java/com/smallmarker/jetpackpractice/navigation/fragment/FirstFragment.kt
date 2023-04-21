package com.smallmarker.jetpackpractice.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import com.smallmarker.jetpackpractice.R
import com.smallmarker.jetpackpractice.navigation.DeepLinkActivity
import kotlin.random.Random


class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.apply {
            findViewById<Button>(R.id.btn_send).setOnClickListener {
                context?.let {
                    val pendingIntent = NavDeepLinkBuilder(it)
                        .setGraph(R.navigation.nav_deep_link)
                        .setDestination(R.id.deepLinkFragment)
                        .setArguments(
                            Bundle().apply {
                                putInt("id", 1)
                            }
                        )
                        .setComponentName(DeepLinkActivity::class.java)
                        .createPendingIntent()

                    val notification = NotificationCompat.Builder(it, "my_channel")
                        .setContentTitle("Title")
                        .setContentText("测试深层链接")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent)
                        .build()

                    NotificationManagerCompat.from(it).notify(Random.nextInt(10), notification)
                }
            }
        }
    }

}