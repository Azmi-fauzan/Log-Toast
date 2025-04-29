package com.example.praktekimplicit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val websiteEditText: EditText = findViewById(R.id.website_edit_text)
        val openWebsiteButton: Button = findViewById(R.id.website_edit_button)

        openWebsiteButton.setOnClickListener{
            val websiteUrl = websiteEditText.text.toString()
            openWebsite(websiteUrl)

        }

        val locationEditText: EditText = findViewById(R.id.location_edit_text)
        val locationButton: Button = findViewById(R.id.location_edit_button)

        locationButton.setOnClickListener{
            val locationName = locationEditText.text.toString()
            openLocation(locationName)
        }

        val shareEditText: EditText = findViewById(R.id.share_edit_text)
        val shareTextButton: Button = findViewById(R.id.share_text_button)
        shareTextButton.setOnClickListener{
            val shareText = shareEditText.text.toString()
            Log.v("Cek String" , shareText)

            ShareText(shareText)
            Toast.makeText(applicationContext , "Cek Cek" , Toast.LENGTH_LONG).show()
        }

    }








  private fun openWebsite(url : String) {
       val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
       startActivity(intent)
    }

  private  fun openLocation(location : String) {
        val uri = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

   private fun ShareText(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, "share Text"))
    }


}