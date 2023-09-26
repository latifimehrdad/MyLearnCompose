package ir.agaring.mylearncompose.weather.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.agaring.mylearncompose.weather.model.Favorite
import ir.agaring.mylearncompose.weather.repository.WeatherDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by m-latifi on 9/13/2023.
 */

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: WeatherDbRepository
): ViewModel() {

    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favList = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            repository.getFavorite().distinctUntilChanged()
                .collect{ listOfFav ->
                    if (listOfFav.isNullOrEmpty())
                        Log.d("meri", "Empty Favorite")
                    else {
                        _favList.value = listOfFav
                        Log.d("meri", "favorites : ${favList.value}")
                    }
                }
        }
    }


    fun insertFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.insertFavorite(favorite) }

    fun updateFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.updateFavorite(favorite) }

    fun deleteFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.deleteFavorite(favorite) }

    fun getFavoriteById(city: String) =
        viewModelScope.launch { repository.getFavoriteById(city) }
}