package com.liang.springcore.generic;

import java.util.ArrayList;
import java.util.List;

/****
 * Created by liliang on 4/17/25.
 ****/
public class GenericSubtypeDemo {

    class A {
        private String id = "a";

        @Override
        public String toString() {
            return id;
        }
    }

    class B extends A {
        private String id = "b";

        @Override
        public String toString() {
            return id;
        }
    }

    class C extends B {
        private String id = "c";

        @Override
        public String toString() {
            return id;
        }
    }

    public void tryGenericSubtype() {
        List<?> oldest;
        List<? extends A> listAandSubtypes;
        List<? extends B> listBandSubtypes;
        List<? extends C> listCandSubtypes;

        List<? super C> listCandParent;
        List<? super B> listBandParent;
        List<? super A> listAandParent;

        List<C> cList = new ArrayList<>();
        cList.add(new C());
        listCandSubtypes = cList;
        listBandSubtypes = listCandSubtypes;
        listAandSubtypes = listBandSubtypes;
        oldest = listAandSubtypes;

        List<A> aList = new ArrayList<>();
        aList.add(new A());
        listAandParent = aList;
        listBandParent = listAandParent;
        listCandParent = listBandParent;
        listBandParent.add(new C());
        listCandParent.add(new C());

        System.out.println(listCandParent);


        System.out.println(oldest);


    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        List<? super Number> listContainNumberNParents =new ArrayList<>();
        Integer integer1 = Integer.valueOf(10);
        listContainNumberNParents.add(integer1);
        System.out.println(listContainNumberNParents);

        //addNumbers(integerList);

        //GenericSubtypeDemo demo = new GenericSubtypeDemo();
        //demo.tryGenericSubtype();


    }

    public void tryGenericSubtype2() {
        List<?> oldest;
        List<? extends Number> listContainNumberNSubtype;
        List<? extends Integer> listContainIntegerNSubtype;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        listContainIntegerNSubtype = integerList;
        listContainNumberNSubtype = listContainIntegerNSubtype;
        oldest = listContainNumberNSubtype;
        List<Object> objectList = new ArrayList<>();
        objectList.add("hello");

        System.out.println(oldest);

        List<? super Integer> listContainIntegerNParents;
        List<? super Number> listContainNumberNParents;
        List<Number> numberList = new ArrayList<>();
        Integer integer1 = Integer.valueOf(10);

        listContainNumberNParents = new ArrayList<>();
        listContainNumberNParents.add(integer1);

        numberList.add(integer1);
        //numberList.add(4);
        listContainNumberNParents = numberList;
        listContainIntegerNParents = listContainNumberNParents;
        oldest = listContainIntegerNParents;
        System.out.println(oldest);

        listContainIntegerNParents = objectList;
        System.out.println(listContainIntegerNParents);
    }

    public static void addNumbers(List<? super Number> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

}
