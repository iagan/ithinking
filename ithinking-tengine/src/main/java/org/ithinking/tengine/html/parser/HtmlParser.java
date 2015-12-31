package org.ithinking.tengine.html.parser;

import org.ithinking.tengine.core.Parser;
import org.ithinking.tengine.core.Template;
import org.ithinking.tengine.html.Document;

public class HtmlParser implements Parser {

	public Template parse(String text) {
		// new DebugHandler()
		Handler handler = new HtmlHandler();
		HtmlScanner scanner = new HtmlScanner(text);
		scanner.setHandler(handler);
		scanner.start();
		Document doc = handler.getRootBlock();
		return new Template(doc);
	}

}
