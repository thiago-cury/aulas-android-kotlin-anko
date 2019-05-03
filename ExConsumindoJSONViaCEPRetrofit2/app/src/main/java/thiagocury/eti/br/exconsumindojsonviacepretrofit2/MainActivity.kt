package thiagocury.eti.br.exconsumindojsonviacepretrofit2

import retrofit2.Callback
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ma_progress.visibility = View.INVISIBLE

        ma_bt_buscar_por_cep.setOnClickListener {

            if(ma_et_cep.text.toString().isEmpty()){
                ma_et_cep.setError("Digite um CEP válido!")
                return@setOnClickListener
            }

            ma_progress.visibility = View.VISIBLE

            val call = RetrofitInitializer().cepService().getEnderecoByCEP(ma_et_cep.text.toString())
            call.enqueue(object : Callback<CEP>{
                override fun onFailure(call: Call<CEP>, t: Throwable) {

                    toast("Erro: ${t?.message}")
                    ma_progress.visibility = View.INVISIBLE

                }

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {
                    response?.let {

                        val CEPs: CEP? = it.body()
                        toast("CEP: "+CEPs.toString())
                        ma_progress.visibility = View.INVISIBLE

                    }
                }
            })
        }

        ma_bt_buscar_por_rua_cidade_estado.setOnClickListener {

            if(ma_et_rua.text.toString().isEmpty()){
                ma_et_rua.setError("Digite uma rua válida!")
                return@setOnClickListener
            }

            if(ma_et_cidade.text.toString().isEmpty()){
                ma_et_cidade.setError("Digite uma cidade válida!")
                return@setOnClickListener
            }

            if(ma_sp_ufs.selectedItemPosition==0){
                toast("Escolha um estado válido!")
                return@setOnClickListener
            }

            ma_progress.visibility = View.VISIBLE

            val call = RetrofitInitializer().cepService().getCEPByCidadeEstadoEndereco(
                ma_sp_ufs.selectedItem as String,
                ma_et_cidade.text.toString(),
                ma_et_rua.text.toString()
            )

            call.enqueue(object : Callback<List<CEP>>{
                override fun onFailure(call: Call<List<CEP>>, t: Throwable) {
                    toast("Erro: ${t?.message}")
                    ma_progress.visibility = View.INVISIBLE
                }

                override fun onResponse(call: Call<List<CEP>>, response: Response<List<CEP>>) {
                    response?.let {

                        val CEPs: List<CEP>? = it.body()

                        toast("CEPs: "+CEPs.toString())
                        ma_progress.visibility = View.INVISIBLE

                    }
                }
            })

        }

    }
}