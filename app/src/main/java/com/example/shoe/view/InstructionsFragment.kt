package com.example.shoe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoe.R
import com.example.shoe.databinding.FragmentAuthBinding
import com.example.shoe.databinding.FragmentDetailBinding
import com.example.shoe.databinding.FragmentInstructionsBinding
import com.example.shoe.viewmodel.AppViewModel

class InstructionsFragment : Fragment() {
    lateinit var binding : FragmentInstructionsBinding
    private val viewModel: AppViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.setTitle("Instructions")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate( inflater,R.layout.fragment_instructions, container, false)
        viewModel.initialize()
        binding.btnInstructionsFragmentToListingFragment.setOnClickListener{
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToListingFragment2())
        }
        return  binding.root
    }
}