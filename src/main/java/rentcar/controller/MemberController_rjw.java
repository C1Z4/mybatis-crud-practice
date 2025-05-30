package rentcar.controller;

import rentcar.common.PrintResult_rjw;
import rentcar.model.dto.MemberDTO;
import rentcar.model.service.MemberService_rjw;

import java.util.List;

public class MemberController_rjw {

    private final MemberService_rjw memberService;

    private final PrintResult_rjw printResult;

    public MemberController_rjw() {
        memberService = new MemberService_rjw();
        printResult = new PrintResult_rjw();
    }

    public void selectMemberLevelInfo(Integer memberCode) {

        MemberDTO memberLevelInfo = memberService.selectMemberLevelInfo(memberCode);

        if (memberLevelInfo != null) {
            printResult.printLevelInfo(memberLevelInfo);
            return;
        }
        printResult.errorMessage("memberLevelInfo");
    }

    public void selectAllMemberWithLevel() {

        List<MemberDTO> memberWithLevelList = memberService.selectAllMemberWithLevel();

        if (memberWithLevelList != null) {
            printResult.printMemberList(memberWithLevelList);
            return;
        }
        printResult.errorMessage("memberWithLevelList");
    }

    public void registMember(MemberDTO newMember) {

        if (memberService.registMember(newMember)) {
            printResult.successMessage("registMember");
            return;
        }
        printResult.errorMessage("registMember");
    }

    public void modifyMember(MemberDTO member) {

        if (memberService.modifyMember(member)) {
            printResult.successMessage("modifyMember");
            return;
        }
        printResult.errorMessage("modifyMember");
    }

    public void deleteMember(Integer memberCode) {

        if (memberService.deleteMember(memberCode)) {
            printResult.successMessage("deleteMember");
            return;
        }
        printResult.errorMessage("deleteMember");

    }
}
