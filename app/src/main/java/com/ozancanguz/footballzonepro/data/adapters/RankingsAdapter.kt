package com.ozancanguz.footballzonepro.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.footballzonepro.R
import com.ozancanguz.footballzonepro.data.models.rankings.RankingResult
import com.ozancanguz.footballzonepro.data.models.rankings.Rankings
import com.ozancanguz.footballzonepro.databinding.RankingsRvRowLayoutBinding

class RankingsAdapter : RecyclerView.Adapter<RankingsAdapter.RankingsViewHolder>() {

    inner class RankingsViewHolder(private val binding: RankingsRvRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rank: RankingResult) {
            binding.ranktextview.text = rank.rank.toString()
            binding.teamtv.text = rank.team
            binding.pointtv.text = rank.point.toString()
        }
    }

    var rankingsList = emptyList<RankingResult>()

    fun setRankings(rankings: Rankings) {
        this.rankingsList = rankings.result
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RankingsRvRowLayoutBinding.inflate(inflater, parent, false)
        return RankingsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rankingsList.size
    }

    override fun onBindViewHolder(holder: RankingsViewHolder, position: Int) {
        val currentRank = rankingsList[position]
        holder.bind(currentRank)
    }
}
