<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="Session.*" %>
<%@page import="Entity.*" %>
<%@page import="java.util.*" %>
<%-- 
    Document   : testdatabase
    Created on : 8 déc. 2019, 21:58:51
    Author     : PSDT0769
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%!  MobilephonesFacade monAbst;%>
        <% monAbst = new MobilephonesFacade();
            List<Mobilephones> monStock = monAbst.findAll();

            out.println(monStock);%>

       
   <%--     <sql:query var="result" dataSource="jdbc/ecommerce">
            SELECT * from mobilephones
        </sql:query>
            
        <table border="1">
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                    </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
       
        </table>  --%>
      
    </body>
</html>
