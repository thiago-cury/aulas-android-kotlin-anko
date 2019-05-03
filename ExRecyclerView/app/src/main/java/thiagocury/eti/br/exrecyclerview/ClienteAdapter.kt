package thiagocury.eti.br.exrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_cliente.view.*

class ClienteAdapter(private val clientes: List<Cliente>, private val context: Context, val listener: (Cliente) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

                                //p0 = parent   p1 = ViewType
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_cliente, p0, false))
    }

//    A mesma função criada pode ser feita de duas maneiras através da técnica
//    Single-Expression function, são elas:
    override fun getItemCount(): Int = clientes.size

//    Original
//    override fun getItemCount(): Int {
//        return clientes.size
//    }
                             //p0 = holder                  p1 = position
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

        val cli = clientes[p1]

        if(p0 is ViewHolder){
            p0?.let {
                it.bind(cli, p1, listener)
            }
        }
    }

    public fun notifyChangedList(){
        this.notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(cli: Cliente?, position: Int, listener: (Cliente) -> Unit) = with(itemView) {
        val tvNome = itemView.row_tv_nome
        val tvSexo = itemView.row_tv_sexo
        val tvRenda = itemView.row_tv_renda

        cli?.let{
            tvNome.text = it.nome
            tvSexo.text = it.sexo
            tvRenda.text = it.renda.toString()

            itemView.setOnClickListener { listener(cli) }
        }
    }

}