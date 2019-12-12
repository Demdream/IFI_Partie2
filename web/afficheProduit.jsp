
<%@page import="Modele.Panier"%>
<%@page import="Modele.Stock"%>
<%@page import="Modele.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="stockSession" class="Modele.Stock" scope="session" ></jsp:useBean>
<jsp:useBean id="panierSession" class="Modele.Panier" scope="session" ></jsp:useBean> 


 <%! 
       Panier panier = new Panier();
       Stock stock = new Stock();
       boolean affichePopUp = false ;
 %>
 
                     <%-- Première session quand l'utilisateur clique sur le bouton ajouter panier, on dit qu'il doit faire
                     appel à la méthode ajouter panier qui existe dans la classe Panier
                     Deuxième session quand l'utilisateur clique sur le bouton passer commande
                     on lui dit qu'il doit faire appel à la méthode modifier stock qui existe dans la classe Stock

<jsp:useBean id="panierSession" class="Modele.Panier" scope="session" ></jsp:useBean> 


 <%! 
       Panier panier = new Panier();
       Stock stock = new Stock();
       boolean affichePopUp = false ;
 %>
 
                     <%-- Première session quand l'utilisateur clique sur le bouton ajouter panier, on dit qu'il doit faire
                     appel à la méthode ajouter panier qui existe dans la classe Panier
                     Deuxième session quand l'utilisateur clique sur le bouton passer commande
                     on lui dit qu'il doit faire appel à la méthode modifier stock qui existe dans la classe Stock
                     et mettre le panier qui existe dans la session panier à 0--%>
<%       
    
              if (request.getParameter("reference") != null){
                int ref = Integer.parseInt(request.getParameter("reference")); 

                panier = (Panier)session.getAttribute("panierSession");
                stock = (Stock)session.getAttribute("stockSession");
      //lorsque je clique sur le boutton ajouter au panier je récupère la référence du produit ensuite je récupère le panier et le stock qui se trouve dans la seesion 
      // je vérifie que mon produit est bien disponible dans le stock  si c'est oui il l'ajoute sinon il affiche le POPUP
                boolean produitDisponible  = panier.verifierDisponibiliteProduit(ref , stock);
                if ( produitDisponible ){
                  panier.ajouterAuPanier(ref);
                  session.setAttribute("panierSession", panier);  
                }
                else { 
                    affichePopUp = true; 
                }
              }
      // quand je clique sur le bouton passer la commande, il mets à jour le stock et il vide le panier dans la session          
          if ( request.getParameter("panier") != null){
              panier = (Panier)session.getAttribute("panierSession");
              stock = (Stock)session.getAttribute("stockSession");
              stock.modifierStock(panier);
              panier = new Panier ();
              session.setAttribute("panierSession", panier);     
           }
 %>
 
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" /> 
        <title>JSP Page</title>
     <style>   
   body {
  background-color: lightblue;
}
</style>
    </head>
    
    <body>
       
        <center><h1>Vente de téléphone en ligne</h1>
        <center><h2> Liste des téléphones disponibles:</h2>
       
            
           
        <table>
            <%=panier%>
            <thead>
                <tr>
                    <th>Image</th>
                    <th>Reference</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Quantite</th>
                    <th></th>
                    
                </tr>
                
            </thead>
            
            <tbody>
                

                <% 
                  Stock stock = (Stock)session.getAttribute("stockSession");                 
                  for ( int i = 0; i< stock.getListeProduit().size(); i++){%>
                
                <tr> 

                    <td><img src=<%="photos/" + stock.getListeProduit().get(i).getImage()%> </td>                   
                    <td><%=stock.getListeProduit().get(i).getRef()%></td>
                    <td><%=stock.getListeProduit().get(i).getNom()%></td>
                    <td><%=stock.getListeProduit().get(i).getPrix()%></td>
                    <td><%=stock.getListeProduit().get(i).getQuantite()%></td>
            
                <from action="afficheProduit.jsp" method="POST">
                    <input type="hidden" value="<%=stock.getListeProduit().get(i).getRef()%>" name="reference">
                
                    <td> <INPUT TYPE="submit" VALUE="Ajouter au panier"></td>
                    
                    <% if (affichePopUp) {  // javascript%>
                         <script> alert("Le produit n'est plus disponible"); </script>  
                    <% }

                    affichePopUp =false;%> 
                
                </form>
                </tr>
            
                <%}%>
            </tbody>
            
        </table>
            
            <br></br>
                 <form action="afficheProduit.jsp" method="POST">
                     <INPUT TYPE="hidden" VALUE="<%=true%>" name="panier">
                     <td> <INPUT TYPE="submit" VALUE="Passer la commande"></td>
                 </form>

    </body>
</html>
