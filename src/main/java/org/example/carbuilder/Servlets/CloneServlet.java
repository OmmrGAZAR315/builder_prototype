package org.example.carbuilder.Servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.carbuilder.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.example.carbuilder.DB.insertCar;


@WebServlet(name = "clone", value = "/cloneServlet")
public class CloneServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        BufferedReader reader = request.getReader();
        String carJson = reader.lines().collect(Collectors.joining());
//
        // Deserialize the JSON string into a Java object
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(carJson, Car.class);

        DB.insertCar((Car) car.clone());



    }
}