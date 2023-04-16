package com.ozancanguz.footballzonepro.ui.fragments.ranking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.api.Distribution.BucketOptions.Linear
import com.ozancanguz.footballzonepro.data.adapters.RankingsAdapter
import com.ozancanguz.footballzonepro.databinding.FragmentRankingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class RankingFragment : Fragment() {

    private var _binding: FragmentRankingBinding? = null

    private val binding get() = _binding!!


    // init ranking view model
    private val rankingViewModel:RankingViewModel by viewModels()

    // init ranking adapter
    private val rankingsAdapter=RankingsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRankingBinding.inflate(inflater, container, false)


        // setting up recycler view
        setupRv()

        // observe live data and update ui
        observeRankingsLiveData()


        return binding.root
    }

    private fun setupRv() {
        binding.rankingRv.layoutManager=LinearLayoutManager(requireContext())
        binding.rankingRv.adapter=rankingsAdapter
    }


    private fun observeRankingsLiveData(){
        binding.rankingprogressBar.visibility=View.VISIBLE
         rankingViewModel.getRankings()
        rankingViewModel.rankings.observe(viewLifecycleOwner, Observer {
            rankingsAdapter.setRankings(it)
            binding.rankingprogressBar.visibility=View.INVISIBLE

        })


    }

}