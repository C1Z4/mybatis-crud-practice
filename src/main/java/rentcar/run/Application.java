package rentcar.run;

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

}
