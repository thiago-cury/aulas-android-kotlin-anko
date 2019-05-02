package thiagocury.eti.br.exentradadedadosedittext

/**
 * Created by thiagocury on 26/03/19.
 */

//Primeira maneira sem construtor
class Cliente {

    var nome: String? = null

    override fun toString(): String {
        return "Nome $nome"
    }
}

//Segunda maneira com construtor!
//class Cliente(var nome: String){
//
//    override fun toString(): String {
//        return "Nome $nome"
//    }
//
//}