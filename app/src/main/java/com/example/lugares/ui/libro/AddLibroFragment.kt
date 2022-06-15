package com.example.lugares.ui.libro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lugares.R
import com.example.lugares.databinding.FragmentAddLibroBinding
import com.example.lugares.model.Libro
import com.example.lugares.viewmodel.LibroViewModel

class AddLibroFragment : Fragment() {

    private var _binding: FragmentAddLibroBinding? = null
    private val binding get() = _binding!!

    private lateinit var lugarViewModel: LibroViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddLibroBinding.inflate(inflater, container, false)

        lugarViewModel = ViewModelProvider(this).get(LibroViewModel::class.java)

        binding.agregar.setOnClickListener { insertarLibro() }

        return binding.root
    }

    private fun insertarLibro() {
        val nombre = binding.nombreLibro.text.toString()
        val escritor = binding.escritor.text.toString()
        val paginas = binding.paginas.text.toString()
        val estatus = binding.estatus.text.toString()

        if (validos(nombre,escritor,paginas,estatus)) {
            val libro = Libro(0,nombre, escritor, paginas, estatus)
            lugarViewModel.addLibro(libro)
            Toast.makeText(requireContext(), getString(R.string.msgLibroAgregado),Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), getString(R.string.msgFaltanDatos),Toast.LENGTH_LONG).show()
        }
    }

    private fun validos(nombre: String, escritor: String, paginas: String, estatus: String): Boolean {
        return !(nombre.isEmpty() || escritor.isEmpty() || paginas.isEmpty() || estatus.isEmpty())
    }

}