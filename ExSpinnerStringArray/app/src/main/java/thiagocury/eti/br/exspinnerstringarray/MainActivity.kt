package thiagocury.eti.br.exspinnerstringarray

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_ok.setOnClickListener {
            if(sp_sexo.selectedItemPosition.toInt() != 0) {

                var usuario = Usuario()
                usuario.sexo = sp_sexo.selectedItem.toString()
                toast("$usuario")

                //Limpando a Spinner
                sp_sexo.setSelection(0)
            } else {
                toast("Escolha um sexo")
            }
        }
    }
}