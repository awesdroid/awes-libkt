package io.awesdroid.libkt.android.gson

import android.net.Uri
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.GsonBuilder
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Awesdroid
 */
@RunWith(AndroidJUnit4::class)
class UriAdapterTest {

    @Test
    fun getUri() {
        val jsonString = "{\"uri\":\"https://www.google.com\"}".trimIndent()
        Model.create(jsonString).apply {
            assertEquals(toString(), jsonString)
        }
    }

    class Model internal constructor() {
        lateinit var uri: Uri

        override fun toString(): String {
            return GsonBuilder()
                .registerTypeAdapter(Uri::class.java, UriAdapter())
                .create()
                .toJson(this)
        }
        companion object {
            fun create(str: String): Model {
                return GsonBuilder()
                    .registerTypeAdapter(Uri::class.java, UriAdapter())
                    .create()
                    .fromJson(str, Model::class.java)
            }
        }
    }
}
