package com.example.viewpager2lesson.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2lesson.R
import com.example.viewpager2lesson.databinding.ViewpagerItemBinding
import com.example.viewpager2lesson.models.User

class ViewPagerRvAdapter(private val list: ArrayList<User>):RecyclerView.Adapter<ViewPagerRvAdapter.Vh>() {
    inner class Vh(val viewpagerItemBinding: ViewpagerItemBinding):RecyclerView.ViewHolder(viewpagerItemBinding.root){
        fun onBind(user: User,position: Int){
            viewpagerItemBinding.tvName.text = user.name
            viewpagerItemBinding.image.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ViewpagerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}