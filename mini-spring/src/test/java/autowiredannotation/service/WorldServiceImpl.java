package autowiredannotation.service;

/**
 * @Author huabin
 * @DateTime 2022-12-09 13:05
 * @Desc
 */
public class WorldServiceImpl implements WorldService {
    @Override
    public void explode() {
        System.out.println("炸了");
    }
}
