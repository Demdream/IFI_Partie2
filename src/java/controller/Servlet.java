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

/**
 *
 * @author PSDT0769
 */
@WebServlet(name = "Servlet",
        loadOnStartup = 1,
        urlPatterns = {"/afficheProduit"})

public class Servlet extends HttpServlet {

    
    @EJB
    private MobilephonesFacade mobilephonesFacade;

    @Override
    public void init() throws ServletException {
         
        

        
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
        

        // if afficheProduit.jsp page is requested

          if(userPath.equals("/afficheProduit")){
               
                String clear = request.getParameter("clear");
                
                if ((clear != null) && clear.equals("true")) {

                Panier phone = (Panier) session.getAttribute("phone");
                phone.clear();
            }
                
                
  
                userPath = "/afficheProduit";
            

            } 
            
            
           

//              if clique Ajouter au panier

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
        
      

        // if clique Ajouter au panier
        if (userPath.equals("/afficheProduit")) {
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
