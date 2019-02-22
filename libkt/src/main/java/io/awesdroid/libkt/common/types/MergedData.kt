package io.awesdroid.libkt.common.types

/**
 * @author Awesdroid
 */
sealed class MergedData
open class MutableMapMergedData<K, V>(val value: MutableMap<K, V>): MergedData()
open class BooleanMergedData(val value: Boolean): MergedData()