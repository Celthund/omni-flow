package costaber.com.github.omniflow.resource.util

import costaber.com.github.omniflow.renderer.IndentedRenderingContext

inline fun render(
    renderer: IndentedRenderingContext,
    appendNewLine: Boolean = true,
    builderAction: IndentedRenderingContext.() -> Unit
): StringBuilder {
    renderer.builderAction()
    val stringBuilder = renderer.stringBuilder
    if (appendNewLine) {
        stringBuilder.appendLine()
    }
    return stringBuilder
}