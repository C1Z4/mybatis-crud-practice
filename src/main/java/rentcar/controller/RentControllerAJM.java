package rentcar.controller;

import rentcar.model.dto.MemberDTO;
import rentcar.model.service.RentServiceAJM;

import java.util.List;
import java.util.Map;

public class RentControllerAJM {
    
    private final RentServiceAJM rentServiceAJM;
    
    public RentControllerAJM() {
        rentServiceAJM = new RentServiceAJM();
    }

    public void registMember(Map<String, String> parameter) {

        String name = parameter.get("name");
        String phone = parameter.get("phone");
        String level = parameter.get("level");

        MemberDTO member = new MemberDTO();
        member.setMemberName(name);
        member.setPhone(phone);
        member.setLevel(level);

        if(rentServiceAJM.registMember(member)){
            System.out.println("등록성공" + member);
        } else {
            System.out.println("등록실패");
        }

    }

    public void modifyMember(Map<String,String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        String phone = parameter.get("phone");
        String level = parameter.get("level");

        MemberDTO member = new MemberDTO();

        member.setMemberCode(code);
        member.setMemberName(name);
        member.setPhone(phone);
        member.setLevel(level);

        if(rentServiceAJM.modifyMember(member)) {
            System.out.println("수정한 내용 : " + member);
        } else {
            System.out.println("수정실패");
        }
    }

    public void deleteMember(Map<String,String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        MemberDTO member = new MemberDTO();
        member.setMemberCode(code);

        if(rentServiceAJM.deleteMember(member)) {
            System.out.println("삭제 성공 : " + member);
        } else {
            System.out.println("삭제실패");
        }
    }

    public static void selectAllMember() {

        List<MemberDTO> memberList = RentServiceAJM.selectAllMember();
        for(MemberDTO member : memberList) {
        System.out.println(member);}
        if(memberList != null) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }
    }

}