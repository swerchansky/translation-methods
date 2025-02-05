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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ATTR=6, RULE_NAME=7, TOKEN_NAME=8, 
		PACKAGE_NAME=9, REGEX_VALUE=10, TOKEN_VALUE=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "ATTR", "RULE_NAME", "TOKEN_NAME", 
			"PACKAGE_NAME", "REGEX_VALUE", "TOKEN_VALUE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'attr'", "'node'", "'+'", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "ATTR", "RULE_NAME", "TOKEN_NAME", 
			"PACKAGE_NAME", "REGEX_VALUE", "TOKEN_VALUE", "WS"
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
		"\u0004\u0000\fi\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0005\u0005,\b\u0005\n\u0005\f\u0005/\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0005\u00065\b\u0006\n\u0006\f\u0006"+
		"8\t\u0006\u0001\u0007\u0001\u0007\u0005\u0007<\b\u0007\n\u0007\f\u0007"+
		"?\t\u0007\u0001\b\u0004\bB\b\b\u000b\b\f\bC\u0001\b\u0001\b\u0004\bH\b"+
		"\b\u000b\b\f\bI\u0005\bL\b\b\n\b\f\bO\t\b\u0001\t\u0001\t\u0005\tS\b\t"+
		"\n\t\f\tV\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\n\\\b\n\n\n\f\n_\t"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0004\u000bd\b\u000b\u000b\u000b\f\u000b"+
		"e\u0001\u000b\u0001\u000b\u0002T]\u0000\f\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0001\u0000\u0005\u0001\u0000@@\u0001\u0000az\u0003"+
		"\u000009AZaz\u0001\u0000AZ\u0003\u0000\t\n\r\r  r\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000"+
		"\u0003\u001e\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007"+
		"%\u0001\u0000\u0000\u0000\t\'\u0001\u0000\u0000\u0000\u000b)\u0001\u0000"+
		"\u0000\u0000\r2\u0001\u0000\u0000\u0000\u000f9\u0001\u0000\u0000\u0000"+
		"\u0011A\u0001\u0000\u0000\u0000\u0013P\u0001\u0000\u0000\u0000\u0015Y"+
		"\u0001\u0000\u0000\u0000\u0017c\u0001\u0000\u0000\u0000\u0019\u001a\u0005"+
		"a\u0000\u0000\u001a\u001b\u0005t\u0000\u0000\u001b\u001c\u0005t\u0000"+
		"\u0000\u001c\u001d\u0005r\u0000\u0000\u001d\u0002\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0005n\u0000\u0000\u001f \u0005o\u0000\u0000 !\u0005d\u0000"+
		"\u0000!\"\u0005e\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005+"+
		"\u0000\u0000$\u0006\u0001\u0000\u0000\u0000%&\u0005;\u0000\u0000&\b\u0001"+
		"\u0000\u0000\u0000\'(\u0005:\u0000\u0000(\n\u0001\u0000\u0000\u0000)-"+
		"\u0005@\u0000\u0000*,\b\u0000\u0000\u0000+*\u0001\u0000\u0000\u0000,/"+
		"\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000"+
		"\u0000.0\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u000001\u0005@\u0000"+
		"\u00001\f\u0001\u0000\u0000\u000026\u0007\u0001\u0000\u000035\u0007\u0002"+
		"\u0000\u000043\u0001\u0000\u0000\u000058\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u00007\u000e\u0001\u0000\u0000"+
		"\u000086\u0001\u0000\u0000\u00009=\u0007\u0003\u0000\u0000:<\u0007\u0002"+
		"\u0000\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\u0010\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000@B\u0007\u0002\u0000\u0000A@\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DM\u0001\u0000\u0000\u0000EL\u0005.\u0000\u0000FH\u0007"+
		"\u0002\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000"+
		"\u0000KE\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000LO\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0012"+
		"\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PT\u0005/\u0000\u0000"+
		"QS\t\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000WX\u0005/\u0000\u0000X\u0014\u0001\u0000"+
		"\u0000\u0000Y]\u0005\"\u0000\u0000Z\\\t\u0000\u0000\u0000[Z\u0001\u0000"+
		"\u0000\u0000\\_\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"`a\u0005\"\u0000\u0000a\u0016\u0001\u0000\u0000\u0000bd\u0007\u0004\u0000"+
		"\u0000cb\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0006"+
		"\u000b\u0000\u0000h\u0018\u0001\u0000\u0000\u0000\u000b\u0000-6=CIKMT"+
		"]e\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}