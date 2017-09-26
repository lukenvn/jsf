package com.luke.example.listener;

import com.luke.example.bean.HelloBean;
import com.sun.faces.util.Util;

import javax.el.ELContext;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.view.ViewDeclarationLanguage;

/**
 * Created by user1 on 09/22/2017.
 */


public class InvokeApplicationListener  implements PhaseListener {
    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = context.getViewRoot();
        HelloBean helloBean = getBean("helloBean", HelloBean.class);
        ViewHandler viewHandler = Util.getViewHandler(context);
        ViewDeclarationLanguage vhl = viewHandler.getViewDeclarationLanguage(context, context.getViewRoot().getViewId());
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        HelloBean helloBean = getBean("helloBean", HelloBean.class);
    }
    public static <T> T getBean(final String beanName, final Class<T> clazz) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        return (T) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, beanName);
    }
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.INVOKE_APPLICATION;
    }
}
