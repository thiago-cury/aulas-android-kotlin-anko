package thiagocury.eti.br.explayer

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener, AnkoLogger {

    private lateinit var tvStartAudio: TextView
    private lateinit var tvFinishAudio: TextView
    private lateinit var btPlayAudio: Button
    private lateinit var btStopAudio: Button
    private lateinit var sbProgressAudio: SeekBar

    private lateinit var mp : MediaPlayer

    private lateinit var runnable:Runnable
    private var handler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        mp = MediaPlayer()
        val url = "https://contactto-asterisk-production.s3.amazonaws.com/2018/10/11/3456-51996365376-20181011112704-1539268024.wav?AWSAccessKeyId=AKIAIS3QUBNTGS652F4Q&Expires=1539558418&Signature=5hxQSVT4VKjSoiUDg883qPWUSyM%3D"
        mp.setDataSource(url)
        mp.setOnPreparedListener(this@MainActivity)
        mp.prepareAsync()

        sbProgressAudio.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser && mp != null) {
                    mp.seekTo(progress * 1000)
                }
            }
        })

        btPlayAudio.onClick {
            mp.start()
            btPlayAudio.isEnabled = false

            statusProgress()

            mp.setOnCompletionListener {
                btPlayAudio.isEnabled = true
            }
        }

        btStopAudio.onClick {
            if(mp.isPlaying){
                mp.pause()
                btPlayAudio.isEnabled = true
            }
        }
    }

    override fun onPrepared(p0: MediaPlayer?) {
        mp.start()

        statusProgress()

        var min : String = ((mp.duration/1000)/60).toString()
        var sec : String = ((mp.duration/1000)%60).toString()
        tvFinishAudio.text = "${min}:${sec}"
    }

    private fun statusProgress(){
        sbProgressAudio.max = mp.duration/1000

        runnable = Runnable {
            sbProgressAudio.progress = mp.currentPosition/1000
            var min : String = ((mp.currentPosition/1000)/60).toString()
            var sec : String = ((mp.currentPosition/1000)%60).toString()
            tvStartAudio.text = "${min}:${sec}"

            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }

    private fun initialize(){
        tvStartAudio = findViewById(R.id.ma_tv_start_audio)
        tvFinishAudio = findViewById(R.id.ma_tv_finish_audio)
        btPlayAudio = findViewById(R.id.ma_bt_play_audio)
        btStopAudio = findViewById(R.id.ma_bt_stop_audio)
        sbProgressAudio = findViewById(R.id.ma_sb_progress_audio)
    }
}
