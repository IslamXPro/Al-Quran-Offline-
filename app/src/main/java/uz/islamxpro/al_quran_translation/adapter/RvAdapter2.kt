package uz.islamxpro.al_quran_translation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.islamxpro.al_quran_translation.databinding.ItemRv2Binding
import uz.islamxpro.al_quran_translation.models.quran.QuranX

class RvAdapter2(private val list: List<QuranX>, private val list2:List<QuranX>, val rvClick: rv_click) :
    RecyclerView.Adapter<RvAdapter2.Vh>() {
    inner class Vh(var itemRv: ItemRv2Binding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(chapter: QuranX, position: Int) {
            itemRv.text.text = chapter.text
            itemRv.textOriginal.text = "${convertToArabic(position+1)}.  ${list2[position].text}"

            itemRv.root.setOnClickListener {
                rvClick.click(chapter, position)
            }
        }
    }

    fun convertToArabic(value: Int): String {
        return (value.toString() + "")
            .replace("1".toRegex(), "١").replace("2".toRegex(), "٢")
            .replace("3".toRegex(), "٣").replace("4".toRegex(), "٤")
            .replace("5".toRegex(), "٥").replace("6".toRegex(), "٦")
            .replace("7".toRegex(), "٧").replace("8".toRegex(), "٨")
            .replace("9".toRegex(), "٩").replace("0".toRegex(), "٠")
    }

    interface rv_click {
        fun click(chapter: QuranX, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRv2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}