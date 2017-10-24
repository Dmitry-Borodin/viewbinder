package com.krenvpravo.sampleappcompat

/**
 * @author Dmitry Borodin on 2017-10-22.
 */

data class ScreenItemModel(val title: String,
                           val onClick: () -> Unit)