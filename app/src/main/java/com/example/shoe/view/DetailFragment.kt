package com.example.shoe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.shoe.R
import com.example.shoe.databinding.FragmentAuthBinding
import com.example.shoe.databinding.FragmentDetailBinding
import com.example.shoe.model.Shoe
import com.example.shoe.viewmodel.AppViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: AppViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)

        binding.saveButton.setOnClickListener{
            val name =  binding. nameBox.text.toString()
            var size :Double ?= binding.sizeBox.text.toString().toDouble()
            var company = binding. companyBox.text.toString()
            var description = binding. descriptionBox.text.toString()
            viewModel.createNewShoe(Shoe(
                name, size,company,description
            ))
            val action=DetailFragmentDirections.actionCreateShoeFragmentToShoeListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.cancelButton.setOnClickListener{
            binding.nameBox.text.clear()
            binding.sizeBox.text.clear()
            binding.companyBox.text.clear()
            binding.descriptionBox.text.clear()
            val action= DetailFragmentDirections.actionCreateShoeFragmentToShoeListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }

}