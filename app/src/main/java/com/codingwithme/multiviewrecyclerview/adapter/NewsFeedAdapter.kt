package com.codingwithme.multiviewrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwithme.multiviewrecyclerview.R
import com.codingwithme.multiviewrecyclerview.model.NewsFeedModel
import de.hdodenhof.circleimageview.CircleImageView
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple

class NewsFeedAdapter(val context:Context,val list:ArrayList<NewsFeedModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var itemView: View? = null
        itemView = LayoutInflater.from(context).inflate(R.layout.item_newsfeed,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            var model = list[position]

            holder.bindTo(model,model.viewType)

            Glide.with(context).load(model.profileImage).into(holder.imageProfile)
            holder.txtName.text = model.name
            holder.txtTime.text = model.time

            if (model.viewType == 1) {
                holder.txtPost.text = model.postText
            }

            if (model.viewType == 2) {
                holder.txtImagePost.text = model.postText
                Glide.with(context).load(model.postImageUrl).into(holder.postImage)
            }

            if (model.viewType == 3) {
                holder.txtVideoPost.text = model.postText
                videoInit(model.postVideoUrl,holder)

            }
        }

    }

    private fun videoInit(path:String,holder:ViewHolder){
        holder.postVideo.setUp(path,JCVideoPlayerSimple.SCREEN_LAYOUT_NORMAL,"")
        val mediaController = MediaController(context)
        mediaController.setAnchorView(holder.postVideo)

    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){


        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtTime = view.findViewById<TextView>(R.id.txtTime)

        val imageProfile = view.findViewById<CircleImageView>(R.id.imgProfile)
        val postImage = view.findViewById<ImageView>(R.id.imgPost)
        val postVideo = view.findViewById<JCVideoPlayerSimple>(R.id.videoView)

        val txtPost = view.findViewById<TextView>(R.id.txtPostText)
        val txtImagePost = view.findViewById<TextView>(R.id.txtPostImage)
        val txtVideoPost = view.findViewById<TextView>(R.id.txtPostVideo)


        val txtLayout = view.findViewById<RelativeLayout>(R.id.layoutText)
        val imageLayout = view.findViewById<LinearLayout>(R.id.layoutImage)
        val videoLayout = view.findViewById<LinearLayout>(R.id.layoutVideo)
        var model:NewsFeedModel? = null

        fun bindTo(model:NewsFeedModel,viewType:Int){
            this.model = model
            this.model?.let {
                when(viewType){
                    1 -> {
                        txtLayout.visibility = View.VISIBLE
                        imageLayout.visibility = View.GONE
                        videoLayout.visibility = View.GONE
                    }
                    2 -> {
                        txtLayout.visibility = View.GONE
                        imageLayout.visibility = View.VISIBLE
                        videoLayout.visibility = View.GONE
                    }
                    3 -> {
                        txtLayout.visibility = View.GONE
                        imageLayout.visibility = View.GONE
                        videoLayout.visibility = View.VISIBLE
                    }
                    else -> {
                        txtLayout.visibility = View.GONE
                        imageLayout.visibility = View.GONE
                        videoLayout.visibility = View.GONE
                    }
                }
            }
        }

    }
}