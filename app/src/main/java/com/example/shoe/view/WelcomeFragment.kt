package com.example.shoe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoe.R
import com.example.shoe.databinding.FragmentAuthBinding
import com.example.shoe.databinding.FragmentDetailBinding
import com.example.shoe.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    lateinit var binding : FragmentWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.setTitle("Welcome")
        binding = DataBindingUtil.inflate( inflater,R.layout.fragment_welcome, container, false)
        binding.btnWelcomeFragmentToInstructionsFragment.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }
        return  binding.root
    }
}