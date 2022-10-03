package Modelos

class Nave {
    var sala1: Sala = Sala(1)
    var sala2: Sala = Sala(2)
    var sala3: Sala = Sala(3)

    //create and fill array with all the rooms
    var salas: Array<Sala> = arrayOf(sala1, sala2, sala3)
    fun iniciarTurno(): Boolean {
        for (sala in salas) {
            sala.genMedicos()
            return true
        }
        return false
    }
    fun comprobarSala(): Sala {
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
        comprobarSala().addPaciente(pNuevo)
        for (sala in salas) {
            sala.pacientes.sortBy { it.prioridad }
        }
    }
    fun atenderPaciente() {
        if (salas[0].pacientes.size == salas[1].pacientes.size && salas[1].pacientes.size == salas[2].pacientes.size) {
            println("No hay pacientes en espera")
        } else {
            
        }
    }

    fun mostrarSalas() {
        for (sala in salas) {
            println(sala)
        }
    }
}