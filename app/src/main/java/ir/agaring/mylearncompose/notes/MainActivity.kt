package ir.agaring.mylearncompose.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import ir.agaring.mylearncompose.notes.screen.NoteScreen
import ir.agaring.mylearncompose.notes.screen.NoteViewModel
import ir.agaring.mylearncompose.ui.theme.MyLearnComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteViewModel: NoteViewModel by viewModels()
            MyApp(noteViewModel = noteViewModel)
        }
    }
}




//--------------------------------------------------------------------------------------------------
@Composable
fun MyApp(noteViewModel: NoteViewModel) {
    val noteList = noteViewModel.noteList.collectAsState().value
    MyLearnComposeTheme {
        NoteScreen(
            notes = noteList,
            onAddNote = { noteViewModel.addNote(it) },
            onRemoveNote = { noteViewModel.removeNote(it) }
        )
    }
}
//--------------------------------------------------------------------------------------------------
