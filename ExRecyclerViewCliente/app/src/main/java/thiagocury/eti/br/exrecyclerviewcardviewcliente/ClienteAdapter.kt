package thiagocury.eti.br.exrecyclerviewcardviewcliente

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.linha_cliente.view.*

/**
 * Created by thiagocury on 14/12/17.
 */
class ClienteAdapter(private val clientes: List<Cliente>,
                     private val context: Context) : Adapter<ClienteAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return clientes.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val cli = clientes[position]

        //Primeira maneira
        /*holder?.nome?.text = cli.nome.toString()
        holder?.renda?.text = cli.renda.toString()
        holder?.sexo?.text = cli.sexo.toString()*/

        //Segunda maneira - com a utilização do let
        /* Caso o holder seja nulo, o let não será executado. */
        holder?.let {
            it.nome.text = cli.nome.toString()
            it.renda.text = cli.renda.toString()
            it.sexo.text = cli.sexo.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.linha_cliente, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nome = itemView.findViewById<TextView>(R.id.tv_nome)
        val sexo = itemView.findViewById<TextView>(R.id.tv_sexo)
        val renda = itemView.findViewById<TextView>(R.id.tv_renda)

        fun bindView(cli: Cliente) {
            val nome = itemView.tv_nome
            val sexo = itemView.tv_sexo
            val renda = itemView.tv_renda

            nome.text = cli.nome
            sexo.text = cli.sexo
            renda.text = cli.renda.toString()
        }

    }

}

