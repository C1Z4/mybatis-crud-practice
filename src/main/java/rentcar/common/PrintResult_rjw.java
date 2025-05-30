package rentcar.common;

import rentcar.model.dto.MemberDTO;

import java.util.List;

public class PrintResult_rjw {

    public void printLevelInfo(MemberDTO memberLevelInfo) {
        System.out.println(memberLevelInfo.getMemberName() + "님의 등급은 " + memberLevelInfo.getLevel().getLevel() + ", 할인율은 " + memberLevelInfo.getLevel().getDiscountRate() + " 입니다.");
    }

    public void printMemberList(List<MemberDTO> memberWithLevelList) {
        for (MemberDTO member : memberWithLevelList) {
            System.out.println(member);
        }
    }

    public void successMessage(String code) {
        switch (code) {
            case "registMember":
                System.out.println("회원 추가에 성공했습니다.");
                break;
            case "modifyMember":
                System.out.println("회원 정보 수정에 성공했습니다.");
                break;
            case "deleteMember":
                System.out.println("회원 삭제에 성공했습니다.");
                break;
        }
    }

    public void errorMessage(String code) {
        switch (code) {
            case "memberLevelInfo" :
                System.out.println("회원의 등급 정보 조회에 실패했습니다.");
                break;
            case "registMember" :
                System.out.println("회원 추가에 실패했습니다.");
                break;
            case "modifyMember" :
                System.out.println("회원 정보 수정에 실패했습니다.");
                break;
            case "deleteMember" :
                System.out.println("회원 삭제에 실패했습니다.");
                break;
        }
    }
}
