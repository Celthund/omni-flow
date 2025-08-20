package costaber.com.github.omniflow.cloud.provider.google.renderer

import costaber.com.github.omniflow.model.BranchContext
import costaber.com.github.omniflow.model.Node
import costaber.com.github.omniflow.renderer.IndentedRenderingContext
import costaber.com.github.omniflow.resource.util.render

class GoogleBranchRenderer(private val branchContext: BranchContext) : GoogleRenderer() {

    override val element: Node = branchContext

    override fun internalBeginRender(renderingContext: IndentedRenderingContext): StringBuilder =
        render(renderingContext) {
            addLine("- ${branchContext.name}:")
            incIndentationLevel()
            add("steps:")
            incIndentationLevel()
        }

    override fun internalEndRender(renderingContext: IndentedRenderingContext) =
        render(renderingContext, appendNewLine = false) {
            decIndentationLevel()
            decIndentationLevel()
        }
}
