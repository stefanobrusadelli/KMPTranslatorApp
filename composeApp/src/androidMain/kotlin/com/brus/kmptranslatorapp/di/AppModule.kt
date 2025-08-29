package com.brus.kmptranslatorapp.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import com.brus.kmptranslatorapp.database.TranslateDatabase
import com.brus.kmptranslatorapp.translate.data.SqlDelightHistoryDataSource
import com.brus.kmptranslatorapp.translate.data.local.DatabaseDriverFactory
import com.brus.kmptranslatorapp.translate.data.remote.HttpClientFactory
import com.brus.kmptranslatorapp.translate.data.translate.KtorTranslateClient
import com.brus.kmptranslatorapp.translate.domain.history.HistoryDataSource
import com.brus.kmptranslatorapp.translate.domain.translate.Translate
import com.brus.kmptranslatorapp.translate.domain.translate.TranslateClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver), coroutineContext = Dispatchers.IO)
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate {
        return Translate(client, dataSource)
    }
}