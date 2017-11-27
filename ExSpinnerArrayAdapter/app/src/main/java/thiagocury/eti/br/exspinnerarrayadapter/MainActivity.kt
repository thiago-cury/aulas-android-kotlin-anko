package thiagocury.eti.br.exspinnerarrayadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    //Widgets
    lateinit var spSexo: Spinner
    lateinit var btnOK: Button

    //Adapter
    var adapter: ArrayAdapter<String>? = null

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
        spSexo = findViewById(R.id.sp_sexo)
        btnOK = findViewById(R.id.btn_ok)

        /* Array para popular na Spinner */
        var arraySexo = arrayOf("Escolha um sexo","Masculino","Feminino")

        /* Instanciando o ArrayAdapter, passando contexto, layout e o array */
        adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arraySexo)

        /* Setando o adapter */
        spSexo.adapter = adapter

        btnOK.setOnClickListener(){

            if(spSexo.selectedItemPosition.toInt() != 0) {

                var usuario = Usuario()
                usuario.sexo = spSexo.selectedItem.toString()
                toast("$usuario")

                //Limpando a Spinner
                spSexo.setSelection(0)

            } else {
                toast("Escolha um sexo")
            }

        }
    }
}
