package com.saarthiapp.android.ui.utils.exoplayer

import android.content.Context
import com.google.android.exoplayer2.upstream.*
import com.google.android.exoplayer2.upstream.cache.CacheDataSink
import com.google.android.exoplayer2.upstream.cache.CacheDataSource
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import com.saarthiapp.android.ui.utils.Constants.Companion.MAX_CACHE_SIZE
import com.saarthiapp.android.ui.utils.Constants.Companion.MAX_FILE_SIZE
import java.io.File

class LocalCacheDataSourceFactory(private val context: Context) : DataSource.Factory {

    private val defaultDataSourceFactory: DefaultDataSourceFactory
    //TODO Needs to be a singleton
    private val simpleCache: SimpleCache = SimpleCache(
        File(context.cacheDir, "media"),
        LeastRecentlyUsedCacheEvictor(MAX_CACHE_SIZE)
    )
    private val cacheDataSink: CacheDataSink = CacheDataSink(simpleCache, MAX_FILE_SIZE)
    private val fileDataSource: FileDataSource = FileDataSource()

    init {
        val userAgent = "Demo"
        val bandwidthMeter = DefaultBandwidthMeter()
        defaultDataSourceFactory = DefaultDataSourceFactory(
            this.context,
            bandwidthMeter,
            DefaultHttpDataSourceFactory(userAgent)
        )
    }

    override fun createDataSource(): DataSource {
        return CacheDataSource(
            simpleCache, defaultDataSourceFactory.createDataSource(),
            fileDataSource, cacheDataSink,
            CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR, null
        )
    }
}