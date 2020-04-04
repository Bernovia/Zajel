package com.bernovia.zajel.notificationsList.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bernovia.zajel.R
import com.bernovia.zajel.databinding.ItemNotificationsBinding
import com.bernovia.zajel.helpers.DateUtil.timeAgo
import com.bernovia.zajel.notificationsList.models.Notification

class NotificationsListViewHolder(var itemBinding: ItemNotificationsBinding, private var fragmentManager: FragmentManager) : RecyclerView.ViewHolder(itemBinding.root) {


    companion object {
        fun create(parent: ViewGroup, fragmentManager: FragmentManager): NotificationsListViewHolder {

            val binding: ItemNotificationsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_notifications, parent, false)
            return NotificationsListViewHolder(binding, fragmentManager)
        }
    }

    fun bindTo(data: Notification?) {
        if (data != null) {
            itemBinding.titleTextView.text = data.payload.title
            itemBinding.subjectTextView.text = data.payload.subject
            itemBinding.createdAtTextView.text= timeAgo(data.createdAt)
            itemBinding.root.setOnClickListener {

            }
        }


    }

}