package circularreferencewithproxybean.service;

/**
 * @Author huabin
 * @DateTime 2022-12-09 13:05
 * @Desc
 */
public class WorldServiceImpl implements WorldService {

    private String name;

    @Override
    public void explode() {
        System.out.println("炸了");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
