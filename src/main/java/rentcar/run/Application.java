package rentcar.run;

import rentcar.controller.MemberController_rjw;
import rentcar.model.dto.MemberDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MemberController_rjw memberController = new MemberController_rjw();

        while (true) {
            System.out.println("-----차량대여 플랫폼 회원 관리 프로그램-----");
            System.out.println("1. 특정 회원의 할인율 조회");
            System.out.println("2. 회원 전체 조회(등급 정보 포함)");
            System.out.println("3. 회원 추가");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 삭제");
            System.out.println("6. 프로그램 종료");

            int selectNum = sc.nextInt();

            switch (selectNum) {
                case 1:
                    memberController.selectMemberLevelInfo(inputMemberCode());
                    break;
                case 2:
                    memberController.selectAllMemberWithLevel();
                    break;
                case 3:
                    memberController.registMember(inputNewMember());
                    break;
                case 4:
                    memberController.modifyMember(inputModifyMember());
                    break;
                case 5:
                    memberController.deleteMember(inputDeleteMemberCode());
                    break;
                case 6:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 번호입니다.");
                    break;
            }
        }

    }

    private static Integer inputMemberCode() {
        Scanner sc = new Scanner(System.in);

        System.out.println("조회하실 회원의 회원코드를 입력해주세요.");

        return sc.nextInt();
    }

    private static MemberDTO inputNewMember() {
        Scanner sc = new Scanner(System.in);

        System.out.println("회원의 이름을 입력해주세요.");
        String memberName = sc.nextLine();

        System.out.println("회원의 전화번호를 입력해주세요.");
        String phone = sc.nextLine();

        MemberDTO newMember = new MemberDTO();
        newMember.setMemberName(memberName);
        newMember.setPhone(phone);

        return newMember;
    }

    private static MemberDTO inputModifyMember() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수정 대상의 회원코드를 입력해주세요.");
        int originalMemberCode = Integer.parseInt(sc.nextLine());

        // 최소 하나는 수정해야 함! 아니면 <set> 태그 안에 업데이트할 필드가 없어서 오류발생
        System.out.println("이름 변경을 원할 시, 새로운 이름을 입력해주세요.");
        String modifyMemberName = sc.nextLine();

        System.out.println("전화번호 변경을 원할 시, 새로운 전화번호를 입력해주세요.");
        String modifyPhone = sc.nextLine();

        System.out.println("등급 변경을 원할 시, 새로운 등급을 입력해주세요. (일반, SILVER, GOLD, VIP, VVIP)");
        String modifyLevel = sc.nextLine();

        MemberDTO modifyMember = new MemberDTO();
        modifyMember.setMemberCode(originalMemberCode);
        modifyMember.setMemberName(modifyMemberName);
        modifyMember.setPhone(modifyPhone);
        modifyMember.setLevel(modifyLevel);

        return modifyMember;
    }

    private static Integer inputDeleteMemberCode() {
        Scanner sc = new Scanner(System.in);

        System.out.println("삭제하실 회원의 회원코드를 입력해주세요.");

        return sc.nextInt();
    }
}
