package training.qa;

class ReDeclared {

    public static void main(String[] args) {
        ReDeclared.do_();
        ReDeclaredSub.do_();
        ReDeclared.do_();
    }

    static void do_() {
        System.out.println("ReDeclared");
    }
}

class ReDeclaredSub extends ReDeclared {

    static void do_() {
        System.out.println("ReDeclaredSub");
    }
}
