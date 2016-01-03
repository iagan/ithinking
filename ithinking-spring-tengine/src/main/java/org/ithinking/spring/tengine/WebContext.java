package org.ithinking.spring.tengine;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ithinking.tengine.core.Context;
import org.ithinking.tengine.core.Template;

public class WebContext implements Context {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, ?> model;
	
	
	public WebContext(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response){
		this.model = model;
		this.request = request;
		this.response = response;
	}

	@Override
	public Context add(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Template loadTemplate(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context writeHeader(String name, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context write(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context write(String s, int start, int len) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context write(char[] values, int start, int len) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context write(byte[] bytes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context write(byte[] bytes, int start, int len) {
		// TODO Auto-generated method stub
		return null;
	}

}
