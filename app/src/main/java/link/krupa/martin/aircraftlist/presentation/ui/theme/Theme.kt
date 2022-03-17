package link.krupa.martin.aircraftlist.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White

private val DarkColorPalette = darkColors(
    primary = LightBlue700,
    primaryVariant = LightBlue900,
    onPrimary = White,
    secondary = Green500,
    secondaryVariant = Green700,
    onSecondary = White
)

private val LightColorPalette = lightColors(
    primary = LightBlue200,
    primaryVariant = LightBlue500,
    onPrimary = Black,
    secondary = Green200,
    secondaryVariant = Green700,
    onSecondary = Black

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AircraftListTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalFontSize provides FontSize()
    )
    {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}