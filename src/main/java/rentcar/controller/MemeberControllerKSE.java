package rentcar.controller;

import rentcar.model.dto.MemberAndLevelDTOKSE;
import rentcar.model.dto.MemberDTO_rjw;
import rentcar.model.service.MemberServiceKSE;

import java.util.List;
import java.util.Map;

public class MemeberControllerKSE {
    private MemberServiceKSE memberService;

    public MemeberControllerKSE() {
        this.memberService = new MemberServiceKSE();
    }

    public void selectAllMember() {
        List<MemberAndLevelDTOKSE> memberList = memberService.selectAllMemeber();

        if (memberList != null) {
            for (MemberAndLevelDTOKSE member : memberList) {
                System.out.println(member);
            }
        } else {
            System.out.println("회원 정보 전체 조회에 실패하였습니다.");
        }
    }

    public void selectMemberById(Map<String, String> parameter) {
        int memberCode = Integer.valueOf(parameter.get("memberCode"));
        MemberAndLevelDTOKSE member = memberService.selectMemberById(memberCode);

        if (member != null) {
            System.out.println(member);
        } else {
            System.out.println("회원 아이디를 통한 회원 조회에 실패하였습니다.");
        }

    }

    public void registMember(Map<String, String> parameter) {
        String memberName = parameter.get("memberName");
        String phone = parameter.get("phone");
        String level = parameter.get("level");

        MemberDTO_rjw member = new MemberDTO_rjw();
        member.setMemberName(memberName);
        member.setPhone(phone);
        member.setLevel(level);

        if (memberService.registMember(member)) {
            System.out.println("회원 등록 성공!");
        } else {
            System.out.println("회원 등록 실패!");
        }
    }

    public void modifyMember(Map<String, String> parameter) {
        int memberCode = Integer.valueOf(parameter.get("memberCode"));
        String memberName = parameter.get("memberName");
        String phone = parameter.get("phone");
        String level = parameter.get("level");

        MemberDTO_rjw member = new MemberDTO_rjw();
        member.setMemberCode(memberCode);
        member.setMemberName(memberName);
        member.setPhone(phone);
        member.setLevel(level);

        if (memberService.modifyMember(member)) {
            System.out.println("회원 수정 성공!");
        } else {
            System.out.println("회원 수정 실패!");
        }

    }

    public void removeMember(Map<String, String> parameter) {
        String memberCode = parameter.get("memberCode");

        if (memberService.removeMember(memberCode)) {
            System.out.println("회원 삭제 성공!");
        } else {
            System.out.println("회원 삭제 실패!");
        }
    }
}
