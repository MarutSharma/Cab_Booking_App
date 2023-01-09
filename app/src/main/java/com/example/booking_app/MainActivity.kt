package com.example.booking_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.booking_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CabViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(CabViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        updateUI()
    }

    private fun updateUI() {
        binding.apply {
            btnPre.setOnClickListener { setData(it as Button) }
            btnGo.setOnClickListener {
                setData(it as Button)
                Log.d("Hello", "Button Go clicked")
            }
            btnGo.setOnLongClickListener {
                viewModel?.clear()
                true
            }
            btnPre.setOnLongClickListener {
                viewModel?.clear()
                true
            }
        }
    }

    private fun setData(button: Button) {
        val fr = binding.txtFrom.text.toString()
        val to = binding.txtTo.text.toString()
        val msg = viewModel.updateInfo(fr, to, button.text.toString())
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}