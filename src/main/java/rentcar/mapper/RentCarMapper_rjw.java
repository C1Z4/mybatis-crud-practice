package rentcar.mapper;

import rentcar.model.dto.LevelDTO;
import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

public interface RentCarMapper_rjw {
    MemberDTO_rjw selectMemberLevelInfo(Integer memberCode);

    List<MemberDTO_rjw> selectAllMemberWithLevel();

    int registerMember(MemberDTO_rjw member);

    int modifyMember(MemberDTO_rjw member);

    int deleteMember(Integer memberCode);

    LevelDTO selectLevelByName(String levelName);
}
