package Modelos

import EnumClasses.*

class Medico (NIDI: Int, n: String, var especialidad: especialidades) : Persona(NIDI, n) {
    var compTrabaja: ArrayList<compSeguros> = ArrayList()

    /**
     * Al crear un medico, se eligen dos compañias de entre todas las que hay.
     */
    init {
        while (compTrabaja.size < 2) {
            val comp = compSeguros.values().random()
            if (!compTrabaja.contains(comp)) {
                compTrabaja.add(comp)
            }
        }
    }

    override fun toString(): String {
        return "\n\t$nombre " +
                "\n\tEspecialidad $especialidad, compañias: ${compTrabaja.get(0)} y ${compTrabaja.get(1)}"
    }

}