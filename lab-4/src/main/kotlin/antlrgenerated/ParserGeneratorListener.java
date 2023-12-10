// Generated from java-escape by ANTLR 4.11.1

package antlrgenerated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserGeneratorParser}.
 */
public interface ParserGeneratorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserGeneratorParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ParserGeneratorParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGeneratorParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ParserGeneratorParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGeneratorParser#package}.
	 * @param ctx the parse tree
	 */
	void enterPackage(ParserGeneratorParser.PackageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGeneratorParser#package}.
	 * @param ctx the parse tree
	 */
	void exitPackage(ParserGeneratorParser.PackageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGeneratorParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(ParserGeneratorParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGeneratorParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(ParserGeneratorParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGeneratorParser#rule_body}.
	 * @param ctx the parse tree
	 */
	void enterRule_body(ParserGeneratorParser.Rule_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGeneratorParser#rule_body}.
	 * @param ctx the parse tree
	 */
	void exitRule_body(ParserGeneratorParser.Rule_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGeneratorParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(ParserGeneratorParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGeneratorParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(ParserGeneratorParser.TokenContext ctx);
}