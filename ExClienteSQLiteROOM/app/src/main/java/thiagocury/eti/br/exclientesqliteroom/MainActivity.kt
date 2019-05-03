package thiagocury.eti.br.exclientesqliteroom

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), AnkoLogger {

    private lateinit var cliente: Cliente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getAppDataBase(this)

        var c = Cliente(1,"aaa", 20, 2000.89)
        db?.clienteDAO()?.add(c)

        var c1 = Cliente(2,"bbb", 30, 3000.89)
        db?.clienteDAO()?.add(c1)

        val clientes: List<Cliente> = db?.clienteDAO()?.getAll()!!

        for(c in clientes){
            toast("clientes: ${c}")
            info { "clientes: ${c}" }
        }

    }
}
