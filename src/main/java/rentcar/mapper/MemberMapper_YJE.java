package rentcar.mapper;

import rentcar.model.dto.MemberAndLevelDTO_YJE;
import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

public interface MemberMapper_YJE {
    List<MemberDTO_rjw> selectAllMembers();

    List<MemberAndLevelDTO_YJE> selectAllMembersWith();

    MemberDTO_rjw selectMemberByCode(int code);

    MemberAndLevelDTO_YJE selectMemberByCodeWith(int code);

    int insertMember(MemberDTO_rjw member);

    int updateMember(MemberDTO_rjw member);

    int deleteMember(int code);
}
