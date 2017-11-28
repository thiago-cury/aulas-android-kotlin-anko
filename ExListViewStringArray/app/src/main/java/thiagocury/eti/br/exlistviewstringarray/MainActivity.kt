package thiagocury.eti.br.exlistviewstringarray

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    //Widgets
    lateinit var lvClientes: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.2' //Não esquecer de verificar por versões mais atuais.
        //Utilizar o compile a seguir:
        //implementation "org.jetbrains.anko:anko:$anko_version"

        //Refs.
        lvClientes = findViewById(R.id.lv_clientes)

        /* OnItemClickListener */
                                                                 //parent, view, position, id ->
        lvClientes.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            var nome = lvClientes.getItemAtPosition(position).toString()

            toast("posição selecionada: $position\n" +
                  "\nNome escolhido: $nome")
        }

        /* OnItemClickLongListener */
                                                                 //parent, view, position, id -> Boolean
        lvClientes.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, position, _ ->

            var nome = lvClientes.getItemAtPosition(position).toString()

            toast("posição selecionada com clique longo: $position\n" +
                  "\nNome escolhido: $nome")

            true
        }

    }
}
