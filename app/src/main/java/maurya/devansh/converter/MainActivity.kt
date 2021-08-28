package maurya.devansh.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTemperature = findViewById<EditText>(R.id.etTemperature)
        val button = findViewById<Button>(R.id.button)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        button.setOnClickListener {
            val input = etTemperature.text.toString()
            val tempInF = input.toFloat() //convert input to decimal number
            val tempInC = fToC(tempInF)
            tvResult.text = tempInC.toString()
        }
    }

    //30°C × 9/5) + 32 = 86°F
    fun cToF(c: Float): Float {
        val tempInF = (c * 9/5) + 32
        return tempInF
    }

    //(30°F − 32) × 5/9 = -1.111°C
    fun fToC(f: Float): Float {
        val tempInC = (f - 32) * 5f/9
        return tempInC
    }
}