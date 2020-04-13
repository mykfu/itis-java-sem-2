package sem2.L12;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class IO {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/sem2/L12/";
//        InputStream inputStream = new FileInputStream(PATH + "image.jpg");
//        OutputStream outputStream = new FileOutputStream(PATH + "image_copy.jpg");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
//
//        int c;
//
//        while ((c = bufferedInputStream.read()) != -1) {
//            System.out.println(c);
//            bufferedOutputStream.write(c);
//        }
//
//        bufferedInputStream.close();
//        bufferedOutputStream.close();

        Reader reader = null;
        reader = new FileReader(PATH + "test.txt");
        try {
            int c;
            while((c = reader.read()) != -1) {
                System.out.println((char)c);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }


        try (BufferedReader reader1 = new BufferedReader(new FileReader(PATH + "test.txt"))){
            int c;
            while((c = reader1.read()) != -1) {
                System.out.println((char)c);
            }
        }

//        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(PATH + "test2.txt"));

        File file = new File(PATH + "test.txt");


        System.out.println("NIO"); //new io & non-blocking io

        Path p1 = Paths.get(PATH + "image.jpg");
        Path p2 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
        Path p3 = FileSystems.getDefault().getPath("tmp");
        Path p5 = Paths.get(PATH);

        Path p4 = file.toPath();

        System.out.println("tostring = " + p1);
        System.out.println(p1.getFileName());
        System.out.println(p1.getName(2));
        System.out.println(p1.getNameCount());
        System.out.println(p1.subpath(0, 2));
        System.out.println(p1.getParent());
        System.out.println(p1.toAbsolutePath().getRoot());

        Path path = Paths.get("src/sem2/L12/foo/../image.jpg");
        System.out.println(path.toRealPath());
        System.out.println(path.toRealPath().toUri()); // URI Uniform Resource Identifier
        //URL Uniform Resource Locator

        final Path footest = p5.resolve(p3).resolve("footest");
        System.out.println(footest);

        System.out.println(footest.relativize(path));
        Path footestAbs = footest.toAbsolutePath();

        System.out.println(footestAbs.equals(footest));

        for (Path path1 : footest) {
            System.out.println(path1);
        }

        final Path dir = Paths.get("src\\sem2\\L12\\tmp");
        if (!Files.isDirectory(dir)) {
            Files.createDirectory(dir);
        }
        if (!Files.isDirectory(footest)) {
            Files.createDirectory(footest);
        }
        System.out.println(Files.isSameFile(footest, footestAbs));

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(PATH + "test.txt"))) {
            System.out.println(bufferedReader.read());
        }
//        Files.deleteIfExists(dir);

        /// java 7
//        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
//            @Override
//            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                System.out.println(file);
//                Files.deleteIfExists(file);
//                return super.visitFile(file, attrs);
//            }
//
//            @Override
//            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//                System.out.println(dir);
//                Files.deleteIfExists(dir);
//                return super.postVisitDirectory(dir, exc);
//            }
//        });

        // java 8 stream

        Files.walk(dir).map(Path::toFile).peek(System.out::println).forEach(File::deleteOnExit);
        String text= "sfasfafdsa";


        System.out.println("Files.newDirectoryStream(dir): ");
        Files.write(dir.resolve("testwrite.txt"), text.getBytes());
        for (Path path1 : Files.newDirectoryStream(dir)) {
            System.out.println(path1);
        }

    }
}
