package com.example.ataia

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_photo.*
import java.util.jar.Manifest

class PhotoActivity : AppCompatActivity() {

    companion object {
        private const val PERMISSION_CODE = 1000
        private const val CAMERA_CODE = 1002
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED &&
            checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
        ) {
            requestPermissions(
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA),
                PERMISSION_CODE
            )
        } else {
            picture_shot.setOnClickListener {
                val intent = Intent( MediaStore.ACTION_IMAGE_CAPTURE )
                startActivityForResult(intent, CAMERA_CODE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == CAMERA_CODE) {

                val cameraImage: Bitmap = data!!.extras!!.get("data") as Bitmap
                picture.setImageBitmap(cameraImage)
            }
        }
    }
}