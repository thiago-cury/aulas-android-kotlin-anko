package thiagocury.eti.br.exsnackbar

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.2' //Não esquecer de verificar por versões mais atuais.
        //Utilizar os três compile a seguir para snack bar:
        //compile "org.jetbrains.anko:anko:$anko_version"
        //compile "org.jetbrains.anko:anko-commons:$anko_version"
        //compile "org.jetbrains.anko:anko-design:$anko_version"

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->

            //Snackbar não internacionalizada
            //snackbar(view, "Olá, mensagem via snack bar")

            //Snackbar internacionalizada
            //snackbar(view, resources.getString(R.string.snack_message))

            //Snackbar internacionalizada com duração maior. Snackbar.LENGTH_LONG
            //longSnackbar(view, resources.getString(R.string.long_snack_message))

            //Snackbar internacionalizada com ação ao clicar
            snackbar(view, resources.getString(R.string.action_title_snack_message), resources.getString(R.string.action_snack_message)) {
                toast(resources.getString(R.string.answer_snack_message))
            }
        }
    }
}
