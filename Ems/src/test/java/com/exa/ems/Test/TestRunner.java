package com.exa.ems.Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exa.ems.controller.LoginController;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestRunner {
	public static void main(String arg[]) {
		Result result = JUnitCore.runClasses(LoginController.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Result == " + result.wasSuccessful());
	}
}
