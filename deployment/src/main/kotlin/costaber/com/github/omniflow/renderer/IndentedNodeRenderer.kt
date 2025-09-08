package costaber.com.github.omniflow.renderer

abstract class IndentedNodeRenderer : NodeRenderer<StringBuilder> {

    override fun beginRender(renderingContext: RenderingContext): StringBuilder {
        val indentedRenderingContext = renderingContext as IndentedRenderingContext
        val render = internalBeginRender(indentedRenderingContext)
        indentedRenderingContext.incIndentationLevel()
        return render
    }

    override fun endRender(renderingContext: RenderingContext): StringBuilder {
        val indentedRenderingContext = renderingContext as IndentedRenderingContext
        indentedRenderingContext.decIndentationLevel()
        return internalEndRender(indentedRenderingContext)
    }

    protected abstract fun internalBeginRender(renderingContext: IndentedRenderingContext): StringBuilder

    protected abstract fun internalEndRender(renderingContext: IndentedRenderingContext): StringBuilder
}