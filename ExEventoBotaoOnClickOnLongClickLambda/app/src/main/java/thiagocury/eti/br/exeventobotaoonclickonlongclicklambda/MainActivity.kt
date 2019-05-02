package thiagocury.eti.br.exeventobotaoonclickonlongclicklambda

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Utilizando: kotlinx.android.synthetic
//        Dessa forma não precisamos criar um Widget no escopo global e também não precisamos buscar a referência
//        com o findViewById()


//        Normal, estilo Java
        ma_bt_ok.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                toast(getString(R.string.ma_toast_onclick))
            }
        })

        ma_bt_ok.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                toast(getString(R.string.ma_toast_onlongclick))
                return true
            }
        })

//        Abreviado
        ma_bt_ok.setOnClickListener(View.OnClickListener {
            toast(getString(R.string.ma_toast_onclick))
        })

        ma_bt_ok.setOnLongClickListener(View.OnLongClickListener {
            toast(getString(R.string.ma_toast_onlongclick))
            true
        })


//        Lambda
        ma_bt_ok.setOnClickListener { toast(getString(R.string.ma_toast_onclick)) }

        ma_bt_ok.setOnLongClickListener {
            toast(getString(R.string.ma_toast_onlongclick))
            true
        }

    }
}
