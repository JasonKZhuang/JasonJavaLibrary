package com.jasonz.java8Features.optional;

//史上最佳 Java Optional 指南
//https://zhuanlan.zhihu.com/p/112109825

import java.util.Optional;

/**
 * Optional is a container object used to contain not-null objects.
 * Optional is just like a box, which may contains an object or not
 * Optional object is used to represent null with absent value.
 * This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not
 * available’ instead of checking null values. It is introduced in Java 8.
 *
 * @author jason.zhuangparcelpoint.com.au
 */
public class ApplyOptionalClass {
    public static void main(String[] args) {
        ApplyOptionalClass mySelf = new ApplyOptionalClass();
        //		mySelf.withoutOptionalDemo();
        //		System.out.println(mySelf.getUserByIdFromDB(0).get().getName());
        mySelf.usingOrElsePattern();
        ;
    }

    /**
     * 方法返回了 Optional<User> 作为结果，这样就表明 User 可能存在，也可能不存在， 这时候就可以在 Optional 的
     * ifPresent() 方法中使用 Lambda 表达式来直接打印结果。 Optional 之所以可以解决 NPE
     * 的问题，是因为它明确的告诉我们，不需要对它进行判空。 它就好像十字路口的路标，明确地告诉你该往哪走。
     *
     * @param id
     * @return
     */
    public static Optional<User> getUserByIdFromDB(int id) {
        boolean hasUser = true;
        if (hasUser) {
            return Optional.of(new User("Jake"));
        }
        return Optional.empty();
    }

    private void usingOrElsePattern() {
        String email = "bbb@gmail.com";
        Optional<User> optionalUser = findUserByEmail(email);
        try {
            System.out.println(optionalUser.get().getEmail());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        /**
         * If a value is present, returns the value, otherwise returns other.
         * Params: other – the value to be returned, if no value is present. May be null.
         * Returns:the value, if present, otherwise other
         */
        User user = optionalUser.orElse(new User(email, "password"));
        System.out.println(user.getEmail());

        /**
         * If a value is present, returns the value, otherwise returns the result produced by the supplying function.
         * Params: supplier – the supplying function that produces a value to be returned
         * Returns: the value, if present, otherwise the result produced by the supplying function
         * Throws: NullPointerException – if no value is present and the supplying function is null
         */
        user = optionalUser.orElseGet(() -> generateDefaultUser());

        user = optionalUser.orElseThrow(() ->  new RuntimeException("The user is not existing"));

        Address address = optionalUser.map(User::getAddress)
                .orElse(new Address("597", new Country("AUS")));

    }

    /**
     * 创建 Optional 对象
     */
    private void createOptionalObject() {
        // 1）可以使用静态方法 empty() 创建一个空的 Optional 对象
        Optional<String> empty = Optional.empty();
        System.out.println(empty); // 输出：Optional.empty

        // 2）可以使用静态方法 of() 创建一个非空的 Optional 对象
        // 传递给 of() 方法的参数必须是非空的，也就是说不能为 null，否则仍然会抛出 NullPointerException。
        Optional<String> opt = Optional.of("Jason");
        System.out.println(opt); // 输出：Optional[Jason]

        // String name = null;
        // Optional<String> optnull = Optional.of(name);

        // 3）可以使用静态方法 ofNullable() 创建一个即可空又可非空的 Optional 对象
        //// ofNullable() 方法内部有一个三元表达式，
        // 如果参数为 null，则返回私有常量 EMPTY；否则使用 new 关键字创建了一个新的 Optional 对象
        // 所以，不会再抛出 NPE 异常了。
        String name = null;
        Optional<String> optOrNull = Optional.ofNullable(name);
        System.out.println(optOrNull); // 输出：Optional.empty

    }

    /**
     * 你看到了，这很容易就变得冗长，难以维护。
     */
    private void withoutOptionalDemo() {
        User user = new User();
        String isocode = "";
        try {
            isocode = user.getAddress().getCountry().getIsoCode().toUpperCase();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String isoCode = country.getIsoCode();
                    if (isocode != null) {
                        isocode = isocode.toUpperCase();
                    }
                }
            }
        }

    }


    private Optional<User> findUserByEmail(String email) {
        if (email.equals("abc@gmail.com")) {
            User user = new User(email, "password");
            return Optional.ofNullable(user);
        } else {
            return Optional.ofNullable(null);
        }

    }

    private User generateDefaultUser() {
        String name = "default user name";
        User user = new User(name);
        user.setEmail("abc@gmail.com");
        user.setPassword("password");
        return user;
    }
}
