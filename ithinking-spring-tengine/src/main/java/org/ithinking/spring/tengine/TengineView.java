package org.ithinking.spring.tengine;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TengineView extends AbstractTengineView{

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	}

	@Override
	public void setBeanName(String name) {
		
	}

}
