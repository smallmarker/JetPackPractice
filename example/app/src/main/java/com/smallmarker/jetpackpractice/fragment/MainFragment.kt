package com.smallmarker.jetpackpractice.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.smallmarker.jetpackpractice.databinding.FragmentMainBinding
import com.smallmarker.jetpackpractice.entity.JetpackType
import com.smallmarker.jetpackpractice.model.MainViewModel
import kotlin.random.Random


/**
 * @author   zl
 * @Date     2023/4/21
 **/
class MainFragment : Fragment() {


    // ViewModel
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    // 组件列表
    private val itemList = mutableListOf<JetpackType>().apply {
        add(JetpackType.Navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getNavigateTo().observe(this) {
            Navigation.findNavController(requireView()).navigate(it)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(layoutInflater)
        binding.rvJetpack.adapter = MyAdapter(itemList) {
            when (it) {
                JetpackType.Navigation -> {
                    viewModel.setNavigateTo(MainFragmentDirections.actionMainToNavigationActivity())
                }
            }
        }
        return binding.root
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

        /**
         * 随机生成背景色
         */
        private fun randomAndroidColor(): Int {
            val red = Random.nextInt(256)
            val green = Random.nextInt(256)
            val blue = Random.nextInt(256)

            return Color.rgb(red, green, blue)
        }
    }
}