package thiagocury.eti.br.exintentabrindosegundatela

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnOK: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.2' //Não esquecer de verificar por versões mais atuais.
        //Utilizar o compile a seguir:
        //compile "org.jetbrains.anko:anko:$anko_version"

        //Ref.
        btnOK = findViewById(R.id.btn_ok)

        //Clique do botão
        btnOK.setOnClickListener(){

            val intent = Intent(this, Tela2::class.java)
            startActivity(intent)

            /* alternativa -> chamar em apenas uma linha! */
            //startActivity<Tela2>()

        }
    }
}
