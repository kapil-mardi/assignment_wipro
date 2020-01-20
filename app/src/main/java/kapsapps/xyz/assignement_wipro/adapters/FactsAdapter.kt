package kapsapps.xyz.assignement_wipro.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kapsapps.xyz.assignement_wipro.modal.BaseModal
import kapsapps.xyz.assignement_wipro.R
import kapsapps.xyz.assignement_wipro.di_utils.GlideApp
import kapsapps.xyz.assignement_wipro.modal.Row
import kotlinx.android.synthetic.main.facts_row.*

class FactsAdapter() : RecyclerView.Adapter<FactsAdapter.FactsRowHolder>(){


    var factsList : MutableList<Row> = mutableListOf()

    fun setData(factList : MutableList<Row>){
        if(this.factsList.size == 0){
            this.factsList = factList
            notifyDataSetChanged()
        }else {
            calculateDiff(this.factsList, factList)
        }
    }


    fun calculateDiff(oldData : MutableList<Row>, newData : MutableList<Row>){
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback(){

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldData[oldItemPosition] == newData[newItemPosition]

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldData[oldItemPosition] == newData[newItemPosition]

            override fun getNewListSize() = newData.size

            override fun getOldListSize() = oldData.size
        })

        diff.dispatchUpdatesTo(this)
    }

    class FactsRowHolder(val view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.title_holder)
        val description : TextView = view.findViewById(R.id.description_holder)
        val image : ImageView = view.findViewById(R.id.image_holder)
        fun bindData(row: Row){
            title.text = row.title ?: ""
            description.text = row.description ?: ""

            GlideApp
                .with(view.context)
                .load(row.imageHref ?: "")
                .placeholder(R.mipmap.ic_launcher)
                .into(image)
        }
    }


    override fun getItemCount(): Int {
        return factsList.size
    }

    override fun onBindViewHolder(holder: FactsRowHolder, position: Int) {
        holder.bindData(factsList[position])
    }

    override fun onCreateViewHolder(viewGroup : ViewGroup, position: Int): FactsRowHolder {
        return FactsRowHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.facts_row,viewGroup,false))
    }
}