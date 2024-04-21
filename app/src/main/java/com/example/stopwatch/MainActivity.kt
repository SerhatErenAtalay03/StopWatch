package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var num=0 // number
    var runnable:Runnable=Runnable{}
    var handler:Handler=Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

    }

    fun start(view: View){
      num=0
        runnable = object:Runnable{
           override fun run() {
               num=num+1
               binding.textView.text="Time: ${num}"
               handler.postDelayed(this,1000) // this = runnable which is in this activity
                                                         // num increase +1 with 1 second delay

           }


       }
      handler.post(runnable) // run runnable
      binding.startButton.isEnabled= false // After One click on start button We can't click on start button due to this code



    }

    fun stop(view:View){
        num=0
        binding.textView.text="Time: ${num}"
        binding.startButton.isEnabled=true // After click on stop button We can click on start button due to this code
        handler.removeCallbacks(runnable)// We stopped to run  this runnable



    }




}