package com.ozancanguz.footballzonepro.ui.fragments.goalking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.footballzonepro.data.adapters.GoalKingsAdapter
import com.ozancanguz.footballzonepro.databinding.FragmentGoalKingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoalKingFragment : Fragment() {
    private var _binding: FragmentGoalKingBinding? = null

    private val binding get() = _binding!!

    // init view model
    private val goalKingViewModel:GoalKingsViewModel by viewModels()

    // init adapter
    private val goalKingsAdapter=GoalKingsAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGoalKingBinding.inflate(inflater, container, false)


        // setting up rv
        setupRv()


        // observe live data and update ui
        observeGoalKingLiveData()



        return binding.root
    }

    private fun setupRv() {
        binding.goalKingRv.layoutManager=LinearLayoutManager(requireContext())
        binding.goalKingRv.adapter=goalKingsAdapter
    }

    private fun observeGoalKingLiveData(){
        binding.goalkingsPb.visibility=View.VISIBLE
        goalKingViewModel.getGoalKings()
        goalKingViewModel.goalKingsList.observe(viewLifecycleOwner, Observer {
            goalKingsAdapter.setGoalKingsData(it)
            binding.goalkingsPb.visibility=View.INVISIBLE

        })
    }


}