<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
a:link {
  color: red;
}
/* visited link */
a:visited {
  color: green;
}

/* mouse over link */
a:hover {
  color: #FF6600;
}

/* selected link */
a:active {
  color: blue;
}

body { 
    background: #b8b894; 
}
input[type="password"], input[type="text"],select{
  border: 1px solid #a1a3a3;
  color: #888800;
  height: 25px;
  padding-left: 37px;
  width: 240px;
}
input[type="password"]:focus, input[type="text"]:focus {
  box-shadow: 0 0 4px 1px rgba(55, 166, 155, 0.3);
  outline: 0;
   border: 3px solid #555;
}
/* input[type=text]:focus {
    border: 3px solid #555;
} */
input[select]:focus {
  box-shadow: 0 0 4px 1px rgba(55, 166, 155, 0.3);
  outline: 0;
    border: 3px solid #555;
}

/* table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 70%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
} */
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 6px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    margin: 4px 2px;
    font-size: 12px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    border-radius: 6px 6px 6px 6px;
}

.button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #008CBA;
}

.button1:hover {
    background-color: #008CBA;
    color: white;
}

</style>
</html>