import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_6.Listener
import com.example.homework_6.Model.Note
import com.example.homework_6.R

class NoteViewHolder(itemView : View, val listener : Listener) : RecyclerView.ViewHolder(itemView)
{

    fun bind (note : Note){
        itemView.findViewById<TextView>(R.id.noteTextView).text = note.text
        itemView.findViewById<TextView>(R.id.noteLabelView).text = note.date.toString()
        itemView.findViewById<ImageView>(R.id.noteImageView).setImageResource(note.drawableRes)
        itemView.setOnClickListener { v -> listener.onNoteClick(note.id) }
    }
}