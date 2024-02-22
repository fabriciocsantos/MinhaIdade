package br.com.fiap.minhaidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.minhaidade.ui.theme.MinhaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaIdadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MeuComponente()
                }
            }
        }
    }
}

@Composable
fun MeuComponente(){
    var idade = remember {
        mutableStateOf(0)
    }
    var maioridade = remember{
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Text(
            text = "Qual a sua idade?",
            color = Color.DarkGray,
            fontSize = 24.sp, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

        )
        Text(
            text = "Pressione os botões para informar a idade!",
            fontSize = 12.sp,
            color = Color(0xFF88c6a5),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "${idade.value}",
            fontSize = 48.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(30.dp))


        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Button(onClick = {
                    if( idade.value > 0){
                        idade.value--
                    }else{
                        idade.value
                    }
            }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF88c6a5)), modifier = Modifier.size(84.dp), shape = RectangleShape)
            {
                Text(
                    text = "-",
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,

                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                    if( idade.value < 100){
                        idade.value++
                    }else{
                        idade.value
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF88c6a5)), modifier = Modifier.size(84.dp), shape = RectangleShape) {
                Text(
                    text = "+",
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
                         if (idade.value >= 18){
                             maioridade.value = "Você é maior de idade"
                         }else{
                             maioridade.value = "Você é menor de idade"
                         }
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF88c6a5)), modifier = Modifier.width(130.dp), shape = RectangleShape) {
            Text(
                text = "Confirmar",
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text(
                text = maioridade.value,
                color = Color.DarkGray,
                fontSize = 24.sp, fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MeuComponentePreview(){
    MeuComponente()
}
