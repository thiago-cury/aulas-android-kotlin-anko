package thiagocury.eti.br.exsnackbar

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        ma_bt_snackbar.setOnClickListener { view ->

            //Snackbar não internacionalizada
            Snackbar.make(view, "Snackbar", Snackbar.LENGTH_LONG).show()

            //Snackbar internacionalizada
            Snackbar.make(view, getString(R.string.ma_snack_message), Snackbar.LENGTH_SHORT).show()

            //Snackbar internacionalizada - tempor maior de visualização
            Snackbar.make(view, getString(R.string.ma_long_snack_message), Snackbar.LENGTH_LONG).show()

            //Snackbar com ação
            Snackbar.make(view, getString(R.string.ma_action_title_snack_message), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.ma_action_snack_message), View.OnClickListener {
                    toast(getString(R.string.ma_answer_snack_message))
                }).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
