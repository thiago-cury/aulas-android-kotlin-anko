package thiagocury.eti.br.exonclickonlongclickbotaolistener

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ma_bt_1.setOnClickListener(this)
        ma_bt_2.setOnClickListener(this)

        ma_bt_1.setOnLongClickListener(this)
        ma_bt_2.setOnLongClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ma_bt_1 -> { toast(R.string.ma_bt_1_onclick) }
            R.id.ma_bt_2 -> { toast(R.string.ma_bt_2_onclick) }
        }
    }

    override fun onLongClick(v: View?): Boolean {
        when(v?.id){
            R.id.ma_bt_1 -> { toast(R.string.ma_bt_1_onlongclick) }
            R.id.ma_bt_2 -> { toast(R.string.ma_bt_2_onlongclick) }
        }
        return true
    }
}
