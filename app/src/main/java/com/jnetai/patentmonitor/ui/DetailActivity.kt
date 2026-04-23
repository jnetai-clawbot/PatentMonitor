package com.jnetai.patentmonitor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jnetai.patentmonitor.PatentMonitor
import com.jnetai.patentmonitor.binding.ActivityDetailBinding
import com.jnetai.patentmonitor.model.Patent
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val app get() = application as PatentMonitor
    private var item: Patent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        val itemId = intent.getLongExtra("item_id", -1)
        if (itemId == -1L) { finish(); return }
        
        lifecycleScope.launch {
            item = app.database.dao().getPatent(itemId)
            item?.let { displayDetails(it) }
        }
    }
    
    private fun displayDetails(item: Patent) {
        binding.titleText.text = item.title
        binding.detailText.text = item.toString()
    }

    override fun onSupportNavigateUp(): Boolean { finish(); return true }
}