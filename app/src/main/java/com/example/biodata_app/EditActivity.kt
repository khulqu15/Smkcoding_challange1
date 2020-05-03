package com.example.biodata_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_edit.btn_simpan
import kotlinx.android.synthetic.main.activity_edit.edt_alamat
import kotlinx.android.synthetic.main.activity_edit.edt_email
import kotlinx.android.synthetic.main.activity_edit.edt_gender
import kotlinx.android.synthetic.main.activity_edit.edt_name
import kotlinx.android.synthetic.main.activity_edit.edt_telp
import kotlinx.android.synthetic.main.activity_edit.edt_umur
import kotlinx.android.synthetic.main.activity_main.*

class EditActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var gender: String
    lateinit var umur: EditText
    lateinit var email: EditText
    lateinit var telp: EditText
    lateinit var alamat: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val bundle = intent.extras
        if(bundle != null) {
            val bundle = intent.extras
            val b_nama = bundle?.getString("nama")
            val b_gender = bundle?.getString("gender")
            val b_umur = bundle?.getString("umur")
            val b_email = bundle?.getString("email")
            val b_telp = bundle?.getString("telp")
            val b_alamat = bundle?.getString("alamat")

            edt_name.text = Editable.Factory.getInstance().newEditable(b_nama)
            val arr_gender = resources.getStringArray(R.array.spinner_gender)
            val spinner = edt_gender
            if(spinner != null) {
                val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr_gender)
                spinner.adapter = adapter
                spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        gender = spinner.selectedItem.toString()
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
            }
            edt_umur.text = Editable.Factory.getInstance().newEditable(b_umur)
            edt_email.text = Editable.Factory.getInstance().newEditable(b_email)
            edt_telp.text = Editable.Factory.getInstance().newEditable(b_telp)
            edt_alamat.text = Editable.Factory.getInstance().newEditable(b_alamat)
        }
        name = edt_name
        umur = edt_umur
        email = edt_email
        telp = edt_telp
        alamat = edt_alamat

        btn_simpan.setOnClickListener {
            val my_name = name.text.toString()
            val my_umur = umur.text.toString()
            val my_email = email.text.toString()
            val my_telp = telp.text.toString()
            val my_alamat = alamat.text.toString()
            if(my_name.trim().isEmpty()) {
                name.error = "Nama harus diisi"
                Toast.makeText(applicationContext, "Name tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            else if(gender.equals("Pilih Gender")) {
                Toast.makeText(applicationContext, "Pilih gender terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
            else if(my_umur.trim().isEmpty()) {
                umur.error = "Umur harus diisi"
                Toast.makeText(applicationContext, "Umur tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            else if(my_email.trim().isEmpty()) {
                email.error = "Email harus diisi"
                Toast.makeText(applicationContext, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            else if(my_telp.trim().isEmpty()) {
                telp.error = "Telp harus diisi"
                Toast.makeText(applicationContext, "Telp tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            else if(my_alamat.trim().isEmpty()) {
                alamat.error = "Alamat harus diisi"
                Toast.makeText(applicationContext, "Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, ProfilActivity::class.java)
                intent.putExtra("nama", name.text.toString())
                intent.putExtra("gender", gender)
                intent.putExtra("umur", umur.text.toString())
                intent.putExtra("email", email.text.toString())
                intent.putExtra("telp", telp.text.toString())
                intent.putExtra("alamat", alamat.text.toString())
                startActivity(intent)
            }
        }
    }
}
