<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Sistema de Filmes</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">

  </head>

  <body>

 	<jsp:include page="/resources/templates/navbar.jsp"/>

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>P�gina inicial</h1>
      </div>
      <p class="lead">Sistema did�tico JAVA para web.</p>
      <p>Desenvolvido por: - <a href="http://www.3asolucoes.com.br">3A Solu��es</a></p>
    </div>

 	<jsp:include page="/resources/templates/rodape.jsp"/>

    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
