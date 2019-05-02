package thiagocury.eti.br.exintentsegundatelaenviandostring

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela1.*
import org.jetbrains.anko.toast

class Tela1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela1)

//        Recebendo o valor digitado
        val msg = intent.getStringExtra("nome")
        t1_tv_msg.text = "Olá, ${msg}"

        toast(getString(R.string.t1_toast_msg))

    }
}
