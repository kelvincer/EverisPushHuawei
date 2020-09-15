package com.home.everispushhuawei

import android.content.Intent
import android.util.Log
import com.huawei.hms.push.HmsMessageService
import com.huawei.hms.push.RemoteMessage

class MyPushService : HmsMessageService() {

    val TAG = MyPushService::class.java.simpleName
    private val CODELABS_ACTION = "com.huawei.codelabpush.action"

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i(TAG, "receive token:$token")
    }

    /**
     * This method is used to receive downstream data messages.
     * This method callback must be completed in 10 seconds. Otherwise, you need to start a new Job for callback processing.
     *
     * @param message RemoteMessage
     */
    override fun onMessageReceived(message: RemoteMessage?) {
        super.onMessageReceived(message)
        Log.i(TAG, "onMessageReceived is called")
        if (message == null) {
            Log.e(TAG, "Received message entity is null!")
            return
        }

        val intent = Intent()
        intent.action = CODELABS_ACTION
        intent.putExtra("method", "onMessageReceived")
        intent.putExtra(
            "msg",
            "onMessageReceived called, message id:" + message.getMessageId() + ", payload data:"
                    + message.dataOfMap
        )
        sendBroadcast(intent)
    }

    override fun onSendError(p0: String?, p1: Exception?) {
        super.onSendError(p0, p1)
        Log.d(TAG, "onSendError")
    }

    override fun onTokenError(p0: Exception?) {
        super.onTokenError(p0)
        Log.d(TAG, "onTokenError")
    }
}