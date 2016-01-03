package org.ithinking.spring.tengine;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ithinking.tengine.core.Configuration;
import org.ithinking.tengine.core.Loader;
import org.ithinking.tengine.core.Parser;
import org.ithinking.tengine.core.Template;
import org.ithinking.tengine.core.TemplateManager;
import org.ithinking.tengine.html.parser.HtmlParser;
import org.ithinking.tengine.loader.ClasspathLoader;
import org.ithinking.tengine.loader.FilepathLoader;
import org.ithinking.tengine.loader.WebinfoLoader;

public class TengineView extends AbstractTengineView {

	private String templateName;
	private Template template;

	protected TengineView(final String templateName) {
		this.templateName = templateName;
	}

	@Override
	public String getContentType() {
		return null;
	}

	public Template loadTemplate() {
		
		String prefix = this.getPrefix() == null ? "" : this.getPrefix();
		String suffix = this.getSuffix() == null ? ".html" : this.getSuffix();
		String path;
		Loader loader = null;
		Configuration conf = new Configuration();
		if(prefix.startsWith("classpath:")){
			path = prefix.substring("classpath:".length());
			loader = new ClasspathLoader(conf);
		}else if(prefix.startsWith("file:")){
			path = prefix.substring("file:".length());
			loader = new FilepathLoader(path);
		}else{
			String root = this.getServletContext().getRealPath("/");
			path = root + prefix;
			loader = new WebinfoLoader(path);
		}
		
		Parser parser = new HtmlParser();
		TemplateManager manager = new TemplateManager(loader, conf, parser);
		
		Template template = manager.getTemplate(templateName + suffix);

		return template;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//Context context = new WebContext(model, request, response);
		if(template == null){
			template = this.loadTemplate();
		}
		response.getWriter().print(template.getText());
		//template.render(context);
	}

	@Override
	public void setBeanName(String name) {

	}

}
