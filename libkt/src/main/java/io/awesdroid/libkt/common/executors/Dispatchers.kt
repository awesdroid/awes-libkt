package io.awesdroid.libkt.common.executors

import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

/**
 * @author Awesdroid
 */
object Dispatchers {
    val CACHED: ExecutorCoroutineDispatcher by lazy { Executors.newCachedThreadPool().asCoroutineDispatcher() }

    fun close() {
        CACHED.close()
    }
}