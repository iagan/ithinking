package org.ithinking.tengine.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.ithinking.tengine.core.Configuration;
import org.ithinking.tengine.core.Loader;

public class ClasspathLoader implements Loader {

	@SuppressWarnings("unused")
	private Configuration conf;

	public ClasspathLoader(Configuration conf) {
		this.conf = conf;
	}

	public String getTemplate(String templateId) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		URL url = classLoader.getResource("");
		StringBuilder sb = new StringBuilder();
		if (url.getProtocol().equals("file")) {
			File file = new File(url.getFile() + "/" + templateId);
			if (file.exists()) {
				InputStream ins = null;
				try {
					ins = new FileInputStream(file);
					BufferedReader bf = new BufferedReader(new InputStreamReader(ins));
					String temp;

					while ((temp = bf.readLine()) != null) {
						sb.append(temp).append("\n");
					}
					bf.close();
				} catch (IOException ioe) {
					throw new RuntimeException();
				}
			}
		}
		return sb.toString();
	}

}
