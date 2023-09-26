package ir.agaring.mylearncompose.book.screens.login


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ir.agaring.mylearncompose.R
import ir.agaring.mylearncompose.book.component.EmailInput
import ir.agaring.mylearncompose.book.component.PasswordInput
import ir.agaring.mylearncompose.book.component.ReaderLogo
import ir.agaring.mylearncompose.book.component.SubmitButton

/**
 * Created by m-latifi on 9/20/2023.
 */

@Composable
fun ReaderLoginScreen(
    navController: NavHostController) {

    val showLoginForm = rememberSaveable { mutableStateOf(true) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            ReaderLogo()
            if (showLoginForm.value)
                UserForm(
                    loading = false,
                    isCreateAccount = false
                ) { email, password ->
                    Log.d("meri", "ReaderLoginScreen : $email $password")
                }
            else
                UserForm(
                    loading = false,
                    isCreateAccount = true
                ) { email, password ->
                    //Todo : FB Login
                }

        }

        Spacer(modifier = Modifier.padding(15.dp))

        Row(
            modifier = Modifier.padding(15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val text = if (showLoginForm.value) "Sing up" else "Login"
            Text(text = "New User?")
            Text(text = text, modifier = Modifier
                .clickable {
                    showLoginForm.value = !showLoginForm.value
                }
                .padding(start = 5.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Green)
        }


    }

}


//-------------------------------------------------------------------------------------------------- UserForm
@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun UserForm(
    loading: Boolean = false,
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = { email, password -> }

) {
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }
    val passwordFocusRequest = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }

    val modifier = Modifier
        .height(250.dp)
        .background(MaterialTheme.colorScheme.background)
        .verticalScroll(rememberScrollState())

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isCreateAccount) Text(
            text = stringResource(id = R.string.create_acct),
            modifier = Modifier.padding(4.dp)
        )
        EmailInput(
            emailState = email,
            enable = !loading,
            onAction = KeyboardActions(
                onNext = { passwordFocusRequest.requestFocus() }
            )
        )


        PasswordInput(
            modifier = Modifier.focusRequester(passwordFocusRequest),
            passwordState = password,
            labelId = "Password",
            enable = !loading,
            passwordVisibility = passwordVisibility,
            onAction = KeyboardActions {
                if (!valid) return@KeyboardActions
                onDone(email.value.trim(), password.value.trim())
                keyboardController?.hide()
            }
        )


        SubmitButton(
            textId = if (isCreateAccount) "Create Account" else "Login",
            loading = loading,
            validInputs = valid
        ) {
            onDone(email.value.trim(), password.value.trim())
        }

    }


}
//-------------------------------------------------------------------------------------------------- UserForm

