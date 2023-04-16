package com.ozancanguz.footballzonepro.data.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.footballzonepro.data.results.LatestResults
import com.ozancanguz.footballzonepro.databinding.ResultRvRowlayoutBinding
import com.ozancanguz.footballzonepro.ui.fragments.result.ResultsFragmentDirections

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {
    inner class ResultViewHolder(val binding: ResultRvRowlayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    var resultList = emptyList<com.ozancanguz.footballzonepro.data.results.Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding = ResultRvRowlayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ResultViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return resultList.size

    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val currentResult = resultList[position]
        holder.binding.hometeamtv.text = currentResult.home
        holder.binding.AwayTv.text = currentResult.away
        holder.binding.scoretv.text = currentResult.skor

        holder.itemView.setOnClickListener {
            val directions=ResultsFragmentDirections.actionResultsFragmentToResultDetailsFragment(currentResult)
            holder.itemView.findNavController().navigate(directions)
        }

    }

    fun setResults(results: LatestResults) {
        resultList = results.result
        notifyDataSetChanged() // add this line
    }

}
