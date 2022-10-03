package Modelos

import EnumClasses.*
import Factorias.*

class Turno(var tipo: Turnos, val nave: Nave) {
    init {
        if (nave.iniciarTurno()) {
            println("\tComienza el turno de $tipo")
        }
    }
    fun simulacion() {
        var tiempo: Int = 0
        while (tiempo != 10) {
            if (tiempo % 2 == 0) {
                llegarPaciente()
            }
            tiempo++
            Thread.sleep(1000)
        }
    }

    fun llegarPaciente() {
        var pNuevo: Paciente = Factoria.crearPaciente()
        nave.addPaciente(pNuevo)
        println("Llega el paciente ${pNuevo.nombre} con ${pNuevo.atencion} y prioridad ${pNuevo.prioridad}")
        println("Ahora las salas están así: ")
        nave.mostrarSalas()
    }

}