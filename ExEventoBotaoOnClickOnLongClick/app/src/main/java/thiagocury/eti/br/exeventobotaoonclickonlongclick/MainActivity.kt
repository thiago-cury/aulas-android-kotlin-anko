package thiagocury.eti.br.exeventobotaoonclickonlongclick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    //Widgets
    var btnOK: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.2' //Não esquecer de verificar por versões mais atuais.
        //Utilizar o compile a seguir:
        //compile "org.jetbrains.anko:anko:$anko_version"

        btnOK = findViewById(R.id.btn_ok) as Button

        //Dessa forma não estamos internacionalizando o projeto.

        //Clique simples.
        btnOK?.setOnClickListener { toast("Você clicou no botão! Evento onClick") }

        //Clique longo
        btnOK?.setOnLongClickListener { toast("Você clicou e segurou o botão! Evento onLongClick") ; true }

    }
}
