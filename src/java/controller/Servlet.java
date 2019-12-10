/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modele.Panier;
import Entity.Mobilephones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;
import Session.MobilephonesFacade;
import javax.servlet.ServletConfig;

/**
 *
 * @author PSDT0769
 */
@WebServlet(name = "Servlet",
        loadOnStartup = 1,
        urlPatterns = {"/afficheProduit", 
                       "/voirTelephone",
                       "/ajoutPanier",
                       "/validerPanier",
                       "/verification",
                       "/achat"})

public class Servlet extends HttpServlet {

    private String frais;
    
    @EJB
    private MobilephonesFacade mobilephonesFacade;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
         
        super.init(servletConfig);

        // initialize servlet with configuration information
        frais = servletConfig.getServletContext().getInitParameter("fraisLivraison");

        
        // store mobilephones list in servlet context
        getServletContext().setAttribute("telephones", mobilephonesFacade.findAll());
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Mobilephones selectedMobilephones;
        

        // si page afficheProduit est appelé

          if(userPath.equals("/afficheProduit")){
              
              // get categoryId from request
            String mobilephoneId = request.getQueryString();

            if (mobilephoneId != null){
              
               // get téléphones
                selectedMobilephones = mobilephonesFacade.find(Short.parseShort(mobilephoneId));

                // placer téléphones sélectionnés dans le scope d'une session
                session.setAttribute("selectedMobilephones", selectedMobilephones);

            } 
                
            } else if (userPath.equals("/voirTelephone")) {

            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {

                Panier phone = (Panier) session.getAttribute("phone");
                phone.clear();
            }

            userPath = "/afficheProduit";
            
            
            }else if (userPath.equals("/verification")) {

            Panier phone = (Panier) session.getAttribute("phone");
            
            phone.calculateTotal(frais);


           

            // forward to checkout page and switch to a secure channel

        }
            
            

            // use RequestDispatcher to forward request internally
            String url = "/" + userPath + ".jsp";

            try {
                request.getRequestDispatcher(url).forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
     
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Panier phone = (Panier) session.getAttribute("phone");
        
        // si  Ajout au panier
        if (userPath.equals("/ajoutPanier")) {
            // TODO: ajouter n produit au panier
        
            if (phone == null){
                
                phone = new Panier();
                session.setAttribute("phone", phone);
            }
                //
                
                String mobilephoneId = request.getParameter("moblephoneId");
                
             if (!mobilephoneId.isEmpty()) {
                 
                  Mobilephones mobilephones = mobilephonesFacade.find(Integer.parseInt(mobilephoneId));
                  phone.addItem(mobilephones);
             }
                
            userPath = "/afficheProduit";
            
            
        
        // if clique Passer commande
        
    } else if (userPath.equals("/validerPanier")) {

            // get input from request
            String mobilephoneId = request.getParameter("mobilephoneId");
            String quantity = request.getParameter("quantity");

            Mobilephones mobilephones = mobilephonesFacade.find(Integer.parseInt(mobilephoneId));
            phone.ajout(mobilephones, quantity);

            userPath = "/afficheProduit";


        // si achat panier
        }else if (userPath.equals("/achat")) {
            // TODO: appeller méthode achat

            userPath = "/confirmation";
        }

        // use RequestDispatcher to forward request internally
        String url = "/" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    }    
