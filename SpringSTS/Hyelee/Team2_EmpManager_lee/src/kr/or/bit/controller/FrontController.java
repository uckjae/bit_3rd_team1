package kr.or.bit.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

@Controller
public class FrontController {
	
	private SqlSession sqlsession;	
	
	@Autowired	
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	//로그인 화면 보여주기
	@RequestMapping(value="/Login.do", method=RequestMethod.GET)
	public String login_form() {
		return "/WEB-INF/views/login/Login.jsp";
	}
	
	//로그인 하기
	@RequestMapping(value="/Login.do", method=RequestMethod.POST)
	public String login_submit(@RequestParam(value="userid") String userid, @RequestParam(value="pwd") String pwd) {
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("pwd", pwd);
		System.out.println("아이디"+map.get("userid")+"비번"+map.get("pwd"));
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		int isLogin = empdao.checkAdminLogin(map);
		String view = "";
		if(isLogin>0) {
			view = "index.jsp";
		}else {
			view="redirect:Login.do";
		}
		return view;
	}
	
	//register 화면
	@RequestMapping(value="/Register.do", method=RequestMethod.GET)
	public String register_form() {
		return "/WEB-INF/views/register/Register.jsp";
	}
	
	@RequestMapping(value="/Register.do", method=RequestMethod.POST)
	public String register_submit(Emp emp) {
		//System.out.println("여기 타니?");
		EmpDao empdao = sqlsession.getMapper(EmpDao.class); 
		int result = empdao.insertEmp(emp); 
		String view = ""; 
		System.out.println("result" + result);
		if(result > 0) {
			view = "index.jsp";
		}else {
			view="redirect:Register.do"; 
			}
		return view;
	}
	
	//
		
}
