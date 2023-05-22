package com.alexander.firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.alexander.firestore.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnUpdate: Button = findViewById(R.id.btnUpdate)
            btnUpdate.setOnClickListener({
                val identity = hashMapOf(
                    "name" to "Larag",
                    "weight" to 1092
                )
            db.collection("Name")
                .add(identity)
                .addOnSuccessListener {
                    Toast.makeText(this, "新增/異動資料成功",
                        Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "新增/異動資料失敗：" + e.toString(),
                        Toast.LENGTH_LONG).show()
                }
        })
    }
}