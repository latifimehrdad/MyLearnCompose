package ir.agaring.mylearncompose.weather.repository

import ir.agaring.mylearncompose.weather.data.FavoriteDao
import ir.agaring.mylearncompose.weather.model.Favorite
import ir.agaring.mylearncompose.weather.model.Unit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by m-latifi on 9/13/2023.
 */

class WeatherDbRepository @Inject constructor(private val favoriteDao: FavoriteDao) {

    fun getFavorite(): Flow<List<Favorite>> = favoriteDao.getFavorite()

    suspend fun insertFavorite(favorite: Favorite) = favoriteDao.insertFavorite(favorite = favorite)

    suspend fun updateFavorite(favorite: Favorite) = favoriteDao.updateFavorite(favorite = favorite)

    suspend fun deleteAllFavorites() = favoriteDao.deleteAllFavorite()

    suspend fun deleteFavorite(favorite: Favorite) = favoriteDao.deleteFavorite(favorite = favorite)

    suspend fun getFavoriteById(city: String) = favoriteDao.getFavById(city = city)

    //
    fun getUnits(): Flow<List<Unit>> = favoriteDao.getUnits()

    suspend fun insertUnit(unit: Unit) = favoriteDao.insertUnit(unit = unit)

    suspend fun updateUnit(unit: Unit) = favoriteDao.updateUnit(unit = unit)

    suspend fun deleteUnit(unit: Unit) = favoriteDao.deleteUnit(unit = unit)

    suspend fun deleteAllUnit() = favoriteDao.deleteAllUnit()

}