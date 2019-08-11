package io.github.droidkaigi.confsched2020.data.api

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.github.droidkaigi.confsched2020.api.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.JSON
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named

@Module(includes = [ApiModule.Providers::class])
internal abstract class ApiModule {
    @Binds abstract fun DroidKaigiApi(impl: InjectableKtorDroidKaigiApi): DroidKaigiApi
    @Binds abstract fun GoogleFormApi(impl: InjectableKtorGoogleFormApi): GoogleFormApi

    @Module
    internal object Providers {
        @JvmStatic @Provides fun httpClient(): HttpClient {
            return HttpClient(OkHttp) {
                engine {
                    if (BuildConfig.DEBUG) {
                        val loggingInterceptor = HttpLoggingInterceptor()
                        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
                        addInterceptor(loggingInterceptor)
                    }

                    addInterceptor(UserAgentInterceptor())
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer(JSON.nonstrict)
                }
            }
        }

        @JvmStatic @Provides @Named("apiEndpoint") fun apiEndpoint(): String {
            return io.github.droidkaigi.confsched2020.data.api.apiEndpoint()
        }
    }
}
