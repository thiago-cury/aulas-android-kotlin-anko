package thiagocury.eti.br.exintentsegundatelaenviandoobjeto

import java.io.Serializable

/**
 * Created by thiagocury on 16/11/17.
 */
class Usuario : Serializable {

    var login: String? = null
    var senha: String? = null

    override fun toString(): String {
        return "Login $login\nSenha $senha"
    }
}