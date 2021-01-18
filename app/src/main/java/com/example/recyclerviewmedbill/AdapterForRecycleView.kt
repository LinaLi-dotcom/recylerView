package com.example.recyclerviewmedbill

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterForRecycleView() : RecyclerView.Adapter<FancyViewHolder>() {

    var myList = mutableListOf<String>("A", "B", "C")
    var doneMarkning = mutableListOf<Boolean>(false, true, false)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FancyViewHolder {

        Log.d("RecyleView", "onCreatViewHolder")

        val vh = FancyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.my_layout_item, parent, false))
        return vh
    }

        override fun getItemCount(): Int {
            //Log.d("RecyleView", "getItemCount")
            return myList.size
        }

        override fun onBindViewHolder(holder: FancyViewHolder, position: Int) {

            Log.d("RecyleView", "onBindViewHolder")

            holder.theRowText.text = myList[position]
            holder.rowNumberText.text = position.toString()

            if(doneMarkning[position] ==  true)
            {
                holder.doneTextView.visibility = View.VISIBLE
            } else {
                holder.doneTextView.visibility = View.INVISIBLE
            }

            holder.itemView.setOnClickListener {
                Log.d("RecyleView", "Clicka på rad nummber " + position.toString())

                //myList.removeAt(position)

                if(doneMarkning[position] ==  true)
                {
                    doneMarkning[position] = false
                } else {
                    doneMarkning[position] = true
                }

                notifyDataSetChanged()
            }

        }
}

class FancyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var theRowText = view.findViewById<TextView>(R.id.theRowText)

    var rowNumberText = view.findViewById<TextView>(R.id.rowNumber)

    var doneTextView = view.findViewById<TextView>(R.id.doneTextView)

    }
