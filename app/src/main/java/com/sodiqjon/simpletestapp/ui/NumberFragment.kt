package com.sodiqjon.simpletestapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sodiqjon.simpletestapp.R
import com.sodiqjon.simpletestapp.databinding.FragmentNumberBinding

class NumberFragment : Fragment() {
    private var _binding: FragmentNumberBinding? = null
    private val binding get() = _binding!!
    var address = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        address = arguments?.getString("address").toString()


        binding.btnNext.setOnClickListener {

            if (binding.editTextNumber.text.isNullOrBlank()) {
                Toast.makeText(
                    requireContext(),
                    "Please enter valid number min 12",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                if (address.equals("checkIn")) {
                    findNavController().navigate(R.id.action_numberFragment_to_welcomeSuccessFragment)

                } else {
                    findNavController().navigate(R.id.action_numberFragment_to_resultFragment)
                    Toast.makeText(requireContext(), "Check Out Successfully", Toast.LENGTH_SHORT)
                        .show()

                }
            }
        }

    }

}