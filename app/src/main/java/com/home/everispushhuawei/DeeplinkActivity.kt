package com.home.everispushhuawei

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_deeplink2.*

class DeeplinkActivity : Activity() {

    val TAG = DeeplinkActivity::class.java.simpleName

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink)
        getIntentData(intent)
    }

    private fun getIntentData(intent: Intent?){
        if (null != intent) {
            // Obtain data set in Method 2.
            val name2 = intent.getStringExtra("name")
            val age2 = intent.getIntExtra("age", -1)
            Log.d(TAG, "name2 $name2,age2 $age2")
            result_intent.text = "name $name2, age $age2"
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        getIntentData(intent)
    }
}
