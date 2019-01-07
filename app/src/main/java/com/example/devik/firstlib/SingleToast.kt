package com.example.devik.firstlib

import android.content.Context
import android.widget.Toast
import java.lang.ref.WeakReference

object SingleToast {

    var ref: WeakReference<Toast>? = null

    fun show(context: Context, messageResId: Int) {
        show(context, context.getString(messageResId))
    }

    fun show(context: Context, message: String) {
        ref?.get()?.let {
            it.cancel()
        }
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        ref = WeakReference(toast)
        toast.show()
    }
}