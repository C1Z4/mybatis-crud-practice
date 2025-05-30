package rentcar.mapper;

import rentcar.model.dto.MemberAndLevelDTOKSE;
import rentcar.model.dto.MemberDTO;

import java.util.List;

public interface MemberMapperKSE {
    List<MemberAndLevelDTOKSE> selectAllMember();

    MemberAndLevelDTOKSE selectMemberById(int memberCode);

    int registMapper(MemberDTO member);

    int modifyMember(MemberDTO member);

    int removeMember(String memberCode);
}
