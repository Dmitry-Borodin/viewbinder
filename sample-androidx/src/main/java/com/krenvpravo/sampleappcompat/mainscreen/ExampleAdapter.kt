package com.krenvpravo.sampleappcompat.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.krenvpravo.sampleappcompat.R
import com.krenvpravo.sampleappcompat.ScreenItemModel
import com.viewbinder.androidx.bindView

/**
 * @author Dmitry Borodin on 2018-12-02.
 */

class ExampleAdapter : RecyclerView.Adapter<ButtonViewHolder>() {

    var screenItems: List<ScreenItemModel> = emptyList()

    override fun getItemCount(): Int = screenItems.size

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        holder.bind(screenItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val rootView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_example, parent, false)
        return ButtonViewHolder(rootView)
    }
}

class ButtonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val button by bindView<Button>(R.id.item_example_button)

    internal fun bind(screenItemModel: ScreenItemModel) {
        button.text = screenItemModel.title
        button.setOnClickListener { screenItemModel.onClick() }
    }
}

