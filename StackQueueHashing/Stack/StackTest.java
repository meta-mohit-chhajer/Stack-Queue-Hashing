package com.metacube.StackQueueHashing.Stack;
import org.junit.Assert;
import org.junit.Test;

public class StackTest {

	// positive test case for expression
		@Test
		public void testExpressionTrue () {
			Assert.assertEquals((Integer) 22,SolveInfixExpression.evaluateString("3 * 4 + ( 5 * 2 )"));
		}
		
		// negative test case for expression
		@Test
		public void testExpressionFalse () {
			Assert.assertNotEquals((Integer) 2,SolveInfixExpression.evaluateString("3 * 4 + ( 5 * 2 )"));
		}
}
