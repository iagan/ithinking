package org.ithinking.spring.tengine;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

public class TengineViewResolver extends AbstractCachingViewResolver implements Ordered {

	private static final Logger vrlogger = LoggerFactory.getLogger(TengineViewResolver.class);

	private Class<? extends AbstractTengineView> viewClass = TengineView.class;

	public static final String REDIRECT_URL_PREFIX = "redirect:";
	public static final String FORWARD_URL_PREFIX = "forward:";
	
	private String prefix;
	private String suffix;

	private boolean redirectContextRelative = true;
	private boolean redirectHttp10Compatible = true;

	private String[] viewNames = null;
	private String[] excludedViewNames = null;
	private int order = Integer.MAX_VALUE;

	public String[] getViewNames() {
		return this.viewNames;
	}

	public String[] getExcludedViewNames() {
		return this.excludedViewNames;
	}

	public void setRedirectHttp10Compatible(final boolean redirectHttp10Compatible) {
		this.redirectHttp10Compatible = redirectHttp10Compatible;
	}

	public boolean isRedirectHttp10Compatible() {
		return this.redirectHttp10Compatible;
	}
	

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

	@Override
	public int getOrder() {
		return order;
	}

	protected boolean canHandle(final String viewName, final Locale locale) {
		final String[] viewNamesToBeProcessed = getViewNames();
		final String[] viewNamesNotToBeProcessed = getExcludedViewNames();
		return ((viewNamesToBeProcessed == null || PatternMatchUtils.simpleMatch(viewNamesToBeProcessed, viewName))
				&& (viewNamesNotToBeProcessed == null
						|| !PatternMatchUtils.simpleMatch(viewNamesNotToBeProcessed, viewName)));
	}

	public boolean isRedirectContextRelative() {
		return this.redirectContextRelative;
	}

	@Override
	protected View createView(final String viewName, final Locale locale) throws Exception {
		String info = null;
		if (!canHandle(viewName, locale)) {
			info = "[TENGINE] View \"{}\" cannot be handled by ThymeleafViewResolver. Passing on to the next resolver in the chain.";
			vrlogger.trace(info, viewName);
			return null;
		}
		if (viewName.startsWith(REDIRECT_URL_PREFIX)) {
			info = "[TENGINE] View \"{}\" is a redirect, and will not be handled directly by TengineViewResolver.";
			vrlogger.trace(info, viewName);
			final String redirectUrl = viewName.substring(REDIRECT_URL_PREFIX.length());
			final RedirectView view = new RedirectView(redirectUrl, isRedirectContextRelative(),
					isRedirectHttp10Compatible());
			view.setApplicationContext(getApplicationContext());
			return view;
		}
		if (viewName.startsWith(FORWARD_URL_PREFIX)) {
			info = "[TENGINE] View \"{}\" is a forward, and will not be handled directly by TengineViewResolver.";
			vrlogger.trace(info, viewName);
			final String forwardUrl = viewName.substring(FORWARD_URL_PREFIX.length());
			return new InternalResourceView(forwardUrl);
		}
		info = "[TENGINE] View {} will be handled by TengineViewResolver and a {} instance will be created for it";
		vrlogger.trace(info, viewName, this.viewClass.getSimpleName());
		return loadView(viewName, locale);
	}

	@Override
	protected View loadView(String viewName, Locale locale) throws Exception {
		final AutowireCapableBeanFactory beanFactory = getApplicationContext().getAutowireCapableBeanFactory();
		return null;
	}

}
