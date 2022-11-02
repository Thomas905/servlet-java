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
 * Servlet implementation class CreationProduit
 */
public class CreationProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreationProduit() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String code = request.getParameter("code");
		double price = Double.valueOf(request.getParameter("prix"));
		HttpSession session = request.getSession();
		Produit p = new Produit();
		p.setCode(code);
		p.setNom(nom);
		p.setPrice(price);
		List<Produit> produits;
		if(session.getAttribute("produits")!=null) {
			produits = (ArrayList<Produit>)session.getAttribute("produits");
			
		}else {
			produits = new ArrayList<Produit>();
			session.setAttribute("produits", produits);
		}
		if(!produits.contains(p)) {
			produits.add(p);
		}
		response.sendRedirect("admin.jsp");
	}

}