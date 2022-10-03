package Modelos

import EnumClasses.*

class Paciente(NIDI: Int, nombre: String, var seguro: compSeguros, var atencion: atencionRequerida, var prioridad: Int) : Persona(NIDI, nombre) {
    override fun toString(): String {
        return "\nModelos.Paciente $NIDI" +
                "\n\tSeguro: $seguro, atencion: $atencion y prioridad $prioridad)"
    }
}