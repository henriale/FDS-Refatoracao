package business;

public class Member extends Customer {
    private String number;

    public Member(String name, String cpf, int age, Gender gender, String number) {
        super(name, cpf, age, gender);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
