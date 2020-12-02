package com.example.videoapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_video.*


class VideoActivity : AppCompatActivity() {

    val REQUEST_VIDEO_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        var i = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        // i.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10)
        startActivityForResult(i, REQUEST_VIDEO_CAPTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK){
            videoView.setVideoURI(data?.data)
            videoView.start()
        }
    }
}