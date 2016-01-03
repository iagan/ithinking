package org.ithinking.spring.tengine;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.View;

public abstract class AbstractTengineView extends WebApplicationObjectSupport implements View, BeanNameAware {

	private String prefix;
	private String suffix;
	private String contentType;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
