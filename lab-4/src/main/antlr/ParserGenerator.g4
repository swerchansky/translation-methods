grammar ParserGenerator;
@header {
package antlrgenerated;
}

start : package? nodeValue* rule+ token+ EOF ;

nodeValue : 'node' NODE_ATTR ;

package : '+' RULE_NAME ';' ;

rule : RULE_NAME ':' rule_body ';' ;

rule_body : (RULE_NAME | TOKEN_NAME)+ ;

token : TOKEN_NAME ':' (TOKEN_VALUE | REGEX_VALUE) ';' ;

NODE_ATTR : '@' (~'@')* '@' ;
RULE_NAME : [a-z][a-zA-Z0-9]* ;
TOKEN_NAME : [A-Z][a-zA-Z0-9]* ;
REGEX_VALUE : '/' .*? '/' ;
TOKEN_VALUE : '"' .*? '"' ;
WS : [ \t\r\n]+ -> skip ;
