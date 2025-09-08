package costaber.com.github.omniflow.cloud.provider.google.strategy

import costaber.com.github.omniflow.cloud.provider.google.renderer.GoogleBranchRenderer
import costaber.com.github.omniflow.factory.NodeRendererStrategyFactory
import costaber.com.github.omniflow.model.BranchContext
import costaber.com.github.omniflow.model.Node
import costaber.com.github.omniflow.predicate.DefaultPredicate
import costaber.com.github.omniflow.renderer.NodeRenderer
import java.util.function.Predicate

class GoogleBranchStrategyFactory : NodeRendererStrategyFactory<StringBuilder> {

    override fun getMatcher(): Predicate<Node> =
        DefaultPredicate(BranchContext::class)

    override fun getRenderer(node: Node): NodeRenderer<StringBuilder> =
        GoogleBranchRenderer(node as BranchContext)
}