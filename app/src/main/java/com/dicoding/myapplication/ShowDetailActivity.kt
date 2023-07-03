package com.dicoding.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class ShowDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_GROUP = "extra_group"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        val tvName: TextView = findViewById(R.id.tv_group_name)
        val tvDesc: TextView = findViewById(R.id.tv_description)
        val tvExtraDesc: TextView = findViewById(R.id.tv_extra_desc)
        val photo: ImageView = findViewById(R.id.group_photo)

        val groups = intent.getParcelableExtra<Kpop>(EXTRA_GROUP)
        photo.setImageResource(groups?.photo!!)
        tvName.text = groups.name
        tvDesc.text = groups.description
        tvExtraDesc.text = groups.extraDesc

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}