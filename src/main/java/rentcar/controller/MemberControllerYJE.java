package rentcar.controller;

import rentcar.model.dto.MemberAndLevelDTO_YJE;
import rentcar.model.dto.MemberDTO_rjw;
import rentcar.model.service.MemberService_YJE;

import java.util.List;
import java.util.Map;

public class MemberControllerYJE {

    private final MemberService_YJE memberService;

    public MemberControllerYJE () {
        memberService = new MemberService_YJE();
    }

    public void selectAllMembers() {

        List<MemberDTO_rjw> memberList = memberService.selectAllMembers();

        if (memberList != null) {
            for (MemberDTO_rjw member: memberList) {
                System.out.println(member);
            }
        } else {
            System.out.println("조회할 멤버가 없습니다.");
        }
    }

    public void selectAllMemberWith() {

        List<MemberAndLevelDTO_YJE> memberList = memberService.selectAllMembersWith();

        if (memberList != null) {
            for (MemberAndLevelDTO_YJE member: memberList) {
                System.out.println(member);
            }
        } else {
            System.out.println("조회할 멤버가 없습니다.");
        }
    }

    public void selectMemberByCode(int code) {

        MemberDTO_rjw member = memberService.selectMemberByCode(code);

        if (member != null) {
            System.out.println(member);
        } else {
            System.out.println("조회할 멤버가 없습니다.");
        }
    }

    public void selectMemberByCodeWith(int code) {

        MemberAndLevelDTO_YJE member = memberService.selectMemberByCodeWith(code);

        if (member != null) {
            System.out.println(member);
        } else {
            System.out.println("조회할 멤버가 없습니다.");
        }
    }

    public void registMember(Map<String, String> parameter) {

        MemberDTO_rjw member = new MemberDTO_rjw();
        member.setMemberName(parameter.get("name"));
        member.setPhone(parameter.get("phone"));
        member.setLevel(parameter.get("level"));

        if (memberService.registMember(member)) {
            System.out.println("회원 등록 성공!");
        } else {
            System.out.println("회원 등록 실패!");
        }
    }


    public void modifyMember(int code, Map<String, String> parameter) {
        MemberDTO_rjw member = new MemberDTO_rjw();
        member.setMemberCode(code);
        member.setMemberName(parameter.get("name"));
        member.setPhone(parameter.get("phone"));
        member.setLevel(parameter.get("level"));

        if (memberService.modifyMember(member)) {
            System.out.println("회원 수정 성공!");
        } else {
            System.out.println("회원 수정 실패!");
        }
    }

    public void deleteMember(int code) {

        if (memberService.deleteMember(code)) {
            System.out.println("회원 삭제 성공!");
        } else {
            System.out.println("회원 삭제 실패!");
        }
    }
}
