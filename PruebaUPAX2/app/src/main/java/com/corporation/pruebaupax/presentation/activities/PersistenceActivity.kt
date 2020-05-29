package com.corporation.pruebaupax.presentation.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.corporation.pruebaupax.R
import com.corporation.pruebaupax.domain.entity.Employee
import com.corporation.pruebaupax.presentation.activities.viewmodel.EmployeeViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_persistence.*

class PersistenceActivity : AppCompatActivity() {
    private lateinit var employeeViewModel: EmployeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistence)

        employeeViewModel = run {
            ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        }

        val mFab = findViewById<FloatingActionButton>(R.id.fabAdd)

        mFab.setOnClickListener{showDialog()}



        addObserver()
    }


//show a dialog to create new user
    private fun showDialog() {
        val  dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.layout_new_employee)

            val btCancel = dialog.findViewById(R.id.btCancel) as Button
            val btSaveEmployee = dialog.findViewById(R.id.btSaveEmployee) as Button

            val nombreEt = dialog.findViewById(R.id.etNombre) as EditText
            val fecha_nacEt = dialog.findViewById(R.id.etFecha) as EditText
            val puestoEt = dialog.findViewById(R.id.etPuesto) as EditText

            btCancel.setOnClickListener{dialog.dismiss()}
            btSaveEmployee.setOnClickListener {
                if (nombreEt.text.toString().isEmpty() || fecha_nacEt.text.toString().isEmpty() || puestoEt.text.toString().isEmpty()){
                        Toast.makeText(this, "Faltan campos por llenar", Toast.LENGTH_SHORT).show()

                }else{
                    addEmployee(nombreEt.text.toString(), fecha_nacEt.text.toString(), puestoEt.text.toString())
                    dialog.dismiss()
                }

            }


            dialog.show()

    }

//create new observer to list all current employees
    private fun addObserver() {
        val observer = Observer<List<Employee>> { employees ->
            if (employees != null) {
                var text = ""
                for (employee in employees) {
                    text += employee.nombre + " " + employee.fecha_nac + " - " + employee.puesto + "\n"
                }
                tvEmployeesInfo.text = text
            }
        }
        employeeViewModel.employees.observe(this, observer)
    }

   private fun addEmployee(
       nombre: String,
       fecha_nac: String,
       puesto: String
   ) {

        if (!nombre.isEmpty() && !fecha_nac.isEmpty()  ){
            employeeViewModel.saveEmployee(
                Employee(
                    nombre,
                    fecha_nac,
                    puesto
                )
            )
        }
    }

}
