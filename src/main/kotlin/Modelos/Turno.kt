package Modelos

import EnumClasses.*
import Factorias.*

class Turno(var tipo: Turnos, val nave: Nave) {
    // Contadores locales del turno para controlar los pacientes derivados y antendidos en cada turno
    var pacientesAtendidos: Int = 0
    var pacientesDerivados: Int = 0

    /**
     * Al iniciar la clase, se muestra el turno que se ha creado y se inicia el turno en la nave, lo cual hace
     * que dos medicos de distinta especialidad vayan a cada sala
     */
    init {
        if (nave.iniciarTurno()) {
            println("\tComienza el turno de $tipo ----------------------------------------------")
        }
    }

    /**
     * Controla la simulación con el tiempo. Cada 2 segundos entra un paciente, y cada 4, se atiende a uno de ellos.
     */
    fun simulacion() {
        var tiempo: Int = 0
        while (tiempo != 10) {
            if (tiempo % 2 == 0) {
                llegarPaciente()
            }
            if (tiempo % 4 == 0) {
                atenderPaciente(nave.comprobarSala())
            }
            Thread.sleep(1000)
            tiempo++
        }
        nave.impPacientes()
        println("\tTermina el turno de $tipo, con $pacientesAtendidos pacientes atendidos y $pacientesDerivados derivados.")
    }

    /**
     * Funcion que crea un paciente y lo añade a la lista de pacientes de la nave
     */
    fun llegarPaciente() {
        var pNuevo: Paciente = Factoria.crearPaciente()
        nave.addPaciente(pNuevo)
    }

    /**
     * Atiende a un paciente y lo elimina de la lista de pacientes de la nave, aunque si no hay medico en esa sala que
     * pueda tratarlo, se deriva a otra nave
     */
    fun atenderPaciente(salaAct: Sala) {
        var pacienteAtendido: Paciente = salaAct.pacientes[0]
        when (pacienteAtendido.atencion) {
            atencionRequerida.Quemadura_Laser -> {
                for (medico in salaAct.medicos) {
                    if (medico.especialidad == especialidades.Traumatologia) {
                        if (medico.compTrabaja[0] == pacienteAtendido.seguro || medico.compTrabaja[1] == pacienteAtendido.seguro) {
                            salaAct.pacientes.remove(pacienteAtendido)
                            println("El paciente ${pacienteAtendido.nombre} ha sido atendido por el medico ${medico.nombre} por una ${pacienteAtendido.atencion}")
                            pacientesAtendidos++
                            break
                        }
                        else {
                            println("El paciente ${pacienteAtendido.nombre} ha sido derivado a otra nave por no coincidir con la compañia del medico")
                            pacientesDerivados++
                            break
                        }
                    }
                }
            }
            atencionRequerida.Impacto_Chorritronico -> {
                for (medico in salaAct.medicos) {
                    if (medico.especialidad == especialidades.Medicina_Interna) {
                        if (medico.compTrabaja[0] == pacienteAtendido.seguro || medico.compTrabaja[1] == pacienteAtendido.seguro ) {
                            salaAct.pacientes.remove(pacienteAtendido)
                            println("El paciente ${pacienteAtendido.nombre} ha sido atendido por el medico ${medico.nombre} por un ${pacienteAtendido.atencion}")
                            pacientesAtendidos++
                            break
                        }
                        else {
                            println("El paciente ${pacienteAtendido.nombre} ha sido derivado a otra nave por no coincidir con la compañia del medico")
                            pacientesDerivados++
                            break
                        }
                    }
                }
            }
            atencionRequerida.Otros -> {
                salaAct.derivarPaciente(pacienteAtendido)
                println("PACIENTE ${pacienteAtendido.nombre} DERIVADO")
                pacientesDerivados++
            }
        }
    }
}