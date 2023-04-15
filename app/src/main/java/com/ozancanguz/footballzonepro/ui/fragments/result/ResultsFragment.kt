package com.ozancanguz.footballzonepro.ui.fragments.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.footballzonepro.R
import com.ozancanguz.footballzonepro.data.adapters.ResultAdapter
import com.ozancanguz.footballzonepro.databinding.FragmentResultsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null

    private val binding get() = _binding!!

    // init adapter
    private val resultAdapter=ResultAdapter()

    // init viewmodel
    private val resultViewModel:ResultViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        val view = binding.root

        // setting up recyclerview
        setupRv()

        // observe result live data
        observeResultLiveData()

        return view

    }

    private fun observeResultLiveData() {
        resultViewModel.getResults()
        resultViewModel.results.observe(viewLifecycleOwner, Observer {
            resultAdapter.setResults(it)
        })
    }

    private fun setupRv() {
        binding.resultRv.layoutManager=LinearLayoutManager(requireContext())
        binding.resultRv.adapter=resultAdapter
    }


}