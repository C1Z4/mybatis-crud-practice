package rentcar.model.service;

import org.apache.ibatis.session.SqlSession;
import rentcar.model.dao.MemberDAO_YJE;
import rentcar.model.dto.MemberAndLevelDTO_YJE;
import rentcar.model.dto.MemberDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static rentcar.common.Template.getSqlSession;

public class MemberService_YJE {

    private final MemberDAO_YJE memberDAO;

    public MemberService_YJE() {
        memberDAO = new MemberDAO_YJE();
    }

    public List<MemberDTO> selectAllMembers() {
        SqlSession sqlSession = getSqlSession();

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("condition", null);
        parameter.put("value", null);

        List<MemberDTO> memberList = memberDAO.selectAllMembers(sqlSession);

        sqlSession.close();

        return memberList;
    }

    public List<MemberAndLevelDTO_YJE> selectAllMembersWith() {
        SqlSession sqlSession = getSqlSession();

        List<MemberAndLevelDTO_YJE> memberList = memberDAO.selectAllMembersWith(sqlSession);

        sqlSession.close();

        return memberList;
    }

    public MemberDTO selectMemberByCode(int code) {
        SqlSession sqlSession = getSqlSession();

        MemberDTO member = memberDAO.selectMemberByCode(sqlSession, code);

        sqlSession.close();

        return member;
    }

    public MemberAndLevelDTO_YJE selectMemberByCodeWith(int code) {

        SqlSession sqlSession = getSqlSession();

        MemberAndLevelDTO_YJE member = memberDAO.selectMemberByCodeWith(sqlSession, code);

        sqlSession.close();

        return member;
    }

    public boolean registMember(MemberDTO member) {

        SqlSession sqlSession = getSqlSession();

        int result = memberDAO.insertMember(sqlSession, member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyMember(MemberDTO member) {

        SqlSession sqlSession = getSqlSession();

        int result = memberDAO.updateMember(sqlSession, member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteMember(int code) {

        SqlSession sqlSession = getSqlSession();

        int result = memberDAO.deleteMember(sqlSession, code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
