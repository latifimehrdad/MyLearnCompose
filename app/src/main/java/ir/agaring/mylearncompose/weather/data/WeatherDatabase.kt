package ir.agaring.mylearncompose.weather.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.agaring.mylearncompose.weather.model.Favorite
import ir.agaring.mylearncompose.weather.model.Unit

/**
 * Created by m-latifi on 9/13/2023.
 */

@Database(
    entities = [Favorite::class, Unit::class],
    version = 2,
    exportSchema = false
)
abstract class WeatherDatabase: RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}