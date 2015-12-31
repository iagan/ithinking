package org.ithinking.tengine.core;

import java.util.HashMap;
import java.util.Map;

public class TemplateManager {
	
	private static Map<String, Template> TEMPLATES = new HashMap<String,Template>();
	
	private Loader loader;
	private Parser parser;
	
	public TemplateManager(Loader loader, Configuration conf, Parser parser){
		this.loader = loader;
		this.parser = parser;
	}

	public Template getTemplate(String id){
		Template tpl = TEMPLATES.get(id);
		if(tpl != null){
			return tpl;
		}else{
			String text = loader.getTemplate(id);
			if(text != null){
				tpl = parser.parse(text);
				if(tpl != null){
					TEMPLATES.put(id, tpl);
				}
			}
		}
		return tpl;
	}
}
