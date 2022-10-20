package com.example.shoe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoe.R
import com.example.shoe.databinding.FragmentAuthBinding
import java.time.Duration

class AuthFragment : Fragment() {
    lateinit var binding : FragmentAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate( inflater,R.layout.fragment_auth, container, false)
        (requireActivity() as AppCompatActivity).supportActionBar?.setTitle(binding.buttonLogin.text)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.setOnClickListener{
            if (binding.editTextEmailAddress.text.isEmpty ().not() && binding.editTextPassword.text. isEmpty().not()){
                findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToWelcomeFragment())
            }
            else  if(binding.editTextPassword.text. isEmpty()&&binding.editTextEmailAddress.text.isEmpty()){
                Toast.makeText(context,"Password & Email Is Required",Toast.LENGTH_SHORT).show()
            }
            else if (binding.editTextPassword.text. isEmpty()) {
                Toast.makeText(context,"Password Is Required",Toast.LENGTH_SHORT).show()
            }
            else if (binding.editTextEmailAddress.text.isEmpty()) {
                Toast.makeText(context,"Email Is Required",Toast.LENGTH_SHORT).show()
            }
        }
    }

}