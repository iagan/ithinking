package org.ithinking.spring.tengine;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.View;

public abstract class AbstractTengineView extends WebApplicationObjectSupport implements View, BeanNameAware {

}
