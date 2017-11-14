package thiagocury.eti.br.exintentsegundatelaenviandostring

import android.content.Intent
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

        //Ref
        etNome = findViewById(R.id.et_nome)
        btnOK = findViewById(R.id.btn_ok)

        //Clique do botao
        btnOK.setOnClickListener(){

            var texto = etNome.text.toString()

            if(texto != "") {
                val intent = Intent(this, Tela2::class.java)
                intent.putExtra("nome", texto)
                startActivity(intent)
            }else{
                toast(resources.getText(R.string.toast_msg_erro))
            }

        }
    }
}
