package br.unifor.ads.argbcalculator

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

/**
 * Created by Bruno Lopes on 27/02/2018.
 */
class SplashScreenActivity: AppCompatActivity() {

    private var mHandler:Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_activity)

        val updateUI: () -> Unit = {
            val it = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(it)
            finish()
        }

        mHandler.postDelayed(updateUI, 3000)

    }

}