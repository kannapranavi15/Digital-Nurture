class BuilderPatternExample{
    static class Computer{
        String cpu;
        String ram;
        String storage;

        Computer(Builder builder){
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
        }
        void display() {

            System.out.println(cpu);
            System.out.println(ram);
            System.out.println(storage);

        }

    }

    static class Builder{
         String cpu;
         String ram;
         String storage;

        public Builder setcpu(String cpu){
            this.cpu = cpu;
            return this;
        }
        public  Builder setram(String ram){
            this.ram = ram;
            return this;
        }
        public  Builder setstorage(String storage){
            this.storage= storage;
            return this;
        }
        public  Computer build(){
            return new Computer(this);
        }

        
    }


    public static void main(String args[]){
        Computer c = new Builder().setcpu("A").setram("B").setstorage("C").build();
        c.display();
    }



}