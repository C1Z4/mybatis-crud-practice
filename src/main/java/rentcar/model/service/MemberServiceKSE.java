package rentcar.model.service;

import org.apache.ibatis.session.SqlSession;
import rentcar.mapper.MemberMapperKSE;
import rentcar.model.dao.MemberDAOKSE;
import rentcar.model.dto.MemberAndLevelDTOKSE;
import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

import static rentcar.common.Template.getSqlSession;

public class MemberServiceKSE {
    private MemberMapperKSE mappper;
    private MemberDAOKSE memberDAO;

    public MemberServiceKSE() {
        this.memberDAO = new MemberDAOKSE();
    }

    public List<MemberAndLevelDTOKSE> selectAllMemeber() {
        SqlSession sqlSession = getSqlSession();

        List<MemberAndLevelDTOKSE> memberList = memberDAO.selectAllMemeber(sqlSession);

        sqlSession.close();

        return memberList;
    }

    public MemberAndLevelDTOKSE selectMemberById(int memberCode) {
        SqlSession sqlSession = getSqlSession();

        MemberAndLevelDTOKSE member = memberDAO.selectMemberById(sqlSession, memberCode);

        sqlSession.close();

        return member;
    }

    public boolean registMember(MemberDTO_rjw member) {
        SqlSession sqlSession = getSqlSession();

        int result = memberDAO.registMember(sqlSession, member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyMember(MemberDTO_rjw member) {
        SqlSession sqlSession = getSqlSession();

        int result = memberDAO.modifyMember(sqlSession, member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean removeMember(String memberCode) {
        SqlSession sqlSession = getSqlSession();

        int result = memberDAO.removeMember(sqlSession, memberCode);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
