grammar Expression;
@header {
package antlr;
}

start : VARIABLE EQ expression SEMI (start | EOF) ;

expression
    : LB expr=expression RB                                     #bracketsExpr
    | <assoc=right> left=expression op=POW right=expression     #binExpr
    | left=expression op=(MULT | DIV) right=expression          #binExpr
    | left=expression op=(PLUS | MINUS) right=expression        #binExpr
    | (PLUS | MINUS)* (NUMBER | VARIABLE)                       #unaryExpr
    ;

VARIABLE : [a-zA-Z][a-zA-Z0-9]* ;
NUMBER : [0-9]+ ;
PLUS  : '+' ;
MINUS : '-' ;
MULT  : '*' ;
DIV   : '/' ;
POW   : '^' ;
SEMI  : ';' ;
EQ    : '=' ;
LB    : '(' ;
RB    : ')' ;
WS : [ \r\n\t] + -> skip ;
