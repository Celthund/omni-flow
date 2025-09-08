package costaber.com.github.omniflow.cloud.provider.google.strategy

import costaber.com.github.omniflow.cloud.provider.google.renderer.GoogleAssignRenderer
import costaber.com.github.omniflow.factory.NodeRendererStrategyFactory
import costaber.com.github.omniflow.model.AssignContext
import costaber.com.github.omniflow.model.Node
import costaber.com.github.omniflow.predicate.DefaultPredicate
import costaber.com.github.omniflow.renderer.NodeRenderer
import java.util.function.Predicate

class GoogleAssignStrategyFactory : NodeRendererStrategyFactory<StringBuilder> {

    override fun getMatcher(): Predicate<Node> =
        DefaultPredicate(AssignContext::class)

    override fun getRenderer(node: Node): NodeRenderer<StringBuilder> =
        GoogleAssignRenderer(node as AssignContext)
}