package com.home.everispushhuawei

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_deeplink2.*

class Deeplink2Activity : AppCompatActivity() {

    val TAG = Deeplink2Activity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink2)
        getIntentData(intent)
    }

    private fun getIntentData(intent: Intent?) {
        if (null != intent) {
            showLog(
                if (intent.getStringExtra("job") == null) "No hay data: onNewIntent" else "Job: ${intent.getStringExtra(
                    "job"
                )}"
            )
        }
    }

    private fun showLog(data: String) {
        result_intent.text = data
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        getIntentData(intent)
    }
}