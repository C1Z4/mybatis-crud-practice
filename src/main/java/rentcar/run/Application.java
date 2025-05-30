package rentcar.run;

import rentcar.controller.MemberControllerYJE;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("================ 관리 메뉴 ================");
            System.out.println("1. 회원 관리");
            System.out.println("2. 차량 관리");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");

            int no = sc.nextInt();

            switch (no) {
                case 1: memberSubMenu(); break;
                case 2: carSubMenu(); break;
                case 9:
                    System.out.println("프로그램을 종료합니다."); return;
            }
        } while (true);
    }

    private static void memberSubMenu() {

        Scanner sc = new Scanner(System.in);
        MemberControllerYJE memberController = new MemberControllerYJE();

        do {
            System.out.println("================ 회원 관리 ================");
            System.out.println("1. 회원 조회");
            System.out.println("2. 회원 추가");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴를 선택하세요: ");

            int no = sc.nextInt();

            switch (no) {
                case 1: selectMemberMenu(); break;
                case 2: memberController.registMember(inputMember()); break;
                case 3: memberController.modifyMember(inputCode(), inputMember()); break;
                case 4: memberController.deleteMember(inputCode()); break;
                case 9:  return;
            }
        } while (true);
    }

    private static void selectMemberMenu() {

        MemberControllerYJE memberController = new MemberControllerYJE();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("================ 회원 관리 ================");
            System.out.println("1. 전체 회원 조회");
            System.out.println("2. 전체 회원 조회(할인율 포함)");
            System.out.println("3. 회원 선택 조회");
            System.out.println("4. 회원 선택 조회(할인율 포함)");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴를 선택하세요: ");

            int no = sc.nextInt();

            switch (no) {

                case 1: memberController.selectAllMembers(); break;
                case 2: memberController.selectAllMemberWith(); break;
                case 3: memberController.selectMemberByCode(inputCode()); break;
                case 4: memberController.selectMemberByCodeWith(inputCode()); break;
                case 9: return;
            }
        } while (true);
    }

    private static void carSubMenu() {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("================ 차량 관리 ================");
            System.out.println("1. 전체 차량 조회");
            System.out.println("2. 차량 선택 조회");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴를 선택하세요: ");

            int no = sc.nextInt();

            switch (no) {
                case 1: break;
                case 2: break;
                case 9: return;
            }
        } while (true);
    }

    private static Map<String, String> inputMember() {

        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("전화번호를 입력하세요: ");
        String phone = sc.nextLine();
        System.out.print("등급을 입력하세요: ");
        String level = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("phone", phone);
        parameter.put("level", level);

        return parameter;
    }

    private static int inputCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("코드를 입력하세요: ");

        return sc.nextInt();
    }
}
