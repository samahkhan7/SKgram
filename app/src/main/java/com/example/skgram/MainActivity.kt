package com.example.skgram

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.*
import java.io.File

/**
 * Let user create a post by taking a photo with their camera
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. setting the description of the past
        // 2. A button to launch the camera to take a picture
        // 3. An ImageView to show the picture the user has taken
        // 4. A button to save and send the post to the Parse server

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemReselectedListener {

            // define our own variable to replace generic 'it' variable
            item ->

            when (item.itemId) {

                // when home is clicked
                // when compose is clicked
                // when profile is clicked
                R.id.action_home -> {
                    // TODO navigate to the Home screen
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }
                R.id.action_compose -> {// TODO navigate to the Compose screen
                    Toast.makeText(this, "Compose", Toast.LENGTH_SHORT).show()
                }
                R.id.action_profile -> {// TODO navigate to the Profile screen
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
            }

            // return true to indicate we've handled this user interaction
            true
        }

     //   queryPosts()
    }


    // Query for all posts in our server
    fun queryPosts() {
        // Specify which class to query
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        query.include(Post.KEY_USER)
        query.findInBackground(object : FindCallback<Post> {
            override fun done(posts: MutableList<Post>?, e:ParseException?) {
                if (e != null) {
                    // something went wrong
                    Log.e(TAG, "Error fetching posts")
                } else {
                    if (posts != null) {
                        for (post in posts) {
                            Log.i(TAG,"Post: " + post.getDescription() + " , username: " + post.getUser()?.username)

                        }
                    }
                }
            }
        })

    }

    companion object {
        const val TAG = "MainActivity"
    }

}

