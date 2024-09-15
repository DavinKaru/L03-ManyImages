package au.edu.swin.sdmd.l03_manyimages

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var image: ImageView
    private lateinit var station: Button
    private lateinit var college: Button
    private lateinit var theatre: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageView)
        station = findViewById(R.id.station)
        college = findViewById(R.id.college)
        theatre = findViewById(R.id.theatre)
        station.backgroundTintList = null
        college.backgroundTintList = null
        theatre.backgroundTintList = null

        station.setOnClickListener {
            image.setImageDrawable(getDrawable(R.drawable.station))
            updateButtonState(station)
        }

        college.setOnClickListener {
            image.setImageDrawable(getDrawable(R.drawable.college))
            updateButtonState(college)
        }

        theatre.setOnClickListener {
            image.setImageDrawable(getDrawable(R.drawable.theatre))
            updateButtonState(theatre)
        }
    }

    private fun updateButtonState(selectedButton: Button) {
        val buttons = listOf(station, college, theatre)
        buttons.forEach { button ->
            if (button == selectedButton) {
                button.setBackgroundResource(R.drawable.button_background_selected)
            } else {
                button.setBackgroundResource(R.drawable.button_background)
            }
        }
    }
}