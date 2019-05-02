package thiagocury.eti.br.exeventobotaoonclickonlongclicklateinit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var btOK : Button

//    Operado LATEINIT:
//    Com o operador lateinit podemos buscar a referência da View posteriormente sem precisar
//    testar com o null safety "?". O lateinit permite criar uma variável sem precisar atribuir o valor
//    de null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Site lib Anko: https://github.com/Kotlin/anko
//        Para utilizar a Anko precisamos:
//        Adicionar em buildscript nível do projeto
//        ext.anko_version = '0.10.8' //Não esquecer de verificar por versões mais atuais.
//        Utilizar o implementation a seguir:
//        implementation "org.jetbrains.anko:anko:$anko_version"

//        Buscando a referência de três formas
        btOK = findViewById(R.id.ma_bt_ok)
//        ou
//        btOK = findViewById(R.id.ma_bt_ok) as Button
//
//        ou
//        btOK = findViewById<Button>(R.id.ma_bt_ok)


//        Clique simples.
        btOK.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                toast(getString(R.string.ma_toast_onclick))
            }
        })

//        Clique longo
        btOK.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                toast(getString(R.string.ma_toast_onlongclick))
                return true
            }
        })

    }
}
