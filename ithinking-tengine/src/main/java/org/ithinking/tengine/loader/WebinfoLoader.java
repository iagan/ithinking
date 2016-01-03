package org.ithinking.tengine.loader;

import java.io.File;

public class WebinfoLoader extends AbstractLoader {
	private String appRootPath;

	public WebinfoLoader(String appRootPath) {
		this.appRootPath = appRootPath;
	}

	@Override
	public String getTemplate(String templateId) {
		File file = new File(appRootPath + templateId);
		return getTemplate(file);
	}

}
