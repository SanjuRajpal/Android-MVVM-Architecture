package com.sr.sample.ui.base


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sr.sample.BR


open class BindingAdapter<T>(
    private val layoutId: Int,
    private val br: Int = -1,
    private var list: List<T>? = null,
    private var clickListener: ((View, Int) -> Unit)? = null
) : RecyclerView.Adapter<BindingAdapter<T>.ViewHolder>() {

    override fun getItemCount() = list?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (br != -1) holder.binding.setVariable(br, list!![holder.adapterPosition])
        holder.binding.setVariable(
            BR.click,
            View.OnClickListener { v -> clickListener?.invoke(v!!, holder.adapterPosition) })
        holder.binding.executePendingBindings()
    }

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}