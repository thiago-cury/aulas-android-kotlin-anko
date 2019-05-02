package thiagocury.eti.br.exintentsegundatelaretornandoobjeto

import java.io.Serializable

//Primeira maneira
class Pessoa (var nome: String, var idade: Int) : Serializable {

    override fun toString(): String {
        return "Nome $nome\nIdade $idade"
    }

}

//Segunda maneira (estrutura tradicional)
//class Pessoa : Serializable {
//
//    var nome: String? = null
//    var idade: Int? = 0
//
//    constructor(nome: String, idade: Int) {
//        this.nome = nome
//        this.idade = idade
//    }
//
//    override fun toString(): String {
//        return "Nome $nome\nIdade $idade"
//    }
//}