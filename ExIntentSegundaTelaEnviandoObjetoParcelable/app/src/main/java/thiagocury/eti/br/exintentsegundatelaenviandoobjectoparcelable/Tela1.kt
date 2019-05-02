package thiagocury.eti.br.exintentsegundatelaenviandoobjectoparcelable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela1.*
import org.jetbrains.anko.toast

class Tela1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela1)

        //Recuperando Objeto fazendo CAST com a palavra "as" para a classe Pessoa
        var p = intent.getParcelableExtra("pessoa") as Pessoa

        //Recebendo o valor digitado
        t1_tv_msg.text = "Olá, ${p.toString()}"

        toast(resources.getText(R.string.t1_toast_msg))
    }
}
