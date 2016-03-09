import DataStructures.GenericList;
import DataStructures.Stack;
import DataStructures.StackImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * PiJ day 11 - exercise 5
 */
public class StackTestD11 {

    @Test
    public void BasicStackTest () {
        Stack<Number> numberStack = new StackImpl<>(new GenericList<>());
        Stack<Integer> intStack = new StackImpl<>(new GenericList<>());
        Stack<Double> doubleStack = new StackImpl<>(new GenericList<>());
        Stack<Long> longStack = new StackImpl<>(new GenericList<>());

        numberStack.push(2000000000);
        numberStack.push(0x7fffffffffffffffL);
        numberStack.push(20.456);
        numberStack.push(20);
        intStack.push(20);
        doubleStack.push(20.456);
        longStack.push(0x7fffffffffffffffL);

        assertEquals(numberStack.pop(), intStack.top());
        assertEquals(numberStack.pop(), doubleStack.top());
        assertEquals(numberStack.pop(), longStack.top());
        assertEquals(numberStack.top(), numberStack.pop());
    }
}
