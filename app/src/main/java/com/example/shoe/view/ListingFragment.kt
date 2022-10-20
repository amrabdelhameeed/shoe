package com.example.shoe.view

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoe.R
import com.example.shoe.databinding.FragmentAuthBinding
import com.example.shoe.databinding.FragmentDetailBinding
import com.example.shoe.databinding.FragmentListingBinding
import com.example.shoe.viewmodel.AppViewModel
class ListingFragment : Fragment() {
    private val viewModel: AppViewModel by activityViewModels()
    lateinit var binding : FragmentListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fun seperator ():View{
            val seperator = View(this.context,)
            seperator.minimumHeight = 30
            return  seperator
        }
        fun makeTextView ( name:String) :TextView{
            var myTextView = TextView(this. context)
            myTextView.setText(name)
            return myTextView
        }
        fun makeLinearLayout ( nameTextView:TextView,companyTextView:TextView,sizeTextView:TextView,descriptionTextView:TextView):LinearLayout{
            val myLinearLayout = LinearLayout(this. context)
            myLinearLayout.orientation = LinearLayout.VERTICAL;
            myLinearLayout.setBackgroundColor(Color.GREEN)
            myLinearLayout.addView(nameTextView)
            myLinearLayout.addView(sizeTextView)
            myLinearLayout.addView(companyTextView)
            myLinearLayout.addView(descriptionTextView)
            return  myLinearLayout
        }
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)
        setHasOptionsMenu(true)
        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5)
        viewModel.shoesGetter().observe(viewLifecycleOwner, Observer {
            for (item in it!!.listIterator()) {
                binding.list.addView(makeLinearLayout(makeTextView(item.name!!),makeTextView(item.company!!),makeTextView(item.description!!),makeTextView(item.size.toString())))
                binding.list.addView(seperator())
            }
        })
        binding.createShoeButton.setOnClickListener{
            val action= ListingFragmentDirections.actionListingFragmentToDetailFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        findNavController().navigate(R.id.authFragment)
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())||super.onOptionsItemSelected(item)
    }
}
