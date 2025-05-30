package rentcar.run;

import rentcar.controller.RentControllerAJM;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApplicationAJM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RentControllerAJM rentControllerAJM = new RentControllerAJM();
        do{
            System.out.println("=========회원 관리========");
            System.out.println("1. 신규 회원 추가");
            System.out.println("2. 회원 수정 ");
            System.out.println("3. 회원 삭제 ");
            System.out.println("4. 회원 전체 조회");
            System.out.println("회원 관리 번호 입력 : ");
            int no = sc.nextInt();

            switch (no){
                case 1: rentControllerAJM.registMember(inputMember()); break;
                case 2: rentControllerAJM.modifyMember(inputModfiyMember()); break;
                case 3: rentControllerAJM.deleteMember(inputDelete()); break;
                case 4: rentControllerAJM.selectAllMember(); break;
//                case 5: rentControllerAJM.memberLevelInfo();break;
//                case 6: rentControllerAJM.allmemberLevelInfo(); break;
                default:
                    System.out.println("번호 잘못 선택"); break;
            }
        } while (true);
    }

    private static Map<String, String> inputMember() {
        Scanner sc = new Scanner(System.in);

        System.out.println("회원 이름 입력 : ");
        String name = sc.nextLine();
        System.out.println("회원 전화번호 입력 : ");
        String phone = sc.nextLine();
        System.out.println("회원 등급 입력 : ");
        String level = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name",name);
        parameter.put("phone",phone);
        parameter.put("level",level);

        return parameter;
    }

    private static Map<String ,String> inputModfiyMember() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수정할 회원 코드 입력 : ");
        int code = sc.nextInt();
        System.out.println("수정할 회원 이름 입력 : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("수정할 회원 전화번호 입력 : ");
        String phone = sc.nextLine();
        System.out.println("수정할 회원 등급 입력 : ");
        String level = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();

        parameter.put("code", String.valueOf(code));
        parameter.put("name",name);
        parameter.put("phone",phone);
        parameter.put("level",level);

        return parameter;
    }

    private static Map<String, String> inputDelete() {
        Scanner sc = new Scanner(System.in);

        System.out.println("삭제할 회원 코드 입력");
        String code = sc.nextLine();

        Map<String ,String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    public void memberLevelInfo() {

    }
}
