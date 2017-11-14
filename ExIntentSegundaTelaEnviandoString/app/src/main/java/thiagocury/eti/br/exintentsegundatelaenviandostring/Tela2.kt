package thiagocury.eti.br.exintentsegundatelaenviandostring

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.toast

class Tela2 : AppCompatActivity() {

    lateinit var tvTexto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        //Ref
        tvTexto = findViewById(R.id.tv_texto)

        //Recebendo o valor digitado
        tvTexto.text = "Olá, "+intent.getStringExtra("nome")

        toast(resources.getText(R.string.toast_msg))
    }
}
