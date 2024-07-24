package dbc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import java.util.*;

public class Score {

	public int insertDate() throws ClassNotFoundException, SQLException {
		int result = 0;

		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql, hak, name;
		int kor, eng, mat;
		Scanner br = new Scanner(System.in);

		try

		{
			System.out.print("학번?");
			hak = br.next();
			
			br.nextLine();

			System.out.print("이름?");
			name = br.nextLine();

			System.out.print("국어?");
			kor = br.nextInt();
			System.out.print("영어?");
			eng = br.nextInt();
			System.out.print("수학?");
			mat = Integer.parseInt(br.nextLine());

			sql = "INSERT INTO score (hak,name,kor,eng,mat) VALUES (";
			sql += "'" + hak + "'," + "'" + name + "',";
			sql += "" + kor + "," + "" + eng + "," + "" + mat + ")";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	public void selectAll() throws ClassNotFoundException, SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String sql, hak, name, str;
		int kor, eng, mat, tot, ave;
		Connection conn = DBConn.getConnection();

		try {
			sql = "SELECT hak, name, kor, eng, mat,";
			sql += "(kor+eng+mat) AS tot,"; // 문자 인덱스 사용을 위해 별칭 필요
			sql += "(kor+eng+mat)/3 AS ave"; // 문자 인덱스 사용을 위해 별칭 필요
			sql += "FROM score ORDER BY hak";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				hak = rs.getString("hak");
				name = rs.getString("name");
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				mat = rs.getInt("mat");
				tot = rs.getInt("tot");
				ave = rs.getInt("ave");
				str = String.format("%-10s %-15s %5d %5d %5d %5d %5d", hak, name, kor, eng, mat, tot, ave);
				System.out.println(str);
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void selectName() throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = DBConn.getConnection();

		String sql, str, searchName, hak, name;
		int kor, eng, mat, tot, ave;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("검색할 이름?");
			searchName = br.readLine();

			sql = "SELECT hak, name, kor, eng, mat, ";
			sql += " (kor+eng+mat) AS tot, ";
			sql += " (kor+eng+mat)/3 AS ave ";
			sql += "FROM score";
			sql += " WHERE upper(name) LIKE upper('" + searchName + "%')";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				hak = rs.getNString("hak");
				name = rs.getNString("name");
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				mat = rs.getInt("mat");
				tot = rs.getInt("tot");
				ave = rs.getInt("ave");
				str = String.format("%-10s %-15s %5d %5d %5d %5d %5d", hak, name, kor, eng, mat, tot, ave);
				System.out.println(str);

			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int deleteDate() throws ClassNotFoundException, SQLException {

		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql, str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("삭제할 학번?");
			str = br.readLine();
			sql = "DELETE FROM score WHERE hak='" + str + "'";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			stmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	public int updateDate() throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;

		String sql, hak, name;
		int kor, eng, mat;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("수정할 학번?");
			hak = br.readLine();

			System.out.println("이름?");
			name = br.readLine();

			System.out.println("국어?");
			kor = Integer.parseInt(br.readLine());
			System.out.println("영어?");
			eng = Integer.parseInt(br.readLine());
			System.out.println("수학?");
			mat = Integer.parseInt(br.readLine());

			sql = "UPDATE score SET";
			sql += " name='" + name + "', kor=" + kor + ",";
			sql += " eng=" + eng + ", mat=" + mat + "";
			sql += " WHERE hak='" + hak + "'";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			stmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

}
