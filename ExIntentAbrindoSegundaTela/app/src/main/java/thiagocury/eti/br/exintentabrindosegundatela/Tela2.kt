package thiagocury.eti.br.exintentabrindosegundatela

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.toast

class Tela2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        toast(resources.getText(R.string.toast_msg))
    }
}
