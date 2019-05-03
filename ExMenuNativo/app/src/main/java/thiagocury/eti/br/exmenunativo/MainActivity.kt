package thiagocury.eti.br.exmenunativo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val MENU_SOBRE : Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        menu.add(MENU_SOBRE, MENU_SOBRE, MENU_SOBRE,"Sobre")
            .setIcon(R.drawable.ic_launcher_background)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.menu_main_op1 -> toast("Você clicou na opcão 1")
            R.id.menu_main_op2 -> toast("Você clicou na opcão 2")
            MENU_SOBRE -> toast("Você clicou na opção sobre")
            else -> toast("Opcão inválida")
        }

        return super.onOptionsItemSelected(item)
    }
}
