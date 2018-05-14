package com.esther.code.api.schema.service.adapter.springmvc;

import com.esther.code.api.schema.adapter.springmvc.Controller;
import com.esther.code.api.schema.adapter.springmvc.HandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author esther
 * 2018-05-04 14:22
 * $DESCRIPTION}
 */

public class DispatcherServlet {
    public static List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    public DispatcherServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
    }

    public void doDispatch(Controller controller) {
        //此处模拟SpringMVC从request取handler的对象，仅仅new出，可以出，
        //不论实现何种Controller，适配器总能经过适配以后得到想要的结果
//      HttpController controller = new HttpController();
//      AnnotationController controller = new AnnotationController();
//      SimpleController controller = new SimpleController();
        //得到对应适配器
        HandlerAdapter handlerAdapter = getHandlerAdapter(controller);
        //通过适配器执行对应的controller对应方法
        handlerAdapter.handle(controller);
    }

    public HandlerAdapter getHandlerAdapter(Controller controller) {
        for (HandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(controller)) {
                return handlerAdapter;
            }
        }
        return null;
    }
}
