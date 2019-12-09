package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")  // 이렇게 앞에 주소가 같으면 컨트롤러에서 잡아 놓을 수 있다. 
public class CustomerController {
	NoticeDao noticedao;
	
	@Autowired  //의존성 주입
	public CustomerController(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	@RequestMapping("notice.htm")     //파라미터 같은 걸 이용해서 받아오기 
	public String list(String pg, String f, String q, Model model) throws ClassNotFoundException, SQLException {
				//default
				int page =1;
				String field = "TITLE";
				String query = "%%";
				
				//조건처리
				if(pg != null && !pg.equals("")) {
					page = Integer.parseInt(pg);
				}
				
				if(f != null && !f.equals("")) {
					field = f;
				}
				
				if(q != null && !q.equals("")) {
					query = q;
				}
				
				//DAO 데이터 받아오기
				List<Notice> list = noticedao.getNotices(page, field, query);
				model.addAttribute("list",list);  // model에 담으면 알아서포워드방식으로 뷰단까지 감 
				return "notice.jsp";
		
	}
	
	@RequestMapping("noticeDetail.htm")
	public String detail(String seq, Model model) {  //파라미터 같은 걸 이용해서 받아오기 
	 	Notice notice = null;
		try {
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	 	model.addAttribute("notice",notice);
		return "noticeDetail.jsp";
	}
	
	

	
	//글쓰기 처리 
	@RequestMapping(value="noticeReg.htm", method=RequestMethod.POST)
	public String write(Notice notice, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		CommonsMultipartFile imagefile = notice.getFile();
		
		
		//POINT 
		notice.setImage(imagefile.getName()); // 이걸 해야지만 db 에 파일명이 들어간다!!!
		
		//실제 파일 업로드( write하는 작업도 따로 써줘야한다. : 웹서버의 특정 경로에다...) 
		String filename=imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload"); 
		//실제로 톰캣의 업로드 경로를 알아내기 위한 작업 그 실 경로를 알아내서 패스작아줌 
		
		String fpath = path + "/" + filename;   //파일명 경로??
		
		//파일쓰기 작업
		FileOutputStream fs = new FileOutputStream(fpath); // 없으면 거기다가 파일 생성함 
		fs.write(imagefile.getBytes());  
		fs.close();   
		//여기까지가 파일 업로드 
		
// 		만약 디비작업이 필요하다면, 추가로 작업 
//		BoardDao dao = new BoardDao();
//		dao.insert(photo);
//		여기서는 디비에는 작업 안함
		
		System.out.println(fpath);
		
		// db에 넣기
		noticedao.insert(notice);
		
		return "redirect:notice.htm";
	}
	

	@RequestMapping(value="noticeReg.htm", method=RequestMethod.GET)  // 겟 방식은 뷰단으로 가는 처리 해주기
	public String form() {
		return "noticeReg.jsp";
		
	}
	
	
	//글삭제하기 (noticeDel.htm) : seq(parameter)
		//return "redirect:notice.htm
		@RequestMapping("noticeDel.htm")  // 요청할때 파라미터가 key가 seq면 파라미터로 넣기만해도 자동으로 잡아서 넣어준다. 
	
		public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
			noticedao.delete(seq);
			return "redirect:notice.htm";
		}
		
		
		//글수정하기 (화면 : select .... where seq=?) : GET   : seq (parameter)
		//noticedao.getNotice(seq)
		//Model model  >> 화면 >> 데이터 >> noticeEdit.jsp
		@RequestMapping(value="noticeEdit.htm", method=RequestMethod.GET)
		public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
			
			Notice notice = noticedao.getNotice(seq);
			model.addAttribute("notice", notice);
			return "noticeEdit.jsp";
		}
		
		
		//글수정하기(처리 : update..... where seq=?) : POST 
		//parameter Notice n >> Insert  동일  >> 무조건 파일 첨부 하는 형태로
		//return "redirect:noticeDetail.htm?seq="+n.getSeq();
		@RequestMapping(value="noticeEdit.htm", method=RequestMethod.POST)
		public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
			
			String filename= n.getFile().getOriginalFilename();
			//먼저 1. 파일이름을 notice 객체에서 받아오고,
			String path = request.getServletContext().getRealPath("/customer/upload");
			// 2. /customer/upload 실경로를 받아와서 
			String fpath = path + "/"+ filename; 
			// 3. 실경로랑 파일 이름이랑 합쳐서 파일 이름까지의 완전한 절대경로를 완성시킨다.
			FileOutputStream fs = new FileOutputStream(fpath); 
			// 위에서 만든 절대경로를 통해 생성하고 
			fs.write(n.getFile().getBytes());
			// 실제로 여기서 쓰기 작업을 한다. 
			fs.close();
			// 모든 일을 끝냈으므로, 자원을 닫아준다.
			
			//DB 파일명 저장
			n.setFileSrc(filename);
			// 노티스 vo에 다른거는 자동으로 들어가지만 이 부분은 이렇게 직접 넣어줘야한다. 그럴수밖에없음 구조상
			noticedao.update(n);
			// 지금까지 완성된 노티스 객체 하나를dao객체를 이용해, DB에 반영한다. 
			return "redirect:noticeDetail.htm?seq="+n.getSeq();
			// 마지막으로 최종 뷰단을 정해준다. 수정 중이였으므로, 해당 글 detail 뷰단으로 가야한다. 
			// redirect 로 해야 새로고침으로 간다. 
		}
	
	
}
