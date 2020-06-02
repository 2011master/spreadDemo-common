package common.statusProcess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
* @desc   状态处理工具类
* @author kanggw
* @datetime 2020/6/2,5:33 下午
*/
public class StatusProcessUtil {

    /**
     *  check当前块是否已经成功执行过
     * @param status  当前块的状态值
     * @param partId  块号
     *              校验规则：
     *                修改处使用了对1进行左移的操作， 1<< 块号，目的是使用二进制来表示不同分块的状态，如
     *               0块 则为 0000 0001
     *               1块 则为 0000 0010
     *               2块 则为 0000 0100
     *               3块 则为 0000 1000
     *
     *               1代表完成
     *
     *               校验时同样对1进行左移 1<< 块号。 然后将状态与 n 进行按位与操作，这样执行过的状态就能被识别出来
     *
     * @return
     */
    public static boolean  checkPartIdSuccess(int status,int partId){
        int n = 1<< partId;
        int m = status & n;
        return n==m;
    }

    /**
     * 根据分块数得出完成状态的值。1左移n位，来表示分片n的完成
     * @param partCount 分片总数
     * @return
     */
    public static int toSuccessStatus(int partCount){

        int status = 0;
        for (int i=0;i<partCount;i++){
            status += 1<<i;
        }
        return status;
    }

    public static void main(String args[]){
//        // 0000 0001
//        System.out.println(StatusProcessUtil.toSuccessStatus(1));
//        //0000 0011
//        System.out.println(StatusProcessUtil.toSuccessStatus(2));
//        //0000 0111
//        System.out.println(StatusProcessUtil.toSuccessStatus(3));
//        //0000 1111
//        System.out.println(StatusProcessUtil.toSuccessStatus(4));

        //所有线程都执行成功的状态值(模拟有4个线程)
        final int allSuccess = toSuccessStatus(4);

        System.out.println("全部线程都执行成功的状态值:" + Integer.toBinaryString(allSuccess));

        final ExecutorService executorService = Executors.newFixedThreadPool(4);

        final StatusTable statusTable = new StatusTable();

        IntStream.range(0,4).forEach(partId -> {

            executorService.execute(() -> {

                Thread.currentThread().setName(String.valueOf(partId));

                //模拟处理两次
                IntStream.rangeClosed(1,2).forEach(item -> {

                    //检查该线程是否处理成功
                    int part = Integer.parseInt(Thread.currentThread().getName());

                    final boolean b = checkPartIdSuccess(statusTable.getStatus(), part);

                    if (!b) {
                        System.out.println("线程："+Thread.currentThread().getName() +" ，第"+item + " 次处理，开始执行");
                        final int i = 1 << Integer.parseInt(Thread.currentThread().getName());
                        statusTable.setStatus(statusTable.getStatus() + i);
                    } else {
                        System.out.println("线程："+Thread.currentThread().getName() +" ，第"+item + " 次处理，已经执行过");

                    }
                });

                //以二进制形式输出
                System.out.println("状态结果输出,线程"+ Thread.currentThread().getName() +":"  + Integer.toBinaryString(statusTable.getStatus()));

            });
        });

        executorService.shutdown();

    }

    /**
    * @desc   模拟状态表
    * @author kanggw
    * @datetime 2020/6/2,5:46 下午
    */
    static class StatusTable{

        private int status = 0;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

}


