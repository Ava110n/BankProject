import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var client = Client()

    var text by remember { mutableStateOf("") }

    Column{
        Row{
            Text("Логин:")
            TextField(value = login, onValueChange = {login = it})
        }
        Row{
            Text("Пароль:")
            TextField(value = password, onValueChange = {password = it}, visualTransformation = PasswordVisualTransformation())
        }
        Row{
            Button(onClick = {
                client.start()
                client.send("hello")
                text = client.get()!!
                client.finish()
            }) {Text("Войти")}
            Button(onClick = {}) {Text("Регистрация")}
        }
        Row {
            Text(text)
            println(text)
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
