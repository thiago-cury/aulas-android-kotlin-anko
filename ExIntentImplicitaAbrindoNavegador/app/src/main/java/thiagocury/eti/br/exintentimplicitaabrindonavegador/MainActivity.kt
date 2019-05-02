package thiagocury.eti.br.exintentimplicitaabrindonavegador

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ma_bt_navegador.setOnClickListener {

            if(ma_et_url.text.toString().isEmpty()){
                ma_et_url.setError(getString(R.string.ma_et_url_erro))
                return@setOnClickListener
            }

            val URL = ma_et_url.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://$URL"))
            startActivity(intent)

        }

    }
}
