package thiagocury.eti.br.exrecyclerview

class Cliente(var nome: String, var sexo: String, var renda: Double){

    override fun toString(): String{
        return "Nome $nome\nSexo: $sexo\nRenda: $renda"
    }

}

//class Cliente{
//    var nome: String? = null
//    var sexo: String? = null
//    var renda: Double? = 0.00
//
//    override fun toString(): String{
//        return "Nome $nome\nSexo: $sexo\nRenda: $renda"
//    }
//}