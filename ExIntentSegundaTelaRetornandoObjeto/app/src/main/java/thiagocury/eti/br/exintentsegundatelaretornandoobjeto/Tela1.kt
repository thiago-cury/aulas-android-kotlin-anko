package thiagocury.eti.br.exintentsegundatelaretornandoobjeto

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela1.*

class Tela1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela1)

        t1_bt_ok.setOnClickListener {

            if(t1_et_nome.text.toString().isEmpty()){
                t1_et_nome.setError(getString(R.string.t1_et_nome_erro))
                return@setOnClickListener
            }

            if(t1_et_idade.text.toString().isEmpty()){
                t1_et_idade.setError(getString(R.string.t1_et_idade_erro))
                return@setOnClickListener
            }

            val nome = t1_et_nome.text.toString()
            val idade = t1_et_idade.text.toString().toInt()

            val p = Pessoa(nome, idade)

            val it = Intent()
            it.putExtra("pessoa", p)
            setResult(Activity.RESULT_OK, it)
            finish()
        }

        t1_bt_cancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
