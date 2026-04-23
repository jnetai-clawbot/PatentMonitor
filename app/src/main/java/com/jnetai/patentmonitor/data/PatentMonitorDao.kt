package com.jnetai.patentmonitor.data

import androidx.room.*
import com.jnetai.patentmonitor.model.Patent
import com.jnetai.patentmonitor.model.Trademark
import com.jnetai.patentmonitor.model.Reminder

@Dao
interface PatentMonitorDao {
    @Query("SELECT * FROM patents ORDER BY createdAt DESC") suspend fun getAllPatents(): List<Patent>
    @Query("SELECT * FROM patents WHERE id = :id") suspend fun getPatent(id: Long): Patent?
    @Insert suspend fun insertPatent(patent: Patent): Long
    @Update suspend fun updatePatent(patent: Patent)
    @Delete suspend fun deletePatent(patent: Patent)

    @Query("SELECT * FROM trademarks ORDER BY createdAt DESC") suspend fun getAllTrademarks(): List<Trademark>
    @Query("SELECT * FROM trademarks WHERE id = :id") suspend fun getTrademark(id: Long): Trademark?
    @Insert suspend fun insertTrademark(trademark: Trademark): Long
    @Update suspend fun updateTrademark(trademark: Trademark)
    @Delete suspend fun deleteTrademark(trademark: Trademark)

    @Query("SELECT * FROM reminders ORDER BY date ASC") suspend fun getAllReminders(): List<Reminder>
    @Insert suspend fun insertReminder(reminder: Reminder): Long
    @Update suspend fun updateReminder(reminder: Reminder)
    @Delete suspend fun deleteReminder(reminder: Reminder)
}