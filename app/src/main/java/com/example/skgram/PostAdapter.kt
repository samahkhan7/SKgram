package com.example.skgram

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class PostAdapter(val context: Context, val posts: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        // Specify the layout file to use for this item
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        // get & inflate specific post out of list of posts and
        // call bind method to display relevant information
        val post = posts.get(position)
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    // clean all elements of the recycler
    fun clear() {
        posts.clear()
        notifyDataSetChanged()
    }

    // add a list of items - change to type used
    fun addAll(postList: List<Post>) {
        posts.addAll(postList)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUsername: TextView
        val ivImage: ImageView
        val tvDescription: TextView

        init {
            tvUsername = itemView.findViewById(R.id.tvUsername)
            ivImage = itemView.findViewById(R.id.ivImage)
            tvDescription = itemView.findViewById(R.id.tvCaption)
        }

        fun bind(post: Post) {
            tvDescription.text = post.getDescription()
            tvUsername.text = post.getUser()?.username

            // populate image view using glide library
            Glide.with(itemView.context).load(post.getImage()?.url).into(ivImage)

        }
    }

}
