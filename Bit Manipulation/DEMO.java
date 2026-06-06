
public abstract class DEMO {

    void PRINT() {
        System.out.println("INSIDE ABSTRACT CLASS");
    }

    public static void main(String[] args) {
        DEMO D1 = new newDEMO();
        D1.PRINT();
    }
}

class newDEMO extends DEMO {

}
