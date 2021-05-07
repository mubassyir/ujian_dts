package com.mubassyir.tokorotitetangga.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mubassyir.tokorotitetangga.UserLocation
import com.mubassyir.tokorotitetangga.UserLocation.Companion.EXTRA_LOCATION
import com.mubassyir.tokorotitetangga.database.model.Ordered
import com.mubassyir.tokorotitetangga.databinding.ListOrderedBinding


class OrderedAdapter: RecyclerView.Adapter<OrderedAdapter.OrderedHolder>() {

    private var orderedData = ArrayList<Ordered>()
    fun setData(i: List<Ordered>){
        if (i==null) return
        orderedData.clear()
        orderedData.addAll(i)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderedHolder {
        val view = ListOrderedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderedHolder(view)
    }

    override fun onBindViewHolder(holder: OrderedHolder, position: Int) {
        val ordered = orderedData[position]
        holder.bind(ordered)
    }

    override fun getItemCount(): Int {
        return orderedData.size
    }

    class OrderedHolder(private val binding : ListOrderedBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(orderedDataModel: Ordered){
            with(binding){
                Glide.with(itemView.context)
                    .load(orderedDataModel.image)
                    .into(ivBreadImage)
                tvBreadName.text = orderedDataModel.breadName
                tvCustomer.text = orderedDataModel.customer
                val price = "Rp.${orderedDataModel.price}"
                tvPrice.text = price
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context,UserLocation::class.java)
                    intent.putExtra(EXTRA_LOCATION,orderedDataModel)
                    root.context.startActivity(intent)
                }
            }
        }
    }
}