# ModJCompiler
This build contains own developed compiler for learning purpose

Take help from below notes :

Lexer : splits source code into tokens which are special keywords and structures of specific programming language
Parser : Identifies patterns of token set and build Abstract Syntax Tree(AST).
Generator : Generates the syntax of target language

Grammar: 

grammar SimplerLang;
program : statement+;        => Program will have multiple Statement
statement : let | show ;     => A Statement is either Let or Show.

let : VAR '=' INT ;          => Let is of the form VAR = INT
show : 'show' (INT | VAR) ;  => Show is of the form SHOW INT or SHOW VAR.

VAR : ('a'..'z'|'A'..'Z')+ ; => VAR → Variable ( String with lower or uppercase letters)
INT : '0'..'9'+ ;            => INT → ( Integer, ie Positive Numberwithout decimal)  
WS : [ \n\t]+ -> skip;
