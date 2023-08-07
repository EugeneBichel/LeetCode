You might be wondering 
what the difference between a method reference and lambda expressions is. 

There is no difference. 
Method references are shortened versions of lambda expressions that call a specific method.

    Function<Person, Integer>  function = p  -> p.getAge();
This can be written as:

    Function<Person, Integer>  function = Person::getAge;


Four kinds of method references #
There are four kinds of method references.
1. Static methods #
The syntax to use static methods as method reference is ClassName::MethodName.

2. Instance method of a particular object #
The syntax to use the instance method as a method reference is ReferenceVariable::MethodName

We will look at the same example as above, but, this time, the getLength() method is not static.

3. Instance method of an arbitrary object #
This type of method reference does not require the object of the referenced class. We can directly use the class name in the method reference

        
        // Code with method reference
        int totalSalary = list.stream()
                .mapToInt(Employee::getSalary)
                .sum();
                
4. Constructor references #
We can refer to a constructor in the same way we reference a static method. The only difference is that we need to use a new keyword.


