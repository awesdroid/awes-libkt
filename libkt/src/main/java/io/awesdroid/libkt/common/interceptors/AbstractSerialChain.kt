package io.awesdroid.libkt.common.interceptors

import java.util.*

/**
 * @author Awesdroid
 */
abstract class AbstractSerialChain<K, R> : SerialInterceptor.Chain<K, R> {
    protected var interceptors: MutableList<Interceptor<SerialInterceptor.Chain<K, R>, R>> = ArrayList()
    abstract var k: K
    private var idx: Int = 0

    abstract fun buildChain(): SerialInterceptor.Chain<K, R>

    fun resetIdx() {
        idx = 0
    }

    override fun getInput(): K {
        return k
    }

    override fun proceed(k: K): R {
        this.k = k

        if (interceptors.isEmpty()) {
            throw IllegalStateException("no interceptors!")
        }

        if (idx >= interceptors.size) {
            throw IllegalStateException("Reach final interceptor ${interceptors[idx - 1]}")
        }
        return interceptors[idx++].intercept(this)
    }
}