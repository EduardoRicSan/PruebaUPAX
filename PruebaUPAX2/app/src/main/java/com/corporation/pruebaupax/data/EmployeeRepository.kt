package com.corporation.pruebaupax.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.corporation.pruebaupax.framework.room.EmployeeDatabase
import com.corporation.pruebaupax.domain.entity.Employee
import com.corporation.pruebaupax.usecases.EmployeeDAO

/**
 * EmployeeRepository execute the functions we use to create and list a employee
 */
class EmployeeRepository(application: Application) {
        private val employeeDAO: EmployeeDAO? = EmployeeDatabase.getInstance(application)?.cemployeeDao()
    /**
     * insert a new employee
     */
        fun insert(employee: Employee) {
            if (employeeDAO != null) InsertAsyncTask(
                employeeDAO
            ).execute(employee)
        }
    /**
     * Get all employees in a list by a Asyntask
     */
        fun getEmployees(): LiveData<List<Employee>> {
            return employeeDAO?.getOrderedAgenda() ?: MutableLiveData<List<Employee>>()
        }

        private class InsertAsyncTask(private val employeeDAO: EmployeeDAO) :
            AsyncTask<Employee, Void, Void>() {
            override fun doInBackground(vararg employees: Employee?): Void? {
                for (emp in employees ) {
                    if (emp != null) employeeDAO.insert(emp)
                }
                return null
            }
        }
}
