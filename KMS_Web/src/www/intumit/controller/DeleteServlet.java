package www.intumit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.intumit.entity.Billboard;
import www.intumit.entity.KMSException;
import www.intumit.service.BillboardService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<String> errors = new ArrayList<>();
		String id = request.getParameter("id");
		
		if(id == null || id.length() == 0) {
			errors.add("id未取得值");
		}
		if(errors.isEmpty()) {
			try {
				Billboard b = new Billboard();
				b.setId(Integer.valueOf(id));
				BillboardService service = new BillboardService();
				service.delete(b);			
				request.setAttribute("billboard", b);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);						
				return;			
			}catch(KMSException e) {
				this.log(e.toString(), e);
				errors.add(e.getMessage());
			}
		}	
		request.setAttribute("errors", errors);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
