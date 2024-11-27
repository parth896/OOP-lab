class trial{
    public static void main(String[] args) {
        StringBuffer s1=new StringBuffer("Hello World");
        StringBuffer s2=new StringBuffer("Hello");
        StringBuffer s3=s2.append(" World");
        System.out.println(s3);
        System.out.println(s1==s3);
    }
}