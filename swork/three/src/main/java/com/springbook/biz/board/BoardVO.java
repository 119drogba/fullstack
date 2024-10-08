package com.springbook.biz.board;

import java.sql.Date;

public class BoardVO {
	private int seq; //0
	private String title ; //null => "임시제목2"
	private String writer ; //null => "홍길동2"
	private String content ;//null => "임시내용2......"
	private Date regdate; //null
	private int cnt; //0
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {//"임시제목2"
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) { //"홍길동2"
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) { //"임시내용2......"
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + "]";
	}
	
}
