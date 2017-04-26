package code.controllers;

import code.model.pojo.StorageUnit;
import code.model.pojo.User;
import code.services.StorageUnitService;
import code.services.StorageUnitServiceImpl;
import code.services.UserService;
import code.services.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 22.04.2017.
 */
public class ListForAdminsServlet  extends HttpServlet {

    private static StorageUnitService storageUnitService = new StorageUnitServiceImpl();
    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", storageUnitService.getAllStorageUnits());
        req.setAttribute("users", userService.getAllUsers());

        getServletContext().getRequestDispatcher("/foradmins.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}