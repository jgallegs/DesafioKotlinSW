package Factorias

import EnumClasses.*
import Modelos.*
import kotlin.random.Random

object Factoria {
    var NIDIpaciente: Int = 0
    var NIDImedico: Int = 0
    fun crearPaciente(): Paciente {
        var p = Paciente(
            NIDIpaciente, "Modelos.Paciente $NIDIpaciente", compSeguros.values().random(),
            atencionRequerida.values().random(),Random.nextInt(1, 4))
        NIDIpaciente++
        return p
    }
    fun crearMedico(i: Int): Medico {
        var m = Medico(NIDImedico, "Modelos.Medico $NIDImedico", especialidades.values()[i])
        NIDImedico++
        return m
    }
}