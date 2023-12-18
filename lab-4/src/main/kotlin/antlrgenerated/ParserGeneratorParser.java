// Generated from java-escape by ANTLR 4.11.1

package antlrgenerated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ParserGeneratorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, NODE_ATTR=5, RULE_NAME=6, TOKEN_NAME=7, 
		REGEX_VALUE=8, TOKEN_VALUE=9, WS=10;
	public static final int
		RULE_start = 0, RULE_nodeValue = 1, RULE_package = 2, RULE_rule = 3, RULE_rule_body = 4, 
		RULE_token = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "nodeValue", "package", "rule", "rule_body", "token"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'node'", "'+'", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "NODE_ATTR", "RULE_NAME", "TOKEN_NAME", 
			"REGEX_VALUE", "TOKEN_VALUE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserGeneratorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ParserGeneratorParser.EOF, 0); }
		public PackageContext package_() {
			return getRuleContext(PackageContext.class,0);
		}
		public List<NodeValueContext> nodeValue() {
			return getRuleContexts(NodeValueContext.class);
		}
		public NodeValueContext nodeValue(int i) {
			return getRuleContext(NodeValueContext.class,i);
		}
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public List<TokenContext> token() {
			return getRuleContexts(TokenContext.class);
		}
		public TokenContext token(int i) {
			return getRuleContext(TokenContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGeneratorVisitor ) return ((ParserGeneratorVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(12);
				package_();
				}
			}

			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(15);
				nodeValue();
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21);
				rule_();
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RULE_NAME );
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				token();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOKEN_NAME );
			setState(31);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NodeValueContext extends ParserRuleContext {
		public TerminalNode NODE_ATTR() { return getToken(ParserGeneratorParser.NODE_ATTR, 0); }
		public NodeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).enterNodeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).exitNodeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGeneratorVisitor ) return ((ParserGeneratorVisitor<? extends T>)visitor).visitNodeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeValueContext nodeValue() throws RecognitionException {
		NodeValueContext _localctx = new NodeValueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nodeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(T__0);
			setState(34);
			match(NODE_ATTR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PackageContext extends ParserRuleContext {
		public TerminalNode RULE_NAME() { return getToken(ParserGeneratorParser.RULE_NAME, 0); }
		public PackageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_package; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).enterPackage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).exitPackage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGeneratorVisitor ) return ((ParserGeneratorVisitor<? extends T>)visitor).visitPackage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageContext package_() throws RecognitionException {
		PackageContext _localctx = new PackageContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_package);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__1);
			setState(37);
			match(RULE_NAME);
			setState(38);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleContext extends ParserRuleContext {
		public TerminalNode RULE_NAME() { return getToken(ParserGeneratorParser.RULE_NAME, 0); }
		public Rule_bodyContext rule_body() {
			return getRuleContext(Rule_bodyContext.class,0);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGeneratorVisitor ) return ((ParserGeneratorVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(RULE_NAME);
			setState(41);
			match(T__3);
			setState(42);
			rule_body();
			setState(43);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rule_bodyContext extends ParserRuleContext {
		public List<TerminalNode> RULE_NAME() { return getTokens(ParserGeneratorParser.RULE_NAME); }
		public TerminalNode RULE_NAME(int i) {
			return getToken(ParserGeneratorParser.RULE_NAME, i);
		}
		public List<TerminalNode> TOKEN_NAME() { return getTokens(ParserGeneratorParser.TOKEN_NAME); }
		public TerminalNode TOKEN_NAME(int i) {
			return getToken(ParserGeneratorParser.TOKEN_NAME, i);
		}
		public Rule_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).enterRule_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).exitRule_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGeneratorVisitor ) return ((ParserGeneratorVisitor<? extends T>)visitor).visitRule_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_bodyContext rule_body() throws RecognitionException {
		Rule_bodyContext _localctx = new Rule_bodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rule_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				_la = _input.LA(1);
				if ( !(_la==RULE_NAME || _la==TOKEN_NAME) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RULE_NAME || _la==TOKEN_NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TokenContext extends ParserRuleContext {
		public TerminalNode TOKEN_NAME() { return getToken(ParserGeneratorParser.TOKEN_NAME, 0); }
		public TerminalNode TOKEN_VALUE() { return getToken(ParserGeneratorParser.TOKEN_VALUE, 0); }
		public TerminalNode REGEX_VALUE() { return getToken(ParserGeneratorParser.REGEX_VALUE, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGeneratorListener ) ((ParserGeneratorListener)listener).exitToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGeneratorVisitor ) return ((ParserGeneratorVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_token);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(TOKEN_NAME);
			setState(51);
			match(T__3);
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==REGEX_VALUE || _la==TOKEN_VALUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(53);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\n8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0003\u0000\u000e\b\u0000\u0001\u0000\u0005"+
		"\u0000\u0011\b\u0000\n\u0000\f\u0000\u0014\t\u0000\u0001\u0000\u0004\u0000"+
		"\u0017\b\u0000\u000b\u0000\f\u0000\u0018\u0001\u0000\u0004\u0000\u001c"+
		"\b\u0000\u000b\u0000\f\u0000\u001d\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0004\u0004/\b\u0004\u000b\u0004\f\u00040\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002"+
		"\u0004\u0006\b\n\u0000\u0002\u0001\u0000\u0006\u0007\u0001\u0000\b\t6"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0002!\u0001\u0000\u0000\u0000\u0004"+
		"$\u0001\u0000\u0000\u0000\u0006(\u0001\u0000\u0000\u0000\b.\u0001\u0000"+
		"\u0000\u0000\n2\u0001\u0000\u0000\u0000\f\u000e\u0003\u0004\u0002\u0000"+
		"\r\f\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u0012"+
		"\u0001\u0000\u0000\u0000\u000f\u0011\u0003\u0002\u0001\u0000\u0010\u000f"+
		"\u0001\u0000\u0000\u0000\u0011\u0014\u0001\u0000\u0000\u0000\u0012\u0010"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0016"+
		"\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0015\u0017"+
		"\u0003\u0006\u0003\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0001\u0000\u0000\u0000\u001a\u001c"+
		"\u0003\n\u0005\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001"+
		"\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0005\u0000"+
		"\u0000\u0001 \u0001\u0001\u0000\u0000\u0000!\"\u0005\u0001\u0000\u0000"+
		"\"#\u0005\u0005\u0000\u0000#\u0003\u0001\u0000\u0000\u0000$%\u0005\u0002"+
		"\u0000\u0000%&\u0005\u0006\u0000\u0000&\'\u0005\u0003\u0000\u0000\'\u0005"+
		"\u0001\u0000\u0000\u0000()\u0005\u0006\u0000\u0000)*\u0005\u0004\u0000"+
		"\u0000*+\u0003\b\u0004\u0000+,\u0005\u0003\u0000\u0000,\u0007\u0001\u0000"+
		"\u0000\u0000-/\u0007\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000/0\u0001"+
		"\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"1\t\u0001\u0000\u0000\u000023\u0005\u0007\u0000\u000034\u0005\u0004\u0000"+
		"\u000045\u0007\u0001\u0000\u000056\u0005\u0003\u0000\u00006\u000b\u0001"+
		"\u0000\u0000\u0000\u0005\r\u0012\u0018\u001d0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}