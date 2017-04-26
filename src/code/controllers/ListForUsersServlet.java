package code.controllers;

import code.model.pojo.StorageUnit;
import code.services.StorageUnitService;
import code.services.StorageUnitServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22.04.2017.
 */
public class ListForUsersServlet  extends HttpServlet {

    private static StorageUnitService storageUnitService = new StorageUnitServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", storageUnitService.getAllStorageUnits());
        getServletContext().getRequestDispatcher("/forusers.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
