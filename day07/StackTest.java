public class StackTest {

    public static void main (String[] args) {
        IntegerStack st = new IntegerStack();
        System.out.println("pushing 2...");
        st.push(2);
        System.out.println("pushing 3...");
        st.push(3);
        System.out.println("pushing 5...");
        st.push(5);
        System.out.println("pushing 8...");
        st.push(8);
        System.out.println("pushing 34...");
        st.push(34);

        int popped = st.pop();
        System.out.println("Popping..." + ((popped > 0) ? (" it's a " + popped) : " Stack is empty!"));

        popped = st.pop();
        System.out.println("Popping..." + ((popped > 0) ? (" it's a " + popped) : " Stack is empty!"));

        popped = st.pop();
        System.out.println("Popping..." + ((popped > 0) ? (" it's a " + popped) : " Stack is empty!"));

        System.out.println("pushing 11...");
        st.push(11);
        System.out.println("pushing 21...");
        st.push(21);

        popped = st.pop();
        System.out.println("Popping..." + ((popped > 0) ? (" it's a " + popped) : " Stack is empty!"));

        popped = st.pop();
        System.out.println("Popping..." + ((popped > 0) ? (" it's a " + popped) : " Stack is empty!"));

        popped = st.pop();
        System.out.println("Popping..." + ((popped > 0) ? (" it's a " + popped) : " Stack is empty!"));

        popped = st.pop();
        System.out.println("Popping..." + ((popped > 0) ? (" it's a " + popped) : " Stack is empty!"));

        popped = st.pop();
        System.out.println("Popping..." + ((popped > 0) ? (" it's a " + popped) : " Stack is empty!"));

    }
}
