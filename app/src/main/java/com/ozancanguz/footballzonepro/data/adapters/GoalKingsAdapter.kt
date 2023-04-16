package com.ozancanguz.footballzonepro.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.footballzonepro.R
import com.ozancanguz.footballzonepro.data.models.goalkings.GoalKings
import com.ozancanguz.footballzonepro.data.models.goalkings.GoalKingsResult
import com.ozancanguz.footballzonepro.databinding.GoalrankingsRvRowLayoutBinding

class GoalKingsAdapter : RecyclerView.Adapter<GoalKingsAdapter.GoalKingsViewHolder>() {

    inner class GoalKingsViewHolder(private val binding: GoalrankingsRvRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(goalKing: GoalKingsResult) {
            binding.goalkingnameTv.text = goalKing.name
            binding.goalamountTv.text = goalKing.goals
        }
    }

    private var goalKingsList = emptyList<GoalKingsResult>()

    fun setGoalKingsData(goalKings: GoalKings) {
        goalKingsList = goalKings.result
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalKingsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GoalrankingsRvRowLayoutBinding.inflate(inflater, parent, false)
        return GoalKingsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return goalKingsList.size
    }

    override fun onBindViewHolder(holder: GoalKingsViewHolder, position: Int) {
        val currentGoalKing = goalKingsList[position]
        holder.bind(currentGoalKing)
    }
}
