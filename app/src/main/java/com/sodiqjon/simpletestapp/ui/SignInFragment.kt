package com.sodiqjon.simpletestapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.sodiqjon.simpletestapp.R
import com.sodiqjon.simpletestapp.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.button.setOnClickListener {
//            viewModel.addUser("ss","ss","ss","ss","ss","ss")
//        }
//
//        viewModel.allUser.observe(requireActivity()){
//            Toast.makeText(requireContext(), "${it.size}", Toast.LENGTH_SHORT).show()
//            binding.bir.text=it[0].locationId
//            binding.ikki.text=it[0].customerId
//            binding.uch.text=it[0].dateOut
//        }
//
//        binding.buttonGer.setOnClickListener {
//            viewModel.getUser()
//        }

        binding.btnCard.setOnClickListener {
            findNavController().navigate(
                R.id.action_signInFragment_to_cardFragment,
                bundleOf("address" to "checkIn")
            )
        }

        binding.btnNumber.setOnClickListener {
            findNavController().navigate(
                R.id.action_signInFragment_to_numberFragment,
                bundleOf("address" to "checkIn")
            )
        }

    }

}