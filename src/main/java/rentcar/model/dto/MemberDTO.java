package rentcar.model.dto;

public class MemberDTO {

    private int memberCode;
    private String memberName;
    private String phone;
    private LevelDTO level;

    public MemberDTO() {}

    public MemberDTO(int memberCode, String memberName, String phone, LevelDTO level) {
        this.memberCode = memberCode;
        this.memberName = memberName;
        this.phone = phone;
        this.level = level;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LevelDTO getLevel() {
        return level;
    }

    public void setLevel(LevelDTO level) {
        this.level = level;
    }

    public void setLevel(String level) {
        if (this.level == null) {
            this.level = new LevelDTO();
        }
        this.level.setLevel(level);
    }
}
