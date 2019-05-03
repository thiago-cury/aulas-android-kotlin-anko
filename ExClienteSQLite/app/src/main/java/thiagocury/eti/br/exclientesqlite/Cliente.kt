package thiagocury.eti.br.exclientesqlite

import java.io.Serializable

class Cliente(var id: Int?, var nome: String?, var idade: Int?, var renda: Double?): Serializable {

    override fun toString(): String {
        return "idCliente: $id nome $nome idade $idade renda $renda"
    }

}