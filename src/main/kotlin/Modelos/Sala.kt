package Modelos

import EnumClasses.*
import Factorias.*

class Sala(var numero: Int) {
    var pacientes: ArrayList<Paciente> = ArrayList()
    var medicos : ArrayList<Medico> = ArrayList()

    override fun toString(): String {
        return "Modelos.Sala $numero \n\t$pacientes \n\t$medicos"
    }
    fun genMedicos() {
        medicos.clear()
        var size: Int = especialidades.values().size
        var cont: Int = 0
        while (medicos.size < size) {
            medicos.add(Factoria.crearMedico(cont))
            cont++
        }
    }
    fun ordenar() {
        pacientes.sortBy { it.prioridad }
    }
    fun addPaciente(paciente: Paciente): Boolean {
        pacientes.add(paciente)
        return true;
    }
}