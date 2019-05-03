package thiagocury.eti.br.exrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ClienteAdapter
    private var clientes = arrayListOf<Cliente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setando o adapter
        adapter = ClienteAdapter(clientes, this, { cli: Cliente -> resultItemClicked(cli)})
        ma_rv_clientes.adapter = adapter

        //Setando o layout da RecyclerView
        ma_rv_clientes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        ou
//        ma_rv_clientes.layoutManager = LinearLayoutManager(this@MainActivity)

        ma_bt_ok.setOnClickListener {

            if(ma_et_nome.text.toString().isEmpty()){
                ma_et_nome.setError(getString(R.string.ma_et_nome_erro))
                return@setOnClickListener
            }

            if(ma_sp_sexo.selectedItemPosition == 0){
                toast(getString(R.string.ma_sp_sexo_erro))
                return@setOnClickListener
            }

            if(ma_et_renda.text.toString().isEmpty()){
                ma_et_nome.setError(getString(R.string.ma_et_renda_erro))
                return@setOnClickListener
            }

            var c = Cliente(ma_et_nome.text.toString(), ma_sp_sexo.selectedItem.toString(), ma_et_renda.text.toString().toDouble())

            /* Adicionando objeto c no arrayListOf */
            clientes.add(c)

            /* Forçando a atualização da RecyclerView */
            adapter!!.notifyChangedList()

            toast(resources.getText(R.string.ma_toast_sucesso))
        }
    }

    private fun resultItemClicked(cli: Cliente) {
        toast(cli.toString())
    }

}
