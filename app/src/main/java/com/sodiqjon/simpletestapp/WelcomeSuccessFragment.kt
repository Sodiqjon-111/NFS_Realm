package com.sodiqjon.simpletestapp

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.orhanobut.hawk.Hawk
import com.sodiqjon.simpletestapp.databinding.FragmentSignInBinding
import com.sodiqjon.simpletestapp.databinding.FragmentWelcomeSuccessBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WelcomeSuccessFragment : Fragment() {
    private var _binding: FragmentWelcomeSuccessBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatterDay = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatterTime = DateTimeFormatter.ofPattern("HH:mm")
        val currentDay = LocalDateTime.now().format(formatterDay)
        val currentTime = LocalDateTime.now().format(formatterTime)

        Hawk.put("chechInTime", currentTime)
        Hawk.put("chechInDate", currentDay)


        binding.checkInDateText.text = currentDay
        binding.checkInTimeText.text = currentTime


        binding.btnCheckOut.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeSuccessFragment_to_checkOutFtragment)
        }

    }


}