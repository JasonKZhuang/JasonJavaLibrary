package com.jasonz.oop.nestedClasses;

class OuterClassWithNestedClasses {
    private static String staticOuterField = "Static outer field";
    private String userNameInOuterClass = "Jason";
    private String outerField = "Outer field";

    public static void main(String[] args) {

        // To instantiate an inner class, you must first instantiate the outer class.
        // Then, create the inner object within the outer object with this syntax:
        OuterClassWithNestedClasses outerObject = new OuterClassWithNestedClasses();
        OuterClassWithNestedClasses.PrivateInnerClass privateInnerClass = outerObject.new PrivateInnerClass();
        OuterClassWithNestedClasses.ProtectedInnerClass protectedInnerClass = outerObject.new ProtectedInnerClass();
        OuterClassWithNestedClasses.PackageInnerClass packageInnerClass = outerObject.new PackageInnerClass();
        OuterClassWithNestedClasses.PublicInnerClass publicInnerClass = outerObject.new PublicInnerClass();
        privateInnerClass.innerClassMethodA();
        protectedInnerClass.innerClassMethodB();
        packageInnerClass.innerClassMethodC();
        publicInnerClass.innerClassMethodD();

        StaticNestedClass staticNestedObject = new StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);

        String a  = PublicInnerClass.publicStaticName;


    }

    String b  = new PublicInnerClass().publicName;

    static class StaticNestedClass {
        void execute() {
            // Static Inner classes do not have access to other members of the enclosing class
            // System.out.println(userNameInOuterClass);
            System.out.println("execute method in StaticInnerClass");
        }

        void accessMembers(OuterClassWithNestedClasses outer) {
            // Compiler error: Cannot make a static reference to the non-static field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    private class PrivateInnerClass {
        public String name;

        public PrivateInnerClass(){
        }
        public PrivateInnerClass(String argName){
            this.name = argName;
        }
        private void innerClassMethodA() {
            userNameInOuterClass = userNameInOuterClass + " Private ";
            System.out.println(userNameInOuterClass);
        }

        void accessMembers() {
            outerField = outerField = " Private";
            staticOuterField = staticOuterField + " Private";
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    protected class ProtectedInnerClass {
        String name;

        public ProtectedInnerClass(){

        }
        public ProtectedInnerClass(String argName){
            this.name = argName;
        }
        private void innerClassMethodB() {
            userNameInOuterClass = userNameInOuterClass + " Protected ";
            System.out.println(userNameInOuterClass);
        }
    }

    class PackageInnerClass {
        String name;

        public PackageInnerClass(){
        }
        public PackageInnerClass(String argName){
            this.name = argName;
        }
        private void innerClassMethodC() {
            userNameInOuterClass = userNameInOuterClass + " Package ";
            System.out.println(userNameInOuterClass);
        }
    }

    public class PublicInnerClass {
        String name;

        public String publicName;
        public static String publicStaticName;

        private void innerClassMethodD() {
            userNameInOuterClass = userNameInOuterClass + " Public ";
            System.out.println(userNameInOuterClass);
        }
    }


}