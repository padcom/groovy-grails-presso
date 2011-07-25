
<%@ page import="myfirstapp.Foo" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'foo.label', default: 'Foo')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'foo.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'foo.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="someField" title="${message(code: 'foo.someField.label', default: 'Some Field')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fooInstanceList}" status="i" var="fooInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${fooInstance.id}">${fieldValue(bean: fooInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: fooInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: fooInstance, field: "someField")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${fooInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
