package link.krupa.martin.aircraftlist.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * This class extend Material Theme with fontSize values
 */
data class FontSize(
    val extraSmall: TextUnit = 10.sp,
    val small: TextUnit = 12.sp,
    val medium: TextUnit = 14.sp,
    val large: TextUnit = 16.sp,
    val extraLarge : TextUnit = 18.sp,
    val default : TextUnit = medium
)

val LocalFontSize = compositionLocalOf { FontSize() }

//This might be a Android studio error, that it creates a warning for "Receiver parameter is never used"
@Suppress("unused")
val MaterialTheme.fontSize: FontSize
    @Composable
    @ReadOnlyComposable
    get() = LocalFontSize.current