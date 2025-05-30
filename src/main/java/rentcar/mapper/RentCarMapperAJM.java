package rentcar.mapper;

import rentcar.model.dto.MemberDTO;

import java.util.List;

public interface RentCarMapperAJM {
    int registMember(MemberDTO member);

    int modifyMember(MemberDTO member);

    int deleteMember(MemberDTO member);

    List<MemberDTO> selectAllMember();
}
