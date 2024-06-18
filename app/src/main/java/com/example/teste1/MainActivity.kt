package com.example.teste1

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teste1.ui.theme.Teste1Theme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Teste1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        var email by remember {
                            mutableStateOf(value = "")
                        }
                        var senha by remember {
                            mutableStateOf(value = "")
                        }
                        var passwordVisibility by remember {
                            mutableStateOf(value = false)
                        }
                        Text(
                            text = "Tela Login",
                            color = Color.Black,
                            fontSize = 24.sp
                        )
                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                        )
                        TextField(
                            label = { Text("Email") },
                            value = email,
                            onValueChange = { newEmail ->
                                email = newEmail
                            }
                        )
                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                        )
                        TextField(
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            label = { Text("Senha") },
                            value = senha,
                            onValueChange = { newSenha ->
                                senha = newSenha
                            },
                            trailingIcon = {
                                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                                    Icon(imageVector = Icons.Rounded.Lock, contentDescription = "")
                                }
                            }
                        )
                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                        )
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Entrar")
                        }
                    }
                }
            }
        }
    }
    fun logar(email: String, senha: String): Boolean{
        var senhaFacebook = "Ge123"
        var emailFacebook = "Ge123@gmail.com"
        return email == emailFacebook && senha == senhaFacebook
    }
    data class Turma(
        val alunos: List <Aluno>
    )
    data class Aluno(
        val nome: String
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Teste1Theme {

    }
}