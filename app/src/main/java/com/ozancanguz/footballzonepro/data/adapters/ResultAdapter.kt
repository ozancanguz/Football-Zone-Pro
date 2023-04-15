package com.ozancanguz.footballzonepro.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.ozancanguz.footballzonepro.R
import com.ozancanguz.footballzonepro.data.results.Results
import com.ozancanguz.footballzonepro.databinding.ResultRvRowlayoutBinding

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    inner class ResultViewHolder(private val binding: ResultRvRowlayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(result: com.ozancanguz.footballzonepro.data.results.Result) {
            binding.hometeamtv.text = result.home
            binding.AwayTv.text = result.away
            binding.scoretv.text = result.skor
            binding.datetv.text = result.date
        }
    }

    private var resultList= emptyList<com.ozancanguz.footballzonepro.data.results.Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding = ResultRvRowlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val currentResult = resultList[position]
        holder.bind(currentResult)
    }

    fun setResults(results: Results) {
        resultList = results.result
        notifyDataSetChanged()
    }
}
