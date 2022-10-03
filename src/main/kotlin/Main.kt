import EnumClasses.*
import Modelos.*

fun main() {
    var nave: Nave = Nave()
    var dia: Int = 1
    var diaSemana: DiasSemana
    var nuevoTurno: Turno
    while (dia <= 7) {
        diaSemana = DiasSemana.values()[dia - 1]
        println("\t\tComienza el $diaSemana")
        for (i in 1..Turnos.values().size) {
            nuevoTurno = Turno(Turnos.values()[i - 1], nave)
            nuevoTurno.simulacion()
        }
        dia++
    }

}