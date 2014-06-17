package com.a.ws;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="redirect",urlPatterns={"/usuario/*"})
public class ServletRedirect extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String context = req.getContextPath();
		String path = req.getPathInfo();
		String id = path.substring(path.indexOf('/') + 1);
		resp.sendRedirect(context+"/index.html#usuario/"+id);
	}
	
}
