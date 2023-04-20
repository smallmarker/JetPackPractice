package com.smallmarker.jetpackpractice

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.smallmarker.jetpackpractice.databinding.ActivityMainBinding
import com.smallmarker.jetpackpractice.entity.JetpackType
import com.smallmarker.jetpackpractice.navigation.NavigationActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val itemList = mutableListOf<JetpackType>().apply {
        add(JetpackType.Navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvJetpack.run {
            adapter = MyAdapter(itemList) {
                when (it) {
                    JetpackType.Navigation -> {
                        startActivity(Intent(this@MainActivity, NavigationActivity::class.java))
                    }
                }
            }
        }
    }

    class MyAdapter(
        private val itemList: MutableList<JetpackType>,
        private val onClickListener: (JetpackType) -> Unit
    ) : RecyclerView.Adapter<MyAdapter.Holder>() {
        class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView = itemView as TextView
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(TextView(parent.context).apply {
                gravity = Gravity.CENTER
                setBackgroundColor(randomAndroidColor())
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 120)
            })
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            val type = itemList[position]
            holder.textView.run {
                text = type.name
                setOnClickListener {
                    onClickListener.invoke(type)
                }
            }
        }

        private fun randomAndroidColor(): Int {
            val red = Random.nextInt(256)
            val green = Random.nextInt(256)
            val blue = Random.nextInt(256)

            return Color.rgb(red, green, blue)
        }
    }
}