package com.example.tugas8tablayoutviewpager

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment() {
    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var btnRegister: Button
    private lateinit var tvLogin: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        etUsername = view.findViewById(R.id.etUsername)
        etEmail = view.findViewById(R.id.etEmail)
        etPhone = view.findViewById(R.id.etPhone)
        etPassword = view.findViewById(R.id.etPassword)
        checkBox = view.findViewById(R.id.checkBox)
        btnRegister = view.findViewById(R.id.btnRegister)
        tvLogin = view.findViewById(R.id.tvLogin)

        btnRegister.setOnClickListener {
            if (validateInputs()) {
                saveUserData(
                    etUsername.text.toString(),
                    etEmail.text.toString(),
                    etPhone.text.toString(),
                    etPassword.text.toString()
                )
                // Lanjutkan ke fragment login
                (activity as MainActivity).navigateToLogin()
            }
        }

        // Tambahkan event click listener untuk beralih ke LoginFragment
        tvLogin.setOnClickListener {
            (activity as MainActivity).navigateToLogin()
        }

        return view
    }

    private fun validateInputs(): Boolean {
        val username = etUsername.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val isChecked = checkBox.isChecked

        if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || !isChecked) {
            // ... (kode validasi lainnya)
            return false
        }

        return true
    }

    private fun saveUserData(username: String, email: String, phone: String, password: String) {
        val sharedPref = requireActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString("email", email)
        editor.putString("phone", phone)
        editor.putString("password", password)
        editor.apply()
    }
}




