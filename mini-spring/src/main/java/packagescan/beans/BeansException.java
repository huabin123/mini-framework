package packagescan.beans;

/**
 * @Author huabin
 * @DateTime 2022-11-30 09:20
 * @Desc 容器相关操作的报错
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg){
       super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
