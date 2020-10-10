package com.codingwithme.multiviewrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithme.multiviewrecyclerview.adapter.NewsFeedAdapter
import com.codingwithme.multiviewrecyclerview.model.NewsFeedModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsFeedArray = ArrayList<NewsFeedModel>()
        newsFeedArray.add(NewsFeedModel("https://lh3.googleusercontent.com/a-/AOh14Gh5NOYDiFV9BdkDn1j_FN_AbWKQWtgnMqhJLvaC=s88-c-k-c0x00ffffff-no-rj-mo","Farhan","48 mins",1,"this is First Text Post","",""))
        newsFeedArray.add(NewsFeedModel("https://lh3.googleusercontent.com/a-/AOh14Gh5NOYDiFV9BdkDn1j_FN_AbWKQWtgnMqhJLvaC=s88-c-k-c0x00ffffff-no-rj-mo","Farhan","48 mins",1,"this is Second Text Post","",""))
        newsFeedArray.add(NewsFeedModel("https://lh3.googleusercontent.com/a-/AOh14Gh5NOYDiFV9BdkDn1j_FN_AbWKQWtgnMqhJLvaC=s88-c-k-c0x00ffffff-no-rj-mo","Farhan","48 mins",2,"this is Image Post","https://images8.alphacoders.com/101/thumb-1920-1015027.jpg",""))
        newsFeedArray.add(NewsFeedModel("https://lh3.googleusercontent.com/a-/AOh14Gh5NOYDiFV9BdkDn1j_FN_AbWKQWtgnMqhJLvaC=s88-c-k-c0x00ffffff-no-rj-mo","Farhan","48 mins",3,"this is Video Post","","https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"))
        newsFeedArray.add(NewsFeedModel("https://lh3.googleusercontent.com/a-/AOh14Gh5NOYDiFV9BdkDn1j_FN_AbWKQWtgnMqhJLvaC=s88-c-k-c0x00ffffff-no-rj-mo","Farhan","48 mins",2,"this is Second Image Post","https://images5.alphacoders.com/105/thumb-1920-1050139.jpg",""))
        newsFeedArray.add(NewsFeedModel("https://lh3.googleusercontent.com/a-/AOh14Gh5NOYDiFV9BdkDn1j_FN_AbWKQWtgnMqhJLvaC=s88-c-k-c0x00ffffff-no-rj-mo","Farhan","48 mins",1,"this is Third Text Post","",""))
        newsFeedArray.add(NewsFeedModel("https://lh3.googleusercontent.com/a-/AOh14Gh5NOYDiFV9BdkDn1j_FN_AbWKQWtgnMqhJLvaC=s88-c-k-c0x00ffffff-no-rj-mo","Farhan","48 mins",3,"this is Second Video Post","","https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"))
        newsFeedArray.add(NewsFeedModel("https://lh3.googleusercontent.com/a-/AOh14Gh5NOYDiFV9BdkDn1j_FN_AbWKQWtgnMqhJLvaC=s88-c-k-c0x00ffffff-no-rj-mo","Farhan","48 mins",2,"this is third Image Post","https://images.alphacoders.com/101/thumb-1920-1012834.png",""))


        val adapter = NewsFeedAdapter(this,newsFeedArray)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}