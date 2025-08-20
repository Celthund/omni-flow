package costaber.com.github.omniflow.cloud.provider.google.strategy

import costaber.com.github.omniflow.cloud.provider.google.renderer.GoogleGreaterThanOrEqualExpressionRenderer
import costaber.com.github.omniflow.cloud.provider.google.renderer.GoogleTermResolver
import costaber.com.github.omniflow.factory.NodeRendererStrategyFactory
import costaber.com.github.omniflow.model.GreaterThanOrEqualExpression
import costaber.com.github.omniflow.model.Node
import costaber.com.github.omniflow.predicate.DefaultPredicate
import costaber.com.github.omniflow.renderer.NodeRenderer
import java.util.function.Predicate

class GoogleGreaterThanOrEqualExpressionStrategyFactory : NodeRendererStrategyFactory<StringBuilder> {

    override fun getMatcher(): Predicate<Node> =
        DefaultPredicate(GreaterThanOrEqualExpression::class)

    override fun getRenderer(node: Node): NodeRenderer<StringBuilder> =
        GoogleGreaterThanOrEqualExpressionRenderer(node as GreaterThanOrEqualExpression<*>, GoogleTermResolver)
}