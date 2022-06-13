package com.reeta.livedataproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var liveDataActivity=LiveDataActivity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnClick.setOnClickListener {
            val intent= Intent(this,LiveDataActivity::class.java)
            startActivity(intent)

        }
        liveDataActivity.setLiveData().observe(this,{
            val data=it
            tvName.text=data
        })
    }

//    override fun onRestart() {
//        super.onRestart()
//        tvName.text = liveDataActivity.setLiveData().toString()
//    }
}

/*
 LiveData:- LiveData is an observable data holder class. Unlike a regular observable,
            LiveData is lifecycle-aware, meaning it respects the lifecycle of other app
            components, such as activities, fragments, or services. This awareness
            ensures LiveData only updates app component observers that are in an active
             lifecycle state.LiveData considers an observer, which is represented by the
             Observer class, to be in an active state if its lifecycle is in the STARTED
             or RESUMED state. LiveData only notifies active observers about updates.
             Inactive observers registered to watch LiveData objects aren't notified about
             changes.

   Advantages:-

   1) No memory leaks :- Observers are bound to Lifecycle objects and clean up after
                         themselves when their associated lifecycle is destroyed.

   2) No crashes due to stopped activities :- If the observer's lifecycle is inactive,
                                              such as in the case of an activity in the
                                              back stack, then it doesn’t receive any
                                              LiveData events.

   3) Always up to date data :- If a lifecycle becomes inactive, it receives the
                                latest data upon becoming active again. For example,
                                an activity that was in the background receives the
                                latest data right after it returns to the foreground.

   4) Proper configuration changes :- If an activity or fragment is recreated due to a
                                      configuration change, like device rotation, it
                                      immediately receives the latest available data.

  5) No more manual lifecycle handling:- UI components just observe relevant data and
                                         don’t stop or resume observation. LiveData
                                         automatically manages all of this since it’s aware
                                          of the relevant lifecycle status changes while
                                          observing.


 */