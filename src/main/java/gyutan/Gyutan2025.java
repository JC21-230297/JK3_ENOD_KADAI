package gyutan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apiClass.GetClu;

@WebServlet("/tan")
public class Gyutan2025 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Gyutan2025() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("doGet method.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 送られてきたデータを取得
		request.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");

		// paramを送ってCLUからデータを取得する
		String detected = GetClu.getLanguageText(param);

		// 結果（スキーム）をコンソールとWebブラウザにひょうじ
		System.out.println(detected);

		// CLUの応答に基づいてページを転送する
		if ("店舗紹介".equals(detected) || "ABOUT".equals(detected)) {
			request.getRequestDispatcher("store_introduction.html").forward(request, response);
		} else if ("店舗メニュー".equals(detected) || "MENU".equals(detected)) {
			request.getRequestDispatcher("store_menu.html").forward(request, response);
		} else if ("通販".equals(detected) || "SHOP".equals(detected)) {
			request.getRequestDispatcher("mail_order.html").forward(request, response);
		} else if ("歴史".equals(detected) || "HISTORY".equals(detected)) {
			request.getRequestDispatcher("history.html").forward(request, response);
		} else {
			// デフォルトの応答
			response.getWriter().println(detected);
		}
	}

}
