package com.bichel.other.basic;

public class PassingParams {
    public static void main(String[] args) {

        /*
        In Java passing only By VALUE (coping the value)
         */
        /*
        For objects passed into methods, the REFERENCE to the object is passed BY VALUE
         */

        int val = 5;
        calcVal(val);
        System.out.println(val); //5

        Integer ref = 7;
        calcRef(ref);
        System.out.println(ref);//7

        String str = "origin";
        changeStr(str);
        System.out.println(str);//origin

        Customer cust = new Customer();
        cust.setName("Tom");
        changeCustomerName(cust); //passed reference by value, but changed a value of instance in a heap
        System.out.println(cust.getName());//Peter
    }

    private static void calcVal(int val) {
        val = val * 100;
    }
    private static void calcRef(Integer ref) {
        ref = ref + 1000;
    }
    private static void changeStr(String str) {
        str = "changed";
    }
    private static void changeCustomerName(Customer customer) {
        customer.setName("Peter");
    }
}

class Customer {
    private String name;

    public Customer() {

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {return this.name;}
}