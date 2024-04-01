package com.example.qoachandroid.User.Adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qoachandroid.R
import com.example.qoachandroid.User.Model.UserRecentNotificationModel
import com.example.qoachandroid.databinding.CellUserHomePopularCoachesBinding

class UserHomePopularCoachAdapter(private val mList: List<UserRecentNotificationModel>) : RecyclerView.Adapter<UserHomePopularCoachAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
//        val view = LayoutInflater.from(parent.context) .inflate(R.layout.cell_user_home_popular_coaches, parent, false)
//
//        return ViewHolder(view)

        val binding = CellUserHomePopularCoachesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)
//
//        // sets the text to the textview from our itemHolder class
//        holder.textView.text = ItemsViewModel.text
        if (position ==0){
            holder.binding.txtCoachTagName.text = "Novice"
            holder.binding.coachTagLayout.background.setColorFilter(Color.parseColor("#2ECC71"), PorterDuff.Mode.SRC_ATOP)
        }else if (position == 1){
            holder.binding.txtCoachTagName.text = "Master"
            holder.binding.coachTagLayout.background.setColorFilter(Color.parseColor("#5B2C6F"), PorterDuff.Mode.SRC_ATOP)
        }else if (position == 2){
            holder.binding.txtCoachTagName.text = "Elite"
            holder.binding.coachTagLayout.background.setColorFilter(Color.parseColor("#FFB300"), PorterDuff.Mode.SRC_ATOP)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(val binding: CellUserHomePopularCoachesBinding) : RecyclerView.ViewHolder(binding.root) {
//        val imageView: ImageView = itemView.findViewById(R.id.imageview)
//        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}