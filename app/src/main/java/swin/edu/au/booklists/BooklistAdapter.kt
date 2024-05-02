package swin.edu.au.booklists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class BooklistAdapter(): RecyclerView.Adapter<BooklistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooklistAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.book_layout, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = BookStore.count

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = BookStore.books.get(position)
        holder.bind(item)
    }

    inner class ViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        val image = v.findViewById<ImageView>(R.id.bookImg)
        val title = v.findViewById<TextView>(R.id.bookTitle)
        val rating = v.findViewById<RatingBar>(R.id.ratingBar)
        fun bind(item: Book) {
            title.text = item.title
            rating.rating = item.rating
            val imageRes = v.context.resources.getIdentifier("l${item.image}","drawable", v.context.packageName)
            image.setImageResource(imageRes)
        }
    }
}