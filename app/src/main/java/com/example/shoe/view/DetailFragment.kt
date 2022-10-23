package com.example.shoe.view
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.shoe.R
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
        binding.lifecycleOwner =viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener{
                viewModel.createNewShoe()
            val action=DetailFragmentDirections.actionCreateShoeFragmentToShoeListFragment()
            NavHostFragment.findNavController(this).navigate(action)
            viewModel.deleteShoeOnCancel()
        }
        binding.cancelButton.setOnClickListener{
            viewModel.deleteShoeOnCancel()
            val action= DetailFragmentDirections.actionCreateShoeFragmentToShoeListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

}