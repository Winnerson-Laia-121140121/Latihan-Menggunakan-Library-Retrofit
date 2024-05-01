package com.example.latihanpam7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private var userList: List<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_user, parent, false))
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int{
        return userList.size
    }

    fun setData(newList: List<User>){
        userList = newList
        notifyDataSetChanged()
    }
    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)

        fun bind(user: User){
            Glide.with(itemView.context).load(user.avatar).into(avatarImageView)
            nameTextView.text = "${user.firstname} ${user.lastname}"
            emailTextView.text = user.email
        }
    }
}
