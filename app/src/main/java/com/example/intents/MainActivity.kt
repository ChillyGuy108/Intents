package com.example.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var button_norm_intent: Button
    private lateinit var button_implicit_intent: Button

    private lateinit var text: TextInputEditText
    companion object {
        const val ACTION_SHOW_TEXT = "com.example.intents.action.SHOW_TEXT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        button_norm_intent=findViewById(R.id.button2)
        button_implicit_intent=findViewById(R.id.button)
        text=findViewById(R.id.textInputEditText)
        button_norm_intent.setOnClickListener {
            val intent = Intent(this@MainActivity,
                IntentActivity::class.java).apply {
                    putExtra("text", text.text.toString())
            }
            startActivity(intent)
        }
        button_implicit_intent.setOnClickListener {
            val intent = Intent(ACTION_SHOW_TEXT).apply {
                putExtra("text", text.text.toString())
            }
            startActivity(intent)
        }

    }
}