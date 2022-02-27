package com.example.s1cfundamental

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class DetailActivity : AppCompatActivity() {

    private var favorite = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val actionBar = supportActionBar
        actionBar?.title = "Detail User's"

        actionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<User>("DATA")


        val name: TextView = findViewById(R.id.tv_user_name)
        name.text = data?.name.toString()

        val location: TextView = findViewById(R.id.tv_user_location)
        location.text = "Location : " + data?.location.toString()

        val company: TextView = findViewById(R.id.tv_user_company)
        company.text = "Company : " + data?.company.toString()

        val photo: ImageView = findViewById(R.id.img_user_photo)


        val username: TextView = findViewById(R.id.tv_name)
        username.text = data?.username.toString()

        val follower: TextView = findViewById(R.id.tv_followers)
        follower.text = data?.followers.toString()

        val following: TextView = findViewById(R.id.tv_following)
        following.text = data?.following.toString()

        val repository: TextView = findViewById(R.id.tv_repository)
        repository.text = data?.repository.toString()


        val photoUser = data?.photo!!.toInt()
        photo.setImageResource(photoUser)


    }

    private fun setFavoriteIcon(menuItem: MenuItem){
        val id = if (favorite ) R.drawable.ic_baseline_favorite_black;
        else R.drawable.ic_baseline_favorite_white;

        menuItem.icon = ContextCompat.getDrawable(this,id)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuu, menu)

        setFavoriteIcon(menu?.findItem(R.id.favorite)!!)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.favorite -> {
                favorite = !favorite
                setFavoriteIcon(item)
            }

            R.id.share -> {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,"Send to WhatsApp : https://chat.whatsapp.com/")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }


        return super.onOptionsItemSelected(item)
    }
}


