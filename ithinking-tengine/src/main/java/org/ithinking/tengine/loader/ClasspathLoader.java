package org.ithinking.tengine.loader;

import java.io.File;
import java.net.URL;

import org.ithinking.tengine.core.Configuration;

public class ClasspathLoader extends AbstractLoader {

	@SuppressWarnings("unused")
	private Configuration conf;

	public ClasspathLoader(Configuration conf) {
		this.conf = conf;
	}

	public String getTemplate(String templateId) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		URL url = classLoader.getResource("");
		String text = "";
		if (url.getProtocol().equals("file")) {
			File file = new File(url.getFile() + "/" + templateId);
			text = this.getTemplate(file);
		}
		return text;
	}

}
