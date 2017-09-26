package com.luke.example.event;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 * Created by user1 on 09/22/2017.
 */
public class PreRenderComponentImpl implements SystemEventListener {
    @Override
    public void processEvent(SystemEvent systemEvent) throws AbortProcessingException {
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = context.getViewRoot();
    }

    @Override
    public boolean isListenerForSource(Object o) {
        return true;
    }
}
