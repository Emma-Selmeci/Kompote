package kompote.ui.mainmenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kompote.ui.theme.KompoteTheme

@Composable
fun MainMenu(content: List<MainMenuItem>, onAction: (MainMenuAction) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.systemBarsPadding()
    ) {
        innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(content) {
                    item -> MainMenuTile(
                item,
                {onAction(item.onClickAction)}
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainMenuPreview() {
    KompoteTheme {
        MainMenu(
            getMainMenuItems(),
            {}
        )
    }
}