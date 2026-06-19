public class FactoryPatternExample {

    interface document {
        void display();
    }


    static class WordDocument implements document {

        public void display() {
            System.out.println("word");
        }
    }


    static class PdfDocument implements document {

        public void display() {
            System.out.println("pdf");
        }
    }


    static class ExcelDocument implements document {

        public void display() {
            System.out.println("excel");
        }
    }


    static abstract class DocumentFactory {

        abstract document createDocument();

    }


    static class WordFactory extends DocumentFactory {

        public document createDocument() {

            return new WordDocument();

        }
    }


    static class PdfFactory extends DocumentFactory {

        public document createDocument() {

            return new PdfDocument();

        }
    }


    static class ExcelFactory extends DocumentFactory {

        public document createDocument() {

            return new ExcelDocument();

        }
    }



    public static void main(String args[]) {


        DocumentFactory factory;


        factory = new PdfFactory();

        document d = factory.createDocument();

        d.display();



        factory = new WordFactory();

        d = factory.createDocument();

        d.display();


    }

}