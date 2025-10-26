public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            
            // Sử dụng StringBuffer
            StringBuffer outputStringBuffer = new StringBuffer();
            for (byte b : inputBytes) {
                outputStringBuffer.append((char)b);
            }
            
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}