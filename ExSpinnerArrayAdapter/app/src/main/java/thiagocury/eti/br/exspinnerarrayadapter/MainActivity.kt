package thiagocury.eti.br.exspinnerarrayadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    //Adapter
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.8' //Não esquecer de verificar por versões mais atuais.
        //Utilizar o implementation a seguir:
        //implementation "org.jetbrains.anko:anko:$anko_version"

        /* Array para popular na Spinner */
        var arraySexo = arrayOf("Escolha um sexo","Masculino","Feminino")

        /* Instanciando o ArrayAdapter, passando contexto, layout e o array */
        adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arraySexo)

        /* Setando o adapter */
        sp_sexo.adapter = adapter

        sp_sexo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position==1){
                    toast("selecionou ${sp_sexo.selectedItem.toString()}")
                }else if(position==2){
                    toast("selecionou ${sp_sexo.selectedItem.toString()}")
                }
            }
        }

        bt_ok.setOnClickListener(){

            if(sp_sexo.selectedItemPosition.toInt() != 0) {

                var usuario = Usuario()
                usuario.sexo = sp_sexo.selectedItem.toString()
                toast("$usuario")

                //Limpando a Spinner
                sp_sexo.setSelection(0)

            } else {
                toast("Escolha um sexo")
            }

        }

    }
}