package org.ithinking.tengine.loader;

import java.io.File;

public class FilepathLoader extends AbstractLoader{

	private String rootPath;

	public FilepathLoader(String rootPath) {
		this.rootPath = rootPath;
	}

	@Override
	public String getTemplate(String templateId) {
		File file = new File(rootPath + templateId);
		return getTemplate(file);
	}
}
