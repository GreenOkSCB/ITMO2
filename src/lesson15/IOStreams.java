package lesson15;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Vector;

//io api
public class IOStreams {
    // InputStream
    // OutputStream

    protected long readByte(File file) throws IOException {
        long byteSum = 0;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            System.out.println(fileInputStream.available());
            while (fileInputStream.available() > 0) {   // available возвращает количество свободных байт
                int data = fileInputStream.read();
                byteSum += data;
                System.out.println((char) data);
            }
            return byteSum;
        }
    }

    private void readByteArray(File file, Charset charset) throws IOException {  // charset  кодировка
        try (InputStream in = new FileInputStream(file);  // сюда передаем поток файла
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;

            // in - отсюда, .read - читаем, (buf) - сюда записываем
            while ((len = in.read(buf)) > 0) {
                System.out.println(Arrays.toString(buf));
                byteArrayOutputStream.write(buf, 0, len);
            }
            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
            System.out.println(new String(byteArrayOutputStream.toByteArray(), charset));
        }
    }

    private void writeToFile(File file, boolean append, Charset charset) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++){
                sb.append("line ").append(i)
                        .append('\n')  // перенос на новую строку
                ;
            }
            byte[] bytes = sb.toString().getBytes(charset); // sb преобразовали строку в байты нужной кодировки
            fileOutputStream.write(bytes);
        }
    }

    public void writeWithBuffer(File file) throws IOException{
        try (FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(out);)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++){
                sb.append("line ").append(i)
                        .append('\n')  // перенос на новую строку
                ;
            }
            byte[] buffer = sb.toString().getBytes();
            bout.write(buffer, 0, buffer.length);
        }
    }
    private  void readFromTwoFiles(File[] files, Charset charset) throws IOException{
        try (
                InputStream input1 = new FileInputStream(files[0]);
                InputStream input2 = new FileInputStream(files[0]);
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ){

            /* какойто Vector, записывает из множества файлов  */
//            InputStream in1 = new FileInputStream("file1.txt");
//            InputStream in2 = new FileInputStream("file2.txt");
//            InputStream in3 = new FileInputStream("file3.txt");
//
//            Vector<InputStream> streams = new Vector<>();
//            streams.add(in1);
//            streams.add(in2);
//            streams.add(in3);
//            SequenceInputStream sequenceInputStream = new SequenceInputStream(streams.elements());

            /* Запись из множества файлов */
            SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2);
            byte[] buf = new byte[1024];
            int len;
            while ((len = sequenceInputStream.read(buf)) > 0){
                bout.write(buf, 0, len);
            }
            System.out.println(new String(bout.toByteArray(), charset));
        }
    }

    private static void dataOutput(OutputStream out) throws IOException{
        /* DataOutputStream - обертка для примитивов */
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeInt(1233);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeUTF("Hello");
    }



    public static void main(String[] args) throws IOException {
        /* чтото с многопоточностью */
//        PipedInputStream pipedInputStream;
//        PipedOutputStream pipedOutputStream;
        /* хз что это */
//        FilterInputStream filterInputStream;
//        FilterOutputStream filterOutputStream;

        IOStreams ioStreams = new IOStreams();
        // чтение из файла по биту
        File file = new File("file.txt");
        File file2 = new File("file2.txt");
//        System.out.println(ioStreams.readByte(file));

//        ioStreams.readByteArray(file, Charset.forName("UTF-8"));

//        ioStreams.writeToFile(file,
//                true, // записываем в файл, добавляем
////                false, // записываем в файл, перезаписываем
//                Charset.forName("UTF-8"));

//        ioStreams.writeWithBuffer(file);

//        File[] files = {file, file2};
//        ioStreams.readFromTwoFiles(files, Charset.forName("UTF-8"));

        try (OutputStream out  = new FileOutputStream(file)){
            dataOutput(out);
        }


    }


}
