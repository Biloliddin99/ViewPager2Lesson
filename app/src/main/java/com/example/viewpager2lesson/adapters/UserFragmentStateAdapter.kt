package com.example.viewpager2lesson.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager2lesson.fragments.ViewPagerFragment
import com.example.viewpager2lesson.models.User

class UserFragmentStateAdapter(fragmentActivity: FragmentActivity, val list: ArrayList<User>) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return ViewPagerFragment.newInstance(
            list[position].name,
            list[position].imageView.toString()
        )
    }
}