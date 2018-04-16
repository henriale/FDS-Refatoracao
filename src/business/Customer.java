package business;

public class Customer {
    private String name;
    private String cpf;
    private int age;
    private Gender gender;

    public Customer(String name, String cpf, int age, Gender gender) {
        this.name = name;
        this.gender = gender;
        ;
        setCpf(cpf);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf.length() == 11 ? cpf : null;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age >= 18 ? age : 0;
    }

    public Gender getGender() {
        return gender;
    }
}
