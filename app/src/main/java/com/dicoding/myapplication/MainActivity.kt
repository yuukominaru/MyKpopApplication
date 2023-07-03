package com.dicoding.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKpopList: RecyclerView
    private val list = ArrayList<Kpop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKpopList = findViewById(R.id.rv_kpop_list)
        rvKpopList.setHasFixedSize(true)

        list.addAll(getKpopList())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvKpopList.layoutManager = LinearLayoutManager(this)
        val listKpopAdapter = KpopListAdapter(list)
        rvKpopList.adapter = listKpopAdapter

        listKpopAdapter.setOnItemClickCallback(object : KpopListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Kpop) {
                showKpopList(data)
            }
        })
    }

    private fun getKpopList(): Collection<Kpop> {
        val groupName = resources.getStringArray(R.array.group_names)
        val groupDesc = resources.getStringArray(R.array.descriptions)
        val groupExtraDesc = resources.getStringArray(R.array.extra_descs)
        val groupPhoto = resources.obtainTypedArray(R.array.group_photos)
        val listGroup = ArrayList<Kpop>()

        for (i in groupName.indices) {
            val group = Kpop(groupName[i], groupDesc[i], groupExtraDesc[i], groupPhoto.getResourceId(i, -1))
            listGroup.add(group)
        }

        return listGroup
    }

    private fun showKpopList(group: Kpop) {
        val showDetail = Intent(this@MainActivity, ShowDetailActivity::class.java)
        showDetail.putExtra(ShowDetailActivity.EXTRA_GROUP, group)
        startActivity(showDetail)
    }
}