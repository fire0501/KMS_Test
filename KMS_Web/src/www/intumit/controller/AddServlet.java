	package www.intumit.controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class AddServlet
 */
@WebServlet("/add.do")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<String> errors = new ArrayList<>();
		//1.取得request中的Form data
		String title = request.getParameter("title");
		String dataStart = request.getParameter("dataStart");
		String dataEnd = request.getParameter("dataEnd");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		if(title == null || title.length() == 0) {
			errors.add("必須輸入標題");
		}
		if(dataStart == null || dataStart.length() == 0) {
			errors.add("必須輸入發佈日期");
		}
		if(dataEnd == null || dataEnd.length() == 0) {
			errors.add("必須輸入截止日期");
		}
		if(name == null || name.length() == 0) {
			errors.add("必須輸入名稱");
		}
		if(content == null || content.length() == 0) {
			errors.add("必須輸入內容");
		}
		
		//2.若檢查無誤則呼叫商業邏輯
		if(errors.isEmpty()) {
			try {
				Billboard b = new Billboard();
				b.setTitle(title);
				b.setDateStart(dataStart);
				b.setDateEnd(dataEnd);
				b.setName(name);
				b.setContent(content);
				
				BillboardService service = new BillboardService();
				service.insert(b);
		//3.1成功
				request.setAttribute("billboard", b);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/add_ok.jsp");
				dispatcher.forward(request, response);						
				return;					
			}catch(KMSException e) {
				this.log(e.toString(), e);
				errors.add(e.getMessage());
			}
		}
		//3.2失敗
		request.setAttribute("errors", errors);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);		
	}
}
