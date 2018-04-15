package business;

public class MembershipTuple {
    private double registered;
    private double unregistered;

    public MembershipTuple(double registered, double unregistered) {
        this.registered = registered;
        this.unregistered = unregistered;
    }

    public double getRegistered() {
        return registered;
    }

    public double getUnregistered() {
        return unregistered;
    }
}
