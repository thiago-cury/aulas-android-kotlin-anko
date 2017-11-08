package thiagocury.eti.br.exentradadedadosedittext

/**
 * Created by thiagocury on 08/11/17.
 */

//Primeira maneira sem construtor
class Cliente {

    var nome: String? = null

    override fun toString(): String {
        return "Nome $nome"
    }
}

//Segunda maneira com construtor!
/*class Cliente(nome:String){

    val nome: String

    init{
        this.nome = nome
    }

    override fun toString(): String {
        return "Nome $nome"
    }
}*/