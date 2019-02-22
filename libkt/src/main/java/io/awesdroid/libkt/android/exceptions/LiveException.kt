package io.awesdroid.libkt.android.exceptions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
/**
 * @author Awesdroid
 */
class LiveException(val type: Type, val exception: Throwable): Exception() {
    enum class Type {
        ERROR_GENERAL,
        ERROR_NETWORK
    }

    override fun toString(): String {
        return "${super.toString()}[type=$type, message=${exception.message}]"
    }
}

object LiveExceptionHandler {
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