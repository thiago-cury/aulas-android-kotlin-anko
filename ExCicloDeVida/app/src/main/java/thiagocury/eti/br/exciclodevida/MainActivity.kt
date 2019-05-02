package thiagocury.eti.br.exciclodevida

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tipos de Log
        info { "entrou no oncreate" }
        debug { "entrou no oncreate" }
        warn { "entrou no oncreate" }
        verbose { "entrou no oncreate" }
        error { "entrou no oncreate" }

    }

    override fun onStart() {
        super.onStart()
        info { "entrou no onstart" }
    }
    override fun onResume() {
        super.onResume()
        info { "entrou no onresume" }
    }
    override fun onPause() {
        super.onPause()
        info { "entrou no onpause" }
    }
    override fun onStop() {
        super.onStop()
        info { "entrou no onstop" }
    }
    override fun onDestroy() {
        super.onDestroy()
        info { "entrou no ondestroy" }
    }
    override fun onRestart() {
        super.onRestart()
        info { "entrou no onrestart" }
    }
}
