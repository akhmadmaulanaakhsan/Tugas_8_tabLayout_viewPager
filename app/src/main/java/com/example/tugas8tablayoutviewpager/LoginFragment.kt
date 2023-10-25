package com.example.tugas8tablayoutviewpager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tugas8tablayoutviewpager.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnLogin.setOnClickListener {
            if (isLoginValid()) {
                // Lakukan tindakan login di sini
                // Jika login berhasil, beralih ke HomepageActivity
                val intent = Intent(requireActivity(), HomepageActivity::class.java)
                startActivity(intent)
                requireActivity().finish() // Jangan lupa untuk menutup MainActivity jika login berhasil
            }
        }

        // Tambahkan event click listener untuk kembali ke RegisterFragment
        binding.tvRegister.setOnClickListener {
            (requireActivity() as MainActivity).navigateToRegister()
        }

        return view
    }

    private fun isLoginValid(): Boolean {
        val usernameInput = binding.etUsername.text.toString()
        val passwordInput = binding.etPassword.text.toString()

        // Dapatkan data pengguna dari SharedPreferences
        val sharedPref = requireActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val savedUsername = sharedPref.getString("username", "")
        val savedPassword = sharedPref.getString("password", "")

        // Perform login validation
        return if (usernameInput == savedUsername && passwordInput == savedPassword) {
            true
        } else {
            Toast.makeText(requireContext(), "Invalid login credentials.", Toast.LENGTH_SHORT).show()
            false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


