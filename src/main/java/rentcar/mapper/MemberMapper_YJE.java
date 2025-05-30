package rentcar.mapper;

import rentcar.model.dto.MemberAndLevelDTO_YJE;
import rentcar.model.dto.MemberDTO;

import java.util.List;

public interface MemberMapper_YJE {
    List<MemberDTO> selectAllMembers();

    List<MemberAndLevelDTO_YJE> selectAllMembersWith();

    MemberDTO selectMemberByCode(int code);

    MemberAndLevelDTO_YJE selectMemberByCodeWith(int code);

    int insertMember(MemberDTO member);

    int updateMember(MemberDTO member);

    int deleteMember(int code);
}
