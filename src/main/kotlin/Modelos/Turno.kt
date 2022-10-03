package Modelos

import EnumClasses.*
import Factorias.*

class Turno(var tipo: Turnos, val nave: Nave) {
    var pacientesAtendidos: Int = 0
    var pacientesDerivados: Int = 0

    init {
        if (nave.iniciarTurno()) {
            println("\tComienza el turno de $tipo ----------------------------------------------")
        }
    }
    fun simulacion() {
        var tiempo: Int = 0
        while (tiempo != 10) {
            if (tiempo % 2 == 0) {
                llegarPaciente()
            }
            if (tiempo % 4 == 0) {
                atenderPaciente(nave.comprobarSala())
            }
            tiempo++
            Thread.sleep(1000)
        }
        println("\tTermina el turno de $tipo, con $pacientesAtendidos pacientes atendidos y $pacientesDerivados derivados. ----------------------------------------------")
        nave.impPacientes()
    }

    fun llegarPaciente() {
        var pNuevo: Paciente = Factoria.crearPaciente()
        nave.addPaciente(pNuevo)
    }
    fun atenderPaciente(salaAct: Sala) {
        if (salaAct.pacientes.size > 0) {
            var pacienteAtendido: Paciente = salaAct.pacientes[0]
            when (pacienteAtendido.atencion) {
                atencionRequerida.Quemadura_Laser -> {
                    for (medico in salaAct.medicos) {
                        if (medico.especialidad == especialidades.Traumatologia) {
                            if (medico.compTrabaja[0] == pacienteAtendido.seguro || medico.compTrabaja[1] == pacienteAtendido.seguro) {
                                salaAct.pacientes.remove(pacienteAtendido)
                                println("El paciente ${pacienteAtendido.nombre} ha sido atendido por el medico ${medico.nombre}")
                                pacientesAtendidos++
                                break
                            }
                        }
                    }
                }
                atencionRequerida.Impacto_Chorritronico -> {
                    for (medico in salaAct.medicos) {
                        if (medico.especialidad == especialidades.Medicina_Interna) {
                            if (medico.compTrabaja[0] == pacienteAtendido.seguro || medico.compTrabaja[1] == pacienteAtendido.seguro) {
                                salaAct.pacientes.remove(pacienteAtendido)
                                println("El paciente ${pacienteAtendido.nombre} ha sido atendido por el medico ${medico.nombre}")
                                pacientesAtendidos++
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
        } else {
            println("No hay pacientes en la sala")
        }
    }
}