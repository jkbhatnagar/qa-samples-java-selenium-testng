package org.example.Listeners;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.example.utils.Log;
import org.example.utils.ResultSender;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ExecutionListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "PASS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "FAIL");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        this.sendTestClassStatus(iTestContext);
    }

    private void sendTestMethodStatus(ITestResult iTestResult, String status) {
        Log.info("JATIN:" + "REPORT STATUS");
        Log.info("JATIN:" + iTestResult.getTestClass().getName());
        Log.info("JATIN:" + iTestResult.getName());
        Log.info("JATIN:" + iTestResult.getMethod().getDescription());
        Log.info("JATIN:" + status);
        Log.info("JATIN:" + iTestResult.getEndMillis());
        Log.info("JATIN:" + iTestResult.getStartMillis());

        Point point = Point.measurement("testmethod")
                .time(Instant.now().toEpochMilli(), WritePrecision.MS)
                .addTag("testclass", iTestResult.getTestClass().getName())
                .addTag("name", iTestResult.getName())
//                .addTag("description", iTestResult.getMethod().getDescription())
                .addTag("result", status)
                .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis()));
        ResultSender.send(point);
    }

    private void sendTestClassStatus(ITestContext iTestContext) {
        Point point = Point.measurement("testclass")
                .time(Instant.now().toEpochMilli(), WritePrecision.MS)
                .addTag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
                .addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()));

        ResultSender.send(point);
    }

}