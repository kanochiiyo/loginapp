package com.dimsseung.loginapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    // buat instance dari FirebaseAuth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inisialisasi instance dari FirebaseAuth
        auth = FirebaseAuth.getInstance()
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        // jika usernya ada
        if (currentUser != null) {
            // arahkan ke LoginActivity kalau belum login
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            // biar user gabisa back ke LoginActivity
            finish()
        } else {
            // arahkan ke LoginActivity kalau belum login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // biar user gabisa back ke LoginActivity
            finish()
        }
    }



}