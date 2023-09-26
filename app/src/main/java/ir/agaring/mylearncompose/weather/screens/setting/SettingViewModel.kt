package ir.agaring.mylearncompose.weather.screens.setting

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.agaring.mylearncompose.weather.model.Favorite
import ir.agaring.mylearncompose.weather.model.Unit
import ir.agaring.mylearncompose.weather.repository.WeatherDbRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by m-latifi on 9/14/2023.
 */

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val repository: WeatherDbRepository
): ViewModel() {

    private val _unitList = MutableStateFlow<List<Unit>>(emptyList())
    val unitList = _unitList.asStateFlow()


    init {
        viewModelScope.launch(IO) {
            repository.getUnits().distinctUntilChanged()
                .collect{listOfUnit ->
                    if (listOfUnit.isNullOrEmpty()){
                        Log.d("meri", "empty list")
                    } else {
                        _unitList.value = listOfUnit
                    }
                }
        }
    }

    fun insertUnit(unit: Unit) =
        viewModelScope.launch { repository.insertUnit(unit) }

    fun updateUnit(unit: Unit) =
        viewModelScope.launch { repository.updateUnit(unit) }

    fun deleteUnit(unit: Unit) =
        viewModelScope.launch { repository.deleteUnit(unit) }

    fun deleteAllUnit() =
        viewModelScope.launch { repository.deleteAllUnit() }

}