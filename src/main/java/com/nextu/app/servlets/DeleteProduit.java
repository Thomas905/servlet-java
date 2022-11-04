package com.nextu.app.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nextu.app.beans.Produit;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteProduit
 */
public class DeleteProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteProduit() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		Produit produitRecherche = null;
		List<Produit> produits = new ArrayList<>();
		String errorMessage = null;
		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("produits")!=null) {
			produits = (ArrayList<Produit>)session.getAttribute("produits");
		}
		
		if(code!=null) {
			produitRecherche = produits.stream()
					  .filter(produit -> produit.getCode().equals(code))
					  .findAny()
					  .orElse(null);
		if(produitRecherche!=null) {
			produits.remove(produitRecherche);
		}
		}
		response.sendRedirect("admin.jsp");
	}

}
