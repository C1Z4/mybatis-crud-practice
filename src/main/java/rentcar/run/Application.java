package rentcar.run;

import rentcar.controller.MemberController_rjw;
import rentcar.model.dto.MemberDTO;
import rentcar.controller.MemeberControllerKSE;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MemeberControllerKSE memeberController = new MemeberControllerKSE();


        while (true) {
            System.out.println("======= 메뉴 입력 =======");
            System.out.println("1. 회원 전체 조회");
            System.out.println("2. 회원 아이디로 등급, 할인율을 포함한 특정 회원 정보 조회하기");
            System.out.println("3. 회원 정보 등록하기");
            System.out.println("4. 회원 정보 수정하기");
            System.out.println("5. 회원 정보 삭제하기");
            System.out.print("메뉴를 선택하세요 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1 :
                    memeberController.selectAllMember();
                    break;
                case 2 :
                    memeberController.selectMemberById(inputMemberCode());
                    break;
                case 3 :
                    memeberController.registMember(insertMember());
                    break;
                case 4 :
                    memeberController.modifyMember(updateMember());
                    break;
                case 5 :
                    memeberController.removeMember(deleteMember());
                    break;
            }
        }
    }

    private static Map<String, String> inputMemberCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 회원의 코드를 입력하세요 : ");
        String memberCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("memberCode", memberCode);

        return parameter;
    }

    private static Map<String, String> insertMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("등록할 회원의 이름을 입력하세요 : ");
        String memberName = sc.nextLine();
        System.out.println("등록할 회원의 전화번호를 입력하세요 : ");
        String phone = sc.nextLine();
        System.out.println("등록할 회원의 등급을 입력하세요 : ");
        String level = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("memberName", memberName);
        parameter.put("phone", phone);
        parameter.put("level", level);

        return parameter;
    }

    private static Map<String, String> updateMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정하고 싶은 회원코드를 입력해주세요 : ");
        String memberCode = sc.nextLine();
        System.out.println("수정할 회원의 이름을 입력해주세요 : ");
        String memberName = sc.nextLine();
        System.out.println("수정할 회원의 전화번호를 입력해주세요 : ");
        String phone = sc.nextLine();
        System.out.println("수정할 회원의 등급을 입력해주세요 : ");
        String level = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();

        parameter.put("memberCode", memberCode);
        parameter.put("memberName", memberName);
        parameter.put("phone", phone);
        parameter.put("level", level);

        return parameter;
    }


    private static Map<String, String> deleteMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 회원 코드를 입력해주세요. : ");
        String memberCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("memberCode", memberCode);

        return parameter;
    }
/* 지원님

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
*/
  
}