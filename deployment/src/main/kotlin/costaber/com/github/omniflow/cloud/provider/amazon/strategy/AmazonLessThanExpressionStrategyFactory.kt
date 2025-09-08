package costaber.com.github.omniflow.cloud.provider.amazon.strategy

import costaber.com.github.omniflow.cloud.provider.amazon.renderer.binaryexpression.AmazonLessThanExpressionRenderer
import costaber.com.github.omniflow.cloud.provider.amazon.renderer.AmazonTermResolver
import costaber.com.github.omniflow.factory.NodeRendererStrategyFactory
import costaber.com.github.omniflow.model.LessThanExpression
import costaber.com.github.omniflow.model.Node
import costaber.com.github.omniflow.predicate.DefaultPredicate
import costaber.com.github.omniflow.renderer.NodeRenderer
import java.util.function.Predicate

class AmazonLessThanExpressionStrategyFactory : NodeRendererStrategyFactory<StringBuilder> {

    override fun getMatcher(): Predicate<Node> =
        DefaultPredicate(LessThanExpression::class)

    override fun getRenderer(node: Node): NodeRenderer<StringBuilder> =
        AmazonLessThanExpressionRenderer(node as LessThanExpression<*>, AmazonTermResolver)
}