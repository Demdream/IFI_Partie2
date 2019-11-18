<%-- 
    Document   : afficheProduit
    Created on : 30 oct. 2019, 16:26:59
    Author     : GLZK2747
--%>

<%@page import="Modele.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%!
    ArrayList<Produit> stock = new ArrayList<>();%>
   <% 
    stock.add( new Produit( 14 , "Samsung Galaxy S10+", 1000, 20, "Samsung.jpg" )); 
    stock.add( new Produit( 20 , "Apple iPhone X", 899, 20, "iphone.jpg" ));
    stock.add( new Produit( 35 , "Huawei P30 Pro", 649, 20, "Huawei.jpg" )); 
%>

        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" /> 
        <title>JSP Page</title>
        
   
    </head>
    <body>
       
        <center><h1>Vente de téléphone en ligne</h1>
        <center><h2> Liste des téléphones disponibles:</h2>
       
            
     
        <table>
            <thead>
                <tr>
                    <th></th>
                    <th>Reference</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Quantite</th>
                    
                </tr>
                
            </thead>
            
            <tbody>
                

                <% for ( int i = 0; i< stock.size(); i++){%>
                
                <tr> 

                    <td><img src=<%="photos/" + stock.get(i).getImage()%> </td>                   
                    <td><%=stock.get(i).getRef()%></td>
                    <td><%=stock.get(i).getNom()%></td>
                    <td><%=stock.get(i).getPrix()%></td>
                    <td><%=stock.get(i).getQuantite()%></td>
                </tr>
                
                <%}%>
            </tbody>
            
        </table>
        
        
        
    </body>
</html>
