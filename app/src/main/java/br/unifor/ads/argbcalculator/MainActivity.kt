package br.unifor.ads.argbcalculator

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener, View.OnKeyListener, View.OnClickListener {

    private lateinit var mColorView:View

    private lateinit var mSeekbarAlpha:SeekBar
    private lateinit var mSeekbarRed:SeekBar
    private lateinit var mSeekbarGreen:SeekBar
    private lateinit var mSeekbarBlue:SeekBar

    private lateinit var mEditTextAlpha: EditText
    private lateinit var mEditTextRed: EditText
    private lateinit var mEditTextGreen: EditText
    private lateinit var mEditTextBlue: EditText

    private lateinit var mTextViewValue: TextView

    private lateinit var mRadioButtonARGB: RadioButton
    private lateinit var mRadioButtonHex: RadioButton

    private var valueAlpha = ""
    private var valueRed = ""
    private var valueGreen = ""
    private var valueBlue = ""


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mColorView = findViewById(R.id.main_color_view)

        mSeekbarAlpha = findViewById(R.id.main_seekbar_alpha)
        mSeekbarRed = findViewById(R.id.main_seekbar_red)
        mSeekbarGreen = findViewById(R.id.main_seekbar_green)
        mSeekbarBlue = findViewById(R.id.main_seekbar_blue)

        mEditTextAlpha = findViewById(R.id.main_edittext_alpha)
        mEditTextRed = findViewById(R.id.main_edittext_red)
        mEditTextGreen = findViewById(R.id.main_edittext_green)
        mEditTextBlue = findViewById(R.id.main_edittext_blue)

        mTextViewValue = findViewById(R.id.textViewValue)

        mRadioButtonARGB = findViewById(R.id.radioButtonARGB)
        mRadioButtonHex = findViewById(R.id.radioButtonHex)

        configureWidgets()

    }

    private fun configureWidgets() {

        mColorView.setBackgroundColor(Color.BLACK)

        mSeekbarAlpha.max = 255
        mSeekbarAlpha.setOnSeekBarChangeListener(this)

        mSeekbarRed.max = 255
        mSeekbarRed.setOnSeekBarChangeListener(this)

        mSeekbarGreen.max = 255
        mSeekbarGreen.setOnSeekBarChangeListener(this)

        mSeekbarBlue.max = 255
        mSeekbarBlue.setOnSeekBarChangeListener(this)

        mEditTextAlpha.setText("0")
        mEditTextAlpha.setOnKeyListener(this)

        mEditTextRed.setText("0")
        mEditTextRed.setOnKeyListener(this)

        mEditTextGreen.setText("0")
        mEditTextGreen.setOnKeyListener(this)

        mEditTextBlue.setText("0")
        mEditTextBlue.setOnKeyListener(this)

        mTextViewValue.setText("0, 0, 0, 0")

        mRadioButtonARGB.isChecked = true
        mRadioButtonARGB.setOnClickListener(this)

        mRadioButtonHex.isChecked = false
        mRadioButtonHex.setOnClickListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {


        when(seekBar.id){

            R.id.main_seekbar_alpha -> {
                mEditTextAlpha.setText(seekBar.progress.toString())
                valueAlpha = seekBar.progress.toString()
            }

            R.id.main_seekbar_red -> {
                mEditTextRed.setText(seekBar.progress.toString())
                valueRed = seekBar.progress.toString()
            }

            R.id.main_seekbar_green -> {
                mEditTextGreen.setText(seekBar.progress.toString())
                valueGreen = seekBar.progress.toString()
            }

            R.id.main_seekbar_blue -> {
                mEditTextBlue.setText(seekBar.progress.toString())
                valueBlue = seekBar.progress.toString()
            }

        }

        updateColorView()
        updateTextView(valueAlpha, valueRed, valueGreen, valueBlue)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {

    }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {

        when(v.id){

            R.id.main_edittext_alpha ->{
                if(event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                    var value = mEditTextAlpha.text.toString().toInt()
                    if( value > 255) value = 255
                    mSeekbarAlpha.progress = value
                }
            }

            R.id.main_edittext_red ->{
                if(event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                    var value = mEditTextRed.text.toString().toInt()
                    if( value > 255) value = 255
                    mSeekbarRed.progress = value
                }
            }

            R.id.main_edittext_green ->{
                if(event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                    var value = mEditTextGreen.text.toString().toInt()
                    if( value > 255) value = 255
                    mSeekbarGreen.progress = value
                }
            }

            R.id.main_edittext_blue ->{
                if(event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                    var value = mEditTextBlue.text.toString().toInt()
                    if( value > 255) value = 255
                    mSeekbarBlue.progress = value
                }
            }

        }

        updateColorView()

        return false
    }

    override fun onClick(v: View) {

        when(v.id){

            R.id.radioButtonARGB -> {
                if (mRadioButtonARGB.isChecked){

                }
            }

        }

    }

    private fun updateColorView() {
        val color = Color.argb(mSeekbarAlpha.progress, mSeekbarRed.progress, mSeekbarGreen.progress, mSeekbarBlue.progress)
        mColorView.setBackgroundColor(color)
    }

    private fun updateTextView(valueAlpha: String, valueRed: String, valueGrenn: String, valueBlue: String){
        mTextViewValue.text = "$valueAlpha, $valueRed, $valueGrenn, $valueBlue"
    }

}
