import java.util.*

fun main(args: Array<String>) {


    BaseGrupos.datos.add(BandasYGrupos("Black Sabbath","Heaavy Metal","1970-2015","Sony",12,"Inglaterra",arrayOf("ozzy", "geezer","tonny", "bill"),"inactivo"))
    BaseGrupos.datos.add(BandasYGrupos("Metallica","Thrash Metal","1970-actualidad","Blast",18,"EU",arrayOf("Ulrich", "Heatfield","Trujillo", "Hammet"),"Activo"))
    //println(BaseGrupos.recuperarPorIndice(1))
    //println()
    //println(BaseGrupos.recuperarPorIndice(0))

    BaseSolistas.datos.add(SolistaOVocalista("Ozzy Osbourne","Heavy Metal","1980-actualidad","Sony",11,"Jonh Michael Osbourne",Date("1948/04/05"),null,"Ingles","voz"))
    BaseSolistas.datos.add(SolistaOVocalista("Bon Jovi","Rock","1985-actualidad","Algo",17,"Jon Bon Jovi",Date("1950/10/18"),null,"Estado Unidense","voz"))
    println(BaseSolistas.recuperarPorIndice(1))
    println()
    println(BaseSolistas.recuperarPorIndice(0))

}

open class ArtistaMusical(val nNombre: String,
                           val nGenero: String,
                           val nTiempoActividad: String,
                           val nCompaniaDiscografica: String,
                           val nDiscos: Int) {
}

class SolistaOVocalista(nombre: String,
                        genero: String,
                        tiempo: String,
                        compania: String,
                        discos: Int,
                        val nNombreReal: String,
                        val nFechaNacimiento: Date,
                        val nMuerte: Date?,
                        val nNacionalidad: String,
                        val nInstrumento: String) : ArtistaMusical(nombre, genero, tiempo, compania, discos) {

    override fun toString(): String {
        return "Artista: $nNombre" + '\n' +
                "Genero: $nGenero" + '\n' +
                "Tiempo Activo: $nTiempoActividad" + '\n' +
                "Compania Discografica: $nCompaniaDiscografica" + '\n' +
                "Discos: $nDiscos" + '\n' +
                "Nombre Real: $nNombreReal" + '\n' +
                "Fecha de Nacimiento: $nFechaNacimiento" + '\n' +
                "Fecha de Muerte: $nMuerte" + '\n' +
                "Nacionalidad: $nNacionalidad" + '\n' +
                "Instrumentos: $nInstrumento"

    }
}

class BandasYGrupos(nombre: String,
                    genero: String,
                    tiempo: String,
                    compania: String,
                    discos: Int,
                    val nOrigen: String,
                    var nMiembros: Array<String>,
                    val nEstado: String): ArtistaMusical(nombre, genero, tiempo, compania, discos) {

    fun getMiembros(miembros: Array<String>):String{
        var salida=""
        for (posicion in miembros.indices)
            if((posicion+1)==miembros.size){
                salida =salida+miembros.get(posicion)
            }else salida =salida+miembros.get(posicion)+", "
        return salida;
    }

    override fun toString(): String {
        return "Artista: $nNombre" + '\n' +
                "Genero: $nGenero" + '\n' +
                "Tiempo Activo: $nTiempoActividad" + '\n' +
                "Compania Discografica: $nCompaniaDiscografica" + '\n' +
                "Discos: $nDiscos" + '\n' +
                "Origen: $nOrigen" + '\n' +
                "Miembros: ${getMiembros(this.nMiembros)}" + '\n' +
                "Estado: $nEstado"

    }
}

class BaseGrupos{
    companion object {
        val datos: ArrayList<BandasYGrupos> = ArrayList()

        fun recuperarPorIndice(indice:Int): BandasYGrupos? {
            for (indiceArreglo in datos.indices){
                if(indiceArreglo == indice){
                    return datos[indiceArreglo]
                }
            }
            return null
        }
    }
}

class BaseSolistas{
    companion object {
        val datos: ArrayList<SolistaOVocalista> = ArrayList()

        fun recuperarPorIndice(indice:Int): SolistaOVocalista? {
            for (indiceArreglo in datos.indices){
                if(indiceArreglo == indice){
                    return datos[indiceArreglo]
                }
            }
            return null
        }
    }
}

