package ir.agaring.mylearncompose.weather.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.agaring.mylearncompose.weather.data.FavoriteDao
import ir.agaring.mylearncompose.weather.data.WeatherDatabase
import javax.inject.Singleton

/**
 * Created by m-latifi on 8/17/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideFavoriteDao(weatherDatabase: WeatherDatabase): FavoriteDao =
        weatherDatabase.favoriteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WeatherDatabase =
        Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            "weather_database"
        )
            .fallbackToDestructiveMigration()
            .build()


}