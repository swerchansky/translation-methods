// Generated from java-escape by ANTLR 4.11.1

package antlrgenerated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ParserGeneratorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, NODE_ATTR=5, RULE_NAME=6, TOKEN_NAME=7, 
		REGEX_VALUE=8, TOKEN_VALUE=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "NODE_ATTR", "RULE_NAME", "TOKEN_NAME", 
			"REGEX_VALUE", "TOKEN_VALUE", "WS"
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


	public ParserGeneratorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ParserGenerator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\nP\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004#\b"+
		"\u0004\n\u0004\f\u0004&\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0005\u0005,\b\u0005\n\u0005\f\u0005/\t\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u00063\b\u0006\n\u0006\f\u00066\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0005\u0007:\b\u0007\n\u0007\f\u0007=\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0005\bC\b\b\n\b\f\bF\t\b\u0001\b\u0001\b\u0001"+
		"\t\u0004\tK\b\t\u000b\t\f\tL\u0001\t\u0001\t\u0002;D\u0000\n\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0001\u0000\u0005\u0001\u0000@@\u0001\u0000az\u0003"+
		"\u000009AZaz\u0001\u0000AZ\u0003\u0000\t\n\r\r  U\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000"+
		"\u0003\u001a\u0001\u0000\u0000\u0000\u0005\u001c\u0001\u0000\u0000\u0000"+
		"\u0007\u001e\u0001\u0000\u0000\u0000\t \u0001\u0000\u0000\u0000\u000b"+
		")\u0001\u0000\u0000\u0000\r0\u0001\u0000\u0000\u0000\u000f7\u0001\u0000"+
		"\u0000\u0000\u0011@\u0001\u0000\u0000\u0000\u0013J\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005n\u0000\u0000\u0016\u0017\u0005o\u0000\u0000\u0017\u0018"+
		"\u0005d\u0000\u0000\u0018\u0019\u0005e\u0000\u0000\u0019\u0002\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0005+\u0000\u0000\u001b\u0004\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0005;\u0000\u0000\u001d\u0006\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0005:\u0000\u0000\u001f\b\u0001\u0000\u0000\u0000 $\u0005"+
		"@\u0000\u0000!#\b\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#&\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000"+
		"%\'\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000\'(\u0005@\u0000"+
		"\u0000(\n\u0001\u0000\u0000\u0000)-\u0007\u0001\u0000\u0000*,\u0007\u0002"+
		"\u0000\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001"+
		"\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.\f\u0001\u0000\u0000\u0000"+
		"/-\u0001\u0000\u0000\u000004\u0007\u0003\u0000\u000013\u0007\u0002\u0000"+
		"\u000021\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u00005\u000e\u0001\u0000\u0000\u0000"+
		"64\u0001\u0000\u0000\u00007;\u0005/\u0000\u00008:\t\u0000\u0000\u0000"+
		"98\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000;9\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000>?\u0005/\u0000\u0000?\u0010\u0001\u0000\u0000\u0000@D\u0005"+
		"\"\u0000\u0000AC\t\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CF\u0001"+
		"\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000GH\u0005\"\u0000\u0000"+
		"H\u0012\u0001\u0000\u0000\u0000IK\u0007\u0004\u0000\u0000JI\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0006\t\u0000\u0000O\u0014"+
		"\u0001\u0000\u0000\u0000\u0007\u0000$-4;DL\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}