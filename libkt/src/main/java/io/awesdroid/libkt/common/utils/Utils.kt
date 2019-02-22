package io.awesdroid.libkt.common.utils

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import org.json.JSONObject

/**
 * @author Awesdroid
 */
val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return tag.takeIf { it.isNotEmpty() }?.let { if (it.length <= 20) it else it.substring(0, 20) }
            ?: javaClass.name.takeIf {it.isNotEmpty()}?.let { if (it.length <= 20) it else it.takeLast(20) }
            ?: "Any"
    }

val prettyJsonString: (String) -> String = { jsonStr ->
    val jsonElement = JsonParser().parse(jsonStr)
    GsonBuilder().setPrettyPrinting().create().toJson(jsonElement)
}

val prettyJsonObject: (JSONObject) -> String = { json ->
    val jso = JsonParser().parse(json.toString()).asJsonObject
    GsonBuilder().setPrettyPrinting().create().toJson(jso)
}