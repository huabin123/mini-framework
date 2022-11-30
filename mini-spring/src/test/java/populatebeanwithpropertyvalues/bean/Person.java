package populatebeanwithpropertyvalues.bean;

/**
 * @Author huabin
 * @DateTime 2022-11-30 15:16
 * @Desc 注意这个地方不能加包含name和age的构造函数，不然会因为缺少init方法报错
 */
public class Person {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
