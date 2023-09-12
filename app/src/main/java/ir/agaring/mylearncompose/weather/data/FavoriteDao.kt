package ir.agaring.mylearncompose.weather.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ir.agaring.mylearncompose.weather.model.Favorite
import kotlinx.coroutines.flow.Flow

/**
 * Created by m-latifi on 9/12/2023.
 */

@Dao
interface FavoriteDao {

    @Query("Select * From fav_tbl")
    fun getFavorite(): Flow<List<Favorite>>

    @Query("Select * From fav_tbl Where city =:city")
    suspend fun getFavById(city: String): Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)

    @Query("Delete From fav_tbl")
    suspend fun deleteAllFavorite()
}