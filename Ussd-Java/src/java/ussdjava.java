/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author markn
 */
@WebServlet(urlPatterns = {"/ussdjava"})
public class ussdjava extends HttpServlet {
    String sessionId, serviceCode, phoneNumber, text, responseText;

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
        response.setContentType("text/plain");
        responseText = "CON This is a test";
        if (text == null)
            text = "";
        if (text== ""){
        responseText = "CON What would you want to check \n";
        responseText += "1. My Account \n";
        responseText += "2. My Phone number";
        } else if (text == "1"){
            responseText = "CON Choose account information you want to view \n";
            responseText += "1. Account number \n";
            responseText += "2. Account balance";
        } else if (text == "2"){
            responseText = "END Your phone number is "+phoneNumber;
        } else if (text == "1*1"){
            String accountNumber = "ACC1001";
            responseText = "END Your account number is "+accountNumber;
        } else if (text == "1*2"){
            String balance = "KES 10,000";
            responseText = "END Your balance is "+balance;
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(responseText);
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
        sessionId = request.getParameter("sessionId");
        serviceCode = request.getParameter("serviceCode");
        phoneNumber = request.getParameter("phoneNumber");
        text = request.getParameter("text");
        
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
