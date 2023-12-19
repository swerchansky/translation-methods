grammar ParserGenerator;
@header {
package antlrgenerated;
}

start : package? parserAttr* nodeValue* rule+ token+ EOF ;

parserAttr : 'attr' ATTR ;
nodeValue : 'node' ATTR ;

package : '+' PACKAGE_NAME ';' ;

rule : RULE_NAME ':' rule_body ';' ;

rule_body : (RULE_NAME | TOKEN_NAME | ATTR)+ ;

token : TOKEN_NAME ':' (TOKEN_VALUE | REGEX_VALUE) ';' ;

ATTR : '@' (~'@')* '@' ;
RULE_NAME : [a-z][a-zA-Z0-9]* ;
TOKEN_NAME : [A-Z][a-zA-Z0-9]* ;
PACKAGE_NAME : [a-zA-Z0-9]+ ('.' | [a-zA-Z0-9]+)* ;
REGEX_VALUE : '/' .*? '/' ;
TOKEN_VALUE : '"' .*? '"' ;
WS : [ \t\r\n]+ -> skip ;
