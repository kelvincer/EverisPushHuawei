package com.home.everispushhuawei

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView.OnEditorActionListener
import kotlinx.android.synthetic.main.dialog_add_topic.*
import kotlinx.android.synthetic.main.dialog_add_topic.view.*

class TopicDialog @SuppressLint("InflateParams") constructor(
    context: Context,
    isAdd: Boolean
) : Dialog(context, R.style.custom_dialog), View.OnClickListener {
    private val view: View
    private var onDialogClickListener: OnDialogClickListener? = null
    private var edTopic: EditText? = null
    private fun initView(isAdd: Boolean, context: Context) {
        setContentView(view)
        tv_cancel.setOnClickListener(this)
        tv_confirm.setOnClickListener(this)
        edTopic = view.findViewById(R.id.ed_topic)
        ed_topic.setHint(if (isAdd) R.string.add_topic else R.string.delete_topic)
        ed_topic.setOnEditorActionListener(OnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_UNSPECIFIED) {
                //
                val imm =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm?.hideSoftInputFromWindow(window!!.decorView.windowToken, 0)
                return@OnEditorActionListener true
            }
            false
        })
        setCanceledOnTouchOutside(false)

    }

    override fun onClick(view: View) {
        val viewId = view.id
        when (viewId) {
            R.id.tv_cancel -> if (onDialogClickListener != null) {
                onDialogClickListener?.onCancelClick()
            }
            R.id.tv_confirm -> if (onDialogClickListener != null) {
                onDialogClickListener?.onConfirmClick(edTopic?.text.toString())
            }
            else -> {
            }
        }
    }

    fun setOnDialogClickListener(onDialogClickListener: OnDialogClickListener?) {
        this.onDialogClickListener = onDialogClickListener
    }

    init {
        view = LayoutInflater.from(context).inflate(R.layout.dialog_add_topic, null)
        initView(isAdd, context)
    }
}
