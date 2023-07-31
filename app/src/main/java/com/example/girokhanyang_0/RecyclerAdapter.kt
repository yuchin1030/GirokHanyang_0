package com.example.girokhanyang_0

/*import DiaryEntry
import SqliteHelper
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    var helper : SqliteHelper? = null
    val listData = mutableListOf<DiaryEntry>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerView, parent, false)
        return Holder(view)
    }

    override fun getItemCount() : Int {
        return listData.size
    }

    override fun onBindViewHolder(holder : Holder, position : Int) {
        val diaryEntry = listData[position]
        holder.setDiaryEntry(diaryEntry)

        holder.itemView.setOnClickListner {
            val intent = Intent(holder.itemView?.context, UploadActivity::class.java)
            intent.putExtra("dImage", listData.get(position).imageUri)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var mDiaryEntry : DiaryEntry? = null

        fun setDiaryEntry(diaryEntry: DiaryEntry) {
            if (diaryEntry.imageUri != null) {
                itemView.itemImage.setImageBitmap(BitmapFactory.decodeByteArray(diaryEntry.imageUri, 0, diaryEntry.imageUri!!.size))
            }

            this.mDiaryEntry = diaryEntry
        }
    }
}*/