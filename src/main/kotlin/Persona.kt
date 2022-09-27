enum class compSeguro {
    Sanitroopers,
    Vaderslas,
    Yodacare
}
enum class especialidades {
    Traumatologia,
    Medicina_Interna
}
enum class atencionRequerida {
    Quemadura_Laser,
    Impacto_Chorritronico,
    Otros
}
open class Persona(var NIDI: String, var nombre: String)