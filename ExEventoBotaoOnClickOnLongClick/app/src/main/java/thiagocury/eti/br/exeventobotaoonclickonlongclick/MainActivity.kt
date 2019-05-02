package thiagocury.eti.br.exeventobotaoonclickonlongclick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var btOK: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Site lib Anko: https://github.com/Kotlin/anko
//        Para utilizar a Anko precisamos:
//        Adicionar em buildscript nível do projeto
//        ext.anko_version = '0.10.8' //Não esquecer de verificar por versões mais atuais.
//        Utilizar o implementation a seguir:
//        implementation "org.jetbrains.anko:anko:$anko_version"

        btOK = findViewById(R.id.ma_bt_ok)

        //Dessa forma não estamos internacionalizando o projeto.

        //Clique simples.
        btOK?.setOnClickListener { toast(getString(R.string.ma_onclick_toast)) }

        //Clique longo
        btOK?.setOnLongClickListener {
            toast(getString(R.string.ma_onlongclick_toast))
            true
        }

    }
}
