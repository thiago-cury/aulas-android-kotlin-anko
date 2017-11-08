package thiagocury.eti.br.exentradadedadosedittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    lateinit var etNome: EditText
    lateinit var btnOK: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.2' //Não esquecer de verificar por versões mais atuais.
        //Utilizar o compile a seguir:
        //compile "org.jetbrains.anko:anko:$anko_version"

        etNome = findViewById<EditText>(R.id.et_nome)
        btnOK = findViewById<Button>(R.id.btn_ok)

        btnOK.setOnClickListener{

            //Primeira maneira sem construtor
            var c = Cliente()

            c.nome = etNome.text.toString()

            //Segunda maneira com construtor
            //val c = Cliente(etNome.text.toString())

            toast("Cliente cadastrado com sucesso")

            //Imprimindo o toString
            toast("Dados: $c")
        }
    }
}
