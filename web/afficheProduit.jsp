<%-- 
    Document   : afficheProduit
    Created on : 3 déc. 2019, 13:12:03
    Author     : PSDT0769
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css">
        <title>JSP page</title>
    </head>
    <body>

        <div id="main">
            <div id="header">

                <a href="#">
                    <img src=${initParam.mobilephonesPhotoPath} id="logo" alt="logo">
                </a>

                <img src="#" id="logoText" alt="mobilephone store">
            </div>

            <div id="singleColumn">

                <c:choose>
                    <c:when test="${phone.numberOfItems > 1}">
                        <p>Votre panier contient ${phone.numberOfItems} items.</p>
                    </c:when>
                    <c:when test="${phone.numberOfItems == 1}">
                        <p>Votre panier contient ${phone.numberOfItems} item.</p>
                    </c:when>
                    <c:otherwise>
                        <p>Votre panier est vide.</p>
                    </c:otherwise>
                </c:choose>


                <div id="actionBar">


                    <a href="${value}" class="bubble hMargin">Passer votre commande</a>

                </div>
                <c:if test="${!empty phone && phone.numberOfItems != 0}">
                    <h4 id="subtotal">subtotal: &euro; ${phone.subtotal}</h4>

                    <table id="mobilephonesTable">

                        <tr class="header">
                            <th>téléphone</th>
                            <th>nom</th>
                            <th>prix</th>
                            <th>quantité</th>
                        </tr>
                        <c:forEach var="phoneItem" items="${phone.items}" varStatus="iter">

                            <c:set var="mobilephones" value="${phoneItem.mobilephones}"/>

                            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                <td class="lightBlue">
                                    <img src="${initParam.mobilephonesPhotoPath}${mobilephones.nom}.jpg"
                                         alt="mobilephones image">
                                </td>

                                <td>${mobilephones.nom}</td>
                                    
<!--                                <td class="lightBlue">[ nom téléphone ]</td>
                                <td class="lightBlue">[ prix ]</td>
                                <td class="lightBlue">-->

                                <td>
                                    &euro; ${phoneItem.total}
                                    <br>
                                    <span class="smallText">( &euro; ${mobilephones.prix} / unit )</span>
                                </td>

                                <td>                              
                                    <form action="afficheProduit.jsp" method="post">
                                        <input type="hidden"
                                               name="mobilephoneId"
                                               value="${mobilephones.id}">
                                        <input type="text"
                                               maxlength="2"
                                               size="2"
                                               value="${phoneItem.quantity}"
                                               name="quantity"
                                               style="margin:5px">
                                        <input type="submit"
                                               name="submit"
                                               value="Ajouter au panier">
                                    </form>
                                </td>
                            </tr>

                            <!--                    <tr>
                                                    <td class="white">
                                                        <img src="#" alt="mobilephones image">
                                                    </td>
                                                    <td class="white">[ mobilephones name ]</td>
                                                    <td class="white">[ prix ]</td>
                                                    <td class="white">
                            
                                                        <form action="ajoutPanier" method="post">
                                                            <input type="text"
                                                                   maxlength="2"
                                                                   size="2"
                                                                   value="1"
                                                                   name="quantity">
                                                            <input type="submit"
                                                                   name="submit"
                                                                   value="Ajouter au panier">
                                                        </form>
                                                    </td>
                                                </tr>
                            
                                                <tr>
                                                    <td class="lightBlue">
                                                        <img src="#" alt="mobilephones image">
                                                    </td>
                                                    <td class="lightBlue">[ product name ]</td>
                                                    <td class="lightBlue">[ price ]</td>
                                                    <td class="lightBlue">
                            
                                                        <form action="ajoutPanier" method="post">
                                                            <input type="text"
                                                                   maxlength="2"
                                                                   size="2"
                                                                   value="1"
                                                                   name="quantity">
                                                            <input type="submit"
                                                                   name="submit"
                                                                   value="Ajouter au panier">
                                                        </form>
                                                    </td>
                                                </tr>-->
                        </c:forEach>
                    </table>
                </c:if>
            </div>

        </div>
    </body>
</html>