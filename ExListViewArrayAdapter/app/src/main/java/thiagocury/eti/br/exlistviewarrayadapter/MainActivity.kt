package thiagocury.eti.br.exlistviewarrayadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    //Widgets
    lateinit var etNome : EditText
    lateinit var btnOK : Button
    lateinit var lvClientes : ListView

    var adapter : ArrayAdapter<Cliente>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.2' //Não esquecer de verificar por versões mais atuais.
        //Utilizar o compile a seguir:
        //implementation "org.jetbrains.anko:anko:$anko_version"

        //Refs
        etNome = findViewById(R.id.et_nome)
        btnOK = findViewById(R.id.btn_ok)
        lvClientes = findViewById(R.id.lv_clientes)

        /* Array para popular na ListView */
        var clientes = arrayListOf<Cliente>()

        /* Instanciando o ArrayAdapter, passando contexto, layout e o array */
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, clientes)

        /* Setando o adapter */
        lvClientes.adapter = adapter

        /* OnItemClickListener */

        lvClientes.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->

            var nome = lvClientes.getItemAtPosition(position).toString()

            toast("posição selecionada: $position\n" +
                    "\nNome escolhido: $nome")

        }

        /* OnItemLongClickListener */

        lvClientes.onItemLongClickListener = AdapterView.OnItemLongClickListener{ _, _, position, _ ->

            var nome = lvClientes.getItemAtPosition(position).toString()

            toast("posição selecionada com clique longo: $position\n" +
                    "\nNome escolhido: $nome")

            true
        }

        btnOK.setOnClickListener() {

            /* Instanciando objeto cliente */
            var c = Cliente()

            /* Recebendo valor digitado */
            c.nome = etNome.text.toString()

            /* Adicionando objeto cliente no Array de objetos */
            clientes.add(c)

            /* Notificando a mudança para o adapter */
            adapter!!.notifyDataSetChanged()

            toast("Cliente cadastrado")

            /* limpando o campo de texto (EditText) */
            etNome.text = null

        }

    }
}
