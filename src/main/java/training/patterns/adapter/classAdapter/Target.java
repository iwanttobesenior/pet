package training.patterns.adapter.classAdapter;

interface Target {

    default void doSmth(){
        System.out.println("smth");
    }
}
