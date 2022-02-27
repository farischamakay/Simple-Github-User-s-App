package com.example.s1cfundamental

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.s1cfundamental.databinding.ItemUserRowBinding

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var binding: ItemUserRowBinding

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemUserRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemUserRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, location, company, photo) = listUser[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .circleCrop()
            .into(holder.binding.imgUserPhoto)
        holder.binding.tvUserName.text = name
        holder.binding.tvUserLocation.text = location
        holder.binding.tvUserCompany.text = company
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

    override fun getItemCount(): Int = listUser.size
}



