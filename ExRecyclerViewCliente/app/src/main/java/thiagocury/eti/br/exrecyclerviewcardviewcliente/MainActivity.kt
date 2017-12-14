package thiagocury.eti.br.exrecyclerviewcardviewcliente

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    lateinit var etNome: EditText
    lateinit var spSexo: Spinner
    lateinit var etRenda: EditText
    lateinit var btnOK: Button
    lateinit var rvCientes: RecyclerView

    lateinit var adapter: ClienteAdapter
    var clientes = arrayListOf<Cliente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Refs
        etNome = findViewById(R.id.et_nome)
        spSexo = findViewById(R.id.sp_sexo)
        etRenda = findViewById(R.id.et_renda)
        btnOK = findViewById(R.id.btn_ok)
        rvCientes = findViewById(R.id.rv_clientes)

        //Setando o adapter
        adapter = ClienteAdapter(clientes, this)
        rvCientes.adapter = adapter

        //Setando o layout da RecyclerView
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvCientes.layoutManager = layoutManager

        /* clique do botão */
        btnOK.setOnClickListener() {

            var c = Cliente()

            c.nome = etNome.text.toString()
            c.sexo = spSexo.selectedItem.toString()
            c.renda = etRenda.text.toString().toDouble()

            /* Adicionando objeto c no arrayListOf */
            clientes.add(c)

            /* Forçando a atualização da RecyclerView */
            adapter!!.notifyDataSetChanged()

            toast(resources.getText(R.string.toast_sucesso))
        }
    }
}
