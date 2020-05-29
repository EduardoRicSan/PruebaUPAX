package com.corporation.pruebaupax.presentation.activities.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.corporation.pruebaupax.domain.entity.Employee
import com.corporation.pruebaupax.data.EmployeeRepository

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {
    //calls to get all employees and save it
    private val repository =
        EmployeeRepository(application)
    val employees = repository.getEmployees()

    fun saveEmployee(employee: Employee) {
        repository.insert(employee)
    }
}