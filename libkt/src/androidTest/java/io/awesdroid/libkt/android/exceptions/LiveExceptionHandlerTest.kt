package io.awesdroid.libkt.android.exceptions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.awesdroid.libkt.android.TestLifeCycleOwner
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

/**
 * @author Awesdroid
 */
@RunWith(AndroidJUnit4::class)
class LiveExceptionHandlerTest {

    private lateinit var lifeCycleOwner: LifecycleOwner
    @Before
    fun setup() {
        lifeCycleOwner = TestLifeCycleOwner()
    }

    @Test
    fun handlers() = runBlocking<Unit> {
        val handler1 = LiveExceptionHandler()
        val handler2 = LiveExceptionHandler()
        val exception1 = LiveException(LiveException.Type.ERROR_NETWORK, Throwable("Network Error"))
        val exception2 =  LiveException(LiveException.Type.ERROR_GENERAL, Throwable("General Error"))
        val random1 = Random.nextLong(0, 1000)
        val random2 = Random.nextLong(0, 1000)

        withContext(Dispatchers.Main) {
            handler1.getError().observe(lifeCycleOwner, Observer {
                Assert.assertTrue(it != null)
                Assert.assertEquals(it, exception1)
            })

            handler2.getError().observe(lifeCycleOwner, Observer {
                Assert.assertTrue(it != null)
                Assert.assertEquals(it, exception2)
            })
        }

        supervisorScope {
            launch(Dispatchers.IO + handler1.handler) {
                delay(random1)
                throw exception1
            }

            launch(Dispatchers.Default + handler2.handler) {
                delay(random2)
                throw exception2
            }
        }
        delay(random1 + random2 + 100)
    }

}
