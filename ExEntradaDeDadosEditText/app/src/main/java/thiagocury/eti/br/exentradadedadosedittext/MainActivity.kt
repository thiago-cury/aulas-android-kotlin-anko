package thiagocury.eti.br.exentradadedadosedittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.8' //Não esquecer de verificar por versões mais atuais.
        //Utilizar o compile a seguir:
        //implements "org.jetbrains.anko:anko:$anko_version"

        bt_ok.setOnClickListener {
            //Primeira maneira sem construtor
            var c = Cliente()

            c.nome = et_nome.text.toString()

            //Segunda maneira com construtor -> Alterar na classe para testar
//            val c = Cliente(et_nome.text.toString())

            toast("Cliente cadastrado com sucesso")

            //Imprimindo o toString
            toast("Dados: $c")
        }
    }
}
