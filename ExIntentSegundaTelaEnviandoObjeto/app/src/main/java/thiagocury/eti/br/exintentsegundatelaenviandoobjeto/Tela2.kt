package thiagocury.eti.br.exintentsegundatelaenviandoobjeto

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

        //Instanciando Objeto
        var u = Usuario()

        //Recuperando Objeto fazendo CAST
        u = intent.getSerializableExtra("usuario") as Usuario

        //Recebendo o valor digitado
        tvTexto.text = "Olá, "+u.login+"! A senha digitada foi: "+u.senha

        toast(resources.getText(R.string.toast_msg))
    }
}
