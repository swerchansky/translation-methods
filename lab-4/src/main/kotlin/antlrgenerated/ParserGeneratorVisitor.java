// Generated from java-escape by ANTLR 4.11.1

package antlrgenerated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParserGeneratorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParserGeneratorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ParserGeneratorParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ParserGeneratorParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGeneratorParser#nodeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeValue(ParserGeneratorParser.NodeValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGeneratorParser#package}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackage(ParserGeneratorParser.PackageContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGeneratorParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(ParserGeneratorParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGeneratorParser#rule_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_body(ParserGeneratorParser.Rule_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGeneratorParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(ParserGeneratorParser.TokenContext ctx);
}