<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
                    <img src="#" id="logo" alt="logo">
                </a>

                <img src="#" id="logoText" alt="Mobilephones Store">
            </div>

            <div id="singleColumn">

                
               
                <p>Liste des téléphones disponibles</p>

                <div id="actionBar">
                   
                    <a href="#" class="bubble hMargin">Passer la commande</a>
 
                </div>

                <h4 id="subtotal">[ subtotal: xxx ]</h4>

                <table id="mobilephonesTable">

                    <tr class="header">
                        <th>téléphone</th>
                        <th>nom</th>
                        <th>price</th>
                        <th>quantité</th>
                    </tr>

                    <tr>
                        <td class="lightBlue">
                            <img src="#" alt="mobilephones image">
                        </td>
                        <td class="lightBlue">[ nom téléphone ]</td>
                        <td class="lightBlue">[ prix ]</td>
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
                    </tr>

                    <tr>
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
                    </tr>

                </table>

            </div>
            <div id="footer">
                <hr>
                <p id="footerText">[ Mobilephones Store ]</p>
            </div>

        </div>
    </body>
</html>