<%@ page import="org.example.carbuilder.Car" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Builder CRUD</title>
</head>
<body>
<h2>Car Builder CRUD</h2>

<h3>Add Car</h3>
<form action="carServlet" method="post">
    <label>Owner Name:
        <input type="text" name="ownerName" placeholder="Enter your name">
    </label>
    <label>Color:
        <input type="text" name="color" placeholder="Enter color">
    </label>
    <select name="directorType">
        <option value="economy">Economic Car</option>
        <option value="sport">Sport Car</option>
    </select>
    <input type="submit" value="Add Car">
</form>

<h3>Cars List</h3>
<table id="carTable">
    <thead>
    <tr>
        <th>Owner Name</th>
        <th>Model</th>
        <th>Color</th>
        <th>Engine</th>
        <th>Fuel Type</th>
    </tr>
    </thead>
    <tbody id="carTableBody">
    </tbody>
</table>

<hr>
<%--<h3>Delete Car</h3>--%>
<%--<form action="carServlet/delete" method="post">--%>
<%--    <label>Index:</label>--%>
<%--    <input type="text" name="index" placeholder="Enter index to delete">--%>
<%--    <input type="submit" value="Delete Car">--%>
<%--</form>--%>
</body>
<script src="script.js"></script>
</html>