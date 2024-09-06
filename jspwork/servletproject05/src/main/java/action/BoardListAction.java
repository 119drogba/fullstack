package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

 public class BoardListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<BoardBean> articleList=new ArrayList<BoardBean>();
	  	int page=1; //현재 선택한 페이지를 받을 변수 (nowBtn에 해당됨)
		int limit=10; // 한 페이지에 보여줄 목록 개수(onePageListCnt에 해당됨)		
		if(request.getParameter("page")==null || request.getParameter("page").equals("")) page = 1;
		else page=Integer.parseInt(request.getParameter("page"));
		
		BoardListService boardListService = new BoardListService();
		int listCount=boardListService.getListCount(); //전체목록 받아옴.
		articleList = boardListService.getArticleList(page,limit); //리스트를 받아옴.
		//총 페이지 수.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95를 더해서 올림 처리.
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		
		ActionForward forward= new ActionForward();
   		forward.setPath("/board/qna_board_list.jsp");
   		return forward;
   		
	 }
	 
 }