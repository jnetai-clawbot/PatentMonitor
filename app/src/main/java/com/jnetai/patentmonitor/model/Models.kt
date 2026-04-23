package com.jnetai.patentmonitor.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(tableName = "patents", indices = [Index("patentNumber")])
data class Patent(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val patentNumber: String,
    val title: String,
    val applicant: String = "",
    val status: String = "Active",
    val filingDate: String = "",
    val expiryDate: String = "",
    val renewalDate: String = "",
    val notes: String = "",
    val isFavourite: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "trademarks", indices = [Index("trademarkNumber")])
data class Trademark(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val trademarkNumber: String,
    val name: String,
    val owner: String = "",
    val status: String = "Registered",
    val registrationDate: String = "",
    val renewalDate: String = "",
    val category: String = "",
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "reminders", indices = [Index("date")])
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val patentId: Long = 0,
    val trademarkId: Long = 0,
    val title: String,
    val date: String = "",
    val type: String = "Renewal",
    val notes: String = "",
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)