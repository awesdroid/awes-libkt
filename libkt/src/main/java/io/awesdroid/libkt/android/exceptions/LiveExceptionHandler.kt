package io.awesdroid.libkt.android.exceptions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * @author Awesdroid
 */
class LiveExceptionHandler {
    private val error = MutableLiveData<LiveException>()
    val handler = CoroutineExceptionHandler { _, exception ->
        if (exception is LiveException) {
            error.postValue(exception)
        }
    }

    fun getError(): LiveData<LiveException> {
        return error
    }
}