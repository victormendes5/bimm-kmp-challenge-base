package com.bimm.takehomeassignmnent.ui.theme

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimens {
    object Padding {
        /** Padding around screens */
        val Screen = 16.dp
        /** Small default padding */
        val Small = 8.dp
    }

    object Spacing {
        /** Vertical spacing between list items */
        val Item = 12.dp
    }

    object Image {
        /** Size for small list-item images */
        val ListItem = 72.dp
        /** Height for detail screen banner images */
        val DetailBanner = 220.dp
    }

    object Font {
        /** Generic body text font size */
        val Body = 14.sp
        /** Generic title font size */
        val Title = 20.sp
        /** List screen title font size */
        val ListTitle = 28.sp
        /** List screen subtitle font size */
        val ListSubtitle = 16.sp
        /** Detail screen description font size */
        val DetailDescription = 16.sp
    }

    object Component {
        /** Standard height for primary buttons */
        val ButtonHeight = 50.dp
    }
}
