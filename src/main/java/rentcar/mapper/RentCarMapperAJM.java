package rentcar.mapper;

import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

public interface RentCarMapperAJM {
    int registMember(MemberDTO_rjw member);

    int modifyMember(MemberDTO_rjw member);

    int deleteMember(MemberDTO_rjw member);

    List<MemberDTO_rjw> selectAllMember();
}
