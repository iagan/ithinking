package org.ithinking.spring.tengine;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class HtmlResourceViewResolver extends UrlBasedViewResolver{

	public HtmlResourceViewResolver() {
		Class<?> viewClass = requiredViewClass();
		if (InternalResourceView.class == viewClass) {
			viewClass = JstlView.class;
		}
		setViewClass(viewClass);
	}


	/**
	 * This resolver requires {@link InternalResourceView}.
	 */
	@Override
	protected Class<?> requiredViewClass() {
		return InternalResourceView.class;
	}
	
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		InternalResourceView view = (InternalResourceView) super.buildView(viewName);
		//if (this.alwaysInclude != null) {
		//	view.setAlwaysInclude(this.alwaysInclude);
		//}
		view.setPreventDispatchLoop(true);
		return view;
	}
}
