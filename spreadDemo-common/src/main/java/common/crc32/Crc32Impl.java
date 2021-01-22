package common.crc32;

import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
* @desc  采用4种方式实现crc32文件校验和，对比处理时间
* @author kanggw
* @datetime 2020/5/9,1:01 下午
*/
public class Crc32Impl {

    /**
     * 通过inputStream方式实现
     * @param path 文件路径
     * @return 校验和
     */
    public static long checkSumInputStream(Path path) throws IOException {

        try (InputStream inputStream = Files.newInputStream(path) ){
            final CRC32 crc32 = new CRC32();

            int temp;

            while ((temp = inputStream.read()) != -1) {
                crc32.update(temp);
            }
            return crc32.getValue();
        }

    }

    /**
     * 通过BufferedInputStream方式实现
     * @param path 文件路径
     * @return 校验和
     */
    public static long checkSumBufferedInputStream(Path path) throws IOException {

        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(path))){
            final CRC32 crc32 = new CRC32();

            int temp;

            while ((temp = inputStream.read()) != -1) {
                crc32.update(temp);
            }
            return crc32.getValue();
        }

    }

    /**
     * 通过RandomAccessFile方式实现
     * @param path 文件路径
     * @return 校验和
     */
    public static long checkSumRandomAccessFile(Path path) throws IOException {

        try (final RandomAccessFile file = new RandomAccessFile(path.toFile(),"r")){

            final CRC32 crc32 = new CRC32();

            final long length = file.length();

            for (int p = 0; p < length; p++) {

                file.seek(p);
                final byte b = file.readByte();
                crc32.update(b);
            }

            return crc32.getValue();
        }

    }

    public static long checksumMappedFile(Path filename) throws IOException {

        try (FileChannel channel = FileChannel.open(filename)){
            final CRC32 crc32 = new CRC32();
            final long size = channel.size();

            final MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, size);

            for (int p = 0; p < size; p++) {
                final byte b = buffer.get(p);
                crc32.update(b);
            }
            return crc32.getValue();
        }
    }

    public static void main(String[] args) throws IOException {


        StopWatch stopWatch = new StopWatch();

        stopWatch.start();


        final Path path = Paths.get(args[0]);

        System.out.println("InputStream");
        stopWatch.split();

        final long l = checkSumInputStream(path);

        System.out.println("crc32校验和："+l);

        System.out.println("消耗时间："+ (stopWatch.getTime() - stopWatch.getSplitTime()));

        System.out.println("BufferedInputStream");
        stopWatch.split();

        final long l1 = checkSumBufferedInputStream(path);

        System.out.println("crc32校验和："+l1);


        System.out.println("消耗时间："+ (stopWatch.getTime() - stopWatch.getSplitTime()));


        System.out.println("RandomAccessFile");
        stopWatch.split();

        final long l2 = checkSumRandomAccessFile(path);

        System.out.println("消耗时间："+ (stopWatch.getTime() - stopWatch.getSplitTime()));
        System.out.println("crc32校验和："+l2);



        System.out.println("MappedFile");
        stopWatch.split();

        final long l3 = checksumMappedFile(path);

        System.out.println("crc32校验和："+l3);


        System.out.println("消耗时间："+ (stopWatch.getTime() - stopWatch.getSplitTime()));

        System.out.println("总时间："+stopWatch.getTime());



    }

}


