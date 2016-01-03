package org.ithinking.tengine.core;

import org.ithinking.tengine.html.Document;

public class Template {

	private String text;
	private Document doc;
	
	public String getText(){
		return text;
	}

	public Template(Document doc, String text) {
		this.doc = doc;
		this.text = text;
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
