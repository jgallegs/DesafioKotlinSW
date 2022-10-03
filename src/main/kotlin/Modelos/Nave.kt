package Modelos

import EnumClasses.atencionRequerida
import EnumClasses.especialidades

class Nave {
    var sala1: Sala = Sala(1)
    var sala2: Sala = Sala(2)
    var sala3: Sala = Sala(3)

    //create and fill array with all the rooms
    var salas: Array<Sala> = arrayOf(sala1, sala2, sala3)
    fun iniciarTurno(): Boolean {
        for (sala in salas) {
            sala.genMedicos()
        }
        return true
    }
    fun comprobarSala(): Sala {
        salas.sortBy { it.pacientes.size }
        var i: Int = 0
        if (salas[0].pacientes.size == salas[1].pacientes.size && salas[1].pacientes.size == salas[2].pacientes.size && salas[2].pacientes.size >= 1) {
            i = (0..2).random()
            when (i) {
                0 -> return salas[0]
                1 -> return salas[1]
                2 -> return salas[2]
            }
        } else if (salas[1].pacientes.size == salas[2].pacientes.size && salas[2].pacientes.size >= 1) {
            i = (0..1).random()
            when (i) {
                0 -> return salas[0]
                1 -> return salas[1]
            }
        } else {
            return salas[2]
        }
        return salas[2]
    }
    fun comprobarSalaLibre(): Sala {
        salas.sortBy { it.pacientes.size }
        var i: Int = 0
        if (salas[0].pacientes.size == salas[1].pacientes.size && salas[1].pacientes.size == salas[2].pacientes.size) {
            i = (0..2).random()
            when (i) {
                0 -> return salas[0]
                1 -> return salas[1]
                2 -> return salas[2]
            }
        } else if (salas[0].pacientes.size == salas[1].pacientes.size) {
            i = (0..1).random()
            when (i) {
                0 -> return salas[0]
                1 -> return salas[1]
            }
        } else {
            return salas[0]
        }
        return salas[0]
    }
    fun addPaciente(pNuevo: Paciente) {
        comprobarSalaLibre().addPaciente(pNuevo)
        for (sala in salas) {
            sala.pacientes.sortBy { it.prioridad }
        }
        println("Ha llegado el paciente ${pNuevo.nombre} a la sala ${comprobarSalaLibre().numero}")
    }
    fun impPacientes() {
        println("Pacientes en sala 1: ${sala1.pacientes.size}")
        println("Pacientes en sala 2: ${sala2.pacientes.size}")
        println("Pacientes en sala 3: ${sala3.pacientes.size}")
    }
}