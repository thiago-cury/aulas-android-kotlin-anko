package thiagocury.eti.br.exintentsegundatelaenviandoobjectoparcelable

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
class Pessoa(var nome: String, var idade: Int): Parcelable {

    override fun toString(): String {
        return "Nome: ${nome} Idade: ${idade}"
    }

}

//Segunda maneira (estrutura tradicional)
//@SuppressLint("ParcelCreator")
//@Parcelize
//class Pessoa : Parcelable {
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