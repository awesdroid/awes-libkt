package io.awesdroid.libkt.common.interceptors


/**
 * @author Awesdroid
 */
interface SerialInterceptor<T, R>:
    Interceptor<SerialInterceptor.Chain<T, R>, R> {
    interface Chain<K, V> {
        fun getInput(): K
        fun proceed(k: K): V
    }
}
