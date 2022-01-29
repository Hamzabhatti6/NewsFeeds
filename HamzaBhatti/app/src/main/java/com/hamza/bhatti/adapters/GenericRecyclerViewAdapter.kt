package com.hamza.bhatti.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.hamza.bhatti.wrappers.HomeNavigationWrapper
import java.util.ArrayList
import com.hamza.bhatti.BR
import com.hamza.bhatti.models.News

class GenericRecyclerViewAdapter<T>(private val context: Context, items: ArrayList<T>?, layoutId: Int,
                                    private var type:String
) : RecyclerView.Adapter<GenericRecyclerViewAdapter<T>.RecyclerViewHolder>() {
    private var listItems: ArrayList<T>? = ArrayList()
    private val layoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return RecyclerViewHolder(binding.root, context)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = listItems!![position]

        holder.binding!!.setVariable(BR.model, item)
        // holder.binding!!.setVariable(BR.type, type)
        holder.binding!!.executePendingBindings()
        holder.itemView.setOnClickListener {
            when (type) {
                "news" -> {
                    item as News
                    HomeNavigationWrapper.showNewsDetail(item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return if (listItems == null) {
            0
        } else listItems!!.size
    }

    inner class RecyclerViewHolder(view: View?, var c: Context) : RecyclerView.ViewHolder(view!!) {
        var binding: ViewDataBinding?

        init {
            binding = DataBindingUtil.bind(view!!)
            //  binding!!.setVariable(BR.handler, this)
        }
    }

    init {
        listItems = items
        this.layoutId = layoutId
    }
}