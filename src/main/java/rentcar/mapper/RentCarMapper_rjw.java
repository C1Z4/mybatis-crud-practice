package rentcar.mapper;

import rentcar.model.dto.LevelDTO;
import rentcar.model.dto.MemberDTO;

import java.util.List;

public interface RentCarMapper_rjw {
    MemberDTO selectMemberLevelInfo(Integer memberCode);

    List<MemberDTO> selectAllMemberWithLevel();

    int registerMember(MemberDTO member);

    int modifyMember(MemberDTO member);

    int deleteMember(Integer memberCode);

    LevelDTO selectLevelByName(String levelName);
}
