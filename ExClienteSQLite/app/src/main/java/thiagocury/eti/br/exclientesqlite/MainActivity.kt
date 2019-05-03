package thiagocury.eti.br.exclientesqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), AnkoLogger {

    var cDAO: ClienteDAO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cDAO = ClienteDAO(this@MainActivity)
        cDAO?.abrirDB()
    }

    override fun onResume() {
        super.onResume()

        var c1 = Cliente(0,"thiago", 35, 2000.50)
        cDAO?.inserirCliente(c1)

        var c2 = Cliente(0,"ze", 35, 2000.50)
        cDAO?.inserirCliente(c2)

        var c3 = Cliente(0,"joao", 35, 2000.50)
        cDAO?.inserirCliente(c3)

        toast(cDAO?.buscarClientes().toString())
        info { "xxx - ${cDAO?.buscarClientes().toString()}" }
    }

    override fun onPause() {
        super.onPause()
        cDAO?.fecharDB()
    }
}
