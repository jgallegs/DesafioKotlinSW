package Modelos

import EnumClasses.*

class Medico (NIDI: Int, n: String, var especialidad: especialidades) : Persona(NIDI, n) {
    var compTrabaja: ArrayList<compSeguros> = ArrayList()
    init {
        while (compTrabaja.size < 2) {
            val comp = compSeguros.values().random()
            if (!compTrabaja.contains(comp)) {
                compTrabaja.add(comp)
            }
        }
    }

    override fun toString(): String {
        return "\n$nombre " +
                "\n\tWspecialidad $especialidad, compañias: ${compTrabaja.get(0)} y ${compTrabaja.get(1)}"
    }

}