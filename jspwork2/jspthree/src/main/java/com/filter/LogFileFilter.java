package com.filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/*
 * @WebFilter( filterName = "Filter02_2", urlPatterns = {
 * "/18_01_filter02_process.jsp" }, initParams = {
 * 
 * @WebInitParam(name = "filename", value = "monitor.log") })
 */
public class LogFileFilter implements Filter {
//	PrintWriter writer;
	FileWriter writer;
	String filename; //null => "monitor.log"
	String realpath = "C:\\log\\";
	
	/*
	 * FilterConfig fConfig => n: "filename" / v: "monitor.log"
	 */
	
	

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter02_2 초기화...");
		File f = new File(realpath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		filename = fConfig.getInitParameter("filename");
	}
		
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Filter02_2 doFilter()...");
		if(filename==null) throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		try {
//			writer = new PrintWriter(new FileWriter(realpath+filename, true),true);
			writer = new FileWriter(realpath+filename,true);
			// true로 설정하면 파일에 데이터를 추가(append) 모드로 열게 됩니다.
			// 즉, 기존 파일의 내용 뒤에 새로운 내용을 추가하게 됩니다.
			//   false일 경우, 기존 파일 내용을 덮어쓰게 됩니다.
		}catch (IOException e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
		writer.write("현재일시: " + getCurrentTime()+"\n");
		String clientAddr = request.getRemoteAddr();
		writer.write("클라이언트 주소: " +clientAddr+"\n");
		String contentType = response.getContentType();
		writer.write("문서의 콘텐츠 유형: "+contentType+"\n");
		writer.write("-----------------------------------\n");
	
		
		
		chain.doFilter(request, response);   //연결된 필터가 있으면 request, response를 그 필터로 보냄 
		//연결된 필터가 없으면 목적지로 감
		//writer.printf("현재일시:%s %n" , getCurrentTime());
		clientAddr = request.getRemoteAddr();
		//writer.printf("클라이언트 주소 : %s %n", clientAddr);
		contentType = response.getContentType();
		writer.write("문서의 콘텐츠 유형: "+contentType+"\n");
		//writer.write("-----------------------------------\n");
		//writer.close();
	}
	


	public void destroy() {
		try {
			writer.write("destroy()메소드호출.filter객체해제");}
		catch (IOException e) {e.printStackTrace();}
		}

	
private String getCurrentTime() {
		DateFormat formatter =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());	
		return formatter.format(calendar.getTime());
	}

	
	

}
