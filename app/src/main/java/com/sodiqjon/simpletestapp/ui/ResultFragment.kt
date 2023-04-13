package com.sodiqjon.simpletestapp.ui

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.orhanobut.hawk.Hawk
import com.sodiqjon.simpletestapp.R
import com.sodiqjon.simpletestapp.viewmodel.UserViewModel
import com.sodiqjon.simpletestapp.databinding.FragmentResultBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatterDay = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatterTime = DateTimeFormatter.ofPattern("HH:mm")
        val currentDay = LocalDateTime.now().format(formatterDay)
        val currenttime = LocalDateTime.now().format(formatterTime)

        viewModel.addUser(
            "170308",
            Hawk.get("chechInDate"),
            Hawk.get("chechInTime"),
            currenttime,
            currentDay,
            "1"
        )
        viewModel.getUser()

        viewModel.allUser.observe(requireActivity()) {
            Toast.makeText(requireContext(), "Your data is saved", Toast.LENGTH_SHORT).show()
            binding.checkOutDateText.text = it.last().dateOut
            binding.checkOutTimeText.text = it.last().timeOut
            binding.checkInDateText.text = it.last().dateIn
            binding.checkInTimeText.text = it.last().timeIn

        }

        binding.btnHome.setOnClickListener {
            Hawk.deleteAll()
            findNavController().navigate(R.id.action_resultFragment_to_signInFragment)
        }


    }


}