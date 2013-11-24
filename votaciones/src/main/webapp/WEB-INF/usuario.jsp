<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="votaciones.*"%>



<jsp:useBean id="usuarioDao" type="votaciones.UsuarioDao" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <title>Sistema de votaciones - Administración de usuarios</title>
    </head>
 
 
    <body>
        <form method="POST" action="usuario.do">
            Usuario: <input type="text" name="usuario" />
            Clave: <input type="text" name="clave" />
            <input type="submit" value="Agregar usuario" />
        </form>
 
        <hr><ol> 
        <% for (Usuario usuario : usuarioDao.getAll()) { %>
            <li> <%= usuario.getUsuario() %> [<%= usuario.getClave() %>] </li>
        <% } %>
        </ol><hr>

</body>
</html>