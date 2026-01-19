package com.example.myapplicationmvvm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationmvvm.R
import com.example.myapplicationmvvm.databinding.ActivityHomelayoutBinding
import com.example.myapplicationmvvm.domain.LoginViewModel
import com.example.myapplicationmvvm.ui.theme.MyApplicationMVVMTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityHomelayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inflate the binding
        binding = ActivityHomelayoutBinding.inflate(layoutInflater)

        // 2. Set the content view to the root of the binding
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.tvUsername.text.toString()
            val password = binding.tvUserPassword.text.toString()

            viewModel.login(username, password)

        }
      //  enableEdgeToEdge()
//        setContent {
//            MyApplicationMVVMTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Divya",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        color = Color.Red,
//        modifier = modifier
//
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationMVVMTheme {
//        Greeting("Android")
//    }
//}