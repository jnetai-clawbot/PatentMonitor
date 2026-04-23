package com.jnetai.patentmonitor.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jnetai.patentmonitor.PatentMonitor
import com.jnetai.patentmonitor.R
import com.jnetai.patentmonitor.databinding.ActivityAddBinding
import com.jnetai.patentmonitor.model.Patent
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private val app get() = application as PatentMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Add New Patent"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.saveButton.setOnClickListener {
            val title = binding.editTitle.text.toString().trim()
            if (title.isEmpty()) {
                Toast.makeText(this, "Title is required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            lifecycleScope.launch {
                val item = Patent(patentNumber = title, title = title, applicant = binding.editSubtitle.text.toString().trim())
            app.database.dao().insertPatent(item)
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean { finish(); return true }
}