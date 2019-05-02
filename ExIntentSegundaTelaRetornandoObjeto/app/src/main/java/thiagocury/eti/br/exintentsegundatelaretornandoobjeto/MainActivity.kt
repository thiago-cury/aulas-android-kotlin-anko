package thiagocury.eti.br.exintentsegundatelaretornandoobjeto

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE_T1: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ma_bt_digitar_dados.setOnClickListener {
            startActivityForResult(Intent(this@MainActivity, Tela1::class.java), REQUEST_CODE_T1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            REQUEST_CODE_T1 -> {

                when(resultCode) {
                    Activity.RESULT_OK -> {
                        data?.let {
                            val p = it.getSerializableExtra("pessoa") as Pessoa
                            ma_tv_dados_recebidos.text = p.toString()
                        }
                    }

                    Activity.RESULT_CANCELED -> {
                        toast(getString(R.string.ma_dados_nao_informados_erro))
                    }

                    else -> {
                        toast(getString(R.string.ma_opcao_invalida_erro))
                    }
                }
            }
        }
    }
}