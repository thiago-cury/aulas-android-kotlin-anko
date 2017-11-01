package thiagocury.eti.br.exciclodevida

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import org.jetbrains.anko.*

                                        //Extends AnkoLogger
class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.2' //Não esquecer de verificar por versões mais atuais.
        //Utilizar os dois compile a seguir para utilizar os logs:
        //compile "org.jetbrains.anko:anko:$anko_version"
        //compile "org.jetbrains.anko:anko-commons:$anko_version"

        //E também estender a classe de AnkoLogger

        info("Entrou no onCreate. Log info")
        //Utilizando Lambda
        info { "Entrou no onCreate. " + "Log info com Lambda" }

        //Todos os logs:
        verbose("Entrou no onCreate. Log verbose") //Corresponde a Log.v()
        debug("Entrou no onCreate. Log debug") //Corresponde a Log.d()
        warn("Entrou no onCreate. Log warn") //Corresponde a Log.w()
        error("Entrou no onCreate. Log error") //Corresponde a Log.e()
        wtf("Entrou no onCreate. Log wtf") //Corresponde a Log.wtf()

    }

    override fun onStart() {
        super.onStart()
        info("Entrou no onStart")
    }

    override fun onPause() {
        super.onPause()
        info("Entrou no onPause")
    }

    override fun onStop() {
        super.onStop()
        info("Entrou no onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        info("Entrou no onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        info("Entrou no onStart")
    }

    override fun onResume() {
        super.onResume()
        info("Entrou no onResume")
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        info("Entrou no método onSaveInstanceState");
    }

}