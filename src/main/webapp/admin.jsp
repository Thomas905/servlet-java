<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ page import="java.util.ArrayList,java.util.List,com.nextu.app.beans.Produit" %>
<%@ page import="java.util.ArrayList,java.util.List,com.nextu.app.beans.User" %>

<%
  List<Produit> produits = new ArrayList<Produit>();
  if(session.getAttribute("produits")!=null){
	  produits = (ArrayList<Produit>)session.getAttribute("produits");
  }
%>

<%
  List<User> users = new ArrayList<User>();
  if(session.getAttribute("users")!=null){
	  users = (ArrayList<User>)session.getAttribute("users");
  }
%>
<div class="container-fluid">
    <div class="row">
      <aside class="col-md-2 d-none d-md-block bg-light sidebar">
        <div class="sidebar-sticky">

          <h6 class="sidebar-heading">
            <span>Menu</span>
          </h6>

          <ul class="nav flex-column">
            <li class="nav-item">
              <a class="nav-link active" href="admin.jsp">
                <i class="fa fa-tachometer"></i>
                Dashboard
                <span class="badge badge-primary">14</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="form.jsp">
                <i class="fa fa-pencil-square-o"></i> Enregistrer un produit
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="formuser.jsp">
                <i class="fa fa-pencil-square-o"></i> Enregistrer un utilisateur
              </a>
            </li>
            
          </ul>
        
        </div>
      </aside>
      <main class="col-md-10 ml-sm-auto col-lg-10 pt-3 px-4">

        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
          <h1 class="h2"><i class="fa fa-tachometer"></i> Dashboard</h1>
          <div class="btn-toolbar mb-2 mb-md-0">
            <div class="btn-group mr-2">
              <button class="btn btn-sm btn-primary">Share</button>
              <button class="btn btn-sm btn-primary">Export</button>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12 pr-0 mb-3">
            <div class="card-collapsible card">
              <div class="card-header">
                Table <i class="fa fa-caret-down caret"></i>
              </div>
              <div class="card-body">
                <table class="table">
                  <thead class="thead bg-primary text-white">
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Code</th>
                      <th scope="col">Nom du produit</th>
                      <th scope="col">Prix</th>
                      <th scope="col">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% for(Produit p :produits) { %>
                    <tr>
                      <th scope="row">1</th>
                      <td><%= p.getCode() %></td>
                      <td><%= p.getNom() %></td>
                      <td><%= p.getPrice() %></td>
                      <td><a href="http://localhost:8080/servlet-0.0.1-SNAPSHOT/detailsProduit?code=<%= p.getCode() %>" >Visualiser</a>
                      <a href="http://localhost:8080/servlet-0.0.1-SNAPSHOT/deleteProduit?code=<%= p.getCode() %>" >Supprimer</a></td>
                      
                    </tr>
                  <%
                    }
                  %>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12 pr-0 mb-3">
            <div class="card-collapsible card">
              <div class="card-header">
                Table <i class="fa fa-caret-down caret"></i>
              </div>
              <div class="card-body">
                <table class="table">
                  <thead class="thead bg-primary text-white">
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Firstname</th>
                      <th scope="col">Lastname</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% for(User u :users) { %>
                    <tr>
                      <th scope="row">1</th>
                      <td><%= u.getFirstname() %></td>
                      <td><%= u.getLastname() %></td>
                    </tr>
                  <%
                    }
                  %>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
  </div>
</body>
</html>