/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Mobilephones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import Session.MobilephonesFacade;

/**
 *
 * @author PSDT0769
 */
@WebServlet(name = "Servlet",
        loadOnStartup = 1,
        urlPatterns = {"/afficheProduit",
            "/viewTelephone",
            "/ajoutPanier"})

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
        Mobilephones selectedMobilephones;

        // if afficheProduit.jsp page is requested
        if (userPath.equals("/afficheProduit")) {

            // get mobilephonesId from request
            String mobilephonesId = request.getQueryString();
            if (mobilephonesId != null) {
                //get selected mobilephones
                selectedMobilephones = mobilephonesFacade.find(Short.parseShort(mobilephonesId));
                
                request.setAttribute("selectedMobilephones", selectedMobilephones);
            }
            
            // if page afficheProduit est appelé
            else if(userPath.equals("/viewTelephone")){
               
                String clear = request.getParameter("clear");
                
                
                
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

        // if clique Ajouter au panier
        if (userPath.equals("/ajoutPanier")) {
            // TODO: ajouter n produit au panier
        
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
