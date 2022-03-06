package uz.islamxpro.al_quran_translation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.islamxpro.al_quran_translation.adapter.RvAdapter
import uz.islamxpro.al_quran_translation.models.quranInfo.Chapter
import uz.islamxpro.al_quran_translation.models.quranInfo.QuranInfo
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val jsonFileString = getJsonDataFromAsset(applicationContext, "names.json")!!
        Log.i("data", jsonFileString)
        val gson = Gson()
        val lisType = object : TypeToken<QuranInfo>() {}.type
        val quranNames: QuranInfo = gson.fromJson(jsonFileString, lisType)

        findViewById<RecyclerView>(R.id.rv).adapter = RvAdapter(quranNames.chapters,object :RvAdapter.rv_click{
            override fun click(chapter: Chapter, position: Int) {
                val intent = Intent(this@MainActivity,SecondActivity::class.java)
                intent.putExtra("chapter",chapter)
                startActivity(intent)
            }
        })

    }
}

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}