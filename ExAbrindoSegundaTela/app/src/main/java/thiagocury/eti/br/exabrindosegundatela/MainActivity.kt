package thiagocury.eti.br.exabrindosegundatela

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

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

        ma_bt_abrir_tela_1.setOnClickListener {
            val intent = Intent(this, Tela1::class.java)
            startActivity(intent)

            /* alternativa -> chamar em apenas uma linha! */
//            startActivity<Tela1>()

//            Atenção:
//            Caso queira fechar essa activity, devemos utilizar o método finish()

        }
    }
}
