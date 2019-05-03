package thiagocury.eti.br.exsplashscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashScreen : AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 2000

    internal  val mRunnable = Runnable {
        if(!isFinishing){
            startActivity<MainActivity>()
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }

    override fun onDestroy() {
        super.onDestroy()

        if(mDelayHandler != null){
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
    }
}