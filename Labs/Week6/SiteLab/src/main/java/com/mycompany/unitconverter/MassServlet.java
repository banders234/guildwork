/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unitconverter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "MassServlet", urlPatterns = {"/MassServlet"})
public class MassServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MassServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MassServlet at " + request.getContextPath() + "</h1>");
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
        double amount = Double.parseDouble(request.getParameter("amount"));
        String originalUnit = request.getParameter("origUnit");
        String newUnit = request.getParameter("newUnit");
        double conversion=0;
        switch (originalUnit) {
            case "Pounds":
                switch(newUnit) {
                    case "Pounds":
                        conversion=amount;
                        break;
                    case "Kilograms":
                        conversion= amount/2.2;
                        break;
                    default:
                        break;
                }
                break;
            case "Kilograms":
                switch(newUnit) {
                    case "Pounds":
                        conversion=amount*2.2;
                        break;
                    case "Kilograms":
                        conversion= amount;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        request.setAttribute("amount", amount);
        request.setAttribute("origUnit", originalUnit);
        request.setAttribute("newUnit", newUnit);
        request.setAttribute("unitType", "Mass");
        request.setAttribute("conversionAmount", conversion);
        RequestDispatcher rd = request.getRequestDispatcher("unitconverter/results.jsp");
        rd.forward(request, response);
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
