package com.example.viewpager2lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import com.example.viewpager2lesson.adapters.UserFragmentStateAdapter
import com.example.viewpager2lesson.adapters.ViewPagerRvAdapter
import com.example.viewpager2lesson.databinding.ActivityMainBinding
import com.example.viewpager2lesson.databinding.TabItemBinding
import com.example.viewpager2lesson.models.User
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerRvAdapter: ViewPagerRvAdapter
    private lateinit var list: ArrayList<User>
    private lateinit var userFragmentStateAdapter: UserFragmentStateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        userFragmentStateAdapter = UserFragmentStateAdapter(this, list)
        binding.myViewPager.adapter = userFragmentStateAdapter
//        viewPagerRvAdapter = ViewPagerRvAdapter(list)

        TabLayoutMediator(binding.myTabLayout, binding.myViewPager) { tab, position ->
            val tabItemBinding = TabItemBinding.inflate(layoutInflater)
            tabItemBinding.tvTab.text = list[position].name
            tabItemBinding.image.setImageResource(list[position].imageView)
            tab.customView = tabItemBinding.root
//            tab.text = "1"
//            tab.text = "2"
//            tab.text = "2"
//            tab.text = "2"
        }.attach()


    }

    private fun loadData() {
        list = ArrayList()

        list.addAll(
            listOf(
                User("hello", R.drawable.ic_launcher_foreground),
                User("good", R.drawable.ic_launcher_foreground),
                User("amazing", R.drawable.ic_launcher_foreground),
                User("astonishing", R.drawable.ic_launcher_foreground)
            )
        )
    }
}