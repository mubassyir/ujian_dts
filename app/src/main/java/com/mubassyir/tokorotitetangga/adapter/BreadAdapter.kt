package com.mubassyir.tokorotitetangga.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mubassyir.tokorotitetangga.DetailBreadActivity
import com.mubassyir.tokorotitetangga.DetailBreadActivity.Companion.EXTRA_BREAD
import com.mubassyir.tokorotitetangga.databinding.ListLayoutBinding
import com.mubassyir.tokorotitetangga.model.BreadDataModel


class BreadAdapter: RecyclerView.Adapter<BreadAdapter.BakeHolder>() {

    private var breadData = ArrayList<BreadDataModel>()

    fun setData (i : List<BreadDataModel>?){
        if(i == null) return
        this.breadData.clear()
        this.breadData.addAll(i)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BakeHolder {
        val view = ListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BakeHolder(view)
    }

    override fun onBindViewHolder(holder: BakeHolder, position: Int) {
        val bread = breadData[position]
        holder.bind(bread)
    }

    override fun getItemCount(): Int {
        return  breadData.size
    }

    class BakeHolder(private val binding :ListLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(breadDataModel:BreadDataModel){
            with(binding){
                tvBreadName.text = breadDataModel.bakeName
                val price = "Rp.${breadDataModel.price}"
                tvPrice.text = price
                Glide.with(root.context)
                    .load(breadDataModel.image)
                    .into(ivBreadImage)

                itemView.setOnClickListener{
                    val intent = Intent(root.context,DetailBreadActivity::class.java)
                    intent.putExtra(EXTRA_BREAD,breadDataModel)
                    root.context.startActivity(intent)
                }
            }

        }
    }

}