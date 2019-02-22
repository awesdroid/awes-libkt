package io.awesdroid.libkt.android.ui

import android.app.Activity
import android.content.Context
import java.lang.ref.WeakReference

/**
 * @author Awesdroid
 */
object ActivityHelper {
    private var activity: WeakReference<Activity>? = null

    fun setActivity(activity: Activity) {
        ActivityHelper.activity = WeakReference(activity)
    }

    fun clear() {
        activity?.clear()
        activity = null
    }

    fun getActivity(): Activity? {
        return activity?.get()
    }

    @JvmStatic
    fun getContext(): Context {
        return activity?.get() as Context
    }
}


