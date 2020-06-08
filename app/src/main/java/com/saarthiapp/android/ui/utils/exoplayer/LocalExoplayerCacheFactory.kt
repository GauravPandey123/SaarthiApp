package com.saarthiapp.android.ui.utils.exoplayer

import android.content.Context
import com.google.android.exoplayer2.upstream.*
import com.google.android.exoplayer2.upstream.cache.CacheDataSink
import com.google.android.exoplayer2.upstream.cache.CacheDataSource
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import com.google.android.exoplayer2.util.Util
import com.saarthiapp.android.R
import java.io.File


class LocalExoplayerCacheFactory(private val context: Context,
                                 private val maxCacheSize: Long,
                                 private val maxFileSize: Long) : DataSource.Factory {

    private var defaultDatasourceFactory: DefaultDataSourceFactory? = null

    fun CacheDataSourceFactory(

    ) {
        val userAgent: String =
            Util.getUserAgent(context, context.resources.getString(R.string.app_name))
        val bandwidthMeter = DefaultBandwidthMeter()
        defaultDatasourceFactory = DefaultDataSourceFactory(
            this.context,
            bandwidthMeter,
            DefaultHttpDataSourceFactory(userAgent, bandwidthMeter)
        )
    }

    override fun createDataSource(): DataSource? {
        val evictor = LeastRecentlyUsedCacheEvictor(maxCacheSize)
        val simpleCache = SimpleCache(File(context.getCacheDir(), "media"), evictor)
        return CacheDataSource(
            simpleCache, defaultDatasourceFactory!!.createDataSource(),
            FileDataSource(), CacheDataSink(simpleCache, maxFileSize),
            CacheDataSource.FLAG_BLOCK_ON_CACHE or CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR, null
        )
    }
}