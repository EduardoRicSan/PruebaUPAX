package com.corporation.pruebaupax.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

/**
 * Create a table with its attributes
 */
@Entity(tableName = Employee.TABLE_NAME)
data class Employee(
    @ColumnInfo(name = "nombre") @NotNull val nombre: String,
    @ColumnInfo(name = "fecha_nac") @NotNull val fecha_nac: String,
    @ColumnInfo(name = "puesto")@NotNull val puesto: String
) {
    companion object {
        const val TABLE_NAME = "employee"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    var employeeId: Int = 0
}