package thiagocury.eti.br.exfragmenttrocandoinformacoes


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_frag1.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Frag1 : Fragment() {

    private lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_frag1, container, false)

        v.bt_ok.setOnClickListener {

            var nome: String = v.et_nome.text.toString()

            var data: Bundle = Bundle()
            data.putString("nome",nome)

            val fgm : FragmentManager = activity!!.supportFragmentManager
            val ft : FragmentTransaction = fgm.beginTransaction()

            val frag2 : Frag2 = Frag2()
            frag2.setArguments(data)
            ft.replace(R.id.frame2, frag2)
            ft.commit()

        }

        return v
    }

}