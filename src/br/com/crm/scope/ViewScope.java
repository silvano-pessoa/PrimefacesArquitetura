package br.com.crm.scope;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.request.FacesRequestAttributes;

/**
 * classe que implementa um escopo do Spring para simular e disponibilizar a
 * utilização do ViewScoped do JSF para os Escopos do Spring. baseado em
 * http://javafaces.wordpress.com/2010/12/20/utilizando-spring-annotations/ e
 * http
 * ://cagataycivici.wordpress.com/2010/02/17/port-jsf-2-0s-viewscope-to-spring
 * -3-0/ http://www.harezmi.com.tr/spring-view-scope-for-jsf-2-users/
 * 
 * @author vitor
 * 
 */
public class ViewScope implements Scope {

	public static final String VIEW_SCOPE_CALLBACKS = "viewScope.callbacks";

	@SuppressWarnings("rawtypes")
	@Override
	public synchronized Object get(String name, ObjectFactory objectFactory) {
		Object instance = getViewMap().get(name);
		if (instance == null) {
			instance = objectFactory.getObject();
			getViewMap().put(name, instance);
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object remove(String name) {
		Object instance = getViewMap().remove(name);
		if (instance != null) {
			Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
			if (callbacks != null) {
				callbacks.remove(name);
			}
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void registerDestructionCallback(String name, Runnable runnable) {
		Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
		if (callbacks != null) {
			callbacks.put(name, runnable);
		}
	}

	public Object resolveContextualObject(String name) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(facesContext);
		return facesRequestAttributes.resolveReference(name);
	}

	@Override
	public String getConversationId() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(facesContext);
		return facesRequestAttributes.getSessionId() + "-" + facesContext.getViewRoot().getViewId();
	}

	private Map<String, Object> getViewMap() {
		if (FacesContext.getCurrentInstance() != null && FacesContext.getCurrentInstance().getViewRoot() != null
				&& FacesContext.getCurrentInstance().getViewRoot().getViewMap() != null) {
			return FacesContext.getCurrentInstance().getViewRoot().getViewMap();
		} else {
			return new HashMap<String, Object>();
		}
	}

}
