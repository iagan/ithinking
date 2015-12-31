package org.ithinking.tengine;

import org.ithinking.tengine.loader.ClasspathLoader;
import org.ithinking.tengine.sql.SQLParser;
import org.junit.Test;

public class SqlTengineTest {

	@Test
	public void test() {
		SQLParser parser = new SQLParser();
		ClasspathLoader cl = new ClasspathLoader(null);
		String sqlText = cl.getTemplate("user.sql");
		parser.parse(sqlText);
	}
}
