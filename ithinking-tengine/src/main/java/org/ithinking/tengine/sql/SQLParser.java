package org.ithinking.tengine.sql;

import org.ithinking.tengine.loader.ClasspathLoader;

public class SQLParser {
	
	public static void main(String[] args){
		ClasspathLoader cl = new ClasspathLoader(null);
		String sqlText = cl.getTemplate("user.sql");
		SQLParser p = new SQLParser();
		p.parse(sqlText);
	}

	public void parse(String text){
		SQLLexer lexer = new SQLLexer(text);
		while(lexer.hasNext()){
			System.out.println(lexer.next());
		}
	}
}
