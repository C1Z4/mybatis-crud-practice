package rentcar.mapper;

import rentcar.model.dto.MemberAndLevelDTOKSE;
import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

public interface MemberMapperKSE {
    List<MemberAndLevelDTOKSE> selectAllMember();

    MemberAndLevelDTOKSE selectMemberById(int memberCode);

    int registMapper(MemberDTO_rjw member);

    int modifyMember(MemberDTO_rjw member);

    int removeMember(String memberCode);
}
