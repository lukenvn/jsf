package com.luke.example.listener;

import com.luke.example.event.PreRenderComponentImpl;
import com.luke.example.event.PreRenderViewEventImpl;

import javax.el.ELContext;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.*;

/**
 * Created by user1 on 09/22/2017.
 */


public class RestoreViewPhaseListener implements PhaseListener {
    @Override
    public void afterPhase(PhaseEvent phaseEvent) {

        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = context.getViewRoot();
        viewRoot.subscribeToViewEvent(PreRenderViewEvent.class,new PreRenderViewEventImpl());
        viewRoot.subscribeToViewEvent(PreRenderComponentEvent.class,new PreRenderComponentImpl());
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
    }
    public static <T> T getBean(final String beanName, final Class<T> clazz) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        return (T) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, beanName);
    }
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
