package com.command.exam;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ExamDAO;
import com.lec.beans.ExamDTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ExamDAO dao = new ExamDAO();
		
		List<ExamDTO> list = null;
		
		try {
			
			list = dao.select();
			request.setAttribute("list", list);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
