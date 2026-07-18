package com.abacatogames.view

import kotlinx.css.Align
import kotlinx.css.Border
import kotlinx.css.BorderStyle
import kotlinx.css.BoxSizing
import kotlinx.css.Color
import kotlinx.css.CssBuilder
import kotlinx.css.Cursor
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.FlexWrap
import kotlinx.css.FontStyle
import kotlinx.css.FontWeight
import kotlinx.css.JustifyContent
import kotlinx.css.LinearDimension
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.TextAlign
import kotlinx.css.TextTransform
import kotlinx.css.alignItems
import kotlinx.css.animationDelay
import kotlinx.css.animationDuration
import kotlinx.css.animationFillMode
import kotlinx.css.animationName
import kotlinx.css.animationTimingFunction
import kotlinx.css.backgroundColor
import kotlinx.css.backgroundImage
import kotlinx.css.border
import kotlinx.css.borderRadius
import kotlinx.css.boxShadow
import kotlinx.css.boxSizing
import kotlinx.css.caretColor
import kotlinx.css.color
import kotlinx.css.cursor
import kotlinx.css.display
import kotlinx.css.em
import kotlinx.css.flexDirection
import kotlinx.css.flexGrow
import kotlinx.css.flexShrink
import kotlinx.css.flexWrap
import kotlinx.css.fontFamily
import kotlinx.css.fontSize
import kotlinx.css.fontStyle
import kotlinx.css.fontWeight
import kotlinx.css.footer
import kotlinx.css.gap
import kotlinx.css.h1
import kotlinx.css.h2
import kotlinx.css.height
import kotlinx.css.justifyContent
import kotlinx.css.keyframes
import kotlinx.css.letterSpacing
import kotlinx.css.lineHeight
import kotlinx.css.margin
import kotlinx.css.marginBottom
import kotlinx.css.marginTop
import kotlinx.css.maxWidth
import kotlinx.css.minHeight
import kotlinx.css.opacity
import kotlinx.css.padding
import kotlinx.css.paddingBottom
import kotlinx.css.pct
import kotlinx.css.properties.BoxShadow
import kotlinx.css.properties.FillMode
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.Timing
import kotlinx.css.properties.Transforms
import kotlinx.css.properties.deg
import kotlinx.css.properties.linearGradient
import kotlinx.css.properties.s
import kotlinx.css.properties.translateX
import kotlinx.css.properties.translateY
import kotlinx.css.px
import kotlinx.css.rem
import kotlinx.css.textAlign
import kotlinx.css.textTransform
import kotlinx.css.transform
import kotlinx.css.vh
import kotlinx.css.vw
import kotlinx.css.width

private val space1 = 4.px
private val space2 = 8.px
private val space3 = 12.px
private val space4 = 16.px
private val space5 = 24.px
private val space6 = 32.px
private val radiusSmall = 6.px
private val radiusMedium = 8.px
private val radiusLarge = 12.px
private const val fontStack = "ui-monospace, SFMono-Regular, Menlo, Consolas, 'Liberation Mono', monospace"

val styles = CssBuilder().apply {
    base()
    headerStyles()
    typography()
    formStyles()
    boardStyles()
    motion()
    detailsStyles()
    footerStyles()
    responsive()
}

private fun CssBuilder.base() {
    root {
        backgroundColor = Color.bgBrown
        margin = Margin(0.px)
        padding = Padding(0.px)
    }
    rule("html") {
        height = 100.pct
        margin = Margin(0.px)
        padding = Padding(0.px)
    }
    rule("body") {
        display = Display.flex
        flexDirection = FlexDirection.column
        alignItems = Align.center
        fontFamily = fontStack
        margin = Margin(0.px)
        padding = Padding(space6)
        minHeight = 100.vh
        boxSizing = BoxSizing.borderBox
    }
    rule(".container") {
        display = Display.flex
        flexDirection = FlexDirection.column
        flexGrow = 1.0
        maxWidth = 1280.px
        width = 100.pct
        margin = Margin(0.px)
        textAlign = TextAlign.center
    }
}

private fun CssBuilder.headerStyles() {
    rule(".site-header") {
        display = Display.flex
        alignItems = Align.center
        justifyContent = JustifyContent.center
        gap = space4
        padding = Padding(space2)
    }
    rule(".mascot") {
        height = clamp(90.px, 14.vw, 170.px)
        width = LinearDimension.auto
    }
}

private fun CssBuilder.typography() {
    h1 {
        fontSize = clamp(1.8.rem, 5.vw, 2.6.rem)
        fontWeight = FontWeight.bold
        marginBottom = space4
        color = Color.blackBean
    }
    h2 {
        fontSize = clamp(1.05.rem, 2.5.vw, 1.35.rem)
        lineHeight = LineHeight("1.4")
        fontWeight = FontWeight.bold
        margin = Margin(LinearDimension.auto, LinearDimension.auto, space5)
        maxWidth = 36.rem
        color = Color.blackBean
    }
    rule(".won") {
        color = Color.winGreen
    }
    rule(".lost") {
        color = Color.lossBrick
    }
    rule(".invalid") {
        color = Color.lossBrick
    }
}

private fun CssBuilder.formStyles() {
    rule("form") {
        display = Display.flex
        justifyContent = JustifyContent.center
        gap = space2
        marginBottom = space5
    }
    rule(".form-slot") {
        minHeight = 48.px
        paddingBottom = 15.px
    }
    rule("input[type=text]") {
        flexGrow = 1.0
        padding = Padding(space3)
        fontFamily = fontStack
        fontWeight = FontWeight.bold
        fontSize = 20.px
        letterSpacing = space2
        borderRadius = radiusMedium
        width = 100.pct
        maxWidth = 420.px
        border = Border(2.px, BorderStyle.solid, Color.cafeNoir)
        backgroundColor = Color.cafeNoir
        color = Color("#d7dadc")
        caretColor = Color.indianYellow
        textAlign = TextAlign.center
        textTransform = TextTransform.uppercase
    }
    rule("input[type=text]:focus-visible") {
        put("outline", "3px solid #e3a857")
        put("outline-offset", "2px")
    }
    rule("input[type=text]::placeholder") {
        color = Color.mutedTan
        letterSpacing = space1
    }
}

private fun CssBuilder.boardStyles() {
    rule(".board") {
        display = Display.flex
        flexDirection = FlexDirection.column
        gap = 0.3.vw
        width = 100.pct
        maxWidth = 1280.px
    }
    rule(".row") {
        display = Display.flex
        gap = 0.3.vw
        width = 100.pct
        justifyContent = JustifyContent.center
        alignItems = Align.center
        paddingBottom = 0.1.vw
    }
    rule(".row.slide") {
        animationDuration = 0.5.s
        animationName = "slide-in"
        animationTimingFunction = Timing.easeInOut
    }
    rule(".tile") {
        display = Display.flex
        justifyContent = JustifyContent.center
        alignItems = Align.center
        width = clamp(58.px, 4.vw, 68.px)
        height = clamp(60.px, 4.8.vw, 70.px)
        fontWeight = FontWeight.bold
        fontSize = clamp(13.px, 2.3.vw, 23.px)
        borderRadius = clamp(radiusSmall, 0.5.vw, radiusMedium)
        backgroundColor = Color.cafeNoir
        color = Color.white
        textTransform = TextTransform.uppercase

        boxShadow += BoxShadow(
            offsetX = 0.px,
            offsetY = 3.px,
            blurRadius = 6.px,
            color = Color.blackBean
        )
    }
    rule(".tile.slide") {
        animationName = "slide-in"
        animationDuration = 0.4.s
        animationTimingFunction = Timing.easeInOut
        animationFillMode = FillMode.forwards
    }
    (1..41).forEach { i ->
        rule(".tile:nth-child($i)") {
            animationDelay = (i * 0.03).s
        }
    }
    rule(".tile.hint") {
        backgroundColor = Color.indianYellow
        fontSize = clamp(12.px, 2.2.vw, 14.px)
        backgroundImage = linearGradient(0.deg) {
            colorStop(Color("#ffd399"), 0.pct)
            colorStop(Color.transparent, 10.pct)
        }
    }
    rule(".tile.correct") {
        backgroundColor = Color.correctGuess
        backgroundImage = linearGradient(0.deg) {
            colorStop(Color("#8cbf88"), 0.pct)
            colorStop(Color.transparent, 10.pct)
        }
    }
    rule(".tile.absent") {
        backgroundColor = Color.cafeNoir
        backgroundImage = linearGradient(0.deg) {
            colorStop(Color("#735c45"), 0.pct)
            colorStop(Color.transparent, 10.pct)
        }
    }
    rule(".tile.tiny") {
        width = clamp(28.px, 2.vw, 38.px)
        height = clamp(30.px, 2.8.vw, 40.px)
    }
}

private fun CssBuilder.motion() {
    keyframes("slide-in") {
        from {
            val tsf = Transforms()
            tsf.translateX(40.pct)
            tsf.translateY((-6).px)
            transform = tsf
            opacity = 0.0
        }
        to {
            val tsf = Transforms()
            tsf.translateX(0.px)
            tsf.translateY(0.px)
            transform = tsf
            opacity = 1.0
        }
    }
    keyframes("banner-in") {
        from {
            val tsf = Transforms()
            tsf.translateY(8.px)
            transform = tsf
            opacity = 0.0
        }
        to {
            val tsf = Transforms()
            tsf.translateY(0.px)
            transform = tsf
            opacity = 1.0
        }
    }
    rule(".banner") {
        display = Display.inlineFlex
        alignItems = Align.center
        justifyContent = JustifyContent.center
        margin = Margin(0.px, LinearDimension.auto, space5)
        padding = Padding(space3, space6)
        borderRadius = 999.px
        color = Color.white
        fontWeight = FontWeight.bold
        fontSize = 20.px
        letterSpacing = 2.px
        animationName = "banner-in"
        animationDuration = 0.5.s
        animationTimingFunction = Timing.easeInOut
        animationFillMode = FillMode.forwards
    }
    rule(".banner-won") {
        backgroundColor = Color.correctGuess
    }
    rule(".banner-lost") {
        backgroundColor = Color.lossBrick
    }
}

private fun CssBuilder.detailsStyles() {
    rule("details") {
        backgroundColor = Color("rgba(61, 12, 2, 0.06)")
        borderRadius = radiusLarge
        padding = Padding(space2, space4)
        maxWidth = 48.rem
        width = 100.pct
        margin = Margin(space5, LinearDimension.auto)
        boxSizing = BoxSizing.borderBox
    }
    rule("summary") {
        cursor = Cursor.pointer
        padding = Padding(space3)
    }
    rule("summary:focus-visible") {
        put("outline", "3px solid #e3a857")
        put("outline-offset", "2px")
        borderRadius = radiusMedium
    }
    rule(".details") {
        padding = Padding(space3)
        fontSize = 1.1.em
        lineHeight = LineHeight("1.5")
        color = Color.blackBean
        textAlign = TextAlign.left
    }
    rule(".details.notes") {
        fontSize = 0.9.em
        fontStyle = FontStyle.italic
    }
    rule(".details.title") {
        fontSize = 1.3.em
        textAlign = TextAlign.center
    }
}

private fun CssBuilder.footerStyles() {
    footer {
        fontSize = 1.em
        color = Color.blackBean
        textAlign = TextAlign.center
        width = 100.pct
        marginTop = LinearDimension.auto
        padding = Padding(space4, 0.px)
    }
}

private fun CssBuilder.responsive() {
    media("(max-width: 900px)") {
        rule(".row") {
            flexWrap = FlexWrap.wrap
            gap = space1
            padding = Padding(space1)
            borderRadius = radiusMedium
            backgroundColor = Color("rgba(61, 12, 2, 0.08)")
        }
        rule(".tile") {
            flexShrink = 0.0
        }
        rule(".board") {
            gap = space3
        }
        rule(".site-header .row") {
            backgroundColor = Color.transparent
            padding = Padding(0.px)
        }
    }
    media("(max-width: 600px)") {
        rule("body") {
            padding = Padding(space4)
        }
        rule(".tile") {
            width = clamp(32.px, 8.5.vw, 44.px)
            height = clamp(34.px, 9.vw, 46.px)
            fontSize = clamp(12.px, 4.vw, 16.px)
        }
        rule("form") {
            width = 100.pct
        }
        rule("input[type=text]") {
            letterSpacing = 2.px
            fontSize = 18.px
            width = 100.pct
        }
        rule(".site-header") {
            gap = space2
        }
    }
    media("(prefers-reduced-motion: reduce)") {
        rule(".tile.slide, .row.slide, .banner") {
            put("animation", "none")
        }
    }
}

private val Color.Companion.cafeNoir: Color
    get() = Color("#4b3621")

private val Color.Companion.correctGuess: Color
    get() = Color("#538d4e")

private val Color.Companion.blackBean: Color
    get() = Color("#3d0c02")

private val Color.Companion.indianYellow: Color
    get() = Color("#e3a857")

private val Color.Companion.bgBrown: Color
    get() = Color("#c19a6b")

private val Color.Companion.winGreen: Color
    get() = Color("#3f6f3a")

private val Color.Companion.lossBrick: Color
    get() = Color("#8c2f1b")

private val Color.Companion.mutedTan: Color
    get() = Color("#a88a63")
