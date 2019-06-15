package com.epam.web.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LoggerListener implements ITestListener {
	private static Logger LOGGER = LogManager.getLogger(LoggerListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info(String.format("Test : %s , Method : %s, Started", result.getName(), result.getMethod()));

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info(String.format("Test : %s , Method : %s passed successful", result.getName(),
				result.getMethod()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LOGGER.warn(String.format("Test : %s , Method : %s failed in", result.getName(), result.getMethod()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.info(String.format("Test : %s , Method : %s was skipped ", result.getName(), result.getMethod()));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		LOGGER.warn(String.format("Test : %s , Method : %s failed  within success precentage: %s  ",
				result.getName(), result.getMethod(),result.getTestContext().getFailedButWithinSuccessPercentageTests().getAllResults().toString()));
	}

	@Override
	public void onStart(ITestContext context) {
		LOGGER.info(String.format("Starting tests : %s, Output directory : %s, Test Suite : %s",
				context.getName(), context.getOutputDirectory(), context.getSuite()));
	}

	@Override
	public void onFinish(ITestContext context) {
		LOGGER.info(String.format("Finish tests : %s, Output directory : %s, Test Suite : %s",
				context.getName(), context.getOutputDirectory(), context.getSuite()));
	}

}
