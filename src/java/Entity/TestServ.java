/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PSDT0769
 */
@WebServlet(name = "TestServ", urlPatterns = {"/TestServ"})
public class TestServ extends HttpServlet {

    @EJB
    private ProductFacadeLocal mobilephonesFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("reference") == null) {
            mobilephonesFacade.init();
            ArrayList<Integer> panier = new ArrayList<>();
            request.getSession().setAttribute("panier", panier);
        } else {
        int ref = Integer.parseInt(request.getParameter("ID"));
        ArrayList panier = (ArrayList)request.getSession().getAttribute("panier");
        panier.add(ref);

        
        if (request.getParameter("commande") == "true"){
        
        List<Product> name = mobilephonesFacade.findAll();
        for (Product p : name) {
        p.setPrix(1000);
        mobilephonesFacade.edit(p);
        
        } 
        }
        //for ( Object atr : panier){
        //    int atrInt = (Integer)atr; 
        //        List<Product> name = mobilephonesFacade.findAll();
        //        for (Product p : name){
        //        if (p.getId() == atrInt){
        //            p.deduitQuant();
        //            mobilephonesFacade.edit(p);
        //        }
        //        }
            //mobilephonesFacade.find(atrInt).setPrix(1000);
      //  }
        }
        ArrayList panier = (ArrayList)request.getSession().getAttribute("panier");
        List<Product> name = mobilephonesFacade.findAll();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServ</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(panier);

            out.println("<table align=center border=\"1\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Référence</th>");
            out.println("<th>Nom</th>");
            out.println("<th>Prix</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for (Product p : name) {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getName()+ "</td>");
                out.println("<td>" + p.getPrix() + "</td>");
                out.println("<td>" + p.getQuantity() + "</td>");
    
                out.write("<form action=\"#\" method=\"POST\">\n");
                out.write("<input type=\"hidden\" value=\"true");
                out.write("\" name=\"reference\">\n");
                out.write("<input type=\"hidden\" value=\""+ p.getId()+"");
                out.write("\" name=\"ID\">\n");
                out.write("\n");
                out.write("<td> <INPUT TYPE=\"submit\" VALUE=\"Ajouter au panier\"></td>\n");
                out.write("\n");
                out.write("</form>");
                
                out.println("</tr>");

            }
            
                  out.write("                 <form action=\"#\" method=\"POST\">\n");
      out.write("                     <INPUT TYPE=\"hidden\" VALUE=\"true");
      out.write("\" name=\"commande\">\n");
      out.write("                     <td> <INPUT TYPE=\"submit\" VALUE=\"Passer la commande\"></td>\n");
 
      out.write("                 </form>\n");
            out.println("</body>");
         
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
