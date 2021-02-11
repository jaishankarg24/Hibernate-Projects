package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Employee;
import com.abc.service.EmployeeService;

@WebServlet("/displayData")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Request received");
		int label = Integer.parseInt(request.getParameter("label"));
		System.out.println(label);

		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = employeeService.getEmployeeDetails(label);

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>ResultPage</title></head>");
		out.println("<body><center>");
		out.println("<table border='3'>");
		out.println("<tr>");
		out.println("<th>ENO</th><th>ENAME</th><th>EAGE</th><th>ESALARY</th><th>EADDRESS</th>");
		out.println("</tr>");

		for (Employee employee : employees) {

			out.println("<tr>");

			out.println("<td>" + employee.getEid() + "</td>");
			out.println("<td>" + employee.getEname() + "</td>");
			out.println("<td>" + employee.getEage() + "</td>");
			out.println("<td>" + employee.getEsalary() + "</td>");
			out.println("<td>" + employee.getEaddress() + "</td>");

			out.println("</tr>");

		}
		out.println("</table></center></body></html>");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
		requestDispatcher.include(request, response);

	}

}
