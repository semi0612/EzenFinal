package com.clockOn.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.clockOn.web.entity.Organization;
import com.clockOn.web.entity.member.Member;
import com.clockOn.web.entity.member.MemberLeave;
import com.clockOn.web.entity.member.MemberList;
import com.clockOn.web.entity.member.MemberSal;
import com.clockOn.web.service.empManagement.AttendanceService;
import com.clockOn.web.service.empManagement.MemberService;
import com.clockOn.web.service.empManagement.OrgService;

@Controller
@RequestMapping("/admin/empManagement/")
public class EmpManageController {
   @Autowired
   private ServletContext ctx;
   @Autowired
   private OrgService orgService;
   @Autowired
   private MemberService memberService;
//   @Autowired
   private AttendanceService attendanceService;


   @GetMapping("organization")
   public String organization(Model model) {
      model.addAttribute("orgView", orgService.orgView());
      model.addAttribute("groupcount", orgService.orgCount().get("groupcount"));
      model.addAttribute("teamcount", orgService.orgCount().get("teamcount"));
      
      return "empManagement.organization.list";
   }
   
   @GetMapping("contacts")
      public String contacts(Model model, String org_teamname) {
         //System.out.println(contactsService.contactsRead(org_teamname).get(0).getEmp_name());
         model.addAttribute("contacts", memberService.contactsRead(org_teamname));
         
         return "empManagement.organization.contacts";
   }

   @PostMapping("memberlist")
   public String list(Model model) {
      List<MemberList> list = memberService.listView();
      model.addAttribute("list", list);
      return "empManagement.empinfo.memberList";
   }
   
   @GetMapping("memberlist")
   public String memberlist(Model model) {
      List<MemberList> list = memberService.listView();
      model.addAttribute("list", list);
      int cnt = memberService.count();
      model.addAttribute("cnt", cnt);
      return "empManagement.empinfo.memberList";
   }
   @GetMapping("leaveInfo")
   public String leaveInfo(Model model) {
      List<MemberLeave> list = memberService.listLeave();
      model.addAttribute("list", list);
      int cnt = memberService.count();
      model.addAttribute("cnt", cnt);
      return "empManagement.empinfo.leaveInfo";
   }
   
   @GetMapping("salaryInfo")
   public String salaryInfo(Model model) {
      List<MemberSal> list = memberService.listSal();
      model.addAttribute("list", list);
      int cnt = memberService.count();
      model.addAttribute("cnt", cnt);
      return "empManagement.empinfo.salaryInfo";
   }
   
   
   @GetMapping("addMember")
   public String addMemer(Model model) {
      List<HashMap<String, String>> org = memberService.listTeam();
      model.addAttribute("orgList", org);
      return "empManagement.empinfo.addMember";
   }
   
   @PostMapping("addMember")
   public String addMember(String emp_id, String emp_name, String emp_email, String emp_tel, String emp_dept,
         String emp_posi, @RequestParam(name="emp_level", defaultValue="ROLE_MEMBER") String emp_level, String emp_sal, @RequestParam(name="total_annday", defaultValue="15") int total_annday, MultipartFile emp_pic, HttpServletResponse response) throws IllegalStateException, IOException {
         String fileName = emp_pic.getOriginalFilename();
      if (fileName != null) {
         String webPath = "/static/upload";
         String realPath = ctx.getRealPath(webPath);
         File savePath = new File(realPath);
         if (!savePath.exists())
            savePath.mkdirs();
         realPath += File.separator + fileName;
         File saveFile = new File(realPath);
         emp_pic.transferTo(saveFile);
//         System.out.println(realPath);
      }
      /*팀명으로 받아서 숫자로 바꿔넣어주기*/
         List<Organization> o = orgService.orgView();
         for(int i=0; i<o.size(); i++) {
            if(o.get(i).getOrg_teamname().equals(emp_dept)){
               emp_dept = String.valueOf((i+1));
            }
         }
      
      Member member = new Member(emp_id, "", emp_name, emp_email, emp_tel, emp_dept, emp_posi, emp_level, null, null,   emp_sal, fileName, total_annday, 0);
      int result = memberService.add(member);
      
      response.sendRedirect("memberlist");
      return "empManagement.empinfo.addMember";
   }

   @GetMapping("corrInfo")
   public String modify(Model model) {
      List<MemberList> list = memberService.listView();
      model.addAttribute("list", list);
      
      int cnt = memberService.count();
      model.addAttribute("cnt", cnt);
      
      List<String> posiList = memberService.listPosi();
      model.addAttribute("posiList", posiList);
      
      List<HashMap<String, String>> org = memberService.listTeam();
      model.addAttribute("orgList", org);

      return "empManagement.empinfo.corrInfo";
   }
   
   @PostMapping("corrInfo")
   public String updateInfo(String[] emp_id, String[] emp_dept, String[] emp_name, String[] emp_posi, String[] emp_tel, String[] emp_email, String[] emp_level, HttpServletResponse response) throws IOException {
      
      /*팀명으로 받아서 숫자로 바꿔넣어주기*/
      List<Organization> o = orgService.orgView();
      
      List<MemberList> list = new ArrayList();
      for(int i=0; i<emp_name.length; i++) {
         for(int j=0; j<o.size(); j++) {
            if(o.get(j).getOrg_teamname().equals(emp_dept[i])){
               emp_dept[i] = String.valueOf((j+1));
            }
         }
         MemberList member = new MemberList(emp_id[i], emp_dept[i], emp_name[i], emp_posi[i], emp_tel[i], emp_email[i], emp_level[i]);
         list.add(member);
      }
      memberService.updateAll(list);
//      return "empManagement.empinfo.corrInfo";
      
      response.sendRedirect("memberlist");
      /*empManage.empinfo.corrInfo -->> 타일즈 : admin/empManagement/corrInfo*/
      return "empManagement.empinfo.memberList";
   }
   
   
   @GetMapping("profile")
   public void profile(HttpServletResponse response) throws IOException {
	   response.sendRedirect("/profile");
	   
	   
   }
   
   @GetMapping("workinginfo")
   public String workinginfo() {
	   
	   
	   return "empManagement.workingSearch.workinginfo";
   }
   
   
   

}