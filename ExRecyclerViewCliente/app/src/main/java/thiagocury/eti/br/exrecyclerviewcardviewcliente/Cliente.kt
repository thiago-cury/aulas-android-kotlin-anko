package thiagocury.eti.br.exrecyclerviewcardviewcliente

/**
 * Created by thiagocury on 14/12/17.
 */
class Cliente{

    var nome: String? = null
    var sexo: String? = null
    var renda: Double? = 0.00

    override fun toString(): String{
        return "Nome $nome\nSexo: $sexo\nRenda: $renda"
    }

}