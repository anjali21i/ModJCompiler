package compiler;
public class Lexer {
	  
	  private final String code;
	  private final int codeLength;

	  private int currentIndex;

	  private Token currentToken;
	  private Token previousToken;

	  public Lexer(String code) {
	    this.code = code;
	    this.currentIndex = 0;
	    this.codeLength = code.length();
	  }
	  
	  public boolean nextToken() {

	    while (!isEndOfCode()) { // while loop is to fetch nextToken, if a skipWS occurs.

	      previousToken = currentToken; // in case you need the previous token

	      final char currentChar = code.charAt(currentIndex);

	      if (Arrays.asList(' ', '\r', '\t', '\n').contains(currentChar)) { // 1. WS
	        skipWhiteSpace();
	        continue;
	      } else if (currentChar == '=') { // 2. LET
	        currentToken = new Token(TokenType.EQUALS_OPERATOR);
	        currentIndex++;
	      } else if (Character.isDigit(currentChar)) { // 3. INT
	        currentToken = new Token(TokenType.NUMBER, readNumber());
	      } else if (Character.isLetter(currentChar)) {
	        String variableName = readVariable();
	        if (variableName.equalsIgnoreCase("show")) { // 4. SHOW
	          currentToken = new Token(TokenType.SHOW);
	        } else { // 5. VAR
	          currentToken = new Token(TokenType.VARIABLE, variableName);
	        }
	      } else {
	        throw new LexerException("Token not defined.");
	      }
	      return true;
	    }
	    return false;
	  }
	  
	  private String readNumber() {
	    
	  }

	  /** @return String read from current index. */
	  private String readVariable() {

	  }


	  private void skipWhiteSpace() {

	  }

	  public Token getCurrentToken() {
	    return currentToken;
	  }
	}
