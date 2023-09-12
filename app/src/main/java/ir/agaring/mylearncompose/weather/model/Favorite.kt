package ir.agaring.mylearncompose.weather.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

/**
 * Created by m-latifi on 9/12/2023.
 */

@Entity(tableName = "fav_tbl")
data class Favorite(
    @Nonnull
    @PrimaryKey
    @ColumnInfo("city")
    val city: String,

    @ColumnInfo(name = "country")
    val country: String
)
