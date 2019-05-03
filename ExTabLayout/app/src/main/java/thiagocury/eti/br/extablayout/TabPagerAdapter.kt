package thiagocury.eti.br.extablayout

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> return Frag1()
            1 -> return Frag2()
            2 -> return Frag3()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}