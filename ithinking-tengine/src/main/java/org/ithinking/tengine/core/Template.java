package org.ithinking.tengine.core;

import org.ithinking.tengine.html.Document;

public class Template {

	private Document doc;

	public Template(Document doc) {
		this.doc = doc;
	}

	public void render(Context context) {
		if (doc != null) {
			doc.render(context);
		}
	}

	public Document getDocument() {
		return doc;
	}

}
