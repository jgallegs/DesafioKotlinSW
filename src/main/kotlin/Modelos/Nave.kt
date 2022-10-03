package Modelos

import EnumClasses.atencionRequerida
import EnumClasses.especialidades

class Nave {
    var sala1: Sala = Sala(1)
    var sala2: Sala = Sala(2)
    var sala3: Sala = Sala(3)

    //create and fill array with all the rooms
    var salas: Array<Sala> = arrayOf(sala1, sala2, sala3)

    /**
     * Inicia el turno añadiendo dos médicos en cada sala
     */
    fun iniciarTurno(): Boolean {
        for (sala in salas) {
            sala.genMedicos()
        }
        return true
    }

    /**
     * Se usa para saber a que sala debe entrar el paciente. Se ordena un array con las salas por tamaño de pacientes
     * y se devuelve la más vacía en la primera posición
     */
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
        }
        return salas[2]
    }

    /**
     * Se usa para saber a que sala debe entrar el paciente. Se ordena un array con las salas por cantidad de pacientes
     */
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

    /**
     * Llama al metodo comprobarSalaLibre para saber a que sala debe entrar el paciente, y se le añade. Después se ordena el array_list
     * con pacientes por orden de prioridad.
     */
    fun addPaciente(pNuevo: Paciente) {
        comprobarSalaLibre().addPaciente(pNuevo)
        for (sala in salas) {
            sala.pacientes.sortBy { it.prioridad }
        }
        println("Ha llegado el paciente ${pNuevo.nombre} a la sala ${comprobarSalaLibre().numero}")
    }

    /**
     * Imprime cuantos pacientes tiene cada sala.
     */
    fun impPacientes() {
        for (sala in salas) {
            println("La sala ${sala.numero} tiene ${sala.pacientes.size} pacientes")
        }
    }
}