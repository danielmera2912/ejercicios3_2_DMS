fun main(args: Array<String>) {
    println("Introduce nombre")
    var nombre= readLine()?.toString()

    println("Introduce edad")
    var edad= readLine()?.toInt()

    println("Introduce sexo")
    var sexo: Char? = readLine()?.single()

    println("Introduce peso (Escribe H/M)")
    var peso= readLine()?.toDouble()

    println("Introduce altura")
    var altura= readLine()?.toDouble()

    var p1= Persona(nombre!!,edad!!,sexo!!,peso!!,altura!!)
    var p2= Persona(nombre!!,edad!!,sexo!!)
    var p3= Persona()
    p2.peso=peso
    p2.altura=altura
    p3.nombre=nombre
    p3.edad=edad+14
    p3.sexo=sexo
    p3.peso=peso
    p3.altura=altura


    if(p2.calcularIMC()==-1){
        println("Debajo del peso normal")
    }
    else if(p2.calcularIMC()==0){
        println("Peso ideal")
    }
    else{
        println("Sobrepeso")
    }


    if(p1.esMayorDeEdad()==true){
        println(p1.nombre+" es mayor de edad")
    }
    else{
        println(p1.nombre+" no es mayor de edad")
    }

    if(p2.esMayorDeEdad()==true){
        println(p2.nombre+" es mayor de edad")
    }
    else{
        println(p2.nombre+" no es mayor de edad")
    }

    if(p2.esMayorDeEdad()==true){
        println(p3.nombre+" es mayor de edad")
    }
    else{
        println(p3.nombre+" no es mayor de edad")
    }

    println(p1.toString())
    println(p2.toString())
    println(p3.toString())
}

private class Persona(){
    var nombre:String?= null
    var edad:Int=0
    val dni:String= generarDni()
    var sexo:Char?
    var peso:Double?=null
    var altura:Double?=null
    init {
        nombre=""
        edad=0
        sexo='H'
        peso=0.0
        altura=0.0
    }
    public constructor(nombre: String,edad: Int,sexo: Char,peso:Double,altura:Double) : this() {
        this.nombre=nombre
        this.edad=edad
        this.sexo=sexo
        this.peso=peso
        this.altura=altura
    }
    public constructor(nombre:String,edad:Int,sexo:Char) : this() {
        this.nombre=nombre
        this.edad=edad
        this.sexo=sexo
    }
    fun generarDni():String{
        var cadena: String = ""
        var caracter: Char= ' '
        for(i in 1..8){
            caracter= (48..57).random().toChar()
            cadena=cadena+caracter.toString()
        }
        caracter= (65..90).random().toChar()
        cadena+=caracter
        return cadena
    }
    fun calcularIMC():Int{
        var pesoIdeal=(this.peso!!/(this.altura!! *this.altura!!))
        if(pesoIdeal<20){
            return -1
        }
        else if (pesoIdeal>=20 && pesoIdeal<=25){
            return 0
        }
        else{
            return 1
        }
    }
    fun esMayorDeEdad(): Boolean{
        if(this.edad>=18){
            return true
        }
        else{
            return false
        }
    }

    override fun toString(): String =("La persona "+nombre+" con "+edad+" años, con DNI "+dni+" de sexo "+sacarSexo()+" con peso "+peso+" y altura "+altura)

    private fun sacarSexo(): String {
        if(sexo=='H'){
            return "Hombre"
        }
        else{
            return "Mujer"
        }
    }


}