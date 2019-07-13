package com.lightningkite.kabinet


interface FileSystem {
    suspend fun info(path: AbsolutePath): FileInformation?
    suspend fun exists(path: AbsolutePath): Boolean = info(path) != null
    /**
     * Makes the directories if needed.
     */
    suspend fun overwrite(path: AbsolutePath, data: ByteArray)

    suspend fun readAll(path: AbsolutePath): ByteArray?

    suspend fun deleteIfExists(path: AbsolutePath): Boolean
    suspend fun deleteRecursivelyIfExists(path: AbsolutePath): Boolean
    suspend fun moveIfExists(path: AbsolutePath, newPath: AbsolutePath): Boolean
}

/*
*
* THE PLAN
*
* Local using filesystem for JVM
* S3
* Selector in config file
*
* Upload Image depends on Archive and Kabinet
* I think it's time to make a dedicated server project for all of the mixes.  Notifications, health checks, metrics...
*
* */