package com.ozancanguz.footballzonepro.ui.fragments.result

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.footballzonepro.R
import com.ozancanguz.footballzonepro.databinding.FragmentResultDetailsBinding


class ResultDetailsFragment : Fragment() {
    private var _binding: FragmentResultDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:ResultDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentResultDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        // get details from result screen
        getResultDetails()



        return view

    }

    private fun getResultDetails() {
        binding.detailsScoretv.text=args.result.skor
        binding.detailsawaytv.text=args.result.away
        binding.detailshometv.text=args.result.home
        binding.detailsscreendatetv.text=args.result.date
    }


}