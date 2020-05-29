package com.corporation.pruebaupax.usecases

import androidx.lifecycle.LiveData
import androidx.room.*
import com.corporation.pruebaupax.domain.entity.Employee

/**
 * Employeeo contains all functions to do on the database
 */
@Dao
interface EmployeeDAO {
    @Insert
    fun insert(employee: Employee)

    @Update
    fun update(vararg employee: Employee)

    @Delete
    fun delete(vararg employee: Employee)

    @Query("SELECT * FROM " + Employee.TABLE_NAME + " ORDER BY nombre")
    fun getOrderedAgenda(): LiveData<List<Employee>>
}