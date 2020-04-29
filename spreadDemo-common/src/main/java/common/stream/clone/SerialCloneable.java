package common.stream.clone;

import java.io.*;

/**
* @desc   通过序列化实现对象深度克隆
 *         注：通过这种方式，其它类只需要继承这个类就可以实现克隆功能，但这种方式虽然灵巧，但在效率上却比显式克隆(copyProperties工具类)低
* @author kanggw
* @datetime 2020/4/29,8:44 下午
*/
public class SerialCloneable implements Cloneable, Serializable {

    private static final long serialVersionUID = -5163165711834713161L;


    /**
     * 克隆方法实现
     * 实现的原理就是将当前对象先写入输出流，然后在通过输入流读到内存，这里的输入，输出是相对内存而言的。
     * @return 克隆后对象
     */
    public Object cloneBySerializable() throws CloneNotSupportedException {

        //创建字节输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
                //将当前对象写入
                objectOutputStream.writeObject(this);
            }

            //创建输入流
            try ( ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray())){

                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                return objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CloneNotSupportedException();
        }
    }

}
