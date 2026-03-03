package LibraryManagement;
public class Member {
    private String memberName;
    private int memberId;
    public Member(String memberName, int memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }
    public void displayMember() {
        System.out.println("Member Name: " + memberName);
        System.out.println("Member ID: " + memberId);
    }
}