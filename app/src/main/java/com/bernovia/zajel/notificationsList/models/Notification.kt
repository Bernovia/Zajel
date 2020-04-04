package com.bernovia.zajel.notificationsList.models


import androidx.room.*
import com.google.gson.annotations.SerializedName


@Entity(tableName = "notification", indices = [Index("id_notification")]) data class Notification(
    @PrimaryKey @ColumnInfo(name = "id_notification") @SerializedName("id") val id: Int,
    @ColumnInfo(name = "content_notification") @SerializedName("content") val content: String,
    @ColumnInfo(name = "created_at_notification") @SerializedName("created_at") val createdAt: String,
    @Embedded @SerializedName("payload") val payload: Payload)