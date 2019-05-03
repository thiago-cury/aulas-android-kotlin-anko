package thiagocury.eti.br.exclientesqliteroom

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    var nome: String?,
    var idade: Int?,
    var renda: Double?
): Serializable {

    override fun toString(): String {
        return "idCliente: $id nome $nome idade $idade renda $renda"
    }
}