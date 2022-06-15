package com.example.lugares.ui.libro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lugares.R
import com.example.lugares.databinding.FragmentLibroBinding
import com.example.lugares.viewmodel.LibroViewModel

class LibroFragment : Fragment() {

    private lateinit var libroViewModel: LibroViewModel
    private var _binding: FragmentLibroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        libroViewModel = ViewModelProvider(this).get(LibroViewModel::class.java)
        _binding = FragmentLibroBinding.inflate(inflater, container, false)

        binding.addLibroFabButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_libro_to_addLibroFragment3)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}