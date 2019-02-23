package io.awesdroid.libkt.android.exceptions

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