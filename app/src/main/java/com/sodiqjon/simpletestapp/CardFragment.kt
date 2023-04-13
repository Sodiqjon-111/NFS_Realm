package com.sodiqjon.simpletestapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sodiqjon.simpletestapp.databinding.FragmentCardBinding
import com.sodiqjon.simpletestapp.databinding.FragmentSignInBinding
import uz.fozilbekimomov.nfcreader.SimpleCardReader
import uz.fozilbekimomov.nfcreader.model.EmvCard

class CardFragment : Fragment(),
    SimpleCardReader.SimpleCardReaderCallback,
    NfcAdapter.ReaderCallback {
    private var _binding: FragmentCardBinding? = null
    private val binding get() = _binding!!
    private var nfcAdapter: NfcAdapter? = null
    var address = ""
//    val mLottieAnimationView: LottieAnimationView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        address = arguments?.getString("address").toString()


        initNFC()
        if (requestNFC()) {
            startNFC()
        }
    }

    private fun startNFC() {
        nfcAdapter?.enableReaderMode(
            requireActivity(), this,
            NfcAdapter.FLAG_READER_NFC_A or
                    NfcAdapter.FLAG_READER_NFC_B or
                    NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK,
            null
        )
    }

    private fun initNFC() {
        nfcAdapter = NfcAdapter.getDefaultAdapter(requireContext())
    }

    override fun cardIsReadyToRead(card: EmvCard) {
        sendData("${card.cardNumber}", "${card.expireDateMonth}/${card.expireDateYear}")
    }

    private fun sendData(number: String, date: String) {

        binding.cardNumber.text = "$number\n$date"
        binding.btnNext.visibility = View.VISIBLE
        binding.btnNext.setOnClickListener {
            if (address.equals("checkIn")) {
                findNavController().navigate(R.id.action_cardFragment_to_welcomeSuccessFragment)

            } else {
                findNavController().navigate(R.id.action_cardFragment_to_resultFragment)
                Toast.makeText(requireContext(), "Check Out Successfully", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun cardMovedTooFastOrLockedNfc() {
        Toast.makeText(requireContext(), "Tap again", Toast.LENGTH_LONG).show()
    }

    override fun errorReadingOrUnsupportedCard() {
        Toast.makeText(requireContext(), "Error / Unsupported", Toast.LENGTH_LONG).show()
    }

    override fun onTagDiscovered(tag: Tag?) {
        SimpleCardReader.readCard(tag, this)
    }

    private fun requestNFC(): Boolean {
        if (nfcAdapter == null) {
            Toast.makeText(requireContext(), "No NFC on this device", Toast.LENGTH_LONG).show()
            return false
        } else if (nfcAdapter?.isEnabled == false) {

            // NFC is available for device but not enabled
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                try {
                    startActivityForResult(Intent(Settings.Panel.ACTION_NFC), 2265)
                } catch (ignored: ActivityNotFoundException) {
                }

            } else {
                try {
                    startActivity(Intent(Settings.ACTION_NFC_SETTINGS))
                } catch (ignored: ActivityNotFoundException) {
                }
            }
            return false
        }
        return true
    }
}