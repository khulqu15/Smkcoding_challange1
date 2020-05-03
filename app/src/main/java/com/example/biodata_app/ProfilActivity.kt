package com.example.biodata_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*
import java.lang.Exception

class ProfilActivity : AppCompatActivity() {

    lateinit var name: TextView
    lateinit var gender: TextView
    lateinit var umur: TextView
    lateinit var email: TextView
    lateinit var telp: TextView
    lateinit var alamat: TextView
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        name = txt_nama
        gender = txt_gender
        umur = txt_umur
        email = txt_email
        telp = txt_telp
        alamat = txt_alamat

        val my_nama = intent.getStringExtra("nama")
        val my_gender = intent.getStringExtra("gender")
        val my_umur = intent.getStringExtra("umur")
        val my_email = intent.getStringExtra("email")
        val my_telp = intent.getStringExtra("telp")
        val my_alamat = intent.getStringExtra("alamat")

        name.text = my_nama
        gender.text = my_gender
        umur.text = my_umur
        email.text = my_email
        telp.text = my_telp
        alamat.text = my_alamat

        btn_edit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("nama", name.text.toString())
            intent.putExtra("gender", gender.text.toString())
            intent.putExtra("umur", umur.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("telp", telp.text.toString())
            intent.putExtra("alamat", alamat.text.toString())
            startActivity(intent)
        }

        btn_dial.setOnClickListener {
            val number = txt_telp.text.toString()
            call(number)
        }
        btn_about.setOnClickListener {
            about()
        }
    }

    private fun about() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    fun Context.call(number: String): Boolean {
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(intent)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }
}
