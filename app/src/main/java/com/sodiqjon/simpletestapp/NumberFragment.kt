package com.sodiqjon.simpletestapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sodiqjon.simpletestapp.databinding.FragmentNumberBinding
import com.sodiqjon.simpletestapp.databinding.FragmentSignInBinding

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

        binding.btnNext.setOnClickListener {
            if (address.equals("checkIn")) {
                findNavController().navigate(R.id.action_numberFragment_to_welcomeSuccessFragment)

            } else {
                findNavController().navigate(R.id.action_numberFragment_to_resultFragment)
                Toast.makeText(requireContext(), "Check Out Successfully", Toast.LENGTH_SHORT)
                    .show()

            }
//            if (binding.editTextNumber.textSize < 12) {
//                Toast.makeText(
//                    requireContext(),
//                    "Please enter valid number\nMinimum number size 12",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else {
//                findNavController().navigate(R.id.action_numberFragment_to_welcomeSuccessFragment)
//            }
        }

    }

}