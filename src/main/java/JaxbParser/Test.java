package JaxbParser;


import JaxbParser.JaxbParserTest;

public class Test {
    public static void main(String[] args) {
        JaxbParserTest test = new JaxbParserTest();
        try {
            test.setUp();
            test.testSaveObject();
            test.testGetObject();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
