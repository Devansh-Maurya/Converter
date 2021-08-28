package maurya.devansh.converter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import com.mukesh.OtpView

class LoginPinActivity : AppCompatActivity() {

    companion object {
        const val IS_CORRECT_PIN_ENTERED = "is_correct_pin_entered"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_pin)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val isPinCorrect = pref.getBoolean(IS_CORRECT_PIN_ENTERED, false)

        if (isPinCorrect) {
            //open converter screen
            openConverterScreen()
        }
        //else show option to enter PIN


        val pinView = findViewById<OtpView>(R.id.pinView)
        pinView.setOtpCompletionListener { pin ->
            if (pin == "1234") {
                //show toast message
                Toast.makeText(this, "Correct PIN", Toast.LENGTH_SHORT).show()

                //store that user entered correct PIN
                val pref = getPreferences(Context.MODE_PRIVATE)
                pref.edit {
                    putBoolean(IS_CORRECT_PIN_ENTERED, true)
                }

                //open converter screen
                openConverterScreen()
            } else {
                Toast.makeText(this, "Enter correct PIN", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun openConverterScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        //close this screen
        finish()
    }
}