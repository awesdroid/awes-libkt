package io.awesdroid.libkt.common.interceptors

/**
 * @author Awesdroid
 */
interface Interceptor<T, R> {
    fun intercept(t: T): R
}