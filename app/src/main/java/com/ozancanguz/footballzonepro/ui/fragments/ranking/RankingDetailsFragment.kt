package com.ozancanguz.footballzonepro.ui.fragments.ranking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.footballzonepro.databinding.FragmentRankingDetailsBinding

class RankingDetailsFragment : Fragment() {
    private var _binding: FragmentRankingDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:RankingDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRankingDetailsBinding.inflate(inflater, container, false)



        getRankingDetails()


        return binding.root

    }

    private fun getRankingDetails() {
        val currentRank=args.currentRank
        binding.rankdetailsteamtv.text="Team: "+currentRank.team
        binding.rankdetailspointtv.text="Point: "+currentRank.point.toString()
        binding.rankdetailsAvr.text="Average: " +currentRank.goaldistance.toString()
        binding.rankdetailslosetv.text="Lose: " +currentRank.lose.toString()
        binding.rankdetailsplayedmatchedTv.text="Played Match: " +currentRank.play.toString()
        binding.rankdetailswintv.text="Win: " +currentRank.win.toString()
        binding.rankdetailsranktv.text="Rank: " +currentRank.rank.toString()
    }


}