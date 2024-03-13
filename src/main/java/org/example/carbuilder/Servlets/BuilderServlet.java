package org.example.carbuilder.Servlets;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.carbuilder.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "car", value = "/carServlet")
public class BuilderServlet extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       // Retrieve the list of cars from your data source
       List<Car> cars = new ArrayList<>();

       // Execute a SQL query to select all records from the car table
       DB.selectAllCars(cars);

       // Convert cars list to JSON
       Gson gson = new Gson();
       String jsonCars = gson.toJson(cars);

       // Set content type and write JSON to response
       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
       response.getWriter().write(jsonCars);
   }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String owner = (String) request.getParameter("ownerName");
        String color = (String) request.getParameter("color");
        String directorType = (String) request.getParameter("directorType");


        CarDirector director = new CarDirector(new ConcreteCarBuilder());
        Car car;
        switch (directorType) {
            case "sport":
                car = director.constructSportCar(owner, color);
                break;
            case "economy":
                car = director.constructEconomyCar(owner, color);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + directorType);
        }

        DB.insertCar(car);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

}