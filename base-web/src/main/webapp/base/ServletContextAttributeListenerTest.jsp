<%@ page import="com.esther.code.web.context.listener.TestBindingBean" %>
<%@ page import="com.esther.code.web.context.listener.TestActivationBean" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>监听域对象中属性的变更的监听器</title>
</head>

<body>
<h1>监听域对象中属性的变更的监听器</h1>
<p>域对象中属性的变更的事件监听器就是用来监听 ServletContext, HttpSession, HttpServletRequest 这三个对象中的属性变更信息事件的监听器。 　　
    　　这三个监听器接口分别是ServletContextAttributeListener, HttpSessionAttributeListener
    和ServletRequestAttributeListener，这三个接口中都定义了三个方法来处理被监听对象中的属性的增加，删除和替换的事件，
    同一个事件在这三个接口中对应的方法名称完全相同，只是接受的参数类型不同。</p>
<%
    //往application域对象中添加属性
    application.setAttribute("name", "hello");
    //替换application域对象中name属性的值
    application.setAttribute("name", "hello world");
    //移除application域对象中name属性
    application.removeAttribute("name");

    //往session域对象中添加属性
    session.setAttribute("user", "rose");
    //替换session域对象中user属性的值
    session.setAttribute("user", "jack");
    //移除session域对象中aa属性
    session.removeAttribute("user");

    //往request域对象中添加属性
    request.setAttribute("age", "15");
    //替换request域对象中age属性的值
    request.setAttribute("age", "18");
    //移除request域对象中aa属性
    request.removeAttribute("age");

    //将javabean对象绑定到Session中
    session.setAttribute("bindingBean", new TestBindingBean("孤傲苍狼"));
    //从Session中删除javabean对象
    session.removeAttribute("bindingBean");
%>

一访问JSP页面，HttpSession就创建了，创建好的Session的Id是：${pageContext.session.id}
<hr/>
<%
    session.setAttribute("activationBean", new TestActivationBean("孤傲苍狼"));
%>
</body>
</html>
