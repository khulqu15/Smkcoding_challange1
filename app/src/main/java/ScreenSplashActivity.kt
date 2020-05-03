import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.biodata_app.R

class ScreenSplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long=3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

}