import EnumClasses.*
import Modelos.*

fun main() {
    var pacientesAtendidos: Int = 0
    var pacientesDerivados: Int = 0
    var nave: Nave = Nave()
    var dia: Int = 1
    var diaSemana: DiasSemana
    var nuevoTurno: Turno
    while (dia <= 7) {
        diaSemana = DiasSemana.values()[dia - 1]
        println("--------------------------- Comienza el $diaSemana ---------------------------")
        for (i in 1..Turnos.values().size) {
            nuevoTurno = Turno(Turnos.values()[i - 1], nave)
            nuevoTurno.simulacion()
            pacientesAtendidos += nuevoTurno.pacientesAtendidos
            pacientesDerivados += nuevoTurno.pacientesDerivados
        }
        dia++
    }
    println("Pacientes atendidos: $pacientesAtendidos")
    println("Pacientes derivados: $pacientesDerivados")
    nave.impPacientes()
}