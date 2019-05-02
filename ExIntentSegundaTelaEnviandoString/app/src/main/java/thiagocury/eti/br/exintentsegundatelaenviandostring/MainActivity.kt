package thiagocury.eti.br.exintentsegundatelaenviandostring

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Site lib Anko: https://github.com/Kotlin/anko
//        Para utilizar a Anko precisamos:
//        Adicionar em buildscript nível do projeto
//        ext.anko_version = '0.10.8' //Não esquecer de verificar por versões mais atuais.
//        Utilizar o implementation a seguir:
//        implementation "org.jetbrains.anko:anko:$anko_version"

        ma_bt_ok.setOnClickListener {

            var nome = ma_et_nome.text.toString()

            if (nome.isNotEmpty()) {
                //Sem a utilização de ANKO.
                val intent = Intent(this, Tela1::class.java)
                intent.putExtra("nome", nome)
                startActivity(intent)

                //Com a utilização de ANKO.
                startActivity<Tela1>("nome" to nome)
            } else {
                ma_et_nome.setError(getString(R.string.ma_et_nome_erro))
                toast(getString(R.string.ma_et_nome_erro))
            }
        }

    }
}
