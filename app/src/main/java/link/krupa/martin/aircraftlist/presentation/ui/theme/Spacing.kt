package link.krupa.martin.aircraftlist.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * This class extend Material Theme with spacing values
 */
data class Spacing(
    val default : Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }

//This might be a Android studio error, that it creates a warning for "Receiver parameter is never used"
@Suppress("unused")
val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current