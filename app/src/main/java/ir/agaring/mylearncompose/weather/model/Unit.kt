package ir.agaring.mylearncompose.weather.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

/**
 * Created by m-latifi on 9/14/2023.
 */

@Entity(tableName = "setting_tbl")
data class Unit(
    @Nonnull
    @PrimaryKey
    @ColumnInfo(name = "unit")
    val unit: String
)
