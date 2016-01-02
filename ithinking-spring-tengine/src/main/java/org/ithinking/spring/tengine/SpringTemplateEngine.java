package org.ithinking.spring.tengine;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class SpringTemplateEngine implements MessageSourceAware, InitializingBean{
	
	private MessageSource messageSource = null;
    private MessageSource templateEngineMessageSource = null;

	@Override
	public void afterPropertiesSet() throws Exception {
//		  final SpringMessageResolver springMessageResolver = new SpringMessageResolver();
//	        springMessageResolver.setMessageSource(
//	                this.templateEngineMessageSource == null ? this.messageSource : this.templateEngineMessageSource);
//	        super.setDefaultMessageResolvers(Collections.singleton(springMessageResolver));
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public void setTemplateEngineMessageSource(final MessageSource templateEngineMessageSource) {
        this.templateEngineMessageSource = templateEngineMessageSource;
    }

}
