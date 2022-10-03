package Modelos

import EnumClasses.*
import Factorias.*

class Sala(var numero: Int) {
    //La sala está compuesta de un número de sala, y una lista de los pacientes y los medicos que la ocupan
    var pacientes: ArrayList<Paciente> = ArrayList()
    var medicos: ArrayList<Medico> = ArrayList()

    override fun toString(): String {
        return "Sala $numero \n\t$pacientes \n\t$medicos"
    }

    /**
     * Genera tantos medicos como especialidades haya, para tener uno de cada en cada sala
     */
    fun genMedicos() {
        medicos.clear()
        var size: Int = especialidades.values().size
        var cont: Int = 0
        while (medicos.size < size) {
            medicos.add(Factoria.crearMedico(cont))
            cont++
        }
    }

    /**
     * Agrega un paciente al ArrayList
     */
    fun addPaciente(paciente: Paciente): Boolean {
        pacientes.add(paciente)
        return true;
    }

    /**
     * Elimina un paciente para derivarlo
     */
    fun derivarPaciente(paciente: Paciente) {
        pacientes.remove(paciente)
    }
}