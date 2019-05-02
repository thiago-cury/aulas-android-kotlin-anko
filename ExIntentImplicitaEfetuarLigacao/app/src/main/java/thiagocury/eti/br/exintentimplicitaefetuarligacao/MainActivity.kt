package thiagocury.eti.br.exintentimplicitaefetuarligacao

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val CALL_PHONE_REQUEST_CODE : Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_ligar.setOnClickListener {

                //Se não possui permissão
                if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //Verifica se já mostramos o alerta e o usuário negou alguma vez.
                    if (ActivityCompat.shouldShowRequestPermissionRationale(
                            this@MainActivity,
                            Manifest.permission.CALL_PHONE)) {

                        //Caso o usuário tenha negado a permissão anteriormente e não tenha marcado o check "nunca mais mostre este alerta"
                        //Podemos mostrar um alerta explicando para o usuário porque a permissão é importante.
                        toast("Você já negou antes essa permissão! \" + \"Para efetuar uma ligação necessitamos dessa permissão!")

                        /* Além da mensagem indicando a necessidade sobre a permissão,
                           podemos solicitar novamente a permissão */
                        requestPermission()

                    } else {
                        //Solicita a permissão
                        requestPermission()
                    }

                } else {
                    makeCallPhone()
                }
            }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            CALL_PHONE_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    toast("Usuário negou a permissao!")
                } else {
                    toast("Usuário aceitou a permissao!")

                    makeCallPhone()

                }
            }
        }
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.CALL_PHONE), CALL_PHONE_REQUEST_CODE)
    }

    private fun makeCallPhone(){
        if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

            //Tudo OK, podemos prosseguir.
            val tel = et_numero.text.toString()
            val uri = Uri.parse("tel:$tel")
            val it = Intent(Intent.ACTION_CALL, uri)
            startActivity(it)

            //Com a lib Anko -> basta chamar o método makeCall
            //makeCall(tel)
        }
    }
}
