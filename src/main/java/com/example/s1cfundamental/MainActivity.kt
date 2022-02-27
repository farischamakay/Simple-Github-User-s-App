package com.example.s1cfundamental

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser : RecyclerView
    private val list = ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_users)
        rvUser.setHasFixedSize(true)

        val actionBar = supportActionBar
        actionBar?.title = "Github User's"


        list.addAll(listUser)
        showRecyclerList()

    }


    private val listUser:ArrayList<User>
    @SuppressLint("Recycle")
    get() {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataCompany = resources.getStringArray(R.array.data_company)
        val dataPhoto = resources.obtainTypedArray(R.array.data_avatar)
        val dataUsername = resources.getStringArray(R.array.data_username)
        val dataFollowers = resources.getStringArray(R.array.data_followers)
        val dataFollowing = resources.getStringArray(R.array.data_following)
        val dataReposity = resources.getStringArray(R.array.data_repository)
        val listUser = ArrayList<User>()
        for (i in dataName.indices) {
            val user = User(dataName[i],dataLocation[i], dataCompany[i], dataPhoto.getResourceId(i, -1), dataUsername[i],
                dataFollowers[i], dataFollowing[i], dataReposity[i])
            listUser.add(user)
        }
        return listUser
    }


    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })

    }
}