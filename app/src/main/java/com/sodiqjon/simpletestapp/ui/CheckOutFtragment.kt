package com.sodiqjon.simpletestapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.sodiqjon.simpletestapp.R
import com.sodiqjon.simpletestapp.databinding.FragmentCheckOutFtragmentBinding

class CheckOutFtragment : Fragment() {

    private var _binding: FragmentCheckOutFtragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckOutFtragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCard.setOnClickListener {
            findNavController().navigate(R.id.action_checkOutFtragment_to_cardFragment, bundleOf("address" to "checkOut"))
        }

        binding.btnNumber.setOnClickListener {
            findNavController().navigate(R.id.action_checkOutFtragment_to_numberFragment, bundleOf("address" to "checkOut"))
        }

    }


}