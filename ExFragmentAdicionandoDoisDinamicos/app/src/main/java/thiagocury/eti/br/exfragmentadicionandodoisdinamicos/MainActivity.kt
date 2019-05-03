package thiagocury.eti.br.exfragmentadicionandodoisdinamicos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fgm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fgm.beginTransaction()

        val frag1: Frag1 = Frag1()
        val frag2: Frag2 = Frag2()

        ft.add(R.id.frame1, frag1)
        ft.add(R.id.frame2, frag2)

        ft.commit()

    }
}